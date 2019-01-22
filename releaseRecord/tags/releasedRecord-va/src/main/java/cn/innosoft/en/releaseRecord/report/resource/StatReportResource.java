package cn.innosoft.en.releaseRecord.report.resource;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Decoder.BASE64Decoder;
import cn.innosoft.en.releaseRecord.releaseManager.model.TSysAcc;
import cn.innosoft.en.releaseRecord.report.service.StatReportService;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.FTPUtil;
import cn.innosoft.en.util.PropsUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping(value = "report/")
public class StatReportResource {
	public final static HashMap<String, Object> mapdata = new HashMap<String, Object>();
	@Resource
	private StatReportService statReport;

	/**
	 * 查询统计报告列表（周，月，季）
	 */
	@RequestMapping(value = "getReportList")
	@ResponseBody
	public Map<String, Object> getReportByDate(String report_type,String curr,String nums) throws Exception {
		Map<String, Object> personList = statReport.getReportByDate(report_type,curr,nums);
		return personList;
	}

	@RequestMapping(value = "toReleaseReport/{inTime}/{id}/{name}/{reportType}")
	public String toReleaseReport(@PathVariable("inTime") String inTime, @PathVariable("id") String id,
			@PathVariable("name") String name, @PathVariable("reportType") String reportType, Model model) {
		model.addAttribute("inTime", inTime);
		model.addAttribute("titleName", name);
		model.addAttribute("id", id);
		model.addAttribute("reportType", reportType);
		mapdata.put("title", name);
		mapdata.put("createTime", inTime);
		mapdata.put("reportType", reportType);
		if (reportType.equals("week")) {
			model.addAttribute("reportType", "周");
		}
		if (reportType.equals("month")) {
			model.addAttribute("reportType", "月");
		}
		if (reportType.equals("year")) {
			model.addAttribute("reportType", "年");
		}
		return "sanyang/release-report";
	}

	/**
	 * 出所人数统计
	 */
	@RequestMapping(value = "getOutDetox")
	@ResponseBody
	public HashMap<String, Object> getOutDetoxData(String report_type) {
		// 计划出所人数统计
		Object outDetoxPlanNum = statReport.getOutDetoxNum(report_type);// 计划出所人数统计

		// 实际出所人数
		List<Map<String, Object>> listNum = statReport.getOutDetoxNumReal(report_type);// 实际出所以及各类型人数
		Object realOut = 0, normal = 0, abnormal = 0, reviewSucc = 0, faceSucc = 0, upRecord = 0;
		if (listNum != null) {
			Map<String, Object> mapValue = listNum.get(0);
			realOut = mapValue.get("realOut"); // 实际人数
			normal = mapValue.get("normal"); // 正常出所
			abnormal = mapValue.get("abnormal"); // 临时出所
			reviewSucc = mapValue.get("reviewSucc");// 审核通过reviewSucc
			faceSucc = mapValue.get("faceSucc");// 头像对比成功faceSucc
			upRecord = mapValue.get("upRecord");// 出所单上传upRecord
		}
		mapdata.put("outDetoxPlanNum", outDetoxPlanNum);// 计划出所人数统计
		mapdata.put("realOut", realOut);// 实际出所人数统计
		mapdata.put("normal", normal);
		mapdata.put("abnormal", abnormal);
		mapdata.put("reviewSucc", reviewSucc);
		mapdata.put("faceSucc", faceSucc);
		mapdata.put("upRecord", upRecord);
		return mapdata;
	}

	/**
	 * 生成报告
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "getReport")
	@ResponseBody
	public void getReport(String imag,String image2,HttpServletResponse response) throws Exception {
		// base64
		imag = imag.replaceAll(" ", "+");
		image2 = image2.replaceAll(" ", "+");
		imag = imag.substring(imag.indexOf(",") + 1, imag.length());
		image2 = image2.substring(image2.indexOf(",") + 1, image2.length());
		exportReport(imag, image2, response);
		//return true;
	}

	// 报告数据处理
	public void exportReport(String imagcanvasBase64, String imag2canvasBase64, HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<>();// word模板合并参数
		dataMap.put("jh", mapdata.get("outDetoxPlanNum"));
		dataMap.put("sj", mapdata.get("realOut"));
		dataMap.put("zc", mapdata.get("normal"));
		dataMap.put("ls", mapdata.get("abnormal"));
		dataMap.put("sh", mapdata.get("reviewSucc"));
		dataMap.put("tx", mapdata.get("faceSucc"));
		dataMap.put("cs", mapdata.get("upRecord"));
		dataMap.put("createTime", mapdata.get("createTime"));
		String reportType = (String) mapdata.get("reportType");
		if (reportType.equals("week")) {reportType="周";}
		if (reportType.equals("month")) {reportType="月";}
		if (reportType.equals("year")) {reportType="年";}
		dataMap.put("reportType",reportType);
		dataMap.put("echartspie", imagcanvasBase64);
		dataMap.put("echartsline", imag2canvasBase64);
		dataMap.put("title", mapdata.get("title"));
		String title = (String) mapdata.get("title");
		System.out.println(dataMap);
		ReportToWord(imagcanvasBase64, imag2canvasBase64, response, title, dataMap);
	}

	// freemarker导出
	private void ReportToWord(String imag, String image2, HttpServletResponse response, String title,
			Map<String, Object> dataMap) {
		String picName = EnUtil.getUUID();// 随机图片名称
		String wordCouAnaTemPath = EnUtil.getFilePath(PropsUtil.getValue("wordCouAnaTemPath")); // 获取word模板所在路径
		String downWordPath = PropsUtil.getValue("wordDownLoadPath") +"/reportDoc/"+ picName + ".doc";// 下载word的路径
		try {
			@SuppressWarnings("deprecation")
			Configuration configuration = new Configuration();
			// 设置编码
			configuration.setDefaultEncoding("UTF-8");
			configuration.setDirectoryForTemplateLoading(new File(wordCouAnaTemPath));
			// 获取模板
			Template template = configuration.getTemplate("report.ftl");
			// 输出文件
			File outFile = new File(downWordPath);
			// 如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
			// 生成文件
			template.process(dataMap, out);
			// 关闭流
			out.flush();
			out.close();
			EnUtil.downFile(downWordPath, response, title, true); // 下载到页面的函数
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
