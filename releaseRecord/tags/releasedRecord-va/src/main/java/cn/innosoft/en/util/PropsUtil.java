package cn.innosoft.en.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropsUtil  {

	// spring注入XML配置的properties文件名列表
	private static List<String> propertiesName;

	// 所有properties文件的配置信息
	private static Map<String, String> propertiesMap;

	public  List<String> getPropertiesName() {
		return propertiesName;
	}

	// 根据XML配置的properties文件名读取properties配置信息并放入Map中
	public void setPropertiesName(List<String> propertiesName) {
		PropsUtil.propertiesName = propertiesName;
		propertiesMap = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream in = null;
		for (int i = 0; i < propertiesName.size(); i++) {
			in = PropsUtil.class.getClassLoader().getResourceAsStream(propertiesName.get(i) + ".properties");
			try {
				prop.load(in);
				Set<Object> keySet = prop.keySet();
				for (Object key : keySet) {
					String keyStr = (String) key;
					propertiesMap.put(keyStr, prop.getProperty(keyStr).trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String curString = dateFormat.format(date);
		// JS文件时间戳生成
		propertiesMap.put("jsTimeStamp", curString);
	}

	// 读取属性值
	public static String getValue(String keyStr) {
		return propertiesMap.get(keyStr);
	}

	// 获取JS文件时间戳
	public static String getJSTimeStamp() {
		return propertiesMap.get("jsTimeStamp");
	}
}
