package cn.innosoft.en.releaseRecord.releaseManager.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.DataSynchService;
import cn.innosoft.en.releaseRecord.releaseManager.service.DemoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.FcfRecordService;
import cn.innosoft.en.releaseRecord.releaseManager.service.JcDetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.OutHistoryService;
import cn.innosoft.en.releaseRecord.releaseManager.service.SysAccService;
import cn.innosoft.en.util.BusinessConstant;
import cn.innosoft.en.util.KSUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;
import cn.innosoft.en.util.loginUtil.JsonUtils;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;

/**
 * 出所管理控制层
 * 
 * @author sh
 *
 */
@Controller
@RequestMapping("release/")
public class ReleaseResource {

	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;

	@Autowired
	private DemoService demoService;
	
	@Autowired
	private FcfRecordService fcfRecordService;
	
	@Autowired
	private FcfOutdetoxInfoService fcfOutdetoxInfoService;
	
	@Autowired
	private SysAccService sysAccService;
	
	@Autowired
	private OutHistoryService outHistoryService;
	
	@Autowired
	private DataSynchService dataSynchService;

	/**
	 * 分页模式1 前端数据格式：var queryCondition2 =
	 * '{"id":"'+Id+'","userName":"'+Name+'"}'; $("#tblResult").datagrid({
	 * queryParams : {queryCondition:queryCondition2},
	 * 
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("getListPage")
	@ResponseBody
	public PageResponse<Map<String, Object>> getExpertInfoList(
			PageRequest pageRequest) {
		jcDetoxInfoService.testEntityAdd();
		fcfRecordService.getRecordList(null, null,null);
		return demoService.getListQueryPage(pageRequest);
	}

	/**
	 * 初代版本layui分页 前端数据格式参考:page_2.js
	 * 
	 * @param id
	 * @param name
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("getListPage2")
	@ResponseBody
	public Map<String, Object> getListPage2(String userName,String userNumber,String startDate,String endDate,String excepVal,String curr,String nums) {
		jcDetoxInfoService.moniAdd();// 添加戒毒人热源模拟数据	
		return demoService.getListPage2(userName,userNumber,startDate,endDate,excepVal,curr,nums);
	}

	/********************************************************正式 ***************************************************/
	
	/**
	 * 跳转到出所管理页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toReleaseManage")
	public String skipManage(Model model,String json) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if(!Util.isEmptyString(json)){
			paraMap = JsonUtils.parseJsonToMap(json);
		}
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		//快速搜索根据选中类型回显对应的input   NUMER-编号 , SFZ-身份证,  NAME-姓名
		Object flagRedio = paraMap.get("flagRedio");
		//选中人员编号
		if("NUMER".equals(flagRedio)){model.addAttribute("jsonQuery", paraMap);}
		//人员姓名
		if("NAME".equals(flagRedio)){model.addAttribute("jsonQueryName", paraMap);}
		//身份证
		if("SFZ".equals(flagRedio)){model.addAttribute("jsonQuerySFZ", paraMap);}
		return "sanyang/iframe/release/normal";
	}
	
	@RequestMapping("toTempManage")
	public String skipTempManage(Model model,String json) {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if(!Util.isEmptyString(json)){
			paraMap = JsonUtils.parseJsonToMap(json);
		}
		//快速搜索根据选中类型回显对应的input   NUMER-编号 , SFZ-身份证,  NAME-姓名
		Object flagRedio = paraMap.get("flagRedio");
		//选中人员编号
		if("NUMER".equals(flagRedio)){model.addAttribute("jsonQuery", paraMap);}
		//人员姓名
		if("NAME".equals(flagRedio)){model.addAttribute("jsonQueryName", paraMap);}
		//身份证
		if("SFZ".equals(flagRedio)){model.addAttribute("jsonQuerySFZ", paraMap);}
		return "sanyang/iframe/release/temp";
	}
	
	/**
	 * 跳转到出所人员详情页
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toDetoxDetails")
	public String skipDetails(String prisonId, String number,Model model) throws IOException {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
		model.addAttribute("nowDate", PropsUtil.getValue("outDateFormat")); // 获取当天日期
		model.addAttribute("exceptionStage", jcDetoxInfoService.getExceptionStage(prisonId, number));// 获取出所异常阶段
		Map<String, Object> resutlMap = jcDetoxInfoService.getOutPersonDetails(prisonId, number);
		model.addAttribute("resutlMap", resutlMap);
		return "releaseRecord/releaseManager/detoxDetails";
	}
	
	/**
	 * 获取该戒毒人员出所异常阶段
	 * @param prisonId
	 * @param number
	 * @return
	 */
	@RequestMapping("getExceptionStage")
	@ResponseBody
	public String judgeExceptionStage(String prisonId, String number) {
		return jcDetoxInfoService.getExceptionStage(prisonId, number);
	}
	
	/**
	 * 跳转到基本信息确认页
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toBaseInfoConfirm")
	public String skipBaseInfoConfirm(String prisonId, String number,Model model) throws IOException {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
		model.addAttribute("nowDate", PropsUtil.getValue("outDateFormat"));// 获取当天日期
		model.addAttribute("exceptionStage", jcDetoxInfoService.getExceptionStage(prisonId, number));// 获取出所异常阶段
		Map<String, Object> resutlMap = jcDetoxInfoService.getOutPersonDetails(prisonId, number);
		model.addAttribute("resutlMap", resutlMap);
		return "releaseRecord/releaseManager/baseInfoConfirm";
	}
	
	/**
	 * 跳转到人脸比对页面
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toFaceCheck")
	public String skipFaceCheck(String prisonId, String number,Model model) throws IOException {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
//		model.addAttribute("userObj", jcDetoxInfoService.findOne(number));
		Map<String, Object> resutlMap = jcDetoxInfoService.getOutPersonDetails(prisonId, number);// 详情，含有头像路径
		model.addAttribute("resutlMap", resutlMap);
//		model.addAttribute("photoPath", jcDetoxInfoService.getPersonPhotoFile(prisonId, number));//由于远程接口不暂注释， 获取戒毒人员原始头像
		return "sanyang/compare-img";
	}
	
	/**
	 * 跳转到出所单上传页面
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toOutListUpload")
	public String skipOutListUpload(String prisonId, String number,Model model) throws IOException {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
//		model.addAttribute("userObj", jcDetoxInfoService.findOne(number));// 2018-10-10注释
		Map<String, Object> mapObj = jcDetoxInfoService.getOutPersonDetails(prisonId, number);
		model.addAttribute("userObj", mapObj);
		//return "sanyang/upload-report";
		return "sanyang/report-detail";// 出所单详情展示页面2018-10-12
	}
	
	

	/**
	 * 同步三洋戒毒人员数据到本地
	 * 
	 * @param endData 出所日期
	 * @param days 近多少天
	 * @throws IOException 
	 */
	@RequestMapping("synchroPersonData")
	@ResponseBody
	public void synchroPersonData(String endData, String days) throws IOException {
		jcDetoxInfoService.synchroPersonData();
//		dataSynchService.synchroPersonData();
	}
	

	/**
	 * 正常出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("normalPage")
	@ResponseBody
	public Map<String, Object> normalReleasePage(String identity,String userName,String userNumber,String startDate,String endDate,String excepVal,String waitOrFlag,String curr,String nums) throws IOException {
//		jcDetoxInfoService.addOneUserTo(userNumber);// 判断并同步，2018-10-23注释
		return jcDetoxInfoService.normalReleasePage(identity,userName,userNumber,startDate,endDate,excepVal,waitOrFlag,curr,nums);
	}
	
	/**
	 * 临时出所为单条查询
	 * @param prisonId:监所编号
	 * @param number:编号或者证件号
	 * @return
	 */
	@RequestMapping("getTemoOut")
	@ResponseBody
	public Map<String, Object> getTemoOut(String prisonId,
			String number) {
		return jcDetoxInfoService.manageTempOut(prisonId, number);
	}

	/**
	 * **废弃
	 * 临时出所出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("temporaryPage")
	@ResponseBody
	public PageResponse<Map<String, Object>> temporaryReleasePage(
			PageRequest pageRequest) {
		return jcDetoxInfoService.temporaryReleasePage(pageRequest);
	}

	/**
	 * 查询出所人员详情信息（本库）
	 * 包含头像同步
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("outPersonDetails")
	public String getOutPersonDetails(String prisonId,
			String number,Model model) throws IOException {
//		sysAccService.testTB(number);// 测试旷视数据同步
		Map<String, Object> mapObj = jcDetoxInfoService.getOutPersonDetails(prisonId, number);
		model.addAttribute("mapObj", mapObj);
		return "sanyang/will-release-detail";
	}

	/**
	 * 出所头像核对
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("headPhotoCheck")
	@ResponseBody
	public Map<String, String> headPortraitCheck(String prisonId, String number,String ksuserId) throws IOException {
		return jcDetoxInfoService.headPortraitCheck(prisonId, number,ksuserId);
	}
	
	/*-----------------------------------------------管理页面、详情页（正常出所、临时出所）出所操作请求----------------------------------------*/
	
	/**
	 * 判断点击出所时，是直接到跳到上次的操作记录、还是第一次操作，并且获取下一步操作
	 * @param number
	 * @param outType 出所类型
	 * @return
	 */
	@RequestMapping("checkOutButon")
	@ResponseBody
	public Map<String, String> checkOutButon(String number,String name,String outType) {
		return jcDetoxInfoService.checkOutButon(number, name, outType);
	}
	
	/**
	 * 达到时间单的出所，【确认完成】，下一步
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("achieveTimeSureOut")
	@ResponseBody
	public String achieveTimeSure(String number,String name,String outType) throws IOException {
		boolean flag = fcfRecordService.checkFirstAndUpdate(number, BusinessConstant.ZBCS_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		
		// 添加操作节点信息
		fcfRecordService.addOptInfo(number, name, BusinessConstant.ZBCS_KEY, BusinessConstant.ZBCS_VAL, "N");// 添加确认下一步操作
		jcDetoxInfoService.updateOutType(number, BusinessConstant.NORMAL_VAL, BusinessConstant.NORMAL_KEY);
		jcDetoxInfoService.updateOutBaseInfoSta(number, Util.getCurTimeUUID(), "true", "");// 更新确认状态和异常
//		jcDetoxInfoService.addKSAfterFirstConfim(number);// 确认后，信息同步到旷视（2018-10-09）
		return "ok";
	}
	
	/**
	 * 达到时间，【尚未完成】，暂不出所
	 * @param number
	 * @param name
	 * @param outType
	 * @return
	 */
	@RequestMapping("uncompleteZB")
	@ResponseBody
	public String uncompleteZB(String number,String name,String outType) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(number, BusinessConstant.LCSB_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(number, name, BusinessConstant.LCSB_KEY, BusinessConstant.LCSB_VAL, "Y");
		jcDetoxInfoService.updateOutType(number, BusinessConstant.NORMAL_VAL, BusinessConstant.NORMAL_KEY);// 更新出所类型
		jcDetoxInfoService.updateOutBaseInfoSta(number, Util.getCurTimeUUID(), "false", BusinessConstant.SHSB_TEXT);// 更新确认状态和异常
		return null;
	}
	
	/**
	 * 达到时间，【尚未完成】，跳过、下一步
	 * @param number
	 * @param name
	 * @param outType
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("uncompleteNext")
	@ResponseBody
	public String uncompleteNext(String number,String name,String outType) throws IOException {
		boolean flag = fcfRecordService.checkFirstAndUpdate(number, BusinessConstant.ZBCS_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(number, name, BusinessConstant.ZBCS_KEY, BusinessConstant.LCSB_NEXT_VAL, "Y");
		jcDetoxInfoService.updateOutType(number, BusinessConstant.NORMAL_VAL, BusinessConstant.NORMAL_KEY);// 更新出所类型
		jcDetoxInfoService.updateOutBaseInfoSta(number, Util.getCurTimeUUID(), "false", BusinessConstant.SHSB_TEXT);// 更新确认状态和异常
//		jcDetoxInfoService.addKSAfterFirstConfim(number);// 确认后，信息同步到旷视（2018-10-09）
		return null;
	}
	
	/**
	 * 未到达时间，临时出所、【是】
	 * @param number
	 * @param name
	 * @param outType
	 * @throws IOException 
	 */
	@RequestMapping("temOutY")
	@ResponseBody
	public String temOutY(String number,String name,String outType) throws IOException {
		boolean flag = fcfRecordService.checkFirstAndUpdate(number, BusinessConstant.ZBCS_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(number, name, BusinessConstant.ZBCS_KEY, BusinessConstant.ZBCS_VAL, "Y");
		jcDetoxInfoService.updateOutType(number, BusinessConstant.TEMP_VAL, BusinessConstant.TEMP_KEY);
		jcDetoxInfoService.updateOutBaseInfoSta(number, Util.getCurTimeUUID(), "true","");// 更新确认状态和异常
//		jcDetoxInfoService.addKSAfterFirstConfim(number);// 确认后，信息同步到旷视（2018-10-09）
		return null;
	}
	
	
	
	/*-----------------------------------------------（基本信息确认、头像比对、出所单附件操作请求）----------------------------------------*/
	
	
	/**
	 * 头像对比成功下一步
	 * @param personNumber
	 * @param checkTime 头像对比成功时间
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("headCheckOk")
	@ResponseBody
	public String headCheckOkNext(String personNumber,String checkTime,String name,String opt) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.DBCG_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.DBCG_KEY, BusinessConstant.DBCG_VAL, "N");// 添加出所节点节点记录
		jcDetoxInfoService.updateHeadcheckSta(personNumber, checkTime, "true", "");// 更新头像对比状态和异常
		jcDetoxInfoService.outSuccessUpdate(personNumber);// 更新出所成功、实际出所时间
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
		return null;
	}
	
	/**
	 * 头像比对失败（暂时不出所）
	 * @param personNumber
	 * @param checkTime
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("headCheckFalse")
	@ResponseBody
	public String headCheckFalse(String personNumber,String checkTime, String name,String opt) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.DBSB_NO_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.DBSB_NO_KEY, BusinessConstant.DBSB_NO_VAL, "Y");// 添加出所节点节点记录
		jcDetoxInfoService.updateHeadcheckSta(personNumber, checkTime, "false", BusinessConstant.DBSB_TEXT);// 更新基本信息确认
		return null;
	}
	
	/**
	 * 头像比对失败（跳过继续下一步）
	 * @param personNumber
	 * @param checkTime
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("headCheckSkip")
	@ResponseBody
	public String headCheckSkip(String personNumber, String checkTime,String name,String opt) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.DBSB_NEXT_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.DBSB_NEXT_KEY, BusinessConstant.DBSB_NEXT_VAL, "Y");// 添加出所节点节点记录
		jcDetoxInfoService.updateHeadcheckSta(personNumber, checkTime, "false", BusinessConstant.DBSB_TEXT);// 更新基本信息确认
		jcDetoxInfoService.outSuccessUpdate(personNumber);// 更新出所成功、实际出所时间
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
		return null;
	}
	
	/**
	 * 头像暂不对比
	 * @param personNumber
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("headTemNoCheck")
	@ResponseBody
	public String headTemNoCheck(String personNumber, String name,String opt) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.ZBDB_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.ZBDB_KEY, BusinessConstant.ZBDB_VAL, "N");// 添加出所节点节点记录
		jcDetoxInfoService.outSuccessUpdate(personNumber);// 更新出所成功、实际出所时间
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
		return null;
	}
	
	/**
	 * 出所单文件暂不上传，跳过
	 * @param personNumber
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("noUploadOutList")
	@ResponseBody
	public String noUploadOutList(String personNumber, String name,String opt) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.FJBC_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		
		List<Map<String, Object>> accList = sysAccService.findAccsByBusinessId(personNumber, "outlist");
		if(null!=accList){// 出所单已上传，不操作
			if(accList.size()>0){
				return "";
			}
		}
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.FJBC_KEY, BusinessConstant.FJBC_VAL, "N");// 添加出所节点记录
		jcDetoxInfoService.updateOutListSta(personNumber, Util.getCurTimeUUID(), "false", BusinessConstant.NO_LIST_TEXT);// 更新出所单上传情况
		jcDetoxInfoService.updateOutStaSuccess(personNumber);// 更新出所成功标记
		jcDetoxInfoService.updateTrueOutDate(personNumber);// 更新出所时间
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		return null;
	}
	
	/**
	 * 出所单页面，出所成功点击请求
	 * @param personNumber
	 * @param name
	 * @param opt
	 * @return
	 */
	@RequestMapping("outSuccess")
	@ResponseBody
	public String outSuccess(String personNumber, String name,String opt) {
		// 出所成功，标记为出所成功、数据同步到存证管理
		jcDetoxInfoService.updateOutStaSuccess(personNumber);
		// 人员同步到存证管理
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);
		return null;
	}
	/*----------------------------------------------------------------------------------------------------------------------------------*/

	/**
	 * 出所单文件上传（存证详情）
	 * @throws Exception 
	 */
	@RequestMapping(value = "upload/outList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadOutList(HttpServletRequest request) throws Exception {
		String result = sysAccService.uploadOutListFile(request, "filename");// 上传附件，并且更新出所单上传情况
		String personNumber = request.getParameter("personNumber");
		String personName = request.getParameter("personName");
		String upType = request.getParameter("upType");// 用于标记出所管理、还是存证管理的上传，用户判断是否拷贝数据
		jcDetoxInfoService.updateOutStaSuccess(personNumber);// 标记出所成功
		fcfOutdetoxInfoService.updateOutStaSuccess(personNumber);// 更新出所成功
		if("cs".equals(upType)){// 出所环节
			jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		}else{// 存证管理详情中上传，不许上传copy数据
			//"cz".equals(upType);
			boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.FJYC_KEY);
			if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
				return null;
			}else{
				fcfRecordService.addOptInfo(personNumber, personName, BusinessConstant.FJYC_KEY, BusinessConstant.FJYC_VAL, "N");// 添加出所节点记录
			}
		}
		return result;
	}
	
	/**
	 * 人脸图片上传
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "upload/facePhoto", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadHeadPhoto(HttpServletRequest request) throws Exception {
		return sysAccService.uploadFacePhoto(request, "filename");
	}
	
	/**
	 * 出所单多附件上传（环节）
	 * @param request
	 * @param name
	 * @param age
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "upload/mulitUpload", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String mulitOutUpload(HttpServletRequest request,String upType,String personNumber,String personName) throws Exception {
		String result = sysAccService.mulitOutUpload(request, "filename", upType, personNumber, personName);// 上传附件，并且更新出所单上传情况
		jcDetoxInfoService.updateOutStaSuccess(personNumber);// 标记出所成功
		jcDetoxInfoService.updateTrueOutDate(personNumber);// 跟新出所时间
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.FJYC_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return result;
		}else{
			fcfRecordService.addOptInfo(personNumber, personName, BusinessConstant.FJYC_KEY, BusinessConstant.FJYC_VAL, "N");// 添加出所节点记录
		}
		return result;
	}
	
	/**
	 * 删除出所单
	 * @param accId
	 * @param number
	 * @return
	 */
	@RequestMapping("deleteAccById")
	@ResponseBody
	public Map<String, String> deleteSysAcc(String accId,String number) {
		sysAccService.deleteAccById(accId);
		Map<String, String> resultMap = new HashMap<String, String>();
		List<Map<String, Object>> outList = sysAccService.findAccsByBusinessId(number, "outlist");// 查询出所单
		if(null==outList||outList.size()<=0){// 已经没有出所单
			fcfRecordService.deleteNewUploadRecord(number);// 删除最近上传出所单的操作记录
			jcDetoxInfoService.updateOutListSta(number, Util.getCurTimeUUID(), "false", BusinessConstant.NO_LIST_TEXT);// 更新待出所出所单上传情况
			fcfOutdetoxInfoService.updateOutListSta(number, Util.getCurTimeUUID(), "false", BusinessConstant.NO_LIST_TEXT);// 更新已出所出所单上传情况
			resultMap.put("listState", "false");
		}
		resultMap.put("listState", "true");
		return null;
	}
	
	/**
	 * 确认出所单（取消文件上传）2018-10-11
	 * @param personNumber
	 * @param personName
	 * @return
	 */
	@RequestMapping("sureOutList")
	@ResponseBody
	public String sureOutList(String personNumber,String personName) {
//		jcDetoxInfoService.updateOutStaSuccess(personNumber);// 标记出所成功
//		jcDetoxInfoService.updateTrueOutDate(personNumber);// 跟新出所时间
		
//		jcDetoxInfoService.sureOutListUpdate(personNumber);// 确认出所单，更新
//		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
//		outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.FJYC_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		fcfRecordService.addOptInfo(personNumber, personName, BusinessConstant.FJYC_KEY, BusinessConstant.FJYC_VAL, "N");// 添加出所节点记录
		jcDetoxInfoService.updateOutListSta(personNumber, Util.getCurTimeUUID(), "true", "");// 更新出所单上传情况
		return null;
	}
	
	/**
	 * 未确认出所单，跳过（取消附件处理）2018-10-11
	 * @param personNumber
	 * @param name
	 * @return
	 */
	@RequestMapping("noSureOutList")
	@ResponseBody
	public String noSureOutList(String personNumber, String name) {
		boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.FJBC_KEY);
		if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
			return null;
		}
		
		fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.FJBC_KEY, BusinessConstant.FJBC_VAL, "N");// 添加出所节点记录
//		jcDetoxInfoService.updateOutListSta(personNumber, Util.getCurTimeUUID(), "false", BusinessConstant.NO_LIST_TEXT);// 更新出所单上传情况
//		jcDetoxInfoService.updateOutStaSuccess(personNumber);// 更新出所成功标记
//		jcDetoxInfoService.updateTrueOutDate(personNumber);// 更新出所时间
		jcDetoxInfoService.noSureOutListUpdate(personNumber);
		jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
		return null;
	}
	
	/**
	 * 获取在所人员（待出所、未出所、人脸对比失败）数量
	 * @param type
	 * @return
	 */
	@RequestMapping("findOutManaTypeNum")
	@ResponseBody
	public Map<String, Object> getOutManaTypeNum() {
		return jcDetoxInfoService.getOutTypeNum();
	}
	
	/**
	 * 跳转到人脸对比大屏（2018-10-16）
	 * @return
	 */
	@RequestMapping("toBigScreenFace")
	public String toBigScreenFace() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		String acct = request.getParameter("account");
//		System.out.println("session 当前账号："+acct);
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
//		return "releaseRecord/releaseManager/big-screen";
		return "sanyang/iframe/mask/masker";
	}
	
	/**
	 * 格式化、处理识别推送的结果（2018-10-19）
	 * @param json
	 * @return
	 */
	@RequestMapping("dealSBData")
	@ResponseBody
	public Map<String, Object> dealSBData(String json) {
		Map<String, Object> map = jcDetoxInfoService.dealSBData(json);
		if(null!=map){
			String userType = Util.isEmpt(map.get("userType"));
			String problem = Util.isEmpt(map.get("problem"));
			String personNumber = Util.isEmpt(map.get("NUMBER"));
			String name = Util.isEmpt(map.get("NAME"));
			String can_open = Util.isEmpt(map.get("can_open"));// 开门是否失败
			if("JD".equals(userType)){
				boolean flag = fcfRecordService.checkFirstAndUpdate(personNumber, BusinessConstant.DBCG_KEY);
				if(flag){// 如果最新操作记录状态与现在预操作状态相吻合,更新最新记录，不添加
					return map;
				}
				if(("no".equals(problem))&&(!"false".equals(can_open))){
					fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.DBCG_KEY, BusinessConstant.DBCG_VAL, "N");// 添加出所节点节点记录
					jcDetoxInfoService.updateHeadcheckSta(personNumber, Util.getCurTimeUUID(), "true", "");// 更新头像对比状态和异常
					jcDetoxInfoService.outSuccessUpdate(personNumber);// 更新出所成功、实际出所时间
					jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
					outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
				}
			}
		}
		return map;
	}
	
	/**
	 * 大屏展示，校验对比的人员流程问题并显示（2018-10-16）
	 * @param json
	 * @return
	 */
	@RequestMapping("checkPerson")
	@ResponseBody
	public Map<String, Object> checkPerson(String json) {
		Map<String, Object> map = jcDetoxInfoService.checkPerson(json);
		return map;
	}
	
	/**
	 * 大屏人脸识别后，校验、出所操作（2018-10-16）
	 * @param json
	 * @return
	 */
	@RequestMapping("sbOutDeal")
	@ResponseBody
	public Map<String, Object> sbAfterOutDeal(String json) {
		Map<String, Object> map = JsonUtils.parseJsonToMap(json);//jcDetoxInfoService.checkPerson(json);
		if(null==map){
			return null;
		}
		String problem = Util.isEmpt(map.get("problem"));
		if("no".equals(problem)){
			String personNumber = Util.isEmpt(map.get("NUMBER"));
			String name = Util.isEmpt(map.get("NAME"));
			fcfRecordService.addOptInfo(personNumber, name, BusinessConstant.DBCG_KEY, BusinessConstant.DBCG_VAL, "N");// 添加出所节点节点记录
			jcDetoxInfoService.updateHeadcheckSta(personNumber, Util.getCurTimeUUID(), "true", "");// 更新头像对比状态和异常
			jcDetoxInfoService.outSuccessUpdate(personNumber);// 更新出所成功、实际出所时间
			jcDetoxInfoService.copyDetoxToOUTDETOX(personNumber);// 人员同步到存证管理
			outHistoryService.addOutHisByNumber(personNumber);// 添加出所记录
		}
		return null;
	}
	
	/**
	 * 测试socket（2018-10-24）
	 * @param model
	 * @return
	 */
	@RequestMapping("toSocket")
	public String toSocket(Model model) {
		model.addAttribute("sb", KSUtil.getUerInfo("10635"));
		return "releaseRecord/releaseManager/big-screen";
	}
	
	/**
	 * 跟新人脸识别底图2018-11-12
	 * @param number
	 * @throws IOException
	 */
	@RequestMapping("updateSB")
	@ResponseBody
	public Map<String, String> updateSBPhoto(String number) throws IOException {
		return jcDetoxInfoService.updateSBPhoto(number);
	}
	
	/**
	 * 跳转到批量出所单确认页面（2018-10-09）
	 * @param idArray
	 * @param model
	 * @return
	 */
	@RequestMapping("toBatchOutList/{idArray}")
	public String toBatchOutList(@PathVariable ArrayList<String> idArray,Model model) {
		model.addAttribute("idArray", idArray);
		return null;
	}
	
	/**
	 * 跳转到批量人脸对比
	 * @param idArray
	 * @param model
	 * @return
	 */
	@RequestMapping("toBatchFace/{idArray}")
	public String toBatchFace(@PathVariable ArrayList<String> idArray,Model model) {
		model.addAttribute("idArray", idArray);
		return null;
	}
	
	/**
	 * 批量第一步确认(var idArray = [];url:address+"release/batchConfim/"+idArray)
	 * @param idArray
	 * @param outType
	 * @return
	 */
	@RequestMapping("batchConfim/{idArray}")
	@ResponseBody
	public String batchOutBaseConfirm(@PathVariable ArrayList<String> idArray,String outType) {
		return null;
	}
	
	/**
	 * 批量出所单确认
	 * @param idArray
	 * @param optType
	 */
	@RequestMapping("batchOutListConfim/{idArray}/{optType}")
	public void confirmOutList(@PathVariable ArrayList<String> idArray,@PathVariable String optType) {
		
	}
	
	/**
	 * 批量人脸对比
	 * @param id
	 */
	@RequestMapping("batchFace/{idArray}")
	@ResponseBody
	public Map<String, String> faceCheck(@PathVariable ArrayList<String> idArray) {
		return null;
	}
	
	/**
	 * 获取所有戒毒人员数据(2018-11-22)
	 * @return
	 */
	@RequestMapping("getAllJDPerson")
	@ResponseBody
	public Map<String, Object> quickSearch(String queryCon,String type) {
		System.out.println("类型条件："+queryCon);
		return jcDetoxInfoService.quickSearch(queryCon,type);
	}

}
