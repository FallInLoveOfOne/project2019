package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ZipUtil;

/**
 * IO工具
 * hutool-all
 * 版本：4.0.5
 * 2018-03-06
 * @author sh
 *
 */
public class FileUtils {
	
	/**
	 * 文件拷贝
	 * @param sourceFile（源文件全路径）
	 * @param destFile（目标文件全路径）
	 * @return
	 */
	public static String copyFile(String sourceFile,String destFile) {
		BufferedInputStream inputStream = FileUtil.getInputStream(sourceFile);
		BufferedOutputStream outputStream = FileUtil.getOutputStream(destFile);
		IoUtil.copy(inputStream, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
		IoUtil.close(inputStream);
		IoUtil.close(outputStream);
		return destFile;
	}
	
	/**
	 * 文件压缩（压缩路径为空时，默认压缩到目标文件夹同级目录）
	 * @param srcPath（文件夹、文件全路径）
	 * @param zipPath（输出的文件全名）
	 */
	public static void fileZip(String srcPath,String zipPath) {
		srcPath = formatFilePath(srcPath);
		zipPath = formatFilePath(zipPath);
		if(null==zipPath||"".equals(zipPath)){
			File src = new File(srcPath);
			if(src.isDirectory()){//目标文件为目录
				String parentDir = src.getParent();
				String name = srcPath.replace(parentDir, "").replace("\\", "");
				parentDir = parentDir+"\\"+name+".zip";
				ZipUtil.zip(srcPath, parentDir, true);
			}
			if(src.isFile()){//目标文件单个文件
				String name = srcPath.substring(srcPath.lastIndexOf("\\")+1, srcPath.lastIndexOf("."))+".zip";
				String parent = src.getParent()+"\\"+name;
				ZipUtil.zip(srcPath, parent, true);
			}
		}else{//有输出文件全名
			ZipUtil.zip(srcPath, zipPath,true);
		}
	}
	
	/**
	 * 文件解压缩（输出目录为空时，解压到当前压缩文件所在的目录）
	 * @param filePath
	 * @param outFileDir
	 */
	public static void fileUnzip(String filePath,String outFileDir) {
		filePath = formatFilePath(filePath);
		outFileDir = formatFilePath(outFileDir);
		if(null==outFileDir||"".equals(outFileDir)){
			ZipUtil.unzip(filePath);
		}else{
			ZipUtil.unzip(filePath, outFileDir);
		}
	}
	
	/**
	 * 获取文件夹下（不包含子级文件夹）文件名称列表
	 * @param path
	 * @return
	 */
	public static List<String> listFileNames(String path) {
		List<String> list = new ArrayList<String>();
		path = formatFilePath(path);
		boolean is = checkFileIsexist(path);
		if(!is){
			return list;
		}
		File file = new File(path);
		if(file.isDirectory()){
			return FileUtil.listFileNames(path);
		}
		if(file.isFile()){
			list.add(path);
			return list;
		}
		return list;
	}
	
	/**
	 * 文件转字节输入流
	 * @param fileName
	 * @return
	 */
	public static ByteArrayInputStream toStream(String fileName,String charset) {
		byte[] bytes = readFileBytes(fileName);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		return byteArrayInputStream;
	}
	
	/**
	 * 清空目录下文件
	 * @param directory
	 * @return
	 */
	public static boolean cleanDirFiles(String directory) {
		directory = formatFilePath(directory);
		boolean is = checkFileIsexist(directory);
		if(!is){
			return false;
		}
		File file = new File(directory);
		if(file.isDirectory()){
			return FileUtil.clean(file);
		}
		return false;
	}
	
	
	/**
	 * 读取文件，生成字节组
	 * @param fileName
	 * @return
	 */
	public static byte[] readFileBytes(String fileName) {
		fileName = formatFilePath(fileName);
		boolean is = checkFileIsexist(fileName);
		if(!is){
			return new byte[0];
		}
		return FileUtil.readBytes(fileName);
	}
	
	/**
	 * 获取文件、目录大小（目录的话，计算该目录下所有文件大小之和：单位：字节）
	 * @param fileName
	 * @return
	 */
	public static long getFileSize(String fileName) {
		fileName = formatFilePath(fileName);
		boolean is = checkFileIsexist(fileName);
		if(!is){
			return 0L;
		}
		return FileUtil.size(new File(fileName));
	}
	
	
	/**
	 * 格式化文件路径
	 * @param filePath
	 * @return
	 */
	public static String formatFilePath(String filePath) {
		if(null==filePath||"".equals(filePath)){
			return "";
		}
		return filePath.replaceAll("\\\\", "/");
	}
	
	/**
	 * 删除文件、目录
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path) {
		path = formatFilePath(path);//格式化文件路径
		boolean flag = true;
		if(checkFileIsexist(path)){
			flag = FileUtil.del(path);
		}
		return flag;
	}
	
	/**
	 * 校验目录、文件是否存在
	 * @param path
	 * @return
	 */
	public static boolean checkFileIsexist(String path) {
		path = formatFilePath(path);//格式化文件路径
		boolean flag = false;
		File file = new File(path);
		flag = file.exists();
		return flag;
	}
	
	/**
	 * 获取文件（字符串）扩展名
	 * @param fileName
	 * @return
	 */
	public static String getSuffixName(String fileName) {
		if(null==fileName||"".equals(fileName)){
			return "";
		}
		return FileUtil.extName(fileName);
	}
	
	/**
	 * 获取系统磁盘列表
	 * @return
	 */
	public static List<String> getDiskList() {
		List<String> diskList = new ArrayList<String>();
		FileSystemView fileSystemView = FileSystemView.getFileSystemView();
		for(File file : File.listRoots()){
			String name = fileSystemView.getSystemDisplayName(file);
			if(null!=name&&!"".equals(name)){
				name = name.substring(name.indexOf("(")+1, name.indexOf(")"));
				diskList.add(name);
			}
		}
		return diskList;
	}
	
	/**
	 * 路径是否在本地磁盘内
	 * @param path
	 * @return
	 */
	public static boolean diskPattern(String path) {
		path = formatFilePath(path).toLowerCase();
		for(String one : getDiskList()){
			one = one.toLowerCase();
			if(path.indexOf(one)!=-1){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 创建文件目录、文件
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static String createFile(String path) throws IOException {
		path = formatFilePath(path);
		if("".equals(path)){
			return "";
		}
		boolean is = checkFileIsexist(path);
		if(!is){
			String suff = getSuffixName(path);
			if(path.indexOf("/")!=-1){
				if("".equals(suff)){
					File file = new File(path);
					file.mkdirs();
				}else{
					String paPath = path.substring(0, path.lastIndexOf("/"));
					File parentPath = new File(paPath);
					parentPath.mkdirs();
					File file = new File(path);
					file.createNewFile();
				}
			}
		}
		return path;
	}
	
	/**
	 * 获取部署项目路径
	 * @param request
	 * @return
	 */
	public static String getProjectPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	/**
	 * 页面响应下载
	 * @param request
	 * @param response
	 * @param filePath（全文件名）
	 * @throws Exception
	 */
	public static void respPageDown(HttpServletRequest request,HttpServletResponse response,String filePath) throws Exception {
		filePath = formatFilePath(filePath);
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
		InputStream in = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		byte[] b = new byte[1024 * 1024];
		int length;
		while ((length = in.read(b)) > 0) {
			os.write(b, 0, length);
		}
		in.close();
	}
	
	/**
	 * 部署项目内页面响应下载
	 * @param request
	 * @param response
	 * @param filePath（项目相对路径）
	 * @param fileName（文件名称）
	 * @throws Exception
	 */
	public static void projectRespDown(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName) throws Exception {
		String project = getProjectPath(request);
		String newFile = project+File.separator+filePath + File.separator + fileName;
		newFile = formatFilePath(newFile);
		respPageDown(request, response, newFile);//页面响应下载
	}
	
	public static void main(String[] args) throws IOException {
		copyFile("F:\\Hutool-filetest\\in\\in.doc", "F:\\Hutool-filetest\\out\\out.docx");
		ZipUtil.unzip("F:\\Hutool-filetest\\out-zip.zip");
		FileUtils.deleteFile("E:\\pathDemo\\demo1");
		FileUtils.checkFileIsexist("E:\\pathDemo\\demo2\\sdfdsfds.txt");
		System.out.println(FileUtils.createFile("E:\\genePathDemo"));
		System.out.println("文件扩展名："+getSuffixName("3424.ert"));
		System.out.println(createFile(null));
		new File("E:\\crDemo\\dsdf.text");
		System.out.println(getFileSize("E:\\crDemo\\新建文本文档.txt"));
		System.out.println(listFileNames("E:\\crDemo\\"));
		System.out.println(readFileBytes("E:\\crDemo\\demo\\sfdsfds.txt"));
		System.out.println(cleanDirFiles("E:\\crDemo\\demo\\ddddd.docx"));
		System.out.println(createFile("E:\\crDemo\\demo\\dsfsd.png"));
		System.out.println(checkFileIsexist("E:\\crDemo\\demo\\fff.png"));
		System.out.println(getDiskList());
	}

}
