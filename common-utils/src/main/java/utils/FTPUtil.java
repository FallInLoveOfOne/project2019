package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * FTP工具类
 * commons-net
 * 版本：3.6
 * 2018-03-06
 * @author sh
 *
 */
public class FTPUtil {
	
	private static FTPClient ftpClient = new FTPClient();
	
	//初始化FTP连接登录
	static{
		try {
			String ip = PropsUtil.getValByKey("test", "ftpIP");
			String port = PropsUtil.getValByKey("test", "ftpPort");
			String loginName = PropsUtil.getValByKey("test", "ftpUser");
			String password = PropsUtil.getValByKey("test", "ftpPassword");
			connectFtp(ip,port,loginName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接FTP服务器
	 * @param ip（ip地址）
	 * @param port（端口号）
	 * @param loginName（登录名）
	 * @param password（密码）
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static String connectFtp(String ip,String port,String loginName,String password) throws NumberFormatException, IOException{
		ftpClient.connect(ip, Integer.valueOf(port));
		ftpClient.login(loginName, password);
		ftpClient.setControlEncoding("UTF-8");//设置字符编码
		ftpClient.setBufferSize(20480);//设置字符编码
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件类型
		String out = ftpClient.getReplyString();//返回响应信息
		System.out.println("连接响应："+out);
		return out;
	}
	
	/**
	 * 关闭Ftp连接
	 * @throws IOException
	 */
	public static void closeFtp() throws IOException {
		if(ftpClient!=null||ftpClient.isConnected()){
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}
	
	/**
	 * 格式化路径
	 * @param path
	 * @return
	 */
	public static String formatPath(String path) {
		if(null==path||"".equals(path)){
			return "";
		}
		path = path.replace("\\\\", "/");
		return path;
	}
	
	/**
	 * 校验FTP远程目录是否存在,并切换到当前远程目录下
	 * @param remotePath
	 * @return
	 * @throws IOException 
	 */
	public static boolean changeAndMakeDir(String remotePath) throws IOException {
		remotePath = formatPath(remotePath);
		boolean is = false;
		if(ftpClient!=null||ftpClient.isConnected()){
			if(null!=remotePath&&!"".equals(remotePath)){
				is = ftpClient.changeWorkingDirectory(remotePath);
				if(!is){//若远程目录不存在，则创建该文件夹
					ftpClient.makeDirectory(remotePath);
					ftpClient.changeWorkingDirectory(remotePath);
				}
			}
		}
		return is;
	}
	
	/**
	 * 检查是否为本地目录（非文件）
	 * @param localPath
	 * @return
	 */
	public static boolean checkLocalIsCatalog(String localPath) {
		localPath = formatPath(localPath);
		File file = new File(localPath);
		boolean is = file.exists();
		if(!is){
			return false;
		}else{
			return file.isDirectory();
		}
	}
	
	/**
	 * 检查是否为本地文件
	 * @param localPath
	 * @return
	 */
	public static boolean checkLocalIsFile(String localPath) {
		localPath = formatPath(localPath);
		File file = new File(localPath);
		boolean isExis = file.exists();
		if(!isExis){
			return false;
		}else{
			return file.isFile();
		}
	}
	
	/**
	 * 检查FTP上此文件是否存在
	 * @param fileName
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static boolean checkFtpFileHas(String fileName) throws Exception {
		fileName = formatPath(fileName);
		if("".equals(fileName)){
			return false;
		}
		InputStream inputStream = ftpClient.retrieveFileStream(new String(fileName.getBytes("utf-8"),"iso-8859-1"));
		if(null!=inputStream){//文件验证
			inputStream.close();
			ftpClient.completePendingCommand();//完成验证
			return true;
		}
		return false;
	}
	
	/**
	 * 校验上传
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkUpload(String remotePath,String localPath) throws Exception {
		remotePath = formatPath(remotePath);
		localPath = formatPath(localPath);
		boolean loIs = checkLocalIsFile(localPath);//校验待上传的文件在本地是否存在，且为文件类型
		boolean reIsEmpty = (null==remotePath||"".equals(remotePath))?false:true;//当FTP远程路径为空null时，不让上传
		return loIs&&reIsEmpty;
	}
	
	/**
	 * 校验下载
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkDown(String remotePath,String localPath) throws Exception {
		remotePath = formatPath(remotePath);
		boolean reIs = checkFtpFileHas(remotePath);//校验FTP上文件是否存在
		boolean loIs = checkLocalIsCatalog(localPath);//校验是否为本地目录
		return reIs&&loIs;
	}
	
	
	/**
	 * 上传文件到FTP
	 * @param sourFile（源文件全路径名）
	 * @param ftpPath（上传至FTP目标路径）
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static Map<String, String> uploadFileToFtp(String sourFile,String ftpPath) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(!checkUpload(ftpPath,sourFile)){//上传前校验（主要检查本地源文件是否存在，远程路径是否为空null）
			return map;
		}
		sourFile = formatPath(sourFile);
		ftpPath = formatPath(ftpPath);
		changeAndMakeDir(ftpPath);//远程目录不为空null,不存在的创建，且切换到当前远程目录
		String ftpFileName = java.util.UUID.randomUUID()+"@2018-03-07"+sourFile.substring(sourFile.lastIndexOf("."));
		ftpFileName = new String(ftpFileName.getBytes("UTF-8"),"ISO-8859-1");
		boolean is = ftpClient.storeFile(ftpFileName, new FileInputStream(sourFile));//2018-02-28添加文件名：ftpFileName
		if(is){
			System.out.println(sourFile+"上传至："+ftpPath+ftpFileName+"成功！");
		}
		map.put("flag", ""+is);
		map.put("ftpPath", ftpFileName);
		closeFtp();
		return map;
	}
	
	/**
	 * FTP文件下载到本地
	 * @param remotePath（ftp具体文件）
	 * @param localPath（本地文件夹）
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Map<String, String> downRemoteFile(String remotePath,String localPath) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(!checkDown(remotePath, localPath)){//检查FTP上该文件是否存在，本地路径是否存在
			return map;
		}
		remotePath = formatPath(remotePath);
		localPath = formatPath(localPath);
		if(remotePath.indexOf("/")!=-1){//不是根目录，切换工作目录
			ftpClient.changeWorkingDirectory(remotePath.substring(0, remotePath.lastIndexOf("/")));//切换ftp工作空间
		}
		String remoteFileName = remotePath.substring(remotePath.lastIndexOf("/")+1);//ftp目录下目标文件
		remoteFileName = new String(remoteFileName.getBytes("utf-8"),"iso-8859-1");
		localPath = localPath+"\\"+UUID.randomUUID()+"@@SH"+remotePath.substring(remotePath.lastIndexOf("."));
		boolean flag = false;
		File localFile = new File(localPath);
		OutputStream outputStream = null;
		outputStream = new FileOutputStream(localFile);
		flag = ftpClient.retrieveFile(remoteFileName, outputStream);
		map.put("flag", ""+flag);
		map.put("localPath", localPath);
		closeFtp();
		return map;
	}
	
	/**
	 * 校验ftp文件是否存在
	 * @param remoteFile
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkHasFile(String remoteFile) throws Exception {
		boolean flag = false;
		if(null!=remoteFile&&!"".equals(remoteFile)){
			String remoteDir = remoteFile.substring(0, remoteFile.lastIndexOf("/")+1);
			boolean is = ftpClient.changeWorkingDirectory(remoteDir);
			if(is){//目录校验
				String remoteFileName = remoteFile.substring(remoteFile.lastIndexOf("/")+1);
				InputStream inputStream = ftpClient.retrieveFileStream(new String(remoteFileName.getBytes("utf-8"),"iso-8859-1"));
				if(null!=inputStream){//文件验证
					inputStream.close();
					ftpClient.completePendingCommand();//完成验证
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 删除ftp上单个文件
	 * @param remoteFile：ftp文件全路径
	 * @return
	 * @throws IOException 
	 */
	public static Map<String, String> deleteRemoteFile(String remoteFile) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(!checkFtpFileHas(remoteFile)){
			return map;
		}
		remoteFile = formatPath(remoteFile);
		if(remoteFile.indexOf("/")!=-1){
			ftpClient.changeWorkingDirectory(remoteFile.substring(0, remoteFile.lastIndexOf("/")));//切换ftp工作目录
		}
		String remoteFileName = remoteFile.substring(remoteFile.lastIndexOf("/")+1);
		boolean flag = false;
		flag = ftpClient.deleteFile(remoteFileName);
		map.put("flag", ""+flag);
		closeFtp();
		return map;
	}
	
	/**
	 * 页面响应下载
	 * @param response
	 * @param remoteFile（ftp文件路径）
	 * @param saveFileName（保存到本地的文件全名：路径+自定义文件名称）
	 * @throws Exception
	 */
	public static void pageRespDown(HttpServletResponse response,String remoteFile,String saveFileName) throws Exception {
		remoteFile = formatPath(remoteFile);
		saveFileName = formatPath(saveFileName);
		Map<String, String> map = downRemoteFile(remoteFile, saveFileName.substring(0, saveFileName.lastIndexOf("/")));
		String flag = map.get("flag");
		String localPath = map.get("localPath");//已经下载到本地的文件路径
		if("".equals(flag)||"false".equals(flag)){
			return;
		}
		InputStream inputStream = new BufferedInputStream(new FileInputStream(localPath));
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		inputStream.close();
		String headerName = "attachment;filename=" + saveFileName.substring(saveFileName.lastIndexOf("/")+1);
		response.setContentType("application/msword;charset=UTF-8");
		response.addHeader("Content-Disposition", new String(headerName.getBytes("GBK"), "ISO-8859-1"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
		bufferedOutputStream.write(bytes);
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
	
	/**
	 * 另一种页面响应下载
	 * @param response
	 * @param filePath（本地路径）
	 * @param fileName（本地文件名）
	 * @throws Exception
	 */
	/*public static void respPageDown(HttpServletResponse response,String filePath,String fileName) throws Exception {
		String newFile = filePath + File.separator + fileName;
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
		InputStream in = new FileInputStream(newFile);
		OutputStream os = response.getOutputStream();
		byte[] b = new byte[1024 * 1024];
		int length;
		while ((length = in.read(b)) > 0) {
			os.write(b, 0, length);
		}
		in.close();
	}*/
	
	/**
	 * 测试主类
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//uploadFileToFtp("E:\\read_pic_0.jpg","/");//上传
		//downRemoteFile("/","E:\\");//下载
		deleteRemoteFile("\\\\/////SH-FTP/demo/1a70650d-69af-4565-a223-673abd1930e9.png");//删除文件
		//System.out.println(checkFtpFileHas("0846be54-58ac-417a-965c-16ee13181203@2018-03-07.jpg"));
	}
}
