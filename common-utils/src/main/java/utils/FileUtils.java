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
 * IO����
 * hutool-all
 * �汾��4.0.5
 * 2018-03-06
 * @author sh
 *
 */
public class FileUtils {
	
	/**
	 * �ļ�����
	 * @param sourceFile��Դ�ļ�ȫ·����
	 * @param destFile��Ŀ���ļ�ȫ·����
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
	 * �ļ�ѹ����ѹ��·��Ϊ��ʱ��Ĭ��ѹ����Ŀ���ļ���ͬ��Ŀ¼��
	 * @param srcPath���ļ��С��ļ�ȫ·����
	 * @param zipPath��������ļ�ȫ����
	 */
	public static void fileZip(String srcPath,String zipPath) {
		srcPath = formatFilePath(srcPath);
		zipPath = formatFilePath(zipPath);
		if(null==zipPath||"".equals(zipPath)){
			File src = new File(srcPath);
			if(src.isDirectory()){//Ŀ���ļ�ΪĿ¼
				String parentDir = src.getParent();
				String name = srcPath.replace(parentDir, "").replace("\\", "");
				parentDir = parentDir+"\\"+name+".zip";
				ZipUtil.zip(srcPath, parentDir, true);
			}
			if(src.isFile()){//Ŀ���ļ������ļ�
				String name = srcPath.substring(srcPath.lastIndexOf("\\")+1, srcPath.lastIndexOf("."))+".zip";
				String parent = src.getParent()+"\\"+name;
				ZipUtil.zip(srcPath, parent, true);
			}
		}else{//������ļ�ȫ��
			ZipUtil.zip(srcPath, zipPath,true);
		}
	}
	
	/**
	 * �ļ���ѹ�������Ŀ¼Ϊ��ʱ����ѹ����ǰѹ���ļ����ڵ�Ŀ¼��
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
	 * ��ȡ�ļ����£��������Ӽ��ļ��У��ļ������б�
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
	 * �ļ�ת�ֽ�������
	 * @param fileName
	 * @return
	 */
	public static ByteArrayInputStream toStream(String fileName,String charset) {
		byte[] bytes = readFileBytes(fileName);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		return byteArrayInputStream;
	}
	
	/**
	 * ���Ŀ¼���ļ�
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
	 * ��ȡ�ļ��������ֽ���
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
	 * ��ȡ�ļ���Ŀ¼��С��Ŀ¼�Ļ��������Ŀ¼�������ļ���С֮�ͣ���λ���ֽڣ�
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
	 * ��ʽ���ļ�·��
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
	 * ɾ���ļ���Ŀ¼
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path) {
		path = formatFilePath(path);//��ʽ���ļ�·��
		boolean flag = true;
		if(checkFileIsexist(path)){
			flag = FileUtil.del(path);
		}
		return flag;
	}
	
	/**
	 * У��Ŀ¼���ļ��Ƿ����
	 * @param path
	 * @return
	 */
	public static boolean checkFileIsexist(String path) {
		path = formatFilePath(path);//��ʽ���ļ�·��
		boolean flag = false;
		File file = new File(path);
		flag = file.exists();
		return flag;
	}
	
	/**
	 * ��ȡ�ļ����ַ�������չ��
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
	 * ��ȡϵͳ�����б�
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
	 * ·���Ƿ��ڱ��ش�����
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
	 * �����ļ�Ŀ¼���ļ�
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
	 * ��ȡ������Ŀ·��
	 * @param request
	 * @return
	 */
	public static String getProjectPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	/**
	 * ҳ����Ӧ����
	 * @param request
	 * @param response
	 * @param filePath��ȫ�ļ�����
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
	 * ������Ŀ��ҳ����Ӧ����
	 * @param request
	 * @param response
	 * @param filePath����Ŀ���·����
	 * @param fileName���ļ����ƣ�
	 * @throws Exception
	 */
	public static void projectRespDown(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName) throws Exception {
		String project = getProjectPath(request);
		String newFile = project+File.separator+filePath + File.separator + fileName;
		newFile = formatFilePath(newFile);
		respPageDown(request, response, newFile);//ҳ����Ӧ����
	}
	
	public static void main(String[] args) throws IOException {
		copyFile("F:\\Hutool-filetest\\in\\in.doc", "F:\\Hutool-filetest\\out\\out.docx");
		ZipUtil.unzip("F:\\Hutool-filetest\\out-zip.zip");
		FileUtils.deleteFile("E:\\pathDemo\\demo1");
		FileUtils.checkFileIsexist("E:\\pathDemo\\demo2\\sdfdsfds.txt");
		System.out.println(FileUtils.createFile("E:\\genePathDemo"));
		System.out.println("�ļ���չ����"+getSuffixName("3424.ert"));
		System.out.println(createFile(null));
		new File("E:\\crDemo\\dsdf.text");
		System.out.println(getFileSize("E:\\crDemo\\�½��ı��ĵ�.txt"));
		System.out.println(listFileNames("E:\\crDemo\\"));
		System.out.println(readFileBytes("E:\\crDemo\\demo\\sfdsfds.txt"));
		System.out.println(cleanDirFiles("E:\\crDemo\\demo\\ddddd.docx"));
		System.out.println(createFile("E:\\crDemo\\demo\\dsfsd.png"));
		System.out.println(checkFileIsexist("E:\\crDemo\\demo\\fff.png"));
		System.out.println(getDiskList());
	}

}
