package cn.innosoft.en.releaseRecord.evidenceManager.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.releaseRecord.evidenceManager.model.TFcfOutdetoxInfo;
import cn.innosoft.en.releaseRecord.evidenceManager.persistent.FcfOutdetoxInfoDao;
import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.releaseRecord.releaseManager.service.FcfRecordService;
import cn.innosoft.en.releaseRecord.releaseManager.service.JcDetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.SysAccService;
import cn.innosoft.en.util.DateUtil;
import cn.innosoft.en.util.KSUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service("FcfOutdetoxInfoService")
public class FcfOutdetoxInfoService extends
		AbstractBaseService<TFcfOutdetoxInfo, String> {

	@Autowired
	private FcfOutdetoxInfoDao dao;

	@Autowired
	private FcfRecordService fcfRecordService;
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	@Autowired
	private SysAccService sysAccService;

	@Override
	public BaseDao<TFcfOutdetoxInfo, String> getBaseDao() {
		return dao;
	}
	
	/**
	 * 测试特殊字段新增
	 */
	public void testEntityAdd() {
		TFcfOutdetoxInfo outDetoxInfo = new TFcfOutdetoxInfo();
		outDetoxInfo.setNumber(Util.getUUID());
		outDetoxInfo.setName("test");
		outDetoxInfo.setException("异常描述");
		outDetoxInfo.setIdentity("身份");
		outDetoxInfo.setWork("职业");
		outDetoxInfo.setPosition("职务");
		outDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		outDetoxInfo.setAlreadyOut("N");
		outDetoxInfo.setBirth("19930725");
		outDetoxInfo.setBrief("setBrief");
		outDetoxInfo.setEducation("setEducation");
		outDetoxInfo.setMarriage("setMarriage");
		outDetoxInfo.setSex("setSex");
		outDetoxInfo.setNationality("setNationality");
		outDetoxInfo.setOrigin("setOrigin");
		String pic = "来自图片字符串";
		byte[] pictureByte = pic.getBytes();
		outDetoxInfo.setPictureByte(pictureByte);
		add(outDetoxInfo);
	}
	
	/*****************************************正式*********************************************/

	/**
	 * 存证管理分页
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Map<String, Object> evidencePageList(String identity,String userName,String userNumber,String startDate,String endDate,String outType,String curr,String nums) {
//		Map<String, Object> params = EnUtil.jsonToParaMap(pageRequest.getQueryCondition()); // 查询条件
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("identity", identity);
		params.put("userName", userName);
		params.put("userNumer", userNumber);
		params.put("outDateStart", startDate.replace("-", ""));
		params.put("outDateEnd", endDate.replace("-", ""));
		params.put("outTypeValue", outType);
		params.put("fetureDate", DateUtil.getFetureDate(7,PropsUtil.getValue("outDateFormat")));
//		params.put("thisWeek", DateUtil.fetureDaysContion(7, PropsUtil.getValue("outDateFormat")));// 获取本周各天日期时间
//		params.put("nowDay", Util.getCurTime(PropsUtil.getValue("outDateFormat")));// 获取今天日期
		PageResponse<Map<String, Object>> pageResponse = null;
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPage(Integer.parseInt(curr));// 当前页
		pageRequest.setRows(Integer.parseInt(nums));// 每页显示数
		pageResponse = findMapBySql("fcfOutdetoxInfo-getEvidencePage", params,pageRequest);
		List<Map<String, Object>> list = null;
		long total = 0;
		if(null!=pageResponse){
			list = pageResponse.getRows();
			total = pageResponse.getTotal();
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", total);
		result.put("data", list);		
		return result;
	}

	/**
	 * 查询戒毒出所人员详情信息
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public Map<String, Object> getOutDetoInfoDetails(String prisonId,
			String number) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNumber", number);
		params.put("prisonId", null);// 2018-10-09修改只通过number字段查询
		List<Map<String, Object>> list = findMapBySql(
				"fcfOutdetoxInfo-selectOutDetoDetails", params);
		if (null != list && list.size() > 0) {//2018-10-27 修改
			//if (list.size() > 0) {
				resultMap = list.get(0);
				// 在resultMap添加人员头像路径，此步骤需要在同步数据后，例如获取人员的字节数组头像，转化为文件保存在本地，后续映射处理处理
				resultMap.put("personPhoto", jcDetoxInfoService.getPersonPhotoFile(prisonId, number)); //因远程接口，暂注释
				// 查询出所节点记录信息
				resultMap.put("recordList", fcfRecordService.getRecordList(number, null,null));
				// 查询附件（人脸拍摄、人脸上传、出所单）信息
//				resultMap.put("sysAccList", sysAccService.findAccsByBusinessId(number));// 由于layui分页原因，通过ajax再调用
				
			//}
		}else{//否则就查询带出所人员表  2018 -10-27 
			List<Map<String, Object>> jcList = jcDetoxInfoService.findMapBySql("jcDetoxInfo-selectOutPersonDetails", params);
			if(null != jcList && jcList.size()>0){
				resultMap = jcList.get(0);
				resultMap.put("personPhoto", jcDetoxInfoService.getPersonPhotoFile(prisonId, number)); //因远程接口，暂注释
				resultMap.put("recordList", fcfRecordService.getRecordList(number, null,null));
			}
		}

		return resultMap;

	}
	
	/**
	 * 更新出所单上传状态
	 * @param number
	 * @param outDocTime
	 * @param outDocState
	 * @param excep
	 */
	public void updateOutListSta(String number,String outDocTime,String outDocState,String excep) {
		TFcfOutdetoxInfo fcfOutdetoxInfo = findOne(number);
		fcfOutdetoxInfo.setOutDocState(outDocState);
		fcfOutdetoxInfo.setOutDocTime(outDocTime);
		fcfOutdetoxInfo.setException(excep);
		updateSome(fcfOutdetoxInfo);
	}
	
	/**
	 * 更新出所状态
	 * @param number
	 */
	public void updateOutStaSuccess(String number) {
		TFcfOutdetoxInfo fcfOutdetoxInfo = findOne(number);
		/*String update = Util.getCurTimeUUID();
		jcDetoxInfo.setProcessState("true");
		jcDetoxInfo.setProcessTime(update);
		jcDetoxInfo.setPictureState("true");
		jcDetoxInfo.setPictureTime(update);*/
		fcfOutdetoxInfo.setAlreadyOut("Y");
		updateSome(fcfOutdetoxInfo);
	}
	
	/**
	 * 根据number删除已经出所人员
	 * @param number
	 */
	public void deleteByNumber(String number) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("userNumber", number);
		executeUpdateBySql("fcfOutdetoxInfo-deleteByNumber", paramsMap);
	}
	
	/**
	 * 获取存正出所类型数量
	 * @param type
	 * @return
	 */
	public String getCZTypeNum(String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("outTypeValue", type);
		List<Map<String, Object>> list = findMapBySql("fcfOutdetoxInfo-selectOutNumByType", params);
		if(null!=list&&list.size()>0){
			return list.get(0).get("TOTAL").toString();
		}
		return "0";
	}
	
	/**
	 * 获取存正（临时、正常）出所数量
	 * @return
	 */
	public Map<String, Object> getCZOutManaNum() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("normal_num", getCZTypeNum("normal"));
		resultMap.put("temp_num", getCZTypeNum("temp"));
		return resultMap;
	}
	
	/**
	 * 回所操作（2018-10-11）
	 * @param number
	 * @return
	 */
	public String comeBackOpt(String number) {
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(number);
		if(null==jcDetoxInfo){
			return null;
		}
		//String ksId = jcDetoxInfo.getKsUserId();
		String time = Util.getCurTimeUUID(); 
		jcDetoxInfo.setAlreadyOut("");
		jcDetoxInfo.setBaseCofirmSta("");
		jcDetoxInfo.setProcessTime("");
		jcDetoxInfo.setPictureState("");
		jcDetoxInfo.setPictureTime("");
		jcDetoxInfo.setOutDocState("");
		jcDetoxInfo.setOutDocTime("");
		jcDetoxInfo.setException("");
//		jcDetoxInfo.setKsUserId("");
		jcDetoxInfo.setSuccessPhoto(null);
		jcDetoxInfo.setTrueOutData("");
		jcDetoxInfo.setUpdateTime(time);
		jcDetoxInfo.setHistory_id("");//2018-10-24 清空操作
		jcDetoxInfoService.updateSome(jcDetoxInfo);// 数据还原
		deleteByNumber(number);// 删除已经出所
		// 以下操作暂定删除，2018-10-15
		/*fcfRecordService.deleteByNumber(number);// 删除操作节点记录
		if(!"".equals(ksId)&&null!=ksId){// 删除旷视人员数据
			KSUtil.deleteUserById(ksId);
		}*/
		return null;
	}

}
