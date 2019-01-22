package cn.innosoft.en.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *  FTP工具类
 * @author ye
 * @version 0.1
 * @date 2016-08-18
 *
 */
public class FTPUtil {
	private static FTPClient ftpClient;
	public static final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;
	public static final int ASCII_FILE_TYPE = FTP.ASCII_FILE_TYPE;
	
	
	/***************************主要函数 ***********************************/
	
	/**
	 * 上传主函数
	 * @throws IOException 
	 * 	@throws SocketException 
	 * 	@throws NumberFormatException
	 */
	
	// 上传主函数--------------支持绝对路径和相对路径
	public synchronized static void uploadFile(String localFilePath, String ftpDirPath)
			throws NumberFormatException, SocketException, IOException {
		String localFileAbsPath = EnUtil.getFilePath(localFilePath);
		ftpDirPath = EnUtil.addSlash(ftpDirPath);
		String remoteFileName = localFileAbsPath.substring(localFileAbsPath.lastIndexOf("/") + 1);
		ftpStart();
		createDirectory(ftpDirPath);
		changeDirectory(ftpDirPath);
		upload(localFileAbsPath, remoteFileName);
		closeServer();
	}
	
	// 下载主函数--------------支持绝对路径和相对路径
	public synchronized static void downFile(String localFilePath, String ftpDirPathAndFileName) throws NumberFormatException, SocketException, IOException{
		String localFileAbsPath = EnUtil.getFilePath(localFilePath);
		ftpDirPathAndFileName = ftpDirPathAndFileName.replace("\\", "/");
		String remoteFileName = ftpDirPathAndFileName.substring(ftpDirPathAndFileName.lastIndexOf("/")+1);
		String relativePath =  ftpDirPathAndFileName.substring(0,ftpDirPathAndFileName.lastIndexOf("/"));
		relativePath = EnUtil.addSlash(relativePath);
		ftpStart();
		changeDirectory(relativePath);	 
		download(remoteFileName, localFileAbsPath);
		closeServer();
	}
	
	//删除主函数
	public synchronized static void deleteFile(String fullPathAndName,boolean flag) throws NumberFormatException, SocketException, IOException{
		ftpStart();
		removeAll(fullPathAndName, flag);
		closeServer();
	}
	
	/*****************************核心函数**********************************/
	
	/**
	 * 使用详细信息进行服务器连接
	 * 
	 * @param server：服务器地址名称
	 * @param port：端口号
	 * @param user：用户名
	 * @param password：用户密码
	 * @param path：转移到FTP服务器目录
	 * @throws SocketException
	 * @throws IOException
	 */
	private static void connectServer(String server, int port, String user, String password, String path)
			throws SocketException, IOException {
		ftpClient = new FTPClient();
		System.out.println("尝试连接FTP： " + server);
		ftpClient.connect(server, port);
		ftpClient.login(user, password);
		// 连接成功后的回应码
		System.out.println("FTP回应码："+ftpClient.getReplyCode()+" "+getReplyInfo(ftpClient.getReplyCode()));
		if (path != null && path.length() != 0) {
			ftpClient.changeWorkingDirectory(path);
		}
		ftpClient.setBufferSize(65535);// 设置上传缓存大小
		ftpClient.setControlEncoding("UTF-8");// 设置编码
		ftpClient.setFileType(BINARY_FILE_TYPE);// 设置文件类型
	}
	
	/**
	 * 关闭连接
	 * 
	 * @throws IOException
	 */
	private  static void closeServer() throws IOException {
		if (ftpClient != null && ftpClient.isConnected()) {
			ftpClient.logout();// 退出FTP服务器
			ftpClient.disconnect();// 关闭FTP连接
		}
	}
	
	/**
	 * 设置传输文件类型:FTP.BINARY_FILE_TYPE | FTP.ASCII_FILE_TYPE 二进制文件或文本文件
	 * 
	 * @param fileType
	 * @throws IOException
	 */
	private static void setFileType(int fileType) throws IOException {
		ftpClient.setFileType(fileType);
	}
	
	/**
	 * 转移到FTP服务器工作目录
	 * 
	 * @param remote ftp要转移的路径
	 * @return  转移是否成功
	 * @throws IOException
	 */
	private static boolean changeDirectory(String remote) throws IOException {
		return ftpClient.changeWorkingDirectory(remote);
	}
	
	/**
	 * 在服务器上创建目录
	 * 
	 * @param remote 要在ftp上创建的路径
	 * @return  创建是否成功
	 * @throws IOException
	 */
	private static boolean createDirectory(String remote) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			while (true) {
				String subDirectory = new String(remote.substring(start, end));
				if (!ftpClient.changeWorkingDirectory(subDirectory)) {
					if (ftpClient.makeDirectory(subDirectory)) {
						ftpClient.changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录失败");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
	
	/**
	 * 在服务器上删除目录
	 * 
	 * @param remote  ftp上要删除的路径
	 * @return  删除是否成功
	 * @throws IOException
	 */
	private static boolean removeDirectory(String remote) throws IOException {
		return ftpClient.removeDirectory(remote);
	}
	
	/**
	 * 删除所有文件和目录
	 * 
	 * @param remote ：ftp上要删除的路径
	 * @param isAll ：true:删除所有文件和目录
	 * @return  删除是否成功
	 * @throws IOException
	 */
	private static boolean removeAll(String remote, boolean isAll) throws IOException {
		if (!isAll) {
			return removeDirectory(remote);
		}//true:删除所有文件和目录
		FTPFile[] ftpFileArr = ftpClient.listFiles(remote);
		if (ftpFileArr == null || ftpFileArr.length == 0) {
			return removeDirectory(remote);
		}
		for (FTPFile ftpFile : ftpFileArr) {
			String name = ftpFile.getName();
			if (ftpFile.isDirectory()) {
				System.out.println("* [sD]Delete subPath [" + remote + "/" + name + "]");
				removeAll(remote + "/" + name, true);
			} else if (ftpFile.isFile()) {
				System.out.println("* [sF]Delete file [" + remote + "/" + name + "]");
				deleteFile(remote);// 删除时候传入是附带文件名
			} else if (ftpFile.isSymbolicLink()) {

			} else if (ftpFile.isUnknown()) {

			}
		}
		return ftpClient.removeDirectory(remote);
	}
	
	/**
	 * 检查目录在服务器上是否存在 true：存在 false：不存在
	 * 
	 * @param remote ftp上是否存在指定路径
	 * @return  是否存在（true/false）
	 * @throws IOException
	 */
	private static Boolean existDirectory(String remote) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles();
		for (FTPFile ftp : ftpFileArr) {
			if (ftp.isDirectory()) {
				if (ftp.getName().equals(remote)) {
					flag = true;
					System.out.println("目录存在！");
					return flag;
				}
			}
		}
		System.out.println("目录不存在！");
		return flag;
	}
	
	/**
	 * 得到文件列表,listFiles返回包含目录和文件，
	 * 它返回的是一个FTPFile数组 listNames()：只包含目录的字符串数组
	 * String[] fileNameArr = ftpClient.listNames(path);
	 * @param remote ftp指定路径
	 * @return  路径下的所有文件
	 * @throws IOException
	 */
	private static List<String> getFileList(String remote) throws IOException {
		FTPFile[] ftpFiles = ftpClient.listFiles(remote);
		List<String> retList = new ArrayList<String>();
		if (ftpFiles == null || ftpFiles.length == 0) {
			return retList;
		}
		for (FTPFile ftpFile : ftpFiles) {
			if (ftpFile.isFile()) {
				retList.add(ftpFile.getName());
			}
		}
		return retList;
	}
	
	/**
	 * 删除服务器上的文件
	 * 
	 * @param fileName  要删除的文件名
	 * @return  删除是否成功
	 * @throws IOException
	 */
	private static boolean deleteFile(String fileName) throws IOException {
		return ftpClient.deleteFile(fileName);
	}
	
	/**
	 *  上传文件到ftp服务器
	 * @param localFilePath  文件的本地路径
	 * @param remoteFileName  放在ftp上的名称
	 * @return  上传是否成功
	 * @throws IOException
	 */
	private static boolean upload(String localFilePath, String remoteFileName) throws IOException {
		boolean flag = false;
		remoteFileName=new String(remoteFileName.getBytes("UTF-8"),"iso-8859-1");
		InputStream iStream = null;
		try {				
			iStream = new FileInputStream(localFilePath);
			flag = ftpClient.storeFile(remoteFileName, iStream);	
			System.out.println("上传成功！");
		} catch (IOException e) {
			flag = false;
			System.out.println("上传失败！");
			return flag;
		} finally {
			if (iStream != null) {
				iStream.close();
			}
		}
		return flag;
	}
	
	/**
	 * 输入流上传到ftp服务器
	 * 
	 * @param iStream 输入流           
	 * @param newName  新文件名称          
	 * @return
	 * @throws IOException
	 */
	private static boolean uploadStream(InputStream iStream, String newName) throws IOException {
		boolean flag = false;
		ftpClient.setBufferSize(65535);
		try {
			flag = ftpClient.storeFile(newName, iStream);	
		} catch (IOException e) {
			flag = false;
			return flag;
		} finally {
			if (iStream != null) {
				iStream.close();
			}
		}
		return flag;
	}
	
	/**
	 * 从ftp服务器上下载文件到本地 
	 * @param remoteFileName：ftp服务器上文件名称
	 * @param localFileName：本地文件名称
	 * @return
	 * @throws IOException
	 */
	private static boolean download(String remoteFileName, String localFileName) throws IOException {
		boolean flag = false;
		ftpClient.setBufferSize(65535);
		System.out.println("前："+ remoteFileName);
		remoteFileName=new String(remoteFileName.getBytes("UTF-8"),"iso-8859-1");
		File outfile = new File(localFileName);
		System.out.println("后："+ remoteFileName);
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outfile);
			System.out.println(1);
			flag = ftpClient.retrieveFile(remoteFileName, oStream);
			System.out.println(2);
			System.out.println("下载成功！");
		} catch (IOException e) {
			flag = false;
			System.out.println("下载失败！");
			return flag;
		} finally {
			oStream.close();
		}
		return flag;
	}
	
	/**
	 * 从ftp服务器上下载文件到本地 
	 * @param sourceFileName：服务器资源文件名称
	 * @return InputStream 输入流
	 * @throws IOException
	 */
	private static InputStream downloadStream(String sourceFileName) throws IOException {
		return ftpClient.retrieveFileStream(sourceFileName);
	}
	
	//ftp的响应代码
	private static String getReplyInfo(int replyCode){
		Map<Integer, String> map = new HashMap<>();
		map.put(220, "连接成功");
		map.put(221, "服务关闭控制连接。如果适当，请注销。");
		map.put(226, "关闭数据连接。请求的文件操作已成功（例如，传输文件或放弃文件）");
		map.put(230, "用户已登录，继续进行");
		map.put(425, "无法打开数据连接");
		map.put(426, "数据连接关闭");
		map.put(450, "未执行请求的文件操作。文件不可用");
		map.put(530, "未登录");
		map.put(550, "未执行请求的操作。文件不可用");
		map.put(552, "请求的文件操作异常终止：超出存储分配");
		return map.get(replyCode);
	}
	
	/**************************启动函数*********************************************/
	
	/**
	 *  ftp启动函数
	 * @throws NumberFormatException
	 * @throws SocketException
	 * @throws IOException
	 */
	private static void ftpStart() throws NumberFormatException, SocketException, IOException{
		String ipAddress = PropsUtil.getValue("ftp.ipAddress");
		String port = PropsUtil.getValue("ftp.port");
		String acct = PropsUtil.getValue("ftp.acct");
		String pwd = PropsUtil.getValue("ftp.pwd");
		connectServer(ipAddress, Integer.parseInt(port), acct, pwd, null);
	}

}
