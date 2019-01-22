package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.hutool.setting.dialect.Props;

/**
 * �����ļ����ع���
 * 2018-03-06
 * @author sh
 *
 */
public class PropsUtil {
	
	private static Map<String, String> resultMap;
	
	/**
	 * ���������ļ�
	 * @param fileName�������ļ������޺�׺��
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
	 * ��ȡ�����ļ�valueֵ
	 * hutool
	 * @param name�������ļ������޺�׺��
	 * @param keyVal�������ļ��е�key��
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
	 * ��ȡ�����ļ�����Value
	 * @param fileName�������ļ������޺�׺��
	 * @param key�������ļ��е�key��
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
