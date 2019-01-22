package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.evidenceManager.model.TFcfOutdetoxInfo;
import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.releaseRecord.releaseManager.model.TSysAcc;
import cn.innosoft.en.releaseRecord.releaseManager.persistent.SysAccDao;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.FTPUtil;
import cn.innosoft.en.util.ImageUtil;
import cn.innosoft.en.util.KSUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service("SysAccService")
public class SysAccService extends AbstractBaseService<TSysAcc, String> {

	@Autowired
	private SysAccDao dao;
	
	@Autowired
	private FcfOutdetoxInfoService fcfOutdetoxInfoService;
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;

	@Override
	public BaseDao<TSysAcc, String> getBaseDao() {
		return dao;
	}

	/**
	 * 通过业务外键获取对应附件信息
	 * 按照上传时间、类型查询
	 * @param businessId
	 * @return
	 */
	public List<Map<String, Object>> findAccsByBusinessId(String businessId,String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("outBusinessId", businessId);
		params.put("accType", type);// 附件类型，查询所有附件
		List<Map<String, Object>> list = findMapBySql("sysAcc-getAccList",
				params);
		return list;
	}
	
	/**
	 * 获取附件列表封装layui
	 * @param personNumber
	 * @param name
	 * @return
	 */
	public Map<String, Object> getAccPage(String personNumber, String name) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		List<Map<String, Object>> list = findAccsByBusinessId(personNumber,null);
		if(null!=list){
			if(list.size()>0){
				resultMap.put("count", list.size());
			}
		}
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("data", list);
		return resultMap;
	}

	// 附件页面响应下载
	public void downloadAcc(HttpServletRequest request,
			HttpServletResponse response, String accId) throws Exception {
		TSysAcc sysAcc = findOne(accId);
		String fullPath = sysAcc.getAccStoragePath(); // 文件完整存储路径名
		String fileName = sysAcc.getAccFileName(); // 文件真实名称
		// 测试下载路径
//		fullPath = "releaseRecord/outListSavePath/201809031429214451863.pdf";
//		fileName = "测试.pdf";
		String realPathDir = EnUtil
				.addPathSep(PropsUtil.getValue("accDirPath")); // 文件下载存储路径
		String newFile = realPathDir + "/" + fullPath;
		EnUtil.createDir(EnUtil.getFileNameAndParentPath(newFile).get(
				"parentPath"));
		EnUtil.createDir(realPathDir);// 验证文件夹是否存在并创建文件夹
		if (!EnUtil.isDirExist(newFile)) {// 如果当前文件不存在则进行下载至指定目录
			FTPUtil.downFile(realPathDir + "/" + fullPath, fullPath); // 从ftp下载文件到指定目录
		}
		EnUtil.downFile(newFile, response, fileName, false); // 页面进行文件下载
	}
	
	/**
	 * 出所单附件上传
	 * @param request
	 * @param inputName
	 * @return
	 * @throws Exception
	 */
	public String uploadOutListFile(HttpServletRequest request, String inputName) throws Exception {
		String dataSavePath = EnUtil.addPathSep(PropsUtil.getValue("temporaryPath"));//EnUtil.addPathSep(PropsUtil.getValue("accDirPath"))+UploadDownDirUtil.PICTURE_SAVE_PATH; // 配置文件中的图片保存路径
		Map<String,String> fileMap = EnUtil.uploadMultReturn(request, dataSavePath, inputName);
		String ftpSavePicturePath = EnUtil.addPathSep("releaseRecord/outListSavePath");//EnUtil.addPathSep(UploadDownDirUtil.PICTURE_SAVE_PATH);//ftp上保存图片文件的目录名称
		String result = "";
		
		String fileSavePath = fileMap.get("path");
		Map<String,String> FileNameAndParentPathMap = EnUtil.getFileNameAndParentPath(fileSavePath);
		String ftpFullPatrh = ftpSavePicturePath+FileNameAndParentPathMap.get("fileName");
		result = uploadFile(fileMap,ftpSavePicturePath);
		
		String suffixName = fileMap.get("fileName").substring(fileMap.get("fileName").lastIndexOf(".")+1);// 文件后缀名
		TSysAcc sysAcc = new TSysAcc();
		String number = request.getParameter("personNumber");
		String update = Util.getCurTimeUUID();
		sysAcc.setAccId(Util.getUUID());
		sysAcc.setCreateDt(update);
		sysAcc.setUpdateDt(update);
		sysAcc.setBusinessId(number);
		sysAcc.setCreateUserAcct(OrmHelper.getCurrentUserAcct());
		sysAcc.setAccSuffixName(suffixName);
		sysAcc.setAccType("outlist");
		sysAcc.setCreateUserName(OrmHelper.getCurrentUserName());
		sysAcc.setValidSign("Y");
		sysAcc.setAccStoragePath(ftpFullPatrh);
		sysAcc.setAccFileName(request.getParameter("outList_name"));
		add(sysAcc);
		jcDetoxInfoService.updateOutListSta(number, update, "true", "");// 更新出所单上传情况
		fcfOutdetoxInfoService.updateOutListSta(number, update, "true", "");// 已经出所人更新出所单上传状态
		return result;
	}
	
	/**
	 * 文件上传调用    传入文件类和文件在系统中的存储路径，上传至ftp后返回ftp中的文件存储路径
	 * 
	 * @param multipartFile 
	 * @param path
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String uploadFile(Map<String,String> fileMap,String ftpSavePicture)throws IllegalStateException, IOException {
		String pictureSavePath = ftpSavePicture; // ftp上保存图片文件的目录名称
		String fileSavePath = fileMap.get("path");
		Map<String,String> FileNameAndParentPathMap = EnUtil.getFileNameAndParentPath(fileSavePath);
		String ftpFullPatrh = pictureSavePath+FileNameAndParentPathMap.get("fileName");// 去根目录符后的完整路径（带文件名）
		FTPUtil.uploadFile(fileSavePath, pictureSavePath); // 上传文件到FTP服务器
		return ftpFullPatrh;
	}
	
	/**
	 * 上传人脸图片
	 * @param request
	 * @param inputName
	 * @return
	 * @throws Exception
	 */
	public String uploadFacePhoto(HttpServletRequest request, String inputName) throws Exception {
		String dataSavePath = EnUtil.addPathSep(PropsUtil.getValue("savePhoto"));//EnUtil.addPathSep(PropsUtil.getValue("accDirPath"))+UploadDownDirUtil.PICTURE_SAVE_PATH; // 配置文件中的图片保存路径
		Map<String,String> fileMap = EnUtil.uploadMultReturn(request, dataSavePath, inputName);
		String ftpSavePicturePath = EnUtil.addPathSep("releaseRecord/faceSavePath");//EnUtil.addPathSep(UploadDownDirUtil.PICTURE_SAVE_PATH);//ftp上保存图片文件的目录名称
		String result = "";
		String fileSavePath = fileMap.get("path");
		Map<String,String> FileNameAndParentPathMap = EnUtil.getFileNameAndParentPath(fileSavePath);
		String ftpFullPatrh = ftpSavePicturePath+FileNameAndParentPathMap.get("fileName");
		
		String suffixName = fileMap.get("fileName").substring(fileMap.get("fileName").lastIndexOf(".")+1);// 文件后缀名
		TSysAcc sysAcc = new TSysAcc();
		String number = request.getParameter("personNumber");
		String update = Util.getCurTimeUUID();
		sysAcc.setAccId(Util.getUUID());
		sysAcc.setCreateDt(update);
		sysAcc.setUpdateDt(update);
		sysAcc.setBusinessId(number);
		sysAcc.setCreateUserAcct(OrmHelper.getCurrentUserAcct());
		sysAcc.setAccSuffixName(suffixName);
		sysAcc.setAccType("facephoto");
		sysAcc.setCreateUserName(OrmHelper.getCurrentUserName());
		sysAcc.setValidSign("Y");
		sysAcc.setAccStoragePath(ftpFullPatrh);
		sysAcc.setAccFileName("人脸对比图"+"."+suffixName/*request.getParameter("photo_name")*/);
		String ksUserId = request.getParameter("ksUserId");// 旷视id
		if(null!=ksUserId&&!"".equals(ksUserId)){
			String photoPath = fileMap.get("path");
			boolean flag = KSUtil.singleSB(ksUserId, photoPath);
			if(flag){
				result = uploadFile(fileMap,ftpSavePicturePath);
				String path = PropsUtil.getValue("savePhoto")+Util.getCurTimeUUID()+".jpg";
				EnUtil.createFile(path);
				TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(number);
				jcDetoxInfo.setSuccessPhoto(ImageUtil.GetImageStr(path).getBytes());
				jcDetoxInfoService.updateSome(jcDetoxInfo);
				add(sysAcc);
				return FileNameAndParentPathMap.get("fileName");
			}
		}
		return "false";//FileNameAndParentPathMap.get("fileName");
	}
	
	/**
	 * 多附件
	 * @param request
	 * @param upType
	 * @param personNumber
	 * @param personName
	 * @return
	 * @throws Exception
	 */
	public String mulitOutUpload(HttpServletRequest request,String inputName,String upType,String personNumber,String personName) throws Exception {
		String dataSavePath = EnUtil.addPathSep(PropsUtil.getValue("temporaryPath"));//EnUtil.addPathSep(PropsUtil.getValue("accDirPath"))+UploadDownDirUtil.PICTURE_SAVE_PATH; // 配置文件中的图片保存路径
		Map<String,String> fileMap = EnUtil.uploadMultReturn(request, dataSavePath, inputName);
		String ftpSavePicturePath = EnUtil.addPathSep("releaseRecord/outListSavePath");//EnUtil.addPathSep(UploadDownDirUtil.PICTURE_SAVE_PATH);//ftp上保存图片文件的目录名称
		String result = "";
		
		String fileSavePath = fileMap.get("path");
		Map<String,String> FileNameAndParentPathMap = EnUtil.getFileNameAndParentPath(fileSavePath);
		String ftpFullPatrh = ftpSavePicturePath+FileNameAndParentPathMap.get("fileName");
		result = uploadFile(fileMap,ftpSavePicturePath);
		
		String suffixName = fileMap.get("fileName").substring(fileMap.get("fileName").lastIndexOf(".")+1);// 文件后缀名
		TSysAcc sysAcc = new TSysAcc();
		String update = Util.getCurTimeUUID();
		String accId = Util.getUUID();// 附件ID
		sysAcc.setAccId(accId);
		sysAcc.setCreateDt(update);
		sysAcc.setUpdateDt(update);
		sysAcc.setBusinessId(personNumber);
		sysAcc.setCreateUserAcct(OrmHelper.getCurrentUserAcct());
		sysAcc.setAccSuffixName(suffixName);
		sysAcc.setAccType("outlist");
		sysAcc.setCreateUserName(OrmHelper.getCurrentUserName());
		sysAcc.setValidSign("Y");
		sysAcc.setAccStoragePath(ftpFullPatrh);
		sysAcc.setAccFileName(fileMap.get("fileName"));// 设置文件名
		add(sysAcc);
		jcDetoxInfoService.updateOutListSta(personNumber, update, "true", "");// 更新出所单上传情况
		return accId;
	}
	
	/**
	 * 删除附件
	 * @param id
	 */
	public void deleteAccById(String id) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("accId", id);
		executeUpdateBySql("sysAcc-deleteById", paramsMap);
//		delete(id);
	}
	
	/**
	 * 远程文件路径，下载到本地
	 * @param fileId
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public String downFileByPath(String fileId,String localPath) throws Exception {
		String realPathDir = EnUtil.addPathSep(PropsUtil.getValue("accDirPath")); // 文件下载存储路径
		String fileName = Util.getCurTimeUUID()+".jpg";
		String newFile = realPathDir + "/" + fileName;
		EnUtil.createDir(EnUtil.getFileNameAndParentPath(newFile).get("parentPath"));
		EnUtil.createDir(realPathDir);// 验证文件夹是否存在并创建文件夹
		if (!EnUtil.isDirExist(newFile)) {// 如果当前文件不存在则进行下载至指定目录
			FTPUtil.downFile(realPathDir + "/" + newFile, newFile); // 从ftp下载文件到指定目录
			return newFile;
		}
		return null;
	}
	
	/**
	 * 添加识摄像头拍摄附件
	 * @param number
	 * @param path
	 * @param name
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public void addSBAcc(String number,String path) throws IllegalStateException, IOException {
		EnUtil.createFile(path);
		String ftpSavePicturePath = EnUtil.addPathSep("releaseRecord/outListSavePath");
		Map<String, String> map = new HashMap<String, String>();
		map.put("path", path);
		map.put("fileName", "人脸对比图"+path.substring(path.lastIndexOf("/")+1));
		map.put("fileSize", new File(path).length()+"");
		//uploadFile(map, ftpSavePicturePath);// 文件上传删除2018-10-26
		TSysAcc sysAcc = new TSysAcc();
		String date = Util.getCurTimeUUID();
		sysAcc.setAccId(Util.getUUID());
		sysAcc.setBusinessId(number);
		sysAcc.setUpdateDt(date);
		sysAcc.setCreateDt(date);
		sysAcc.setCreateUserAcct(OrmHelper.getCurrentUserAcct());
		sysAcc.setCreateUserId(OrmHelper.getCurrentUserId());
		sysAcc.setCreateUserName(OrmHelper.getCurrentUserName());
		sysAcc.setValidSign("Y");
		sysAcc.setAccSuffixName(path.substring(path.lastIndexOf(".")+1));
		sysAcc.setAccType("facephoto");
		sysAcc.setAccFileName("人脸对比图");
		sysAcc.setAccStoragePath(ftpSavePicturePath+"/"+path.substring(path.lastIndexOf("/")+1));
		add(sysAcc);
	}
	
	
	/*****************************************************************************************************************/
	
	/**
	 * 本地图片转字节数组
	 * @param path
	 * @return
	 */
	public byte[] image2Bytes(String path) {
		path = "D:/releaseRecordDownFils/detail_01_03.jpg";
		TFcfOutdetoxInfo info = new TFcfOutdetoxInfo();
		String idString = Util.getUUID();
		info.setNumber(idString);
		byte[] bytes = ImageUtil.image2byte(path);
		info.setPictureByte(ImageUtil.image2byte(path));
		fcfOutdetoxInfoService.add(info);
		System.out.println("有图片人ID:"+idString);
		return bytes;
	}
	
	/**
	 * 字节数组转文件
	 * @param data
	 */
	public void byte2image(byte[] data) {
		TFcfOutdetoxInfo info = fcfOutdetoxInfoService.findOne("1dcd1a5f5d584005a7b871f0956e9e00");
		byte[] bytes = info.getPictureByte();
		ImageUtil.byte2image(bytes, PropsUtil.getValue("savePhoto")+Util.getCurTimeUUID()+".jpg");
	}
	
	public void testTB(String id) {
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "嘻嘻哈哈");
		map.put("number", jcDetoxInfo.getNumber());
		byte[] bytes = jcDetoxInfo.getPictureByte();
		//jcDetoxInfoService.addUserToKS(map, bytes);
	}
	
	public void TT() {
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne("07f5fdaf-e3d7-422f-add2-6180346a225b");
		jcDetoxInfo.setPictureByte(ImageUtil.GetImageStr("D:/IMG_2041.JPG").getBytes());
		jcDetoxInfoService.updateSome(jcDetoxInfo);

	}

}
