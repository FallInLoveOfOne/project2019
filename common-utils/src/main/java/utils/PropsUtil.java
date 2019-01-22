package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.hutool.setting.dialect.Props;

/**
 * 配置文件加载工具
 * 2018-03-06
 * @author sh
 *
 */
public class PropsUtil {
	
	private static Map<String, String> resultMap;
	
	/**
	 * 加载配置文件
	 * @param fileName（配置文件名，无后缀）
	 * @throws IOException
	 */
	public static void loadPropFile(String fileName) throws IOException {
		Map<String, String> map = new HashMap<String,String>();
		Properties properties = new Properties();
		InputStream inputStream = null;
		inputStream = PropsUtil.class.getClassLoader().getResourceAsStream(fileName+".properties");
		properties.load(inputStream);
		Set<Object> sets = properties.keySet();
		if(null!=sets){
			for(Object one : sets){
				String key = (String)one;
				String val = properties.getProperty(key).toString();
				map.put(key, val);
				resultMap = map;
			}
		}
		inputStream.close();
	}
	
	/**
	 * 获取配置文件value值
	 * hutool
	 * @param name（配置文件名，无后缀）
	 * @param keyVal（配置文件中的key）
	 * @return
	 */
	public static String getValByHutool(String name,String keyVal) {
		Map<String, String> map = new HashMap<String,String>();
		Props props = new Props(name+".properties");
		Set<Object> keys = props.keySet();
		for(Object one : keys){
			String key = (String)one;
			String val = props.getStr(key);
			map.put(key, val);
		}
		return map.get(keyVal);
	}
	
	/**
	 * 获取配置文件单个Value
	 * @param fileName（配置文件名，无后缀）
	 * @param key（配置文件中的key）
	 * @return
	 * @throws IOException
	 */
	public static String getValByKey(String fileName,String key) throws IOException {
		loadPropFile(fileName);
		return resultMap.get(key);
	}
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("--"+PropsUtil.getValByHutool("test", "ftpPort"));
	}
}
