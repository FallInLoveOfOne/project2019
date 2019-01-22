package cn.innosoft.en.releaseRecord.releaseManager.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.releaseRecord.releaseManager.service.JcDetoxInfoService;

@Controller
@RequestMapping("message/")
public class MessageResource {
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	@RequestMapping("getMessage")
	@ResponseBody
	public Map<String, Object> senderMessage(String number) throws IOException {
		Map<String, Object> mapObj = new HashMap<String, Object>();//jcDetoxInfoService.getOutPersonDetails(null, number);
		mapObj.put("UUID", number+"已处理");
		return mapObj;
	}
}
