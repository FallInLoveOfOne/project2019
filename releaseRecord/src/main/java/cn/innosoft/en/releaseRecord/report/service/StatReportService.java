package cn.innosoft.en.releaseRecord.report.service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.innosoft.en.releaseRecord.report.model.TFcfReport;
import cn.innosoft.en.releaseRecord.report.persistent.StatReportDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.persistent.CustomJdbcTemplate;

@Service
public class StatReportService extends AbstractBaseService<TFcfReport, String> {
	@Resource
	private CustomJdbcTemplate customJdbcTemplate;
	@Autowired
	private StatReportDao dao;
	@Override
	public BaseDao<TFcfReport, String> getBaseDao() {
		return dao;
	}

	/**
	 * 查询统计报告列表
	 */
	public Map<String, Object> getReportByDate(String report_type,String curr,String nums) {
		String orderSql = "ORDER BY CREATE_TIME,ID";
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("report_type", report_type);
		map.put("orderSQL", orderSql);
		PageRequest page = new PageRequest();
		page.setPage(Integer.parseInt(curr));
		page.setRows(Integer.parseInt(nums));
		PageResponse<Map<String, Object>> pageResponse = findMapBySql("report-getReportList", map,page);
		List<Map<String, Object>> list=null;
		long total=0;
		if(pageResponse!=null){
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

	private long OBJ_Long(Object obj) {
		String countString = String.valueOf(obj);
		Long count = Long.valueOf(countString);
		return count;

	}

	// 计划出所人数统计
	public Object getOutDetoxNum(String report_type) {
		Object OutDetoxNum_Plan = 0;
		Map<String, Object> param = getParms(report_type);
		List<Map<String, Object>> list = customJdbcTemplate.findMapBySql("report-getPlanNum", param);
		if (list == null) {
			return OutDetoxNum_Plan;
		}
		OutDetoxNum_Plan = list.get(0).get("planNum");
		return OutDetoxNum_Plan;
	}

	private Map<String, Object> getParms(String report_type) {
		Map<String, Object> param = new HashMap<String, Object>();
		// report_type=="周报" week
		param.put("SQL", "to_char(to_date(HOLD_END,'yyyy-mm-dd hh24:mi:ss'),'iw')=to_char(sysdate,'iw')");
		if (report_type.equals("month")) {
			param.put("SQL", "to_char(to_date(HOLD_END,'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm')=to_char(sysdate,'yyyy-mm')");
		}
		/*
		 * if(report_type.equals("ji")){ param.put("SQL",
		 * "to_char(to_date(OUT_DATE,'yyyy-mm-dd hh24:mi:ss'),'yyyy-q')=to_char(sysdate,'yyyy-q')"
		 * ); }
		 */
		if (report_type.equals("year")) {
			param.put("SQL", "to_char(to_date(HOLD_END,'yyyy-mm-dd hh24:mi:ss'),'yyyy')=to_char(sysdate,'yyyy')");
		}
		return param;
	}

	public List<Map<String, Object>> getOutDetoxNumReal(String report_type) {
		Map<String, Object> param = getParms(report_type);
		List<Map<String, Object>> list = customJdbcTemplate.findMapBySql("report-getRealNum", param);
		return list;
	}

	
}
