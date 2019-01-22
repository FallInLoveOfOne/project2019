package cn.innosoft.en.releaseRecord.releaseManager.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.util.KSUtil;

@Controller
@RequestMapping("ksface")
public class KSResource {
	
	@RequestMapping("getInfo")
	@ResponseBody
	public String getInfo(String ksId) {
		String info = KSUtil.getUerInfo(ksId);
		System.out.println("旷视人员基本信息："+info);
		return info;
	}
}
