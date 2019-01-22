package cn.innosoft.en.login.client.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.FTPUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;

@Controller
@RequestMapping(value="home/")
public class LoginUserResource {

	/**
	 * 获取已登录用户的token
	 */
	@RequestMapping("getUserMsg")
	public String getToken(Model model) {
		String token = OrmHelper.getToken();
		String userAcct = OrmHelper.getCurrentUserAcct();
		model.addAttribute("userAcct", userAcct);
		model.addAttribute("token", token);
		return "supervisor/index/index";
	}

	/**
	 * 本地下载 google安装包(暂时保留32位)
	 */
	@RequestMapping("downGoogle")
	@ResponseBody
	public void downGoogle(HttpServletRequest request, HttpServletResponse response, String chrome32or64) throws Exception {
		if (chrome32or64.equals("chrome64")) {
			String Chrome64Path = EnUtil.getFilePath("chrome/ChromeSetup_64.exe");
			EnUtil.downFile(Chrome64Path, response, "ChromeSetup_64安装包", false);
		} else if (chrome32or64.equals("chrome32")) {
			String Chrome32Path = EnUtil.getFilePath("chrome/ChromeSetup_32.exe");
			EnUtil.downFile(Chrome32Path, response, "ChromeSetup_32安装包", false);
		} // 页面进行文件下载
	}

	/**
	 * FTP下载google安装包
	 */
	/*
	 * @RequestMapping("downGoogle")
	 * 
	 * @ResponseBody public void downGoogle(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * //ftp://ye@192.168.90.82:8889/FTP/chrome/ChromeSetup_32.exe String
	 * fullPath = "FTP/chrome/ChromeSetup_32.exe"; // 文件完整存储路径名 String
	 * realPathDir = EnUtil.addPathSep(PropsUtil.getValue("googleDirPath")); //
	 * 文件下载存储路径 String newFile = realPathDir + "/" + fullPath;
	 * EnUtil.createDir(EnUtil.getFileNameAndParentPath(newFile).get(
	 * "parentPath")); EnUtil.createDir(realPathDir);// 验证文件夹是否存在并创建文件夹 if
	 * (!EnUtil.isDirExist(newFile)) {// 如果当前文件不存在则进行下载至指定目录
	 * FTPUtil.downFile(realPathDir + "/" + fullPath, fullPath); //
	 * 从ftp下载文件到指定目录 } EnUtil.downFile(newFile, response, "Chrome", false); //
	 * 页面进行文件下载 }
	 */
}
