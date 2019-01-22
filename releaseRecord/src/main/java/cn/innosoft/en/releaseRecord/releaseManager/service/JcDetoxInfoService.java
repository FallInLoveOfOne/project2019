package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.io.IOException;
//import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import cn.innosoft.en.releaseRecord.evidenceManager.model.TFcfOutdetoxInfo;
import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.releaseRecord.releaseManager.persistent.JcDetoxInfoDao;
import cn.innosoft.en.util.BusinessConstant;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.ImageUtil;
import cn.innosoft.en.util.KSUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;
//import cn.innosoft.en.util.ks.HttpDeal;
import cn.innosoft.en.util.ks.SanYUtil;
import cn.innosoft.en.util.loginUtil.JsonUtils;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service("JcDetoxInfoService")
public class JcDetoxInfoService extends
		AbstractBaseService<TJcDetoxInfo, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(JcDetoxInfoService.class);

	@Autowired
	private JcDetoxInfoDao dao;
	
	@Autowired
	private FcfRecordService fcfRecordService;
	
	@Autowired
	private FcfOutdetoxInfoService fcfOutdetoxInfoService; 
	
	@Autowired
	private SysAccService SysAccService;
	
	@Resource(name="goOnlineTransactionManager")
	private JpaTransactionManager goOnlineTransactionManager;

	@Autowired
	private OutHistoryService outHistoryService;
	
	@Override
	public BaseDao<TJcDetoxInfo, String> getBaseDao() {
		return dao;
	}

	/**
	 * 测试实体对象新增
	 * （涉及到一些特殊字段）
	 */
	public void testEntityAdd() {
		TJcDetoxInfo jcDetoxInfo = new TJcDetoxInfo();
		jcDetoxInfo.setNumber(Util.getUUID());
		jcDetoxInfo.setName("test");
		jcDetoxInfo.setException("异常描述");
		jcDetoxInfo.setIdentity("身份");
		jcDetoxInfo.setWork("职业");
		jcDetoxInfo.setPosition("职务");
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		jcDetoxInfo.setAlreadyOut("N");
		jcDetoxInfo.setBirth("19930725");
		jcDetoxInfo.setBrief("setBrief");
		jcDetoxInfo.setEducation("setEducation");
		jcDetoxInfo.setMarriage("setMarriage");
		jcDetoxInfo.setSex("setSex");
		jcDetoxInfo.setNationality("setNationality");
		jcDetoxInfo.setOrigin("setOrigin");
		String pic = "来自图片字符串";
		byte[] pictureByte = pic.getBytes();
		jcDetoxInfo.setPictureByte(pictureByte);
		add(jcDetoxInfo);
	}

	/**
	 * 测试sSQl模板新增
	 */
	public void testSQLAdd() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", Util.getUUID());
		params.put("userName", "testsql");
		params.put("exceptionVal", "异常描述");
		params.put("identityVal", "sql身份");
		params.put("workVal", "sql 职业");
		params.put("postionVal", "sql 职业");
		byte[] bytes = { (byte) 0xB8, (byte) 0xDF, (byte) 0xCB, (byte) 0xD9 };
		params.put("pictureByte", new String(bytes));
		executeUpdateBySql("jcDetoxInfo-addOneUser", params);
	}

	/***************************************正式***************************************/
	
	/**
	 * 同步人员接口（可根据人员编号同步）
	 * @param endData
	 * @param days
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public void synchroPersonData() throws IOException {
		// 请求接口: http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&page=2&size=50
		// 从三洋接口获取戒毒人员数据
		
//		String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findAllDetoxPeopleInfo?prisonId="+PropsUtil.getValue("prisonId")+"&page=1&size=88888888888"; 
//		String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&size=88888888888"; 
		String datas = SanYUtil.getAllPerson();//HttpDeal.get(url); 获取三洋人员接口更换（2018-10-09）
//		String datas = "{\"pageNum\":1,\"pageSize\":20,\"size\":2,\"orderBy\":null,\"startRow\":1,\"endRow\":2,\"total\":2,\"pages\":1,\"list\":[{\"number\":\"330301131201808240055\",\"name\":\"薛纪晓\",\"anotherName\":\"无\",\"sex\":\"1\",\"sexValue\":\"男性\",\"birth\":\"19770402\",\"marriage\":\"4\",\"marriageValue\":\"离婚\",\"identityId\":\"330327197704020953\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330327\",\"originValue\":\"浙江省温州市苍南县\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330327\",\"houseAddrValue\":\"浙江省温州市苍南县\",\"houseDetailAddr\":\"宜山镇仁寿街２６号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"05\",\"identityValue\":\"农民\",\"workAddr\":\"无\",\"position\":\"无\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"1106\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"imprisonLimit\":\"20200904\",\"brief\":\"2018年8月24日，因吸食毒品后被公安机关查获。\",\"comeDate\":\"20180905093357\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"林震\",\"transactorPhone\":\"747709\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"},{\"number\":\"330301131201808210040\",\"name\":\"王丽跃\",\"sex\":\"2\",\"sexValue\":\"女性\",\"birth\":\"19700814\",\"marriage\":\"2\",\"marriageValue\":\"已婚\",\"identityId\":\"330302197008145923\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330302\",\"originValue\":\"浙江省温州市鹿城区\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330302\",\"houseAddrValue\":\"浙江省温州市鹿城区\",\"houseDetailAddr\":\"南郊街道横塘巷26--3号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"09\",\"identityValue\":\"无业人员\",\"workAddr\":\"不详\",\"position\":\"不详\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"3305\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"detoxEnd\":\"20180905\",\"imprisonLimit\":\"20200904\",\"holdBegin\":\"20180821\",\"brief\":\"2018年08月21日该王丽跃因吸食毒品被公安机关查获，尿检呈阳性。\",\"comeDate\":\"20180905092658\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"叶军\",\"transactorPhone\":\"588588\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"}],\"firstPage\":1,\"prePage\":0,\"nextPage\":0,\"lastPage\":1,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1]}";
		if("".equals(datas)||null==datas){
			return;
		}
		JSONObject jsonObject = new JSONObject(datas);
		int total = jsonObject.getInt("total");
		JSONArray dataArray = jsonObject.getJSONArray("list");
		if(total==0){
			return;
		}
		for (int key=0;key<dataArray.length();key++) {
			JSONObject object = dataArray.getJSONObject(key);
			System.out.println(object.get("prisonName"));
			Map<String, Object> userMap = object.toMap();
			String number_id = Util.isEmpt(userMap.get("number"));
			TJcDetoxInfo haveDetoxInfo = findOne(number_id);
			if (null != haveDetoxInfo) {// 若本库有有此数据，则更新本库的时间
				String updateTime = haveDetoxInfo.getUpdateTime();
				if(null==updateTime||"".equals(updateTime)){// 如果本库没有操作过，则先删除后新增
					/*
					deleteById(number_id);// 删除此条记录
					String ksId = haveDetoxInfo.getKsUserId();
					if(null!=ksId&&!"".equals(ksId)){
						KSUtil.deleteUserById(ksId);// 删除旷视数据
					}
					addDetoxInfoByMap(userMap);// 新增到本地库
					*/
					//updatePersonByMap(haveDetoxInfo, userMap);
				}
				updatePersonByMap(haveDetoxInfo, userMap);
			} else {// 如果本库无数据，需要新增到本库
				addDetoxInfoByMap(userMap);
			}
		}
	}
	
	
	/**
	 * 通过map新增戒毒人员数据到本库
	 * @param map
	 * @throws IOException 
	 */
	public Map<String, String> addDetoxInfoByMap(Map<String, Object> map) throws IOException {
		TJcDetoxInfo detoxInfo = new TJcDetoxInfo();
		String number_id = Util.isEmpt(map.get("number"));
		if(null==number_id||"".equals(number_id)){
			return null;
		}
		detoxInfo.setNumber(number_id);
		detoxInfo.setName(Util.isEmpt(map.get("name")));
		detoxInfo.setOtherName(Util.isEmpt(map.get("anotherName")));
		detoxInfo.setSex(Util.isEmpt(map.get("sex")));
		detoxInfo.setSexValue(Util.isEmpt(map.get("sexValue")));
		detoxInfo.setBirth(Util.isEmpt(map.get("birth")));
		detoxInfo.setEthnicGroup(Util.isEmpt(map.get("ethnicGroup")));
		detoxInfo.setEthnicGroupValue(Util.isEmpt(map.get("ethnicGroupValue")));
		detoxInfo.setPoliticalStatus(Util.isEmpt(map.get("politicalStatus")));
		detoxInfo.setPoliticalStatusValue(Util.isEmpt(map.get("politicalStatusValue")));
		detoxInfo.setNationality(Util.isEmpt(map.get("nationality")));
		detoxInfo.setNationalityValue(Util.isEmpt(map.get("nationalityValue")));
		detoxInfo.setHouseAddr(Util.isEmpt(map.get("houseAddr")));
		detoxInfo.setHouseAddrValue(Util.isEmpt(map.get("houseAddrValue")));
		detoxInfo.setHouseDetailAddr(Util.isEmpt(map.get("houseDetailAddr")));
		detoxInfo.setManageType(Util.isEmpt(map.get("manageType")));
		detoxInfo.setManageTypeValue(Util.isEmpt(map.get("manageTypeValue")));
		detoxInfo.setEmphasisPersoner(Util.isEmpt(map.get("emphasisPersoner")));
		detoxInfo.setEmphasisPersonerValue(Util.isEmpt(map.get("emphasisPersonerValue")));
		detoxInfo.setIdentityId(Util.isEmpt(map.get("identityId")));
		detoxInfo.setIdentityType(Util.isEmpt(map.get("identityType")));
		detoxInfo.setIdentityTypeValue(Util.isEmpt(map.get("identityTypeValue")));
		detoxInfo.setIdentity(Util.isEmpt(map.get("identity")));
		detoxInfo.setIdentityValue(Util.isEmpt(map.get("identityValue")));
		detoxInfo.setWorkAddr(Util.isEmpt(map.get("workAddr")));
		detoxInfo.setPosition(Util.isEmpt(map.get("position")));
		detoxInfo.setSpecialty(Util.isEmpt(map.get("specialty")));
		detoxInfo.setSpecialtyValue(Util.isEmpt(map.get("specialtyValue")));
		detoxInfo.setDormCode(Util.isEmpt(map.get("dormCode")));
		detoxInfo.setDetoxLimit(Util.isEmpt(map.get("detoxLimit")));
		detoxInfo.setDetoxLimitValue(Util.isEmpt(map.get("detoxLimitValue")));
		detoxInfo.setDetoxBegin(Util.isEmpt(map.get("detoxBegin")));
		detoxInfo.setDetoxEnd(Util.isEmpt(map.get("detoxEnd")));
		detoxInfo.setHoldDay(Util.isEmpt(map.get("holdDay")));
		detoxInfo.setHoldBegin(Util.isEmpt(map.get("holdBegin")));
		detoxInfo.setHoldEnd(Util.isEmpt(map.get("holdEnd")));
		detoxInfo.setBrief(Util.isEmpt(map.get("brief")));
		detoxInfo.setComeDate(Util.isEmpt(map.get("comeDate")));
		detoxInfo.setComeReason(Util.isEmpt(map.get("comeReason")));
		detoxInfo.setComeResonValue(Util.isEmpt(map.get("comeReasonValue")));
		detoxInfo.setOutDate(Util.isEmpt(map.get("outDate")));
		detoxInfo.setProcessState(Util.isEmpt(map.get("processState")));
		detoxInfo.setOutReason(Util.isEmpt(map.get("outReason")));
		detoxInfo.setOutReasonValue(Util.isEmpt(map.get("outReasonValue")));
		detoxInfo.setOutPlaceValue(Util.isEmpt(map.get("outPlaceValue")));
		detoxInfo.setMarriage(Util.isEmpt(map.get("marriage")));
		detoxInfo.setMarriageValue(Util.isEmpt(map.get("marriageValue")));
		detoxInfo.setOrigin(Util.isEmpt(map.get("origin")));
		detoxInfo.setOriginValue(Util.isEmpt(map.get("originValue")));
		detoxInfo.setEducation(Util.isEmpt(map.get("education")));
		detoxInfo.setEducationValue(Util.isEmpt(map.get("educationValue")));
		detoxInfo.setSpecialIndentity(Util.isEmpt(map.get("specialIdentity")));
		detoxInfo.setSpecialIndentityValue(Util.isEmpt(map.get("specialIdentityValue")));
		detoxInfo.setWork(Util.isEmpt(map.get("work")));
		detoxInfo.setWorkValue(Util.isEmpt(map.get("workValue")));
		byte[] photoBytes = sanyangPhotoGet(PropsUtil.getValue("prisonId"),number_id);// 获取三洋戒毒人员原始头像
		detoxInfo.setPictureByte(photoBytes);
		detoxInfo.setImprisonLimit(Util.isEmpt(map.get("imprisonLimit")));
		// 以下旷视人员信息同步
		Map<String, String> ksMap = addUserToKS(map,photoBytes);// 人员新增旷视识别系统，并且添加识别图，返回旷视的人员ID
		String ksuserId = ksMap.get("ksid");// 旷视内部自生成用户id
		detoxInfo.setKsUserId(ksuserId);// 设置旷ID
		add(detoxInfo);
		return null;
	}
	
	/**
	 * 从三洋接口获取原始头像
	 * @param prisonId
	 * @param number
	 */
	public byte[] sanyangPhotoGet(String prisonId,String number) {
		// http://10.118.5.86:8380/jc/prisoner/findPhotoByNumber?prisonId=330301131&number=330301131201808240055
		return SanYUtil.getPersonPhoto(number);// 更新头像获取方法（2018-10-09）
		/*String data = HttpDeal.get(PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findPhotoByNumber?prisonId="+prisonId+"&number="+number);
		data = data.replaceAll("\"", "");
		return data.getBytes();*/
		
	}
	
	/**
	 * 同步人员信息到旷视人脸比对系统
	 * @param userMap
	 * @throws IOException 
	 */
	public Map<String, String> addUserToKS(Map<String, Object> userMap,byte[] photoBytes) throws IOException {
		String basePath =  PropsUtil.getValue("savePhoto");
		EnUtil.createDir(basePath);// 检验文件夹，无则创建
		String path = Util.getCurTimeUUID()+".jpg";
		EnUtil.createFile(basePath+path);
		ImageUtil.GenerateImage(new String(photoBytes),basePath+path);
		Map<String, String> addMap = new HashMap<String, String>();
		addMap.put("name", Util.isEmpt(userMap.get("name")));
		addMap.put("job_number", Util.isEmpt(userMap.get("number")));
		addMap.put("avatar",new String(photoBytes));//ImageUtil.GetImageStr("D:/abiubiu/20180913145946143.jpg"));
		addMap.put("gender", "1");
		addMap.put("subject_type", "0");
		addMap.put("start_time", "2018");
		addMap.put("end_time", "2018");
		addMap.put("entry_date", "2018");
		addMap.put("description", "允许出所");
		String ksuserId = KSUtil.addSubject(addMap);
		KSUtil.uploadFace(ksuserId, basePath+path);
//		String ksuserId = KSUtil.addAndPhoto(addMap, basePath+path);
		Map<String, String> map = new HashMap<String, String>();
		map.put("ksid", ksuserId);// 旷视内部自生成用户id
//		map.put("sbPhotoPath", "D:/releaseRecordGenePhoto/20180913100952576.jpg"/*basePath+path*/);
		return map;
		
	}
	
	
	/**
	 * 批量新增旷视识别图片
	 * @param list
	 * @return
	 */
	public void addMulKSSBPhoto(List<Map<String, String>> list) {
		if(null==list||list.size()<=0){
			return;
		}
		Iterator<Map<String, String>> iterator = list.iterator();
		while(iterator.hasNext()){
			Map<String, String> map = iterator.next();
			String id = map.get("ksid");// 旷视内部自生成用户id
			String path = map.get("sbPhotoPath");
			KSUtil.uploadFace(id, path);
		}
	}

	/**
	 * 同步人员照片到本库
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public boolean synchroPersonPhotoXX(String prisonId, String number) {
		// 调用远程接口，获取头像字节数组数据
		byte[] data = null;
		TJcDetoxInfo jcDetoxInfo = findOne(number);// 查询本地库，该戒毒人员是否插入本库
		if(null==jcDetoxInfo){
			return false;
		}else {// 若本库存在此人记录，跟新人员头像信息
			jcDetoxInfo.setPictureByte(data);
			update(jcDetoxInfo);
		}
		return true;
	}
	
	/**
	 * 获取出所人员的头像，生成本地图片文件
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public String getPersonPhotoFile(String prisonId, String number) throws IOException {
		String basePath =  PropsUtil.getValue("savePhoto");
		EnUtil.createDir(basePath);// 检验文件夹，无则创建
		String path = Util.getCurTimeUUID()+".jpg";
		EnUtil.createFile(basePath+path);
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null==jcDetoxInfo){// 本库该戒毒人员信息不存在
			path = "";
		}else{
			byte[] bytes = jcDetoxInfo.getPictureByte();
			if(null==bytes){//如果本地没有同步头像图片，则用远程接口获取头像字节数组数据
				// 调用远程接口
//				ImageUtil.byte2image(bytes, basePath+path);
				bytes = sanyangPhotoGet(PropsUtil.getValue("prisonId"), number);
				ImageUtil.GenerateImage(new String(bytes), basePath+path);
			}else {
//				ImageUtil.byte2image(bytes, basePath+path);
				ImageUtil.GenerateImage(new String(bytes), basePath+path);
			}
		}
		
		return path;
	}

	/**
	 * 正常出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Map<String, Object> normalReleasePage(String identity,String userName,String userNumber,String startDate,String endDate,String excepVal,String waitOrFlag,String curr,String nums) {
//		Map<String, Object> params = EnUtil.jsonToParaMap(pageRequest.getQueryCondition()); // 查询条件
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("identity", identity);
		params.put("userName", userName);
		params.put("userNumer", userNumber);
		params.put("outDateStart", startDate.replace("-", ""));
		params.put("outDateEnd", endDate.replace("-", ""));
		params.put("waitOrNoSql", getOutDetoxWhere(waitOrFlag));// 获取待出所、未出所条件2018-10-11
//		params.put("fetureDate", DateUtil.getFetureDate(7,PropsUtil.getValue("outDateFormat")));// 获取本周各天日期时间
//		params.put("nowDay", Util.getCurTime(PropsUtil.getValue("outDateFormat")));// 获取今天日期
		String exceptionType = excepVal;//Util.isEmpt(params.get("exceptionType"));
		String exceptionTypeSql = null;
		if("sh".equals(exceptionType)){// 异常类型：审核未通过
			exceptionTypeSql = "(BASE_COFIRM_STA='false')";
		}
		if("face".equals(exceptionType)){// 异常类型：头像对比失败
			exceptionTypeSql = "(PICTURE_STATE='false')";
		}
		if("doc".equals(exceptionType)){// 异常类型：出所单未上传
			exceptionTypeSql = "(OUT_DOC_STATE='false')";
		}
		params.put("exceptionTypeSql", exceptionTypeSql);// 添加异常类型条件
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPage(Integer.parseInt(curr));// 当前页
		pageRequest.setRows(Integer.parseInt(nums));// 每页显示数
		PageResponse<Map<String, Object>> pageResponse = null;
		pageResponse = findMapBySql("jcDetoxInfo-getNormalPage", params,pageRequest);
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
	 * 临时出所管理
	 * @param prisonId
	 * @param number:内部管理编号或证件号
	 * @return
	 */
	public Map<String, Object> manageTempOut(String prisonId,
			String number) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dormCode", prisonId);
		params.put("userNumer", number);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if((!"".equals(prisonId)&&null!=prisonId)||(!"".equals(number)&&null!=number)){
			list = findMapBySql("jcDetoxInfo-getManegeTemporary", params);
			if(null!=list){
				if(list.size()>0){
//				Map<String, Object> resultMap = new HashMap<String, Object>();
//				resultMap = list.get(0);
//				return resultMap;
					resultMap.put("count", 1);
				}
			}
		}
		
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("data", list);
		return resultMap;
	}

	/**
	 * **废弃
	 * 临时出所出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<Map<String, Object>> temporaryReleasePage(
			PageRequest pageRequest) {
		Map<String, Object> params = EnUtil.jsonToParaMap(pageRequest
				.getQueryCondition()); // 查询条件
		params.put("thisWeek", Util.weekQueryCondtion(PropsUtil.getValue("outDateFormat")));// 获取本周各天日期时间
		params.put("nowDay", Util.getCurTime(PropsUtil.getValue("outDateFormat")));// 获取今天日期
		PageResponse<Map<String, Object>> pageResponse = null;
		pageResponse = findMapBySql("jcDetoxInfo-getTemporaryPage", params,
				pageRequest);
		return pageResponse;
	}

	/**
	 * 查询出所人员详情信息（本库）
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public Map<String, Object> getOutPersonDetails(String prisonId,
			String number) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNumber", number);
		params.put("prisonId", null);// 2018-10-09修改只通过number字段查询
		List<Map<String, Object>> list = findMapBySql(
				"jcDetoxInfo-selectOutPersonDetails", params);
		if (null != list) {
			if (list.size() > 0) {
				resultMap = list.get(0);
				// 在resultMap添加人员头像路径，此步骤需要在同步数据后，例如获取人员的字节数组头像，转化为文件保存在本地，后续映射处理处理
				resultMap.put("photoPath", getPersonPhotoFile(prisonId, number));// 考虑几口问题，获取头像先注释
				//
			}
		}

		return resultMap;
	}
	
	/*------------------------------------------------------管理页面、详情页面（正常、临时）出所操作请求的下一步------------------------------------------------------------------------*/
	
	/**
	 * 判断点击出所时，是直接到跳到上次的操作记录、还是第一次操作
	 * @param number
	 * @param outType
	 * @return
	 */
	public Map<String, String> checkOutButon(String number,String name,String outType) {
		//2018-10-17 创建历史记录表   
		String historyId = "";
	    TJcDetoxInfo jcDetoxInfo = (TJcDetoxInfo)findOne(number);
	    if ((jcDetoxInfo != null) && (jcDetoxInfo.getHistory_id() != null) && (!"".equals(jcDetoxInfo.getHistory_id()))) {
	      historyId = jcDetoxInfo.getHistory_id();
	    }
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("nowDate", Util.getCurTime(PropsUtil.getValue("outDateFormat")));
		List<Map<String, Object>> list = fcfRecordService.getRecordList(number, name,historyId);
		if(null!=list){// 有操作记录
			if(list.size()>0){
				String nowStage = Util.isEmpt(list.get(0).get("NOW_STAGE"));// 当前出出所节点记录的阶段
				//FJBC:附件不传、FJYC:附件已经传、CSCG：出所成功
				//ZBDB:暂不对比、DBCG：头像对比成功，下一步，DBSB-NO:对比失败不出所、DBSB-NEXT:对比失败，下一步、
				if((!"ZBDB".equals(nowStage))&&(!"DBCG".equals(nowStage))&&(!"DBSB-NEXT".equals(nowStage))){// 源非出所成功前提下(!"FJBC".equals(nowStage))&&(!"FJYC".equals(nowStage))&&(!"FJYC".equals(nowStage))
					resultMap.put("optVal", "old");// 
					resultMap.put("nextStep", outLickNextStep(number, name, outType,historyId).get("nextStep"));
					return resultMap;
				}else {
					resultMap.put("optVal", "new");// 
					resultMap.put("nextStep", "");
					return resultMap;
				}
			}
		}else{// 无操作记录
			resultMap.put("optVal", "new");
			resultMap.put("nextStep", "");
		}
		resultMap.put("optVal", "new");
		resultMap.put("nextStep", "");
		return resultMap;
	}
	
	/**
	 * 有过操作记录的话，下一步操作
	 * @return
	 */
	public Map<String, String> outLickNextStep(String number,String name,String outType,String historyId) {
		//ZBCS:准备出所、LCSB:流程失败、ZBDB:暂不对比、DBCG：头像对比成功，下一步，DBSB-NO:对比失败不出所、DBSB-NEXT:对比失败，下一步、
		//FJBC:附件不传、FJYC:附件已经传、CSCG：出所成功
		Map<String, String> resultMap = new HashMap<String, String>();
		String nextStep = "";
		List<Map<String, Object>> list = fcfRecordService.getRecordList(number, name,historyId);
		if(null!=list){// 有操作记录
			if(list.size()>0){
				String nowStage = Util.isEmpt(list.get(0).get("NOW_STAGE"));// 当前出出所节点记录的阶段
//				String haveException = Util.isEmpt(list.get(0).get("HAVE_EXCEP"));// 当前阶段的情况
				if("ZBCS".equals(nowStage)){
					nextStep="listUp";// faceCheck 2018-10-12
				}
				if("LCSB".equals(nowStage)){
					nextStep="processFail";// 下一步相当于新操作
				}
				if("DBCG".equals(nowStage)||"DBSB-NEXT".equals(nowStage)||"ZBDB".equals(nowStage)){
					nextStep="outOk";// 下一步附件上传listUp 2018-10-12
				}
				if("DBSB-NO".equals(nowStage)){
					nextStep="faceCheck";// 下一步人脸比对faceCheck
				}
				if("FJBC".equals(nowStage)||"FJYC".equals(nowStage)||"CSCG".equals(nowStage)){
					nextStep="faceCheck";// 下一步出所成功outOk 2018-10-12
				}
			}
		}else{// 无操作记录
			nextStep="";
		}
		resultMap.put("nextStep", nextStep);
		return resultMap;
	}
	
	
	/**
	 * 正常出所、详情页面的，出所操作请求
	 * @param number
	 * @return
	 */
	public Map<String, String> detailsNormalOutReq(String number) {
		return null;
	}
	
	
	/**
	 * 临时出所，详情页面的，出所操作
	 * @param number
	 * @return
	 */
	public Map<String, String> tempDetailsOutReq(String number) {
		return null;
	}
	
	/*------------------------------------------------------管理页面、详情页面（正常、临时）出所操作请求的下一步END------------------------------------------------------------------------*/

	/**
	 * 出所头像核对
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public Map<String, String> headPortraitCheck(String prisonId, String number,String ksuserId) throws IOException {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("prisonId", prisonId);
		resultMap.put("number", number);
		// 头像比对失败，戒毒人员信息表更新头像比对失败异常信息,同时添加出所节点表的事项信息
		// 本地头像文件路径
//		String oriPhotoPath = PropsUtil.getValue("savePhoto")+getPersonPhotoFile(prisonId, number); 
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null!=jcDetoxInfo){
			byte[] successPhoto = jcDetoxInfo.getSuccessPhoto();
			String photoState = jcDetoxInfo.getPictureState();
			if((null!=successPhoto)&&("true".equals(photoState))){// 如果数据库已经保存识别图片
				String basepath = PropsUtil.getValue("savePhoto");
				String sbPotho = Util.getCurTimeUUID()+".jpg";
				EnUtil.createFile(basepath+sbPotho);
				ImageUtil.GenerateImage(new String(successPhoto),basepath+sbPotho);
				resultMap.put("isOk", "true");
				resultMap.put("checkTime", Util.getCurTimeUUID());
				resultMap.put("sbPhoto", PropsUtil.getValue("keyToPath")+sbPotho);
				return resultMap;
			}
		}
		if(null!=ksuserId&&!"".equals(ksuserId)){
			Map<String, Object> bdMap = KSUtil.getRecognizeHistory(ksuserId);// 获取人脸比对结果
			if(null!=bdMap){// 有识别记录
				String sbPhotoUrl = PropsUtil.getValue("ksip")+"/"+bdMap.get("photo").toString();
				resultMap.put("isOk", "true");
				resultMap.put("checkTime", Util.getCurTimeUUID());
				resultMap.put("sbPhoto", sbPhotoUrl);
				
				String path = PropsUtil.getValue("savePhoto")+Util.getCurTimeUUID()+".jpg";
				EnUtil.createFile(path);
				KSUtil.saveImage(sbPhotoUrl,path);//远程识别头像下载到本地
				jcDetoxInfo.setSuccessPhoto(ImageUtil.GetImageStr(path).getBytes());
				updateSome(jcDetoxInfo);
//				SysAccService.addSBAcc(number, path);// 添加识别图附件
//				saveSBPhotoToData(number,sbPhotoUrl);
				return resultMap;
			}
		}
		resultMap.put("isOk", "false");
		resultMap.put("checkTime", Util.getCurTimeUUID());
		return resultMap;
	}
	
	/**
	 * 判断出所异常所处阶段
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public String getExceptionStage(String prisonId, String number) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null==jcDetoxInfo){
			return null;
		}
		String process_state = jcDetoxInfo.getProcessState();// 出所流程状态
		String picture_state = jcDetoxInfo.getPictureState();// 头像比对状态
		String out_doc_state = jcDetoxInfo.getOutDocState();// 出所单上传状态
//		String exception_reason = jcDetoxInfo.getException();// 异常原因
		// 是具体情况而定
		if("false".equals(process_state)){
			return "process_exception";
		}
		if("false".equals(picture_state)){
			return "picture_exception";
		}
		if("false".equals(out_doc_state)){
			return "outdoc_exception";
		}
		return "no_exception";
	}

	/**
	 * 更新新出所人员信息
	 * 
	 * @param person
	 */
	public void updateOutPerson(TJcDetoxInfo person) {
		updateSome(person);
	}
	
	/*--------------------------------------------更新阶段状态、异常原因-------------------------------------------------------------*/
	
	/**
	 * 更新出所流程状态、确认时间、异常原因
	 * @param number
	 * @param update
	 * @param ProcessState
	 * @param excep
	 */
	public void updateOutBaseInfoSta(String number,String cofirmTime,String baseState,String excep) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		jcDetoxInfo.setBaseCofirmSta(baseState);
		jcDetoxInfo.setProcessTime(cofirmTime);
		jcDetoxInfo.setException(excep);
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 跟新头像对比状态、确认时间、异常原因
	 * @param number
	 * @param cofirmTime
	 * @param photoState
	 * @param excep
	 */
	public void updateHeadcheckSta(String number,String photoTime,String photoState,String excep) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		jcDetoxInfo.setPictureState(photoState);
		jcDetoxInfo.setPictureTime(photoTime);
		jcDetoxInfo.setException(excep);
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 跟新出所单状态、确认时间、异常原因
	 * @param number
	 * @param outDocTime
	 * @param outDocState
	 * @param excep
	 */
	public void updateOutListSta(String number,String outDocTime,String outDocState,String excep) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		jcDetoxInfo.setOutDocState(outDocState);
		jcDetoxInfo.setOutDocTime(outDocTime);
		jcDetoxInfo.setException(excep);
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 更新出所成功
	 * @param number
	 */
	public void updateOutStaSuccess(String number) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		/*String update = Util.getCurTimeUUID();
		jcDetoxInfo.setProcessState("true");
		jcDetoxInfo.setProcessTime(update);
		jcDetoxInfo.setPictureState("true");
		jcDetoxInfo.setPictureTime(update);*/
		jcDetoxInfo.setAlreadyOut("Y");// 设置出所成功
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 拘留截止日期时间
	 * @param number
	 */
	public void updateTrueOutDate(String number) {
		TJcDetoxInfo jcDetoxInfo =  findOne(number);
		jcDetoxInfo.setTrueOutData(Util.getCurTime(PropsUtil.getValue("outDateFormat")));
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 确认出所单更新，相关状态、时间（2018-10-11）
	 * @param number
	 */
	public void sureOutListUpdate(String number) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		String time = Util.getCurTimeUUID();
		jcDetoxInfo.setOutDocState("true");
		jcDetoxInfo.setOutDocTime(time);
		jcDetoxInfo.setException("");
		jcDetoxInfo.setAlreadyOut("Y");
		jcDetoxInfo.setTrueOutData(Util.getCurTime(PropsUtil.getValue("outDateFormat")));
		jcDetoxInfo.setUpdateTime(time);
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 未确认出所单，更新相关状态、时间（2018-10-11）
	 * @param number
	 */
	public void noSureOutListUpdate(String number) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		String time = Util.getCurTimeUUID();
		jcDetoxInfo.setOutDocState("false");
		jcDetoxInfo.setOutDocTime(time);
		jcDetoxInfo.setException(BusinessConstant.NO_LIST_TEXT);
		jcDetoxInfo.setAlreadyOut("Y");// 设置出所成功
		jcDetoxInfo.setTrueOutData(Util.getCurTime(PropsUtil.getValue("outDateFormat")));
		jcDetoxInfo.setUpdateTime(time);
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 更新出所成功、实际出所时间
	 * @param number
	 */
	public void outSuccessUpdate(String number) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		String time = Util.getCurTimeUUID();
		jcDetoxInfo.setAlreadyOut("Y");// 设置出所成功
		jcDetoxInfo.setTrueOutData(Util.getCurTime(PropsUtil.getValue("outDateFormat")));
		jcDetoxInfo.setUpdateTime(time);
		updateSome(jcDetoxInfo);
	}
	
	/*------------------------------------------------更新阶段状态、异常原因END---------------------------------------------------------*/
	
	/**
	 * 出所成功，将信息添加到已出所戒毒人员信息表，即数据同步到存证(实体同步或者sql模板同步)
	 * 
	 * @param person
	 */
	public void copyDetoxToOUTDETOX(String number) {
		fcfOutdetoxInfoService.deleteByNumber(number);// 先删除原已出所的该人员
		// sql模板同步
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNumber", number);
		executeUpdateBySql("jcDetoxInfo-copyDetoxToOUTDETOX", params);

		// 实体同步
		TFcfOutdetoxInfo outdetoxInfo = new TFcfOutdetoxInfo();
		outdetoxInfo.setNumber(number);// ....

	}
	
	/**
	 * 更新出所类型
	 * @param number
	 * @param type
	 * @param typeVal
	 */
	public void updateOutType(String number,String type,String typeVal) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		jcDetoxInfo.setOutType(type);
		jcDetoxInfo.setOutTypeValue(typeVal);
		jcDetoxInfo.setUpdateTime(Util.getCurTimeUUID());
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 更新待出所人员异常原因
	 * @param number
	 * @param exceptionReason
	 */
	public void updateExceptionReason(String number,String exceptionReason) {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		jcDetoxInfo.setException(exceptionReason);
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 同步单人数据
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public void addOneUserTo(String number) throws IOException {
		if(!"".equals(number)&&null!=number){
			TJcDetoxInfo jcDetoxInfo = findOne(number);
			if(null!=jcDetoxInfo){
				return;
				//return true;
			}else{
				// 接口调用
//				String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findAllDetoxPeopleInfo?prisonId="+PropsUtil.getValue("prisonId")+"&number="+number;
				
				String datas = SanYUtil.getOneInfo(number);// 以下获取单个人员信息接口（2018-10-09）
				/*String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&number="+URLEncoder.encode(Util.isEmpt(number),"UTF-8");
				String datas = HttpDeal.get(url);*/
				
				if("".equals(datas)||null==datas){// 结果可能为空
					return;
				}
//				String datas = "{\"pageNum\":1,\"pageSize\":20,\"size\":2,\"orderBy\":null,\"startRow\":1,\"endRow\":2,\"total\":2,\"pages\":1,\"list\":[{\"number\":\"330301131201808240055\",\"name\":\"薛纪晓\",\"anotherName\":\"无\",\"sex\":\"1\",\"sexValue\":\"男性\",\"birth\":\"19770402\",\"marriage\":\"4\",\"marriageValue\":\"离婚\",\"identityId\":\"330327197704020953\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330327\",\"originValue\":\"浙江省温州市苍南县\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330327\",\"houseAddrValue\":\"浙江省温州市苍南县\",\"houseDetailAddr\":\"宜山镇仁寿街２６号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"05\",\"identityValue\":\"农民\",\"workAddr\":\"无\",\"position\":\"无\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"1106\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"imprisonLimit\":\"20200904\",\"brief\":\"2018年8月24日，因吸食毒品后被公安机关查获。\",\"comeDate\":\"20180905093357\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"林震\",\"transactorPhone\":\"747709\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"},{\"number\":\"330301131201808210040\",\"name\":\"王丽跃\",\"sex\":\"2\",\"sexValue\":\"女性\",\"birth\":\"19700814\",\"marriage\":\"2\",\"marriageValue\":\"已婚\",\"identityId\":\"330302197008145923\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330302\",\"originValue\":\"浙江省温州市鹿城区\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330302\",\"houseAddrValue\":\"浙江省温州市鹿城区\",\"houseDetailAddr\":\"南郊街道横塘巷26--3号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"09\",\"identityValue\":\"无业人员\",\"workAddr\":\"不详\",\"position\":\"不详\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"3305\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"detoxEnd\":\"20180905\",\"imprisonLimit\":\"20200904\",\"holdBegin\":\"20180821\",\"brief\":\"2018年08月21日该王丽跃因吸食毒品被公安机关查获，尿检呈阳性。\",\"comeDate\":\"20180905092658\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"叶军\",\"transactorPhone\":\"588588\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"}],\"firstPage\":1,\"prePage\":0,\"nextPage\":0,\"lastPage\":1,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1]}";
				JSONObject jsonObject = new JSONObject(datas);
				int total = jsonObject.getInt("total");
				JSONArray dataArray = jsonObject.getJSONArray("list");
				if(total>0){
					//return true;
					//for (int key=0;key<dataArray.length();key++) {
						JSONObject object = dataArray.getJSONObject(0);
						Map<String, Object> userMap = object.toMap();
						addDetoxInfoByMap(userMap);
					//}
				}
				//return false;
			}
		}
		//return true;
	}
	
	/**
	 * 人员ID，SQL删除
	 * @param number
	 */
	public void deleteById(String number) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);//  PROPAGATION_REQUIRED
		//def.setTimeout(30);
		//事务状态
		TransactionStatus status = goOnlineTransactionManager.getTransaction(def);
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("userId", number);
		executeUpdateBySql("jcDetoxInfo-deleteOneByUserId", paraMap);
		goOnlineTransactionManager.commit(status);
	}
	
	
	/**
	 * 流程第一步确认后，同步人员信息到旷视系统，同时更新本库的ksid（2018-10-09）
	 * @param number
	 * @throws IOException 
	 */
	public void addKSAfterFirstConfim(String number) throws IOException {
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null==jcDetoxInfo){
			return;
		}
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("name", jcDetoxInfo.getName());
		userMap.put("number", jcDetoxInfo.getNumber());
		byte[] faceBytes = jcDetoxInfo.getPictureByte();
		Map<String, String> ksMap = addUserToKS(userMap,faceBytes);// 人员新增旷视识别系统，并且添加识别图，返回旷视的人员ID
		String ksuserId = ksMap.get("ksid");// 旷视内部自生成用户id
		jcDetoxInfo.setKsUserId(ksuserId);// 设置旷ID
		updateSome(jcDetoxInfo);
	}
	
	/**
	 * 获取在所人员类型条件（待出所、未出所、人脸对比失败）2018-10-11
	 * @param type
	 * @return
	 */
	public static String getOutDetoxWhere(String type) {
		if(null==type||"".equals(type)){
			return null;
		}
		StringBuilder where = new StringBuilder("");
//		String nowDate = Util.getCurTime("yyyyMMdd"/*PropsUtil.getValue("outDateFormat")*/);
		if(BusinessConstant.WAIT_KEY.equals(type)){// 待出所
//			where = where.append("(to_date(IMPRISON_LIMIT,'yyyy-mm-dd')<=").append("to_date('").append(nowDate).append("','yyyy-mm-dd'))");
			where = where.append("(OUT_DATE is not null)");
		}
		if(BusinessConstant.NO_OUT_KEY.equals(type)){// 未出所
//			where = where.append("(to_date(IMPRISON_LIMIT,'yyyy-mm-dd')>").append("to_date('").append(nowDate).append("','yyyy-mm-dd'))");
			where = where.append("(OUT_DATE is null)");
		}
		if(BusinessConstant.FACE_FALSE_KEY.equals(type)){// 人脸对比失败
			where = where.append("(PICTURE_STATE='false')");
		}
		return where.toString();
	}
	
	/**
	 * 获取待出所、未出所、人脸比对失败总量
	 * @param type
	 * @return
	 */
	public String getOutManaTypeNum(String type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("waitOrNoSql", getOutDetoxWhere(type));// 获取待出所、未出所条件2018-10-11
		List<Map<String, Object>> list = findMapBySql("jcDetoxInfo-selectCount", params);
		if(null!=list&&list.size()>0){
			return list.get(0).get("TOTAL").toString();
		}
		return "0";
		
	}
	
	/**
	 * 获取各出所类型数量
	 * @return
	 */
	public Map<String, Object> getOutTypeNum() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("wait_num", getOutManaTypeNum("WAIT"));
		resultMap.put("noout_num", getOutManaTypeNum("NO_OUT"));
		resultMap.put("facefalse_num", getOutManaTypeNum("FACE_FALSE"));
		return resultMap;
	}
	
	/**
	 * 根据旷视人员id查询（2018-10-16）
	 * @param ksId
	 * @return
	 */
	public Map<String, Object> getInfoByKsId(String ksId) {
		if(null==ksId||"".equals(ksId)){
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ksId", ksId);
		List<Map<String, Object>> list = findMapBySql("jcDetoxInfo-getInfoByKsId", params);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 处理判断推送的识别数据（2018-10-19）
	 * @param json
	 * @return
	 */
	public Map<String, Object> dealSBData(String json) {
		if(null==json||"".equals(json)){
			return null;
		}
		/*******************************推送数据处理***********************************/
		// screen:识别位置的信息，只有type不为gone时才会有
    	// person:和底库里相似的人，只有type为recognized时才会有
    	// open_door:是否开门，只有type为recognized时才会有
    	// error:如果open_door为false，这个字段就是不能开门的原因
    	// type:本条信息的类型，4种，lastface（识别中）、recognized、unrecognized、gone
    	// data:算法识别的底层信息，无特殊需求的话不用处理，其中track为track id。只有当type为gone的时候，这里才包含年龄性别信息。
		Map<String, Object> resultMap = new HashMap<String, Object>();// key:userType：人员类别：（MS、JD、QT）
		String img_str = "";
		JSONObject jsonObj = new JSONObject(json);
		String type = jsonObj.getString("type");// 本条信息的类型，4种，lastface（识别中）、recognized、unrecognized、gone、attr（此类型直接退出处理）
		if(!"recognized".equals(type)){
			return null;
		}
		
		JSONObject dataObj = jsonObj.getJSONObject("data");// data对象一直存在，算法识别的底层信息
		long dataObj_quality = dataObj.getLong("quality");// 识别准确值
//		String dataObj_status = dataObj.getString("status");
		//JSONObject dataObj_statusObj = dataObj.getJSONObject("status");// 2.8版固件之后：status的值从字符串变成一个字典
		//String dataObj_statusObj_recognize_status = dataObj_statusObj.getString("recognize_status");
		//String dataObj_statusObj_snapshot_status = dataObj_statusObj.getString("snapshot_status");
		
		long dataObj_track = dataObj.getLong("track");
		long dataObj_timestamp = dataObj.getLong("timestamp");
		JSONObject dataObj_faceObj = dataObj.getJSONObject("face");
		String dataObj_faceObj_image = dataObj_faceObj.getString("image");
		img_str = dataObj_faceObj_image;
		/*if("attr".equals(type)){// attr目前不显示
			resultMap.put("userType", "MS");// 陌生人
			resultMap.put("img", img_str);
			resultMap.put("sbState", type);
			resultMap.put("sbData", json);
			return resultMap;
		}*/
		/*if("lastface".equals(type)){// 比对中目前不显示
			resultMap.put("sbState", type);
			resultMap.put("sbData", json);
			return resultMap;
		}*/
		/*if("unrecognized".equals(type)){// 未识别目前不显示
			resultMap.put("sbState", type);
			resultMap.put("sbData", json);
			return resultMap;
		}*/
		JSONObject dataObj_faceObj_rectObj = dataObj_faceObj.getJSONObject("rect");
//		var dataObj_faceObj_rectObj_top = dataObj_faceObj_rectObj["top"];
//		var dataObj_faceObj_rectObj_right = dataObj_faceObj_rectObj["right"];
//		var dataObj_faceObj_rectObj_bottom = dataObj_faceObj_rectObj["bottom"];
//		var dataObj_faceObj_rectObj_left = dataObj_faceObj_rectObj["left"];
		JSONObject dataObj_personObj = null;
		// data属性中person属性：feature_id,confidence,tag,id
		// data属性中person属性：根据type的不同会有不同：
		// gone时:subject_id，confidence，photo_id，id
		// unrecognized时候：subject_id，confidence，photo_id，id
		// recognized时候：subject_id，confidence，photo_id，id
		// lastface时：subject_id，confidence，photo_id，id
		
		dataObj_personObj = dataObj.getJSONObject("person");
		String dataObj_personObj_subject_id = dataObj_personObj.getLong("subject_id")+"";// 判断人员类型（2018-11-01三垟使用此版本**公司版本识别成功的dataObj_personObj属性与此版本不一致）
		long dataObj_personObj_confidence = dataObj_personObj.getLong("confidence");
		String dataObj_personObj_photo_id = dataObj_personObj.getLong("photo_id")+"";
		long dataObj_personObj_id = dataObj_personObj.getLong("id");
		// data属性中person属性中tag的属性(与实际数据不符舍弃)：subject_type,description,start_time,birthday,id
		/*Object tagObject = dataObj_personObj.get("tag");// tag可能为空值，可能为对象
		JSONObject dataObj_personObj_tagObj = null;
		if("".equals(Util.isEmpt(tagObject))){
			
		}else{
			dataObj_personObj_tagObj = dataObj_personObj.getJSONObject("tag");
		}
		String dataObj_personObj_id = dataObj_personObj.getString("id");*/
		
		JSONObject screenObj = null;
		JSONObject personObj = null;
		String open_door = "";
		String error = null;
		if(!"gone".equals(type)){// 
			// screen属性：camera_address,allowed_subject_ids:[],network_switcher_status,box_token,description,box_heartbeat,network_switcher,camera_name,camera_status,allow_visitor,screen_token,network_switcher_token,box_status,allow_all_subjects,type,id,camera_position,box_address
			screenObj = jsonObj.getJSONObject("screen");
			//JSONArray allowed_subject_ids = screenObj.getJSONArray("allowed_subject_ids");// 数组转换
			//int leng = allowed_subject_ids.length();
		}
		if("recognized".equals(type)){// 
			// person属性：src,remark,subject_type,description,title,timestamp,start_time,avatar,job_number,birthday,entry_date,department,end_time,id,name,
			personObj = jsonObj.getJSONObject("person");
			open_door = jsonObj.getBoolean("open_door")+"";
		}
		
		if("false".equals(open_door)){
			error = jsonObj.getString("error");
		}
		
		if("recognized".equals(type)){// 识别成功情况
			if(null==dataObj_personObj_subject_id||"".equals(dataObj_personObj_subject_id)||"0".equals(dataObj_personObj_subject_id)){
				resultMap.put("userType", "MS");// 陌生人
				resultMap.put("img", img_str/*personObj.get("src")*/);// base64
				resultMap.put("sbState", type);
				resultMap.put("type", type);
				return resultMap;
			}else{
				
				//String description = personObj.getString("description");
				String id = personObj.getLong("id")+"";
				img_str = KSUtil.getSbPhoto(id);// url
				String queryJson = "{\"id\":\""+id+"\"}";
				Map<String, Object> lisMap = fcfOutdetoxInfoService.getYInfoByKsId(id);
				if(null!=lisMap){
					resultMap = lisMap;
					resultMap.put("userType", "JD");// 戒毒人员
					resultMap.put("img", img_str/*personObj.get("src")*/);
					resultMap.put("sbState", type);
					resultMap.put("type", type);
					resultMap.put("can_open", open_door);
					resultMap.put("open_error", error);
					resultMap.put("problem", "alout");
					return resultMap;
				}
				Map<String, Object> jcInfo = checkPerson(queryJson);
				if(null!=jcInfo){// 戒毒人员
					resultMap = jcInfo;
					resultMap.put("userType", "JD");// 戒毒人员
					resultMap.put("img", img_str/*personObj.get("src")*/);
					resultMap.put("sbState", type);
					resultMap.put("type", type);
					resultMap.put("can_open", open_door);
					resultMap.put("open_error", error);
					return resultMap;
				}else{
					resultMap = personObj.toMap();
					resultMap.put("userType", "MJ");// 其他人员
					resultMap.put("img", img_str/*personObj.get("src")*/);
					resultMap.put("sbState", type);
					resultMap.put("type", type);
					resultMap.put("can_open", open_door);
					resultMap.put("open_error", error);
					return resultMap;
				}
			}
		}else{// 无底图
			/*Map<String, Object> map = new HashMap<String, Object>();
			if("unrecognized".equals(type)){
				map.put("type", "unrecognized");
				if(null==dataObj_personObj_subject_id||"".equals(dataObj_personObj_subject_id)||"0".equals(dataObj_personObj_subject_id)){
					map.put("erro", "noPhoto");
				}else {
					map.put("erro", "quality");
				}
			}*/
			/*if(null==dataObj_personObj_photo_id||"".equals(dataObj_personObj_photo_id)||"0".equals(dataObj_personObj_photo_id)){
				map.put("hasPhoto", "false");
				map.put("type", "unrecognized");
				return map;
			}*/
		}
		
		if("gone".equals(type)){// 识别结束，待处理
			resultMap.put("sbState", type);
			
		}
		
		/*******************************推送数据处理END***********************************/
		return null;
	}
	
	/**
	 * 校验大屏后，人员的流程状况（2018-10-16）
	 * @param json
	 * @return
	 */
	public Map<String, Object> checkPerson(String json) {
		if(null==json||"".equals(json)){
			return null;
		}
		
		Map<String, Object> map = JsonUtils.parseJsonToMap(json);
		String ksId = map.get("id").toString();
		Map<String, Object> personInfo = getInfoByKsId(ksId);
		if(null==personInfo){
			return null;
		}
		String outDate = Util.isEmpt(personInfo.get("OUT_DATE"));
		String baseState = Util.isEmpt(personInfo.get("BASE_COFIRM_STA"));
		String outDocState = Util.isEmpt(personInfo.get("OUT_DOC_STATE"));
		if(null==baseState||"".equals(baseState)||"false".equals(baseState)){
			personInfo.put("problem", "date");
		}else{
			if(null==outDocState||"".equals(outDocState)||"false".equals(outDocState)){
				personInfo.put("problem", "doc");
			}else{
				personInfo.put("problem", "no");
			}
		}
		/*if(null==outDate||"".equals(outDate)){
			personInfo.put("problem", "date");
		}else{
			
		}*/
		return personInfo;
	}
	
	/**
	 * 人员同步时，更新数据（2018-10-17）
	 * @param detoxInfo
	 * @param map
	 * @throws IOException
	 */
	public void updatePersonByMap(TJcDetoxInfo detoxInfo,Map<String, Object> map) throws IOException {
		if(null==detoxInfo){
			return;
		}
		String number_id = detoxInfo.getNumber();
		detoxInfo.setNumber(number_id);
		detoxInfo.setName(Util.isEmpt(map.get("name")));
		detoxInfo.setOtherName(Util.isEmpt(map.get("anotherName")));
		detoxInfo.setSex(Util.isEmpt(map.get("sex")));
		detoxInfo.setSexValue(Util.isEmpt(map.get("sexValue")));
		detoxInfo.setBirth(Util.isEmpt(map.get("birth")));
		detoxInfo.setEthnicGroup(Util.isEmpt(map.get("ethnicGroup")));
		detoxInfo.setEthnicGroupValue(Util.isEmpt(map.get("ethnicGroupValue")));
		detoxInfo.setPoliticalStatus(Util.isEmpt(map.get("politicalStatus")));
		detoxInfo.setPoliticalStatusValue(Util.isEmpt(map.get("politicalStatusValue")));
		detoxInfo.setNationality(Util.isEmpt(map.get("nationality")));
		detoxInfo.setNationalityValue(Util.isEmpt(map.get("nationalityValue")));
		detoxInfo.setHouseAddr(Util.isEmpt(map.get("houseAddr")));
		detoxInfo.setHouseAddrValue(Util.isEmpt(map.get("houseAddrValue")));
		detoxInfo.setHouseDetailAddr(Util.isEmpt(map.get("houseDetailAddr")));
		detoxInfo.setManageType(Util.isEmpt(map.get("manageType")));
		detoxInfo.setManageTypeValue(Util.isEmpt(map.get("manageTypeValue")));
		detoxInfo.setEmphasisPersoner(Util.isEmpt(map.get("emphasisPersoner")));
		detoxInfo.setEmphasisPersonerValue(Util.isEmpt(map.get("emphasisPersonerValue")));
		detoxInfo.setIdentityId(Util.isEmpt(map.get("identityId")));
		detoxInfo.setIdentityType(Util.isEmpt(map.get("identityType")));
		detoxInfo.setIdentityTypeValue(Util.isEmpt(map.get("identityTypeValue")));
		detoxInfo.setIdentity(Util.isEmpt(map.get("identity")));
		detoxInfo.setIdentityValue(Util.isEmpt(map.get("identityValue")));
		detoxInfo.setWorkAddr(Util.isEmpt(map.get("workAddr")));
		detoxInfo.setPosition(Util.isEmpt(map.get("position")));
		detoxInfo.setSpecialty(Util.isEmpt(map.get("specialty")));
		detoxInfo.setSpecialtyValue(Util.isEmpt(map.get("specialtyValue")));
		detoxInfo.setDormCode(Util.isEmpt(map.get("dormCode")));
		detoxInfo.setDetoxLimit(Util.isEmpt(map.get("detoxLimit")));
		detoxInfo.setDetoxLimitValue(Util.isEmpt(map.get("detoxLimitValue")));
		detoxInfo.setDetoxBegin(Util.isEmpt(map.get("detoxBegin")));
		detoxInfo.setDetoxEnd(Util.isEmpt(map.get("detoxEnd")));
		detoxInfo.setHoldDay(Util.isEmpt(map.get("holdDay")));
		detoxInfo.setHoldBegin(Util.isEmpt(map.get("holdBegin")));
		detoxInfo.setHoldEnd(Util.isEmpt(map.get("holdEnd")));
		detoxInfo.setBrief(Util.isEmpt(map.get("brief")));
		detoxInfo.setComeDate(Util.isEmpt(map.get("comeDate")));
		detoxInfo.setComeReason(Util.isEmpt(map.get("comeReason")));
		detoxInfo.setComeResonValue(Util.isEmpt(map.get("comeReasonValue")));
		detoxInfo.setOutDate(Util.isEmpt(map.get("outDate")));
		detoxInfo.setProcessState(Util.isEmpt(map.get("processState")));
		detoxInfo.setOutReason(Util.isEmpt(map.get("outReason")));
		detoxInfo.setOutReasonValue(Util.isEmpt(map.get("outReasonValue")));
		detoxInfo.setOutPlaceValue(Util.isEmpt(map.get("outPlaceValue")));
		detoxInfo.setMarriage(Util.isEmpt(map.get("marriage")));
		detoxInfo.setMarriageValue(Util.isEmpt(map.get("marriageValue")));
		detoxInfo.setOrigin(Util.isEmpt(map.get("origin")));
		detoxInfo.setOriginValue(Util.isEmpt(map.get("originValue")));
		detoxInfo.setEducation(Util.isEmpt(map.get("education")));
		detoxInfo.setEducationValue(Util.isEmpt(map.get("educationValue")));
		detoxInfo.setSpecialIndentity(Util.isEmpt(map.get("specialIdentity")));
		detoxInfo.setSpecialIndentityValue(Util.isEmpt(map.get("specialIdentityValue")));
		detoxInfo.setWork(Util.isEmpt(map.get("work")));
		detoxInfo.setWorkValue(Util.isEmpt(map.get("workValue")));
		byte[] photoBytes = sanyangPhotoGet(PropsUtil.getValue("prisonId"),number_id);// 获取三洋戒毒人员原始头像
		detoxInfo.setPictureByte(photoBytes);
		detoxInfo.setImprisonLimit(Util.isEmpt(map.get("imprisonLimit")));
//		updateSome(detoxInfo);
		
		String ksId = detoxInfo.getKsUserId();
		if(null!=ksId&&!"".equals(ksId)){// 
			updateSome(detoxInfo);
			String img_str = KSUtil.getSbPhoto(ksId);
			if(null==img_str||"".equals(img_str)){
				try {
					String basePath =  PropsUtil.getValue("savePhoto");
					EnUtil.createDir(basePath);// 检验文件夹，无则创建
					String path = Util.getCurTimeUUID()+".jpg";
					EnUtil.createFile(basePath+path);
					ImageUtil.GenerateImage(new String(photoBytes),basePath+path);
					KSUtil.uploadFace(ksId, basePath+path);
				} catch (Exception e) {
					return;
				}
			}
			
		}else{// 没有旷视信息
			/*boolean falg = KSUtil.deleteUserById(ksId);
			if(!falg){
				
				return;
			}*/
			// 以下旷视人员信息同步
			Map<String, String> ksMap = addUserToKS(map,photoBytes);// 人员新增旷视识别系统，并且添加识别图，返回旷视的人员ID
			String ksuserId = ksMap.get("ksid");// 旷视内部自生成用户id
			detoxInfo.setKsUserId(ksuserId);// 设置旷ID
			updateSome(detoxInfo);
		}
	}
	
	/**
	 * 检测识别底库信息（人员存在、识别底图存在情况）2018-10-31
	 * @param number
	 * @return
	 */
	public Map<String, String> checkKSState(String number) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("hasUser", "N");
		map.put("hasPhoto", "N");
		if(null==number||"".equals(number)){
			return map;
		}
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null==jcDetoxInfo){
			return map;
		}
		String ksId = jcDetoxInfo.getKsUserId();
		if(null!=ksId&&!"".equals(ksId)){
			String ksUserMap = KSUtil.getUerInfo(ksId); 
			if(null==ksUserMap){
				return map;
			}else {
				map.put("hasUser", "Y");
				JSONObject jsonObject = new JSONObject(ksUserMap);
				JSONObject dataObject = jsonObject.getJSONObject("data");
				JSONArray jsonArray = dataObject.getJSONArray("photos");
				if(jsonArray.length()>0){
					map.put("hasPhoto", "Y");
					return map;
				}else{
					return map;
				}
			}
		}
		return map;
		
	}
	
	/**
	 * 更新戒毒戒毒人员识别底图2018-10-31
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	public Map<String, String> updateSBPhoto(String number) throws IOException {
		if(null==number||"".equals(number)){
			return null;
		}
		byte[] photoBytes = SanYUtil.getPersonPhoto(number);//ImageUtil.GetImageStr("D:/IMG_2041.JPG").getBytes();
		if(null==photoBytes){
			return null;
		}
		String upPath = PropsUtil.getValue("savePhoto")+Util.getCurTimeUUID()+".jpg";
		ImageUtil.GenerateImage(new String(photoBytes), upPath);
		Map<String, Integer> xsMap = ImageUtil.getPhotoPixel(upPath);// 像素
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("isup", "false");
		if(null!=xsMap){// 底片像素
			int WIDTH = xsMap.get("WIDTH");
			int HEIGHT = xsMap.get("HEIGHT");
			if((WIDTH>=200)&&(HEIGHT>=200)){
				resultMap.put("xs", "true");
			}else{
				resultMap.put("xs", "false");
				return resultMap;
			}
		}
		TJcDetoxInfo jcDetoxInfo = findOne(number);
		if(null==jcDetoxInfo){
			return null;
		}
		String ksId = jcDetoxInfo.getKsUserId();
		if((null!=ksId)&&(!"".equals(ksId))){
			KSUtil.deleteUserById(ksId);
			/*new Thread(new Runnable() {
				@Override
				public void run() {
					KSUtil.deleteUserById(ksId);
				}
			});*/
		}
		jcDetoxInfo.setPictureByte(photoBytes);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", number);
		map.put("name", jcDetoxInfo.getName());
		// 以下旷视人员信息同步
		Map<String, String> ksMap = addUserToKS(map,photoBytes);// 人员新增旷视识别系统，并且添加识别图，返回旷视的人员ID
		String ksuserId = ksMap.get("ksid");// 旷视内部自生成用户id
		jcDetoxInfo.setKsUserId(ksuserId);// 设置旷ID
		updateSome(jcDetoxInfo);
		resultMap.put("isup", "true");
		return resultMap;
	}
	
	
	// ***添加测试数据
	public void moniAdd() {
		List<String> list = new ArrayList<String>();
		list.add("20180901");
		list.add("20180908");
		list.add("20181102");
		for(int key=0;key<list.size();key++){
			String dateString = list.get(key);
			for(int y=0;y<38;y++){// 模拟每种日期添加38条数据
				TJcDetoxInfo jcDetoxInfo = new TJcDetoxInfo();
				jcDetoxInfo.setNumber(UUID.randomUUID().toString());
				jcDetoxInfo.setName("邱云");
				jcDetoxInfo.setSex("2");
				jcDetoxInfo.setSexValue("男性");
				jcDetoxInfo.setBirth("19700814");
				jcDetoxInfo.setMarriage("2");
				jcDetoxInfo.setMarriageValue("已婚");
				jcDetoxInfo.setIdentityId("330302197008145923");
				jcDetoxInfo.setIdentityType("11");
				jcDetoxInfo.setIdentityTypeValue("身份证");
				jcDetoxInfo.setOrigin("330302");
				jcDetoxInfo.setOriginValue("浙江省温州市鹿城区");
				jcDetoxInfo.setEthnicGroup("01");
				jcDetoxInfo.setEthnicGroupValue("汉族");
				jcDetoxInfo.setPoliticalStatus("13");
				jcDetoxInfo.setPoliticalStatusValue("群众");
				jcDetoxInfo.setNationality("156");
				jcDetoxInfo.setNationalityValue("中国");
				jcDetoxInfo.setHouseAddr("330302");
				jcDetoxInfo.setHouseAddrValue("浙江省温州市鹿城区");
				jcDetoxInfo.setHouseAddrValue("南郊街道横塘巷26--3号");
				jcDetoxInfo.setSpecialIndentity("99");
				jcDetoxInfo.setSpecialIndentityValue("其他");
				jcDetoxInfo.setIdentity("09");
				jcDetoxInfo.setIdentityValue("无业人员");
				jcDetoxInfo.setWorkAddr("不详");
				jcDetoxInfo.setPosition("不详");
				jcDetoxInfo.setSpecialty("90");
				jcDetoxInfo.setSpecialtyValue("其他专长");
				jcDetoxInfo.setEducation("70");
				jcDetoxInfo.setEducationValue("初中");
				jcDetoxInfo.setWork("Y00");
				jcDetoxInfo.setWorkValue("不便分类的其他从业人员");
				jcDetoxInfo.setDormCode("3305");
				jcDetoxInfo.setDetoxLimit("14");
				jcDetoxInfo.setDetoxLimitValue("两年");
				jcDetoxInfo.setDetoxBegin("20180905");
				jcDetoxInfo.setDetoxEnd(dateString/*"20180927"*/);// 出所截止日期
				jcDetoxInfo.setHoldBegin("20180821");
				jcDetoxInfo.setHoldEnd(dateString/*"20180927"*/);// 拘留截止日期
				jcDetoxInfo.setBrief("2018年08月21日该王丽跃因吸食毒品被公安机关查获，尿检呈阳性。");
				jcDetoxInfo.setComeDate("20180905092658");
				jcDetoxInfo.setComeReason("01");
				jcDetoxInfo.setComeResonValue("");			
				jcDetoxInfo.setManageType("1");
				jcDetoxInfo.setManageTypeValue("重点");
				jcDetoxInfo.setEmphasisPersoner("1");
				jcDetoxInfo.setEmphasisPersonerValue("否");
				//jcDetoxInfo.setKsUserId("45");
				jcDetoxInfo.setPictureByte(ImageUtil.GetImageStr("D:/aaa20180926163343898.jpg").getBytes());
				add(jcDetoxInfo);
			}
			
		}
		System.out.println("模拟数据已经插入");
	}
	
	public String getPersonOutDate(String personNumber) {
		String alreadyOut="";
		TJcDetoxInfo tjcDetoxInfo = findOne(personNumber);
		if(null != tjcDetoxInfo &&!"".equals(tjcDetoxInfo.getAlreadyOut()) &&null != (tjcDetoxInfo.getAlreadyOut())){
			alreadyOut = tjcDetoxInfo.getAlreadyOut();
			return alreadyOut;
		}
		return alreadyOut;
	}
	
	public List<Map<String, Object>> getInfoByPY(String namePYCon) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(null!=namePYCon&&!"".equals(namePYCon)){
			namePYCon = namePYCon.toUpperCase();
		}
		params.put("queryCon", namePYCon);
		List<Map<String, Object>> list = findMapBySql("jcDetoxInfo-getJDByPY", params);
		return list;
	}
	
	public Map<String, Object> formatPYList(List<Map<String, Object>> list) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", null);
		resultMap.put("totalRow", 0);
		if(null!=list){
			if(list.size()>0){
				resultMap.put("list", list);
				resultMap.put("totalRow", list.size());
				return resultMap;
			}
		}
		return resultMap;
	}
	
	
	public Map<String, Object> quickSearch(String con,String type) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("showField", "'NAME'");
		paramsMap.put("queryCon", con);
		if("-1".equals(con)){
			paramsMap.put("queryCon", "SXSXSXSXSXSX");
		}
		if(null!=type&&!"".equals(type)){
			if("PY".equals(type)){
				List<Map<String, Object>> pyList = getInfoByPY(con);
				return formatPYList(pyList);
			}else{
				if("IDENTITY_ID".equals(type)){
					paramsMap.put("showField", type);
				}else {
					paramsMap.put("showField", "\""+type+"\"");
				}
			}
		}
		List<Map<String, Object>> list = findMapBySql("jcDetoxInfo-getAllJDPerson",paramsMap);
		return formatPYList(list);
		/*Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", null);
		resultMap.put("totalRow", 0);
		if(null!=list){
			if(list.size()>0){
				resultMap.put("list", list);
				resultMap.put("totalRow", list.size());
				return resultMap;
			}
		}
		return resultMap;*/
	}
}
