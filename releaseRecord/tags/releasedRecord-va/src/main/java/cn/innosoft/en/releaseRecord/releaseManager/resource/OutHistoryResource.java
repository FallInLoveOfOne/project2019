package cn.innosoft.en.releaseRecord.releaseManager.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.releaseRecord.releaseManager.service.OutHistoryService;

@Controller
@RequestMapping("outHistory")
public class OutHistoryResource {
	
	@Autowired
	private OutHistoryService outHistoryService;
	
	/**
	 * 出所记录分页
	 * @param number
	 * @param curr
	 * @param nums
	 * @return
	 */
	@RequestMapping("outHisPage")
	@ResponseBody
	public Map<String, Object> getOutHisPage(String number) {
		return outHistoryService.getOutHisPage(number);
	}

}
