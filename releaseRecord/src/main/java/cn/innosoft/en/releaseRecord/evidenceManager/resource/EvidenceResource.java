package cn.innosoft.en.releaseRecord.evidenceManager.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.FcfRecordService;
import cn.innosoft.en.releaseRecord.releaseManager.service.JcDetoxInfoService;
import cn.innosoft.en.releaseRecord.releaseManager.service.SysAccService;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;
import cn.innosoft.en.util.loginUtil.JsonUtils;

/**
 * 存证管理控制层
 * 
 * @author sh
 *
 */
@Controller
@RequestMapping("evidence/")
public class EvidenceResource {
	
	
	@Autowired
	private FcfOutdetoxInfoService fcfOutdetoxInfoService;
	
	@Autowired
	private FcfRecordService fcfRecordService;
	
	@Autowired
	private SysAccService sysAccService;

	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	/**
	 * 跳转存证管理页面
	 * @param model
	 * @return
	 */
	@RequestMapping("toEvidenceManage")
	public String skipEvidenceManage(Model model,String json) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if(!Util.isEmptyString(json)){
			paraMap=JsonUtils.parseJsonToMap(json);
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
		return "sanyang/iframe/certificate/management";
	}
	
	/**
	 * 跳转到存正管理临时出所页面
	 * @param model
	 * @param json
	 * @return
	 */
	@RequestMapping("toEvidenceTempMana")
	public String skipEvidenceTemMana(Model model,String json) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if(!Util.isEmptyString(json)){
			paraMap=JsonUtils.parseJsonToMap(json);
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
		return "sanyang/iframe/certificate/temp-management";
	}
	
	/**
	 * 跳转到存证人员详情页面
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toOutDetoxDetails")
	public String skipEvidencePersonDetails(String prisonId,String number,Model model) throws IOException {
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
		model.addAttribute("nowDate", Util.getCurTime(PropsUtil.getValue("outDateFormat")));// 获取当前今天日期
		Map<String, Object> resultMap = fcfOutdetoxInfoService.getOutDetoInfoDetails(prisonId, number);// 基本信息、附件信息、出所界定啊信息
		model.addAttribute("resultMap", resultMap);
//		return "releaseRecord/evidenceManager/evidenceDetails";
		return "sanyang/released-detail";
	}
	
	/**
	 * 存证管理分页查询
	 * 
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("evidencePageList")
	@ResponseBody
	public Map<String, Object> evidencePage(String identity,String userName,String userNumber,String startDate,String endDate,String outType,String curr,String nums) {
		return fcfOutdetoxInfoService.evidencePageList(identity,userName,userNumber,startDate,endDate,outType,curr,nums);
	}

	/**
	 * 查询存证人员详情信息
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("evidencePersonDetails")
	@ResponseBody
	public Map<String, Object> getEvidencePersonDetails(String prisonId,
			String number) throws IOException {
		return fcfOutdetoxInfoService.getOutDetoInfoDetails(prisonId, number);

	}

	/**
	 * 查询出所节点所记录信息(服务层)
	 * 
	 * @param number
	 * @param name
	 * @return
	 */
	@RequestMapping("outDetoRecords")
	@ResponseBody
	public List<Map<String, Object>> getOutRecord(String number, String name) {
		return fcfRecordService.getRecordList(number, name,null);
	}

	/**
	 * 出所单文件下载
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @throws Exception 
	 */
	@RequestMapping("download/outList")
	@ResponseBody
	public void downOutList(HttpServletRequest request,
			HttpServletResponse response, String id) throws Exception {
		sysAccService.downloadAcc(request, response, id);
	}
	
	/**
	 * 获取存正管理正常、临时出所数量
	 * @return
	 */
	@RequestMapping("findCZOutManaNum")
	@ResponseBody
	public Map<String, Object> getCZOutManaNum() {
		return fcfOutdetoxInfoService.getCZOutManaNum();
	}
	
	/**
	 * 回所操作（2018-10-11）
	 * @param number
	 * @return
	 */
	@RequestMapping("comeBackOpt")
	@ResponseBody
	public String comeBackOpt(String number) {
		return fcfOutdetoxInfoService.comeBackOpt(number);
	}
	
	/**
	 * 测试返回的map中含有数组的情况（测试map用）
	 * @param id
	 * @return
	 */
	@RequestMapping("getmap")
	public String testMap(Model model) {
		fcfOutdetoxInfoService.testEntityAdd();//测试特殊字段新增
		Map<String, Object> map =  new HashMap<String, Object>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 =  new HashMap<String, Object>();
		map.put("aa", "aa来了");
		map.put("zz", "zz来了");
		list1.add(map1);
		List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map2 =  new HashMap<String, Object>();
		map2.put("cc", "cc2");
		map2.put("vv", "vv2");
		Map<String,Object> map23 = new HashMap<String, Object>();
		map23.put("cc", "cc23来也");
		map23.put("vv", "vv23来也");
		list2.add(map2);
		list2.add(map23);
		map.put("qq", "sss");
		map.put("ww", "hhh");
		map.put("list1", list1);
		map.put("list2", list2);
		model.addAttribute("mapEnt", map);
		return "releaseRecord/releaseManager/jstl";
	}
	/**
	 * 存证信息（人员基本信息）
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 */
	@RequestMapping("toOutDetoxDetails1")
	@ResponseBody
	public Map<String, Object> EvidencePersonDetails1(String prisonId,String number,Model model){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNumber", number);
		params.put("prisonId", prisonId);
		List<Map<String, Object>> list = fcfOutdetoxInfoService.findMapBySql("fcfOutdetoxInfo-selectOutDetoDetails", params);
		if(null != list && list.size()>0){
			resultMap.put("count",list.size()) ;
		}
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("data", list);
		return resultMap;
	}
	
	/**
	 * @param prisonId
	 * @param number
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("toReportDetail2")
	public String toReportDetail(Model model,String prisonId,String number,String historyid) throws IOException{
		
		model.addAttribute("role", OrmHelper.getLoginRole());// 当前用户角色
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
		Map<String, Object> mapObj = jcDetoxInfoService.getOutPersonDetails(prisonId, number);
		model.addAttribute("userObj", mapObj);
		return "sanyang/report-detail2";
	}
	

	/**
	 * 出所记录详情  
	 * 存正
	 * @param prisonId    人员编号
	 * @param historyid	      外键
	 */
	@RequestMapping("toEviOutDetoxDetails")
	public String toEviOutDetoxDetails(String historyid,String number,Model model,String prisonId) throws IOException {
		model.addAttribute("prisonId", prisonId);
		model.addAttribute("number", number);
		model.addAttribute("historyid", historyid);
		return "sanyang/released-detail2";
	}
	
	/**
	 * @param personNumber  人员编号
	 * @return  ALREADY_OUT是否处所 Y/N
	 */
	@RequestMapping("getPersonOutDate")
	@ResponseBody
	public String getPersonOutDate(String personNumber){
		return jcDetoxInfoService.getPersonOutDate(personNumber);
	}
}
