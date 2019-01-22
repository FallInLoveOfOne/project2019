package cn.innosoft.en.login.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class OrmFwConfig {
	private static String prosStr = "orm-config";
	private static Map<String, String> ormProMap;
	static {
		ormProMap = new HashMap<String, String>();
		Properties prop = new Properties();
		String[] arr = prosStr.split(",");
		InputStream in = null;
		for (int i = 0; i < arr.length; i++) {
			in = OrmFwConfig.class.getClassLoader().getResourceAsStream(arr[i] + ".properties");
			try {
				prop.load(in);
				Set<Object> keySet = prop.keySet();
				for (Object key : keySet) {
					String keyStr = (String) key;
					ormProMap.put(keyStr, prop.getProperty(keyStr).trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 私有构造方法，不需要创建对象
	 */
	private OrmFwConfig() {
		
	}

	// 读取属性值
	public static String getProValue(String keyStr) {
		return ormProMap.get(keyStr);
	}
}