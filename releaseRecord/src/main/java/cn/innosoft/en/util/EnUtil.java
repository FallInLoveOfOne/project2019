package cn.innosoft.en.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnUtil {

	// 获取UUID
	public static String getUUID() {
		String uuid = java.util.UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}

	// 获取当前系统时间——UUID
	public static String getCurTimeUUID() {
		return getCurTime("yyyyMMddHHmmssSSS");
	}

	// 获取当前系统时间——默认方式
	public static String getCurTime() {
		return getCurTime("yyyy-MM-dd HH:mm:ss:SSS");
	}

	// 指定格式获取当前系统时间
	public static String getCurTime(String formatStr) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		String curString = dateFormat.format(date);
		return curString;
	}

	// 格式化日期——支持yyyyMMddHHmmss格式和yyyy-MM-dd HH:mm:ss格式
	public static String formatDate(String dateStr, String formatStr) {
		SimpleDateFormat sdf;
		if (dateStr.indexOf("-") > 0)
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (date == null)
			return "";
		else {
			SimpleDateFormat sdFormat = new SimpleDateFormat(formatStr);
			return sdFormat.format(date);
		}
	}

	// 格式化日期——返回 yyyy-MM-dd
	public static String formatDate(String dateStr) {
		return formatDate(dateStr, "yyyy-MM-dd");
	}

	// 格式化日期——自由转换
	public static String formatDate(String dateStr, String selfFormatStr, String targetFormatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(selfFormatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat(targetFormatStr);
		return sdFormat.format(date);
	}

	// 文件上传接收不提供文件名自动计算文件名
	// 返回文件路径——支持绝对路径和相对路径
	public static String upload(HttpServletRequest request, String filePath, String inputName) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(inputName);
		Map<String, String> map = getFileSavePath(filePath, getFileExtName(file.getOriginalFilename()));
		String savePath = map.get("savepath");
		File srcFile = new File(savePath);
		try {
			file.transferTo(srcFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 保存文件到指定的目录下。
		return map.get("filepath");
	}

	// 文件上传——返回保存路径和文件名——支持绝对路径和相对路径和文件大小
	public static Map<String, String> uploadMultReturn(HttpServletRequest request, String filePath, String inputName) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile(inputName);
		Map<String, String> map = getFileSavePath(filePath, getFileExtName(file.getOriginalFilename()));
		String savePath = map.get("savepath");
		File srcFile = new File(savePath);
		try {
			file.transferTo(srcFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 保存文件到指定的目录下。
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("path", map.get("filepath"));// 文件保存路径
		tempMap.put("fileName", file.getOriginalFilename());// 上传的文件名
		tempMap.put("fileSize", String.valueOf(file.getSize()));
		return tempMap;
	}

	// 文件下载
	public static void downFile(String filePath, HttpServletResponse response) {
		downLoadFile(filePath, response, "", false);
	}

	// 文件下载——提供删除功能
	public static void downFile(String filePath, HttpServletResponse response, boolean deleteFlag) {
		downLoadFile(filePath, response, "", deleteFlag);
	}

	// 文件下载——提供文件下载名
	public static void downFile(String filePath, HttpServletResponse response, String downFileName) {
		downLoadFile(filePath, response, downFileName, false);
	}

	// 文件下载—提供文件下载名和删除功能
	public static void downFile(String filePath, HttpServletResponse response, String downFileName,
			boolean deleteFlag) {
		downLoadFile(filePath, response, downFileName, deleteFlag);
	}

	// 文件下载处理函数
	private static void downLoadFile(String filePath, HttpServletResponse response, String downFileName,
			boolean deleteFlag) {
		InputStream fis;
		try {
			Map<String, String> map = getFileSavePath(filePath, "");
			String pathStr = map.get("savepath");
			fis = new BufferedInputStream(new FileInputStream(pathStr));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			if (downFileName == null || downFileName.equals("")) {// 默认下载文件名
				downFileName = getFileName(pathStr);
			}
			if (downFileName.lastIndexOf(".") == -1) {// 添加文件下载后缀名
				downFileName = downFileName + getFileExtName(filePath);
			}
			String headerStr = "attachment;filename=" + downFileName;
			response.setContentType("application/msword;charset=UTF-8");
			response.addHeader("Content-Disposition", new String(headerStr.getBytes("GBK"), "ISO-8859-1"));
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			out.write(buffer);
			out.flush();
			out.close();
			if (deleteFlag == true) {// 删除文件
				deleteFile(pathStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取项目路径
	public static String getProjectPath() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		return realPath;
	}

	// 复制对象的数据
	public static void copyFieldVal(Object newObj, Object oldObj) throws Exception {
		Class classType = newObj.getClass();
		Map<String, String> map = new HashMap<String, String>();
		Class aClass = oldObj.getClass();
		Field[] aFields = aClass.getDeclaredFields();
		for (int j = 0; j < aFields.length; j++) {
			Field field = aFields[j];
			String fieldStr = field.getName();
			if ("serialVersionUID".equals(fieldStr)) {
				continue;
			}
			String firstName = fieldStr.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstName + fieldStr.substring(1);
			map.put(fieldStr, getMethodName);
		}
		Field[] fields = classType.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			if ("serialVersionUID".equals(fieldName)) {
				continue;
			}
			String firstName = fieldName.substring(0, 1).toUpperCase();
			String setMethodName = "set" + firstName + fieldName.substring(1);
			if (map.get(fieldName) != null) {
				String getMethodN = map.get(fieldName);
				Method getmethod = aClass.getMethod(getMethodN, new Class[] {});
				Object value = getmethod.invoke(oldObj, new Object[] {});
				Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });
				setMethod.invoke(newObj, new Object[] { value });
			}
		}
	}

	// 获取文件的保存的物理路径
	public static String getFilePath(String pathStr) {
		String indexStr = ":";
		int index = pathStr.indexOf(indexStr);
		String filePathStr = "";
		if (index == -1) {
			// 相对路径
			filePathStr = getProjectPath() + pathStr;
		} else {
			// 绝对路径
			filePathStr = pathStr;
		}
		return filePathStr;
	}

	// 获取文件的后缀名
	public static String getFileExtName(String fileName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index);
	}

	// 根据文件路径获取文件名
	public static String getFileName(String filePath) {
		filePath = getFilePath(filePath);
		File file = new File(filePath);
		if (file.exists()) {
			return file.getName();
		} else {
			return "";
		}
	}

	// 读取文件内容
	public static String readFile(String filePath) throws Exception {
		filePath = EnUtil.getFilePath(filePath);
		StringBuilder sBuilder = new StringBuilder();
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis, "utf-8");
		BufferedReader bReader = new BufferedReader(reader);
		String str = "";
		while ((str = bReader.readLine()) != null) {
			sBuilder.append(str);
		}
		bReader.close();
		return sBuilder.toString();
	}

	// 删除单个文件(支持绝对路径和相对路径)
	public static void deleteFile(String filePath) {
		String filePathName = getFilePath(filePath);
		File file = new File(filePathName);
		if (file.exists()) {
			file.delete();
		}
	}

	// 删除单个文件
	public static void deleteFileOne(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}

	// 删除某目录下指定扩展名的文件(支持绝对路径和相对路径)
	public static void deleteExtFile(String dirPath, String extName) {
		String dirPathName = getFilePath(dirPath);
		File dirFile = new File(dirPathName);
		if (!dirFile.isDirectory()) {
			dirFile = dirFile.getParentFile();
		}
		if (dirFile.isDirectory()) {
			int index = extName.indexOf(".");
			if (index == -1)
				extName = "." + extName;
			final String extString = extName;
			File[] files = dirFile.listFiles(new FileFilter() {
				private final String extStr = extString;

				@Override
				public boolean accept(File file) {
					if (file.getName().endsWith(extStr)) {
						return true;
					} else {
						return false;
					}
				}
			});
			for (int i = 0; i < files.length; i++) {
				files[i].delete();
			}
		}
	}

	// 创建文件夹(支持相对路径和绝对路径)
	public static String createDir(String dirName) {
		String filePath = getFilePath(dirName);
		// filePath = filePath + dirName;
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return filePath;
	}

	// 创建文件(支持相对路径和绝对路径)
	public static void createFile(String filePath) throws IOException {
		filePath = getFilePath(filePath);
		File file = new File(filePath);
		File parentDirFile = file.getParentFile();
		if (!parentDirFile.exists()) {
			parentDirFile.mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	// 把字符串写入到文件中
	public static void writeFile(String filePath, String fileContent) {
		filePath = getFilePath(filePath);
		try {
			createFile(filePath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream foStream = null;
		BufferedWriter bWriter = null;
		try {
			foStream = new FileOutputStream(filePath, false);
			OutputStreamWriter osWriter = new OutputStreamWriter(foStream, "utf-8");
			bWriter = new BufferedWriter(osWriter);
			bWriter.write(fileContent);
			bWriter.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bWriter != null)
					bWriter.close();
				if (foStream != null)
					foStream.close();
			} catch (IOException ie) {

			}
		}

	}

	// json字符串转为Map形式
	public static Map<String, String> jsonToMap(String json) {
		Map<String, String> map = new HashMap<String, String>();
		if (json == null || json.length() == 0)
			return map;
		// 将单引号替换成双引号
		// json = json.replace("\'", "\"");
		ObjectMapper objMapper = new ObjectMapper();
		try {
			map = objMapper.readValue(json, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// json字符串转为paraMap形式
	public static Map<String, Object> jsonToParaMap(String json) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		if (json == null || json.length() == 0)
			return paraMap;
		// 将单引号替换成双引号
		json = json.replace("\'", "\"");
		ObjectMapper objMapper = new ObjectMapper();
		try {
			paraMap = objMapper.readValue(json, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paraMap;
	}

	// json字符串转为List<Map<String,String>>形式
	public static List<Map<String, String>> jsonToListMap(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> listMaps = new ArrayList<Map<String, String>>();
		if (json == null || json.length() == 0)
			return listMaps;
		// 将单引号替换成双引号
		//json = json.replace("\'", "\"");
		try {
			listMaps = objectMapper.readValue(json, List.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMaps;
	}

	// 替换路径中的分隔符
	private static String replaceSep(String pathStr) {
		pathStr = pathStr.replaceAll("\\\\", "/");
		return pathStr;
	}

	// 判断文件路径字符串
	private static String checkFilePath(String filePath) {
		String returnPath = "";
		if (filePath.endsWith("/")) {
			returnPath = filePath;
		} else {
			returnPath = filePath + "/";
		}
		return returnPath;
	}

	// 根据传递进来的文件路径是否需要处理文件的路径(内部使用)
	// 返回文件的完整路径（包括事件戳的文件名）和 文件相对路径
	private static Map<String, String> getFileSavePath(String path, String suffixName) {
		String filePath = replaceSep(path);
		int nameIndex = filePath.indexOf(".");
		String filePathStr = "";
		if (nameIndex == -1) {
			// 不存在文件名的情况
			String pathStr = checkFilePath(filePath);
			createDir(pathStr);// 创建文件夹
			Random random = new Random();
			int val = random.nextInt(2000);
			if (suffixName.indexOf(".") == -1)
				suffixName = "." + suffixName;
			String fileName = getCurTimeUUID() + String.valueOf(val) + suffixName;
			filePathStr = pathStr + fileName;
		} else {
			filePathStr = filePath;
		}
		path = filePathStr;
		String savePath = getFilePath(filePathStr);
		Map<String, String> pathMap = new HashMap<String, String>();
		pathMap.put("filepath", filePathStr);
		pathMap.put("savepath", savePath);
		return pathMap;
	}

	// 复制文件
	public static void copyFile(String sourcePath, String targetPath) throws IOException {
		sourcePath = getFilePath(sourcePath);
		targetPath = getFilePath(targetPath);
		File source = new File(sourcePath);
		File target = new File(targetPath);
		if (!target.exists())
			createFile(targetPath);
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				in.close();
				outStream.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 复制目录----------只复制目录下的文件没有复制目录下的目录
	public static void copyDir(String sourceDir, String targetDir) throws Exception {
		sourceDir = getFilePath(sourceDir);
		targetDir = getFilePath(targetDir);
		File sourceDirFile = new File(sourceDir);
		File targetDirFile = new File(targetDir);
		if (!sourceDirFile.exists())
			throw new Exception("目录不存在!");
		if (!targetDirFile.exists()) {
			createDir(targetDir);
		}
		if (!sourceDirFile.isDirectory())
			throw new Exception(sourceDir + "不是目录！");
		if (!targetDirFile.isDirectory()) {
			throw new Exception(targetDir + "不是目录！");
		}
		File[] files = sourceDirFile.listFiles();
		String fileName = "";
		for (File file : files) {
			if (file.isFile()) {
				fileName = file.getName();
				copyFile(sourceDir + "/" + fileName, targetDir + "/" + fileName);
			}
		}
	}

	// 获取目录下的所有文件名
	public static ArrayList<String> getDirFileName(String dirPath) throws Exception {
		dirPath = getFilePath(dirPath);
		File dirFile = new File(dirPath);
		if (!dirFile.exists())
			throw new Exception("目录不存在！");
		if (!dirFile.isDirectory())
			throw new Exception("不是目录！");
		ArrayList<String> list = new ArrayList<>();
		File[] files = dirFile.listFiles();
		for (File file : files) {
			list.add(file.getName());
		}
		return list;
	}

	// 判断目录是否存在
	public static boolean isDirExist(String dirPath) {
		dirPath = getFilePath(dirPath);
		if (!(dirPath.endsWith("/") || dirPath.endsWith("\\"))) {
			dirPath = dirPath + "/";
		}
		File dirFile = new File(dirPath);
		boolean flag = false;
		if (dirFile.exists())
			flag = true;
		return flag;
	}

	// 判断文件是否存在
	public static boolean isFileExist(String filePath) {
		filePath = getFilePath(filePath);
		File fileF = new File(filePath);
		boolean flag = false;
		if (fileF.exists())
			flag = true;
		return flag;
	}

	// 路径最后添加斜杠
	public static String addPathSep(String path) {
		if (path.endsWith("/") || path.endsWith("\\"))
			return path;
		else {
			return path + "/";
		}
	}

	// 路径前后添加斜杠
	public static String addSlash(String path) {
		path = path.replace("\\", "/");
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (!path.endsWith("/")) {
			path = path + "/";
		}
		return path;
	}

	// 目录删除--接口函数--支持绝对路径和相对路径
	public static void deleteDir(String dirPath) {
		if (isDirExist(dirPath)) {
			File dirFile = new File(getFilePath(dirPath));
			deleteDirFile(dirFile);
		}
	}

	// 目录删除--实现函数
	private static void deleteDirFile(File file) {
		if (file.exists()) {// 判断文件是否存在
			if (file.isFile()) {// 判断是否是文件
				file.delete();// 删除文件
			} else if (file.isDirectory()) {// 否则如果它是一个目录
				File[] files = file.listFiles();// 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) {// 遍历目录下所有的文件
					deleteDirFile(files[i]);// 把每个文件用这个方法进行迭代
				}
				file.delete();// 删除文件夹
			}
		} else {
			System.out.println("所删除的文件不存在");
		}
	}

	// 分解存储路径和物理文件名的方法
	public static Map<String, String> getFileNameAndParentPath(String relFilePath) {
		int dotIndex = relFilePath.lastIndexOf(".");
		String fileName = "";
		int sepIndex = relFilePath.lastIndexOf("/");
		Map<String, String> fileMap = new HashMap<String, String>();
		if (dotIndex > -1) {
			fileName = relFilePath.substring(sepIndex + 1);
			String parentFilePath = relFilePath.substring(0, sepIndex);
			fileMap.put("fileName", fileName);
			fileMap.put("parentPath", parentFilePath);
			return fileMap;
		} else {
			return null;
		}
	}

	public static String changeNull(String str) {
		if (str == null)
			return "";
		else {
			return str;
		}
	}
	
	public static String changeNull(Object obj) {
		if (obj == null)
			return "";
		else {
			return obj.toString();
		}
	}

	// 改变null---避免隐藏空的指针异常
	public static String changeNull1(Object obj) {
		if (obj == null)
			return "";
		else {
			return obj.toString();
		}
	}

	// 对象转JSON
	public static String objToJson(Object obj) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			return objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 多文件上传——返回保存路径和文件名——支持绝对路径和相对路径和文件大小
	public static List<Map<String, String>> mulUpload(HttpServletRequest request, String filePath, String inputName) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> fileList = multipartRequest.getFiles(inputName);
		if (fileList.size() == 0)
			return null;
		List<Map<String, String>> fileListMap = new ArrayList<>();
		for (MultipartFile file : fileList) {
			Map<String, String> map = new HashMap<>();
			map = getFileSavePath(filePath, getFileExtName(file.getOriginalFilename()));
			String savePath = map.get("savepath");
			File srcFile = new File(savePath);
			try {
				file.transferTo(srcFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 保存文件到指定的目录下。
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("path", map.get("filepath"));// 文件保存路径
			tempMap.put("fileName", file.getOriginalFilename());// 上传的文件名
			tempMap.put("fileSize", byteToM(String.valueOf(file.getSize())));// 单位为M--保留两位小数
			fileListMap.add(tempMap);
		}
		return fileListMap;
	}

	// 字节单位转化为M单位
	public static String byteToM(String byteSize) {
		double million = 1024 * 1024;
		double size = Double.parseDouble(byteSize);
		double fileSize = size / million;
		BigDecimal numBig = new BigDecimal(fileSize);
		String MSize = bigDecimalToStr(numBig, 2);
		return MSize;
	}

	// 字符串转bigDecimal
	public static BigDecimal strToBigDecimal(String sizeStr) {
		BigDecimal bigDeci = new BigDecimal(sizeStr);
		return bigDeci;
	}

	// bigDecimal转换为字符串---四舍五入
	public static String bigDecimalToStr(BigDecimal bigDeci, Integer digit) {
		bigDeci = bigDeci.setScale(digit, BigDecimal.ROUND_HALF_UP);
		return bigDeci.toString();
	}
}
