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
 * FTP������
 * commons-net
 * �汾��3.6
 * 2018-03-06
 * @author sh
 *
 */
public class FTPUtil {
	
	private static FTPClient ftpClient = new FTPClient();
	
	//��ʼ��FTP���ӵ�¼
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
	 * ����FTP������
	 * @param ip��ip��ַ��
	 * @param port���˿ںţ�
	 * @param loginName����¼����
	 * @param password�����룩
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static String connectFtp(String ip,String port,String loginName,String password) throws NumberFormatException, IOException{
		ftpClient.connect(ip, Integer.valueOf(port));
		ftpClient.login(loginName, password);
		ftpClient.setControlEncoding("UTF-8");//�����ַ�����
		ftpClient.setBufferSize(20480);//�����ַ�����
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//�����ļ�����
		String out = ftpClient.getReplyString();//������Ӧ��Ϣ
		System.out.println("������Ӧ��"+out);
		return out;
	}
	
	/**
	 * �ر�Ftp����
	 * @throws IOException
	 */
	public static void closeFtp() throws IOException {
		if(ftpClient!=null||ftpClient.isConnected()){
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}
	
	/**
	 * ��ʽ��·��
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
	 * У��FTPԶ��Ŀ¼�Ƿ����,���л�����ǰԶ��Ŀ¼��
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
				if(!is){//��Զ��Ŀ¼�����ڣ��򴴽����ļ���
					ftpClient.makeDirectory(remotePath);
					ftpClient.changeWorkingDirectory(remotePath);
				}
			}
		}
		return is;
	}
	
	/**
	 * ����Ƿ�Ϊ����Ŀ¼�����ļ���
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
	 * ����Ƿ�Ϊ�����ļ�
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
	 * ���FTP�ϴ��ļ��Ƿ����
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
		if(null!=inputStream){//�ļ���֤
			inputStream.close();
			ftpClient.completePendingCommand();//�����֤
			return true;
		}
		return false;
	}
	
	/**
	 * У���ϴ�
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkUpload(String remotePath,String localPath) throws Exception {
		remotePath = formatPath(remotePath);
		localPath = formatPath(localPath);
		boolean loIs = checkLocalIsFile(localPath);//У����ϴ����ļ��ڱ����Ƿ���ڣ���Ϊ�ļ�����
		boolean reIsEmpty = (null==remotePath||"".equals(remotePath))?false:true;//��FTPԶ��·��Ϊ��nullʱ�������ϴ�
		return loIs&&reIsEmpty;
	}
	
	/**
	 * У������
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkDown(String remotePath,String localPath) throws Exception {
		remotePath = formatPath(remotePath);
		boolean reIs = checkFtpFileHas(remotePath);//У��FTP���ļ��Ƿ����
		boolean loIs = checkLocalIsCatalog(localPath);//У���Ƿ�Ϊ����Ŀ¼
		return reIs&&loIs;
	}
	
	
	/**
	 * �ϴ��ļ���FTP
	 * @param sourFile��Դ�ļ�ȫ·������
	 * @param ftpPath���ϴ���FTPĿ��·����
	 * @return
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static Map<String, String> uploadFileToFtp(String sourFile,String ftpPath) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(!checkUpload(ftpPath,sourFile)){//�ϴ�ǰУ�飨��Ҫ��鱾��Դ�ļ��Ƿ���ڣ�Զ��·���Ƿ�Ϊ��null��
			return map;
		}
		sourFile = formatPath(sourFile);
		ftpPath = formatPath(ftpPath);
		changeAndMakeDir(ftpPath);//Զ��Ŀ¼��Ϊ��null,�����ڵĴ��������л�����ǰԶ��Ŀ¼
		String ftpFileName = java.util.UUID.randomUUID()+"@2018-03-07"+sourFile.substring(sourFile.lastIndexOf("."));
		ftpFileName = new String(ftpFileName.getBytes("UTF-8"),"ISO-8859-1");
		boolean is = ftpClient.storeFile(ftpFileName, new FileInputStream(sourFile));//2018-02-28����ļ�����ftpFileName
		if(is){
			System.out.println(sourFile+"�ϴ�����"+ftpPath+ftpFileName+"�ɹ���");
		}
		map.put("flag", ""+is);
		map.put("ftpPath", ftpFileName);
		closeFtp();
		return map;
	}
	
	/**
	 * FTP�ļ����ص�����
	 * @param remotePath��ftp�����ļ���
	 * @param localPath�������ļ��У�
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Map<String, String> downRemoteFile(String remotePath,String localPath) throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		if(!checkDown(remotePath, localPath)){//���FTP�ϸ��ļ��Ƿ���ڣ�����·���Ƿ����
			return map;
		}
		remotePath = formatPath(remotePath);
		localPath = formatPath(localPath);
		if(remotePath.indexOf("/")!=-1){//���Ǹ�Ŀ¼���л�����Ŀ¼
			ftpClient.changeWorkingDirectory(remotePath.substring(0, remotePath.lastIndexOf("/")));//�л�ftp�����ռ�
		}
		String remoteFileName = remotePath.substring(remotePath.lastIndexOf("/")+1);//ftpĿ¼��Ŀ���ļ�
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
	 * У��ftp�ļ��Ƿ����
	 * @param remoteFile
	 * @return
	 * @throws Exception 
	 */
	public static boolean checkHasFile(String remoteFile) throws Exception {
		boolean flag = false;
		if(null!=remoteFile&&!"".equals(remoteFile)){
			String remoteDir = remoteFile.substring(0, remoteFile.lastIndexOf("/")+1);
			boolean is = ftpClient.changeWorkingDirectory(remoteDir);
			if(is){//Ŀ¼У��
				String remoteFileName = remoteFile.substring(remoteFile.lastIndexOf("/")+1);
				InputStream inputStream = ftpClient.retrieveFileStream(new String(remoteFileName.getBytes("utf-8"),"iso-8859-1"));
				if(null!=inputStream){//�ļ���֤
					inputStream.close();
					ftpClient.completePendingCommand();//�����֤
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * ɾ��ftp�ϵ����ļ�
	 * @param remoteFile��ftp�ļ�ȫ·��
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
			ftpClient.changeWorkingDirectory(remoteFile.substring(0, remoteFile.lastIndexOf("/")));//�л�ftp����Ŀ¼
		}
		String remoteFileName = remoteFile.substring(remoteFile.lastIndexOf("/")+1);
		boolean flag = false;
		flag = ftpClient.deleteFile(remoteFileName);
		map.put("flag", ""+flag);
		closeFtp();
		return map;
	}
	
	/**
	 * ҳ����Ӧ����
	 * @param response
	 * @param remoteFile��ftp�ļ�·����
	 * @param saveFileName�����浽���ص��ļ�ȫ����·��+�Զ����ļ����ƣ�
	 * @throws Exception
	 */
	public static void pageRespDown(HttpServletResponse response,String remoteFile,String saveFileName) throws Exception {
		remoteFile = formatPath(remoteFile);
		saveFileName = formatPath(saveFileName);
		Map<String, String> map = downRemoteFile(remoteFile, saveFileName.substring(0, saveFileName.lastIndexOf("/")));
		String flag = map.get("flag");
		String localPath = map.get("localPath");//�Ѿ����ص����ص��ļ�·��
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
	 * ��һ��ҳ����Ӧ����
	 * @param response
	 * @param filePath������·����
	 * @param fileName�������ļ�����
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
	 * ��������
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//uploadFileToFtp("E:\\read_pic_0.jpg","/");//�ϴ�
		//downRemoteFile("/","E:\\");//����
		deleteRemoteFile("\\\\/////SH-FTP/demo/1a70650d-69af-4565-a223-673abd1930e9.png");//ɾ���ļ�
		//System.out.println(checkFtpFileHas("0846be54-58ac-417a-965c-16ee13181203@2018-03-07.jpg"));
	}
}
