package cn.innosoft.en.releaseRecord.home.resource;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.releaseRecord.home.model.DemoUser;
import cn.innosoft.en.releaseRecord.home.service.DemoUserService;
import cn.innosoft.en.releaseRecord.home.service.HomeService;
import cn.innosoft.en.releaseRecord.releaseManager.service.JcDetoxInfoService;
import cn.innosoft.en.util.BusinessConstant;
import cn.innosoft.en.util.Util;

/**
 * 
 * @author sh
 *
 */
@Controller
@RequestMapping(value = "home/")
public class HomeResource {

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private DemoUserService demoUserService;
	
	@Autowired
	private JcDetoxInfoService  jcDetoxInfoService;
	
	@Autowired
	private FcfOutdetoxInfoService fcfOutdetoxInfoService;

	@RequestMapping("forward/homePage")
	public String getUserAndDepInfo(Model model) {
		System.out.println("当前用户账号："+OrmHelper.getCurrentUserAcct());
		model.addAttribute("result", homeService.getUserAndDepInfo());
//		return demoUserService.getOneByTemplet("11");
//		return "releaseRecord/index/index";
		//return "sanyang/main";
		return "sanyang/index";
	}
	
	
	@RequestMapping("addOne")
	@ResponseBody
	public void addOneObj(DemoUser userObj) {
		demoUserService.addOneUser(userObj);
	}
	/**
	 * 获取人员角色名
	 */
	@RequestMapping("getLoginName")
	@ResponseBody
	public String getLoginName() {
		String loginRole = OrmHelper.getCurrentUserName();
		return loginRole;
	}
	
	/**
	 *快速搜索  人员编号
	 */
	@RequestMapping("search/{json}")
	public String search(@PathVariable("json") String json,Model model) {
		Map<String, String> map = Util.parseJsonToMap(json);
		model.addAttribute("flag", map.get("flag"));
		model.addAttribute("ID", map.get("ID"));
		model.addAttribute("flagRedio", map.get("flagRedio"));
		model.addAttribute("BusiStatus", map.get("BusiStatus"));
		return "sanyang/main";
	}
	
	/**判断快速搜索的人员编号（身份证，姓名）是出所还是存证
	 * @param ID 快速搜索的值
	 * @param checkedType   NUMER人员编号   SFZ身份证   NAME姓名
	 * @param model  
	 * @return  inDetox_D待出所    inDetox_W未出所   OutDetox_Normal正常出所    OutDetox_Temp临时出所
	 */
	@RequestMapping("initSearch")
	@ResponseBody
	public String initSearch(String ID,String checkedType) {
		String BusiStatus="";
		if("NUMER".equals(checkedType)){
			Map<String, Object>  map = null;
			map = jcDetoxInfoService.normalReleasePage("","", ID, "", "", "", BusinessConstant.WAIT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.WAIT_KEY;
			}
			map =jcDetoxInfoService.normalReleasePage("","", ID,"", "","", BusinessConstant.NO_OUT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.NO_OUT_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList("","", ID, "", "", BusinessConstant.NORMAL_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.NORMAL_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList("","",ID, "", "", BusinessConstant.TEMP_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.TEMP_KEY;
			}
			return BusiStatus;
		}
		if("SFZ".equals(checkedType)){
			Map<String, Object>  map = null;
			map = jcDetoxInfoService.normalReleasePage(ID,"", "", "", "", "", BusinessConstant.WAIT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.WAIT_KEY;
			}
			map =jcDetoxInfoService.normalReleasePage(ID,"", "","", "","", BusinessConstant.NO_OUT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.NO_OUT_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList(ID,"", "", "", "", BusinessConstant.NORMAL_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.NORMAL_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList(ID,"","", "", "", BusinessConstant.TEMP_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.TEMP_KEY;
			}
			return BusiStatus;
		}
		if("NAME".equals(checkedType)){
			Map<String, Object>  map = null;
			map = jcDetoxInfoService.normalReleasePage("",ID, "", "", "", "", BusinessConstant.WAIT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.WAIT_KEY;
			}
			map =jcDetoxInfoService.normalReleasePage("",ID, "","", "","", BusinessConstant.NO_OUT_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus=  BusinessConstant.NO_OUT_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList("",ID, "", "", "", BusinessConstant.NORMAL_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.NORMAL_KEY;
			}
			map = fcfOutdetoxInfoService.evidencePageList("",ID,"", "", "", BusinessConstant.TEMP_KEY, "1", "10");
			if(null!=map.get("data")&&!"0".equals(map.get("count").toString())){
				BusiStatus =  BusinessConstant.TEMP_KEY;
			}
			return BusiStatus;
		}
		
		return BusiStatus;
	}

	/**
	 * 更多详情跳转
	 */
	@RequestMapping("tomain/{flag}")
	public String tomain(@PathVariable("flag") String flag,Model model) {
		model.addAttribute("flag", flag);
		return "sanyang/main";
	}
	
	/**
	 * 获取处理事项数量
	 */
	@RequestMapping("getMatterNum")
	@ResponseBody
	public Map<String,Object> getMatterNum(){
		Map<String,Object> map = new HashMap<>();
		//   逾期未处理  
		/*Map<String, Object> todatNum = jcDetoxInfoService.normalReleasePage("", "", getToday(), getToday(), "",null, "1", "10");
		Map<String, Object> overdue = jcDetoxInfoService.normalReleasePage("", "", "",getToday(), "",null, "1", "10");
		Map<String, Object> InfoFail = jcDetoxInfoService.normalReleasePage("", "", "", "", "sh",null, "1", "10");
		Map<String, Object> face = jcDetoxInfoService.normalReleasePage("", "", "", "", "face",null, "1", "10");
		Map<String, Object> recordUP = jcDetoxInfoService.normalReleasePage("", "", "", "", "doc",null, "1", "10");
		map.put("todatNum", todatNum.get("count"));
		map.put("overdue", overdue.get("count"));
		map.put("InfoFail", InfoFail.get("count"));
		map.put("face", face.get("count"));
		map.put("recordUP", recordUP.get("count"));*/
		
		Map<String, Object> waitOut = jcDetoxInfoService.normalReleasePage("","", "", "", "", "", "WAIT","1", "10"); //待出所人数
		Map<String, Object> notOut = jcDetoxInfoService.normalReleasePage("","", "", "", "", "", "NO_OUT","1", "10"); //未出所人数
		Map<String, Object> already = fcfOutdetoxInfoService.evidencePageList("","", "", "", "", "", "1", "10");  //已处所人数
		map.put("waitOut", waitOut.get("count"));
		map.put("notOut", notOut.get("count"));
		map.put("already", already.get("count"));
		return map;
	}
	
//	@RequestMapping("getMatterNum")
//	public String getMatterNum(Model model){
//		//   逾期未处理  
//		//userName, userNumber, startDate, endDate, excepVal 本周, curr, nums
//		//今日待出所
//		Map<String, Object> todatNum = jcDetoxInfoService.normalReleasePage("", "", getToday(), "", "", "1", "10");
//		Object object = todatNum.get("count");
//		model.addAttribute("today",object);
//		//逾期未处理
//		Map<String, Object> overdue = jcDetoxInfoService.normalReleasePage("", "", "",getToday(), "", "1", "10");
//		model.addAttribute("overdue",overdue.get("count"));
//		// 审核信息未通过
//		Map<String, Object> InfoFail = jcDetoxInfoService.normalReleasePage("", "", "", "", "sh", "1", "10");
//		model.addAttribute("infoFail",InfoFail.get("count"));
//		//头像对比未通过  
//		Map<String, Object> face = jcDetoxInfoService.normalReleasePage("", "", "", "", "face", "1", "10");
//		model.addAttribute("face",face.get("count"));
//		//出所单未上传
//		Map<String, Object> recordUP = jcDetoxInfoService.normalReleasePage("", "", "", "", "doc", "1", "10");
//		model.addAttribute("recordUP",recordUP.get("count"));
//		return "releaseRecord/sanyang/index";
//	}

	
	private String getToday() {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String format = df.format(day);  
		return format;
	}
	

}
