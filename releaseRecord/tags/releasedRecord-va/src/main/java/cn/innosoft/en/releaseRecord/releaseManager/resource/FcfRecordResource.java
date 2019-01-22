package cn.innosoft.en.releaseRecord.releaseManager.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.releaseRecord.releaseManager.service.FcfRecordService;

@Controller
@RequestMapping("fcfRecord")
public class FcfRecordResource {
	
	@Autowired
	private FcfRecordService fcfRecordService;
	
	@RequestMapping("getRecordsByNumber")
	@ResponseBody
	public Map<String, Object> getRecordsByNumber(String number,String name,String historyid) {
		return fcfRecordService.getCordPage(number, name, historyid);
	}

}
