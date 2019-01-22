/**
 * 
 */
package cn.innosoft.en.util.loginUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 对象转换为json字符串帮助类.
 * 
 * @author huangwb
 * @date 2013-11-20 上午9:27:59
 * @version
 */
public final class JsonUtils {

	/**
	 * 私有构建函数.
	 */
	private JsonUtils() {

	}

	/**
	 * 对象转化对象.
	 */
	private static volatile ObjectMapper objectMapper = null;

	/**
	 * 获取单例对象，用以把对象转换为json字符串.
	 * 
	 * @return json字符
	 */
	public static ObjectMapper getInstance() {
		if (objectMapper == null) {
			synchronized (JsonUtils.class) {
				if (objectMapper == null) {
					objectMapper = new ObjectMapper();
				}
			}
		}
		return objectMapper;
	}

	/**
	 * Object转换为json字符串，对外抛出异常.
	 * 
	 * @param obj
	 *            Object对象
	 * @return 对象转换后的json字符串
	 * @throws Exception
	 *             Json转换异常
	 */
	public static String genJsonStr(Object obj) throws Exception {
		return getInstance().writeValueAsString(obj);
	}

	/**
	 * Object转换为json字符串，不对外抛出异常.
	 * 
	 * @param obj
	 *            Object对象
	 * @return 对象转换后的json字符串
	 */
	public static String genJsonStrQuite(Object obj) {
		try {
			return getInstance().writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * json字符串转化为Map.
	 * 
	 * @param json
	 *            json字符串
	 * @return json字符串转化得到的Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJsonToMap(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = getInstance().readValue(json, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * json字符串转化为对象.
	 * 
	 * @param json
	 *            json字符串
	 * @param clazz
	 *            对象类型
	 * @param <T>
	 *            泛型对象
	 * @return 转化后的对象
	 */
	public static <T> T parseJsonToObject(String json, Class<T> clazz) {
		try {
			return getInstance().readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Map<String, String>> parseJsonToList(String json) {
		List<Map<String, String>> list = null;
		try {
			list = getInstance().readValue(json, List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> parseJsonToList(String json, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		try {
			List<Map<String, Object>> mlist = getInstance().readValue(json, List.class);
			for (Map<String, Object> map : mlist) {
				T t = parseJsonToObject(genJsonStrQuite(map), clazz);
				list.add(t);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	// /**
	// * 测试入口.
	// *
	// * @param args
	// * 参数.
	// */
	// public static void main(String[] args) {
	// String s = "[{\"entId\":\"100\",\"rdisplayType\":\"222\"}]";
	// List<RModel> list = parseJsonToList(s, RModel.class);
	// int i = 100;
	// }
}
