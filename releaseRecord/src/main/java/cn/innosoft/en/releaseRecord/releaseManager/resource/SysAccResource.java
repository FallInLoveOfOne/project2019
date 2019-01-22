package cn.innosoft.en.releaseRecord.releaseManager.resource;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.releaseRecord.releaseManager.service.SysAccService;

@Controller
@RequestMapping("sysAcc")
public class SysAccResource {
	
	@Autowired
	private SysAccService sysAccService;
	
	/**
	 * 获取附件列表
	 * @param personNumber
	 * @return
	 */
	@RequestMapping("getSysAccsByNumber")
	@ResponseBody
	public Map<String, Object> getSysAccsByNumber(String personNumber) {
		return sysAccService.getAccPage(personNumber, null);
	}
	
	@RequestMapping(value = "uploadFace", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadFace(HttpServletRequest request) throws Exception {
		return sysAccService.uploadFacePhoto(request, "filename");
	}
}
