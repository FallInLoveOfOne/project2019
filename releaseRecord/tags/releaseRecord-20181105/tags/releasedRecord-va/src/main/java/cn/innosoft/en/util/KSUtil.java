package cn.innosoft.en.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.innosoft.en.util.ks.HttpDeal;

public class KSUtil {
	
	private final static String IP = PropsUtil.getValue("ksip");//"http://41.213.199.239";
	private final static String username = PropsUtil.getValue("ksacct");//"sanyang@megvii.com";
	private final static String password = PropsUtil.getValue("kspass");//"123456";
	private final static Map<String, String> LOGINMAP = new HashMap<String, String>();
	private final static Map<String, String> HEADSMAP = new HashMap<String, String>();
	
	/*static{
		LOGINMAP.put("username", username);
		LOGINMAP.put("password", password);
		HEADSMAP.put("user-agent", "Koala Admin");
		try {
			HttpDeal.post(IP+"/auth/login", LOGINMAP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void loginKS() {
		LOGINMAP.put("username", username);
		LOGINMAP.put("password", password);
		HEADSMAP.put("user-agent", "Koala Admin");
		try {
			HttpDeal.post(IP+"/auth/login", LOGINMAP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    /**
     * 登录PAD
     * @param url
     * @param json
     * @return
     * @throws Exception 
     */
    public static String loginPad() throws Exception {
    	loginKS();
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("username", username);
    	params.put("password", password);
    	params.put("pad_id", Util.getUUID());
    	params.put("device_type", "2");
    	String datas = HttpDeal.post(IP+"/pad/login", params);
    	return datas;
	}
    
    /**
     * 创建用户
     * @param url
     * @param map
     * @return id 底库人员id
     * @throws Exception 
     */
    public static String addSubject(/*String url,*/Map<String, String> map) {
    	loginKS();
    	// "新增失败结果":"code": -1002, "data": {},"新增成功：""code": 0, "data": {"avatar": "/static/upload/avatar/2018-09-17/v2_2a9b506bee349488afad8bde88a78284ed8abdd9.jpg", 
    	String data = HttpDeal.post(IP+"/subject", map);
    	JSONObject resultObject = new JSONObject(data);
    	int code_num = resultObject.getInt("code");
    	JSONObject dataObject = resultObject.getJSONObject("data");
    	if(code_num<0){// 创建失败
    		return null;
    	}
    	if(code_num>=0){
    		// userMap结果集：{birthday=null, visit_notify=false, gender=1, purpose=0, interviewee_pinyin=, description=, remark=, title=, photos=[], entry_date=-28800, password_reseted=false, id=185, job_number=977, department=, email=, come_from=, company_id=2, subject_type=1, end_time=2018223345, avatar=/static/upload/avatar/2018-09-18/v2_c28ed4c4bd7bb210626ea379669c0fd40346c490.jpg, interviewee=, start_time=2018223345, pinyin=xidurenyuan, phone=, name=吸毒人员}
    		Map<String, Object> userMap = dataObject.toMap();
    		String userId = userMap.get("id").toString();
    		System.out.println("创建ID"+userId);
    		return userId;
    	}
    	return null;
	}
    
    
    /**
     * 按用户ID获取识别记录	
     * @param subjectId
     * @return null:无识别记录，非空map:sbMap.get("photo"):拍摄头像路径
     */
    public static Map<String, Object>  getRecognizeHistory(/*String url,*/String subjectId) {
    	loginKS();
    	// String queryCon = "?start=&end=&user_role=0&user_name=&screen_id=&subject_id=45&page=1&size=10"; 
    	// 完整路径:http://41.213.199.239/event/events?subject_id=57
    	String data = HttpDeal.get(IP+"/event/events"+"?subject_id="+subjectId);
    	/******************/
    	JSONObject resultObject = new JSONObject(data);
//    	int code_num = resultObject.getInt("code");
    	JSONArray dataObject = resultObject.getJSONArray("data");
    	int dataLen = dataObject.length();
    	if(dataLen<=0){
    		return null;
    	}
    	if(dataLen>0){
    		JSONObject firstObject = dataObject.getJSONObject(0);
    		// {subject_id=2, company_id=2, gender=0.20411, subject={birthday=null, visit_notify=false, gender=2, purpose=0, interviewee_pinyin=330328199209280227, description=, remark=, title=, photos=[{subject_id=2, company_id=2, id=22, version=7, url=/static/upload/photo/2018-09-14/v2_d0676add30a6ff51d8d3eefdc37e740261b2a00a.jpg, quality=0.975701}], entry_date=null, password_reseted=false, id=2, job_number=, department=, email=, come_from=, company_id=2, subject_type=1, end_time=1536930000, avatar=/static/upload/photo/2018-09-14/v2_d0676add30a6ff51d8d3eefdc37e740261b2a00a.jpg, interviewee=330328199209280227, start_time=1536894438, pinyin=yuyingying, phone=, name=余颖颖}, confidence=78.3372, fmp=0.00307394, photo=/static/upload/event/2018-09-14/v2_dfb7afc38b4ca82bcd3c20e0e7d37c29495c5373.jpg, screen={network_switcher_token=null, allow_visitor=true, camera_position=探视中心, camera_address=rtsp://41.213.199.240:8554/0/0/0, description=null, type=1, screen_token=b02b24a8-4bf6-4072-8862-a0e29deb9b42, network_switcher_drive=2, box_status=0, camera_status=0, network_switcher=, box_heartbeat=1537239216, box_token=2a3e9060-3c04-4adb-821b-0aa1176ca8a2, is_select=1, allow_all_subjects=true, network_switcher_status=1, id=1, camera_name=, box_address=41.213.199.239}, fmp_error=false, quality=0.974827, id=205, age=20.0944, group=-1, timestamp=1536900785}
    		Map<String, Object> dataMap = firstObject.toMap();
//    		String photo = dataMap.get("photo").toString(); 
    		return dataMap;
    	}
    	return null;
    	/******************/
    	
    	/*Map<String, Object> bdMap = JsonUtils.parseJsonToMap(data);
		String sbJson = bdMap.get("data").toString();// []:标识无识别记录，
		if("[]".equals(sbJson)){// 无识别记录
			return null;
		}
		if(!"[]".equals(sbJson)){// 有识别记录
			String sb = sbJson.substring(sbJson.indexOf("{"),sbJson.indexOf("screen"));
			int index = sb.lastIndexOf(", ");
			sb = sb.substring(0, index)+"}";
			sb = Util.fromatJson(sb);
			// 截取结果：{age=26.1925, company_id=2, confidence=85.5609, fmp=2.62141E-4, fmp_error=false, gender=0.838511, group=-1, id=519, photo=/static/upload/event/2018-09-17/v2_a3191d13ae7e35d6e548a3a33db7aff70486a748.jpg, quality=0.99014}
			Map<String, Object> sbMap = JsonUtils.parseJsonToMap(sb);
			return sbMap;
		}
		return null;*/
	}
    
    /**
     * 上传人脸识别图
     * @param url
     * @param id
     * @param photoPath
     * @return
     */
    public static Map<String, Object> uploadFace(/*String url,*/String id,String photoPath) {
    	loginKS();
    	//String url = "http://41.213.199.239/subject/photo";
    	//"失败结果：""code": -1002, "data": {}, "desc": "\u53c2\u6570\u9519\u8bef"，"成功结果：""code": 0,  "data": {"company_id": 2, "id": 51,
        
		String respData = HttpDeal.upFacePhoto(IP+"/subject/photo",id,photoPath);
		JSONObject resultObject = new JSONObject(respData);
    	int code_num = resultObject.getInt("code");
    	JSONObject dataObject = resultObject.getJSONObject("data");
		if(code_num<0){
			return null;
		}
		if(code_num>=0){
			// map结果集：{origin_url=/static/upload/origin/2018-09-18/v2_427f5a78b4f2f61b0b520548f372c66f0daa775e.jpg, subject_id=185, company_id=2, id=102, version=7, url=/static/upload/photo/2018-09-18/v2_f0da416f89e9becc184873dcb8f06497247c3935.jpg, quality=0.989462}
			Map<String, Object> objMap = dataObject.toMap();
			return objMap;
		}
		return null;
	}
    
    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public static String getUerInfo(String id) {
    	loginKS();
    	String data = HttpDeal.get(IP+"/subject/"+id);
    	if(null==data||"".equals(data)){
    		return null;
    	}
    	JSONObject resultObject = new JSONObject(data);
    	int code = resultObject.getInt("code");
//    	JSONObject dataObject = resultObject.getJSONObject("data");
    	if(code<0){
    		return null;
    	}
    	if(code>=0){
    		//map结果集： {birthday=null, visit_notify=false, gender=1, purpose=0, interviewee_pinyin=, description=, remark=来自, title=, photos=[{subject_id=45, company_id=2, id=28, version=7, url=/static/upload/photo/2018-09-16/v2_2a85f26dbb2d9b4070a06a47129aa1999d85dced.jpg, quality=0.996385}], entry_date=-28800, password_reseted=false, id=45, job_number=11111, department=, email=, come_from=, company_id=2, subject_type=0, end_time=0, avatar=/static/upload/avatar/2018-09-16/v2_070a9bceae781c89b51b8dd3dd8e25ee73d18044.jpg, interviewee=, start_time=0, pinyin=ss, phone=, name=ss}
//    		Map<String, Object> map = dataObject.toMap();
    		return data;
    	}
		return null;
	}
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    public static boolean deleteUserById(String id) {
    	loginKS();
    	String data = HttpDeal.delete(IP+"/subject/"+id, null);
    	JSONObject resultObject = new JSONObject(data);
    	int code_num = resultObject.getInt("code");
    	if(code_num<0){
    		return false;
    	}
    	if(code_num>=0){
    		return true;
    	}
		return false;
	}
    
    /**
     * 1:1静态识别
     * @param id
     * @param photoPath
     * @return
     */
    public static boolean singleSB(String persionId,String photoPath) {
    	loginKS();
    	String data = HttpDeal.sbOne2one(IP+":8866/checkin", persionId, photoPath);
    	
    	JSONObject resultObject = new JSONObject(data);
    	int code = resultObject.getInt("code");
    	if(code<0){
    		return false;
    	}
    	JSONObject dataObject = resultObject.getJSONObject("data");
    	Map<String, Object> dataMap = dataObject.toMap();
    	String res_person_id = dataMap.get("person_id").toString();
    	if("0".equals(res_person_id)){
    		return false;
    	}
    	if(!"0".equals(res_person_id)){
    		return true;
    	}
		return false;
	}
    
    /**
     * 添加同时添加识别图
     * @param map
     * @param photoPath
     * @return
     */
    public static String addAndPhoto(Map<String, String> map,String photoPath) {
    	loginKS();
		String id = addSubject(map);
		uploadFace(id, photoPath);
		return id;
	}
    
    /**
     * 下载识别拍摄的头像到本地
     * @param url
     * @param path
     */
    public static void saveImage(String url,String path) {
		HttpDeal.saveImage(url, path);
	}
    
    /**
     * 修改员工信息(主要员工标识字段,photo_ids:为必填参数，空列表会删除的用户的识别头像)
     * @param id
     * @param json
     * @return
     * @throws IOException 
     */
    public static String updatePersonIndfo(byte[] sbPhotos,String id,String json) throws IOException {
    	String url = IP+"/subject/"+id;
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("description", "姓名、哪里人、办案单位、出所类型、审批结果");
    	String[] photos = {};// 识别图数组
    	params.put("photo_ids", photos);
    	json = params.toString();// put参数
    	String data = HttpDeal.httpPut(url, json, null, "utf-8");
    	String photoPath = PropsUtil.getValue("savePhoto")+Util.getCurTimeUUID()+".jpg";
    	EnUtil.createFile(photoPath);
    	ImageUtil.GenerateImage(new String(sbPhotos), photoPath);
    	uploadFace(id, photoPath);// 更新员工的识别头像
		return data;
	}
    
    
//	static String photo = "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";

    /**
     * 获取人员第一张识别底图
     * @param id
     * @return
     */
    public static String getSbPhoto(String id) {
		String map = getUerInfo(id);
		if(null != map){
			JSONObject resultObject = new JSONObject(map);
	    	int code = resultObject.getInt("code");
	    	JSONObject dataObject = resultObject.getJSONObject("data");
	    	if(code<0){
	    		return null;
	    	}
	    	if(code>=0){
	    		JSONArray jsonArray = dataObject.getJSONArray("photos");
	    		if (jsonArray.length()>0) {
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					return PropsUtil.getValue("ksip")+jsonObject.getString("url");
				}
	    	}
		}
		return null;
	}
    
    public static void main(String[] args) throws Exception {
    	
    	/**
    	 * 创建用户
    	 */
    	Map<String, String> addMap = new HashMap<String, String>();
		addMap.put("name", "戒毒人员");
		addMap.put("job_number", "977");
		addMap.put("avatar",ImageUtil.GetImageStr("D:/releaseRecordGenePhoto/20180913100952576.jpg"));
		addMap.put("gender", "1");
		addMap.put("subject_type", "0");
		addMap.put("start_time", "2018223345");
		addMap.put("end_time", "2018223345");
		addMap.put("entry_date", "2018");
		addMap.put("description", "出所人员");
		String id = addSubject(/*"http://41.213.199.239/subject",*/ addMap);
		uploadFace(/*"http://41.213.199.239/subject/photo",*/ id, "D:/releaseRecordGenePhoto/20180913100952576.jpg");
		for(int k=0;k<=10;k++){
//			String id = addSubject(/*"http://41.213.199.239/subject",*/ addMap);
//			System.out.println(id);
//			uploadFace(/*"http://41.213.199.239/subject/photo",*/ id, "D:/abiubiu/20180913145946143.jpg");
		}
    	
    	/**
    	 * 获取该用户识别记录
    	 */
//    	getRecognizeHistory(/*"http://41.213.199.239/event/events",*/ "45");
    	
    	/**
    	 * 添加人脸识别照片
    	 */
//    	uploadFace(/*"http://41.213.199.239/subject/photo",*/ "136", "D:/abiubiu/20180913145946143.jpg");
		
		/**
		 * 删除用户
		 */
//		deleteUserById("210");
		
		/**
		 * 获取用户
		 */
//		System.out.println("用户基本信息："+getUerInfo("45"));
    	
		/**
		 * 1:1人脸比对
		 */
//    	singleSB("45", "D:/IMG_2041.JPG");
    	
//    	HttpDeal.saveImage("http://41.213.199.239/static/upload/event/2018-09-20/v2_c0778d53576b9d545faca842c99ee598d95a5473.jpg",null);
    	
    	
    	
	}

}
