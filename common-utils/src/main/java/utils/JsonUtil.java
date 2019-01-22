package utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utils.entity.People;

/**
 * Json工具
 * Gson
 * 版本：2.8.0
 * 2018-03-06
 * @author sh
 *
 */
@SuppressWarnings("serial")
public class JsonUtil {
	
	private static Gson gson = new Gson();
	
	private static GsonBuilder gsonBuilder = new GsonBuilder();
	
	/**
	 * list转json
	 * @param list
	 * @return
	 */
	public static String listToJson(List<?> list) {
		return gson.toJson(list);
	}
	
	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String mapToJson(Map<String, ?> map) {
		return gson.toJson(map);
	}
	
	/**
	 * json转类list
	 * @param json
	 * @param className
	 * @return
	 */
	public static <T> List<T> jsonToList(String json,TypeToken<? extends List<?>> typeToken) {
		Type type = typeToken.getType();
		ArrayList<T> list = gsonBuilder.serializeNulls().create().fromJson(json, type);
		return list;
	}
	
	/**
	 * json转map
	 * @param json
	 * @param className
	 * @return
	 */
	public static <T> Map<String, T> jsonToMap(String json,TypeToken<? extends Map<String, ?>> typeToken) {
		Type type = typeToken.getType();
		HashMap<String, T> map = gsonBuilder.serializeNulls().create().fromJson(json, type);
		return map;
	}
	
	/**
	 * json转对象
	 * @param json
	 * @param className
	 * @return
	 */
	public static <T> T jsonToObject(String json, Class<T> className) {
		return gsonBuilder.serializeNulls().create().fromJson(json, className);//避免属性null值时，丢失该属性
	}
	
	/**
	 * 对象转json
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object) {
		return gsonBuilder.serializeNulls().create().toJson(object);
	}
	
	
	/**
	 * 测试主类
	 * @param args
	 */
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("sfds");
		list.add("b");
		list.add(new People("myList"));
		String listJson = JsonUtil.listToJson(list);
		System.out.println("list to json:"+listJson);
		System.out.println(list.getClass());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("1", "fsf");
		map.put("2", "fsf");
		map.put("3", "fsf");
		map.put("4", list);
		Map<String, String> map2 = new HashMap<String,String>();
		map2.put("ee", "dwesre");
		map.put("5", map2);
		String objectMapJson = JsonUtil.mapToJson(map);
		System.out.println("map to json:"+objectMapJson);
		
		People people = new People("nn");
		people.setId("1");
		people.setYear(1997);
		people.setAddres(null);
		map.put("people", new People("mm"));
		people.setForv(map);
		String peopleJson = JsonUtil.objectToJson(people);
		System.out.println("object to json:"+peopleJson);
		People people2 = JsonUtil.jsonToObject(peopleJson, People.class);
		System.out.println("json to object:"+people2.getForv());
		
		List<People> peopleList = new ArrayList<People>();
		peopleList.add(new People("1-p"));
		peopleList.add(new People("2-p"));
		String peopleListJson = JsonUtil.listToJson(peopleList);
		List<People> demoList = JsonUtil.jsonToList(peopleListJson,new TypeToken<ArrayList<People>>() {
		});
		System.out.println("json to list:"+demoList.get(0).getName());
		
		Map<String, People> peopleMap = new HashMap<String,People>();
		peopleMap.put("1", new People("1-map"));
		peopleMap.put("2", new People("2-map"));
		String mapJson = JsonUtil.mapToJson(peopleMap);
		System.out.println("mapJson:"+mapJson);
		Map<String, People> demoMap = JsonUtil.jsonToMap(mapJson, new TypeToken<HashMap<String, People>>() {
		});
		System.out.println("json to map:"+demoMap.get("2").getName());
	}
	
}
