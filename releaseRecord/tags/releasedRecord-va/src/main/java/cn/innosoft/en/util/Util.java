package cn.innosoft.en.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.util.ks.HttpDeal;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util extends BeanUtils {
	/**
	 * 
	 * @方法名: extend
	 * @描述: 把第二个对象的非空属性值设置到对象一
	 * @param obj1
	 * @param obj2
	 * @param classtype
	 * @return
	 * @author jinsf
	 * @返回类型 Object
	 * @throws
	 */
	public static Object extend(Object oldObj, Object newObj) {
		Field[] f = oldObj.getClass().getDeclaredFields();
		for (Field field : f) {
			try {
				if ("serialVersionUID".equals(field.getName())) {
					continue;
				}
				Object o = BeanUtils.getProperty(newObj, field.getName());
				if (o != null) {
					BeanUtils.setProperty(oldObj, field.getName(), o);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return oldObj;
	}

	public static Object extend2(Object oldObj, Object newObj) {
		Field[] f = oldObj.getClass().getDeclaredFields();
		for (Field field : f) {
			try {
				if ("serialVersionUID".equals(field.getName())) {
					continue;
				}
				Object o = BeanUtils.getProperty(oldObj, field.getName());
				if (o != null) {
					BeanUtils.setProperty(newObj, field.getName(), o);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return newObj;
	}

	public static Object getValue(String name, Object object)
			throws IntrospectionException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(name, object.getClass());
		Method getMethod = pd.getReadMethod(); // 获得所有属性的读方法
		return getMethod.invoke(object); // 执行读取方法，获得属性值
	}

	public static Object setValue(Field field, Object object, Object value)
			throws IntrospectionException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		String name = field.getName();
		PropertyDescriptor pd = new PropertyDescriptor(name, object.getClass());
		Method setMethod = pd.getWriteMethod(); // 获得所有属性的写方法
		return setMethod.invoke(object, value); // 执行写方法，设置属性值
	}

	public static String getUUID() {
		String uuid = java.util.UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型yyyyMMddHHmmssSSS
	 */
	public static String getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> parseJsonToMap(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> list = null;
		try {
			list = objectMapper.readValue(json, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * json 转 Map<String,Object>
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJsonToMapObj(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> list = null;
		try {
			list = objectMapper.readValue(json, Map.class);
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
	public static List<Map<String, String>> parseJsonToList(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> list = null;
		try {
			list = objectMapper.readValue(json, List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 根据行业代码获取报告模板ID
	public static String getModId(String tradeCode) {
		String json = "{\"FD\":\"0001\",\"DW\":\"0002\",\"GT\":\"0003\",\"HG\":\"0004\",\"AL\":\"0005\",\"MG\":\"0006\",\"PB\":\"0007\",\"SN\":\"0008\",\"TC\":\"0009\",\"HK\":\"0010\",\"SH\":\"0011\",\"JH\":\"0012\",\"MT\":\"0013\",\"ST\":\"0014\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Map<String, String> map = objectMapper.readValue(json, Map.class);
			Set<Entry<String, String>> set = map.entrySet();
			for (Entry<String, String> entry : set) {
				if (entry.getKey().equals(tradeCode)) {
					return entry.getValue();
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	// 根据行业代码获取报告名称
	public static String getModName(String tradeCode) {
		String json = "{\"FD\":\"发电企业\",\"DW\":\"电网企业\",\"GT\":\"钢铁生产企业\",\"HG\":\"化工生产企业\",\"AL\":\"电解铝生产企业\",\"MG\":\"镁冶炼企业\",\"PB\":\"平板玻璃生产企业\",\"SN\":\"水泥企业\",\"TC\":\"陶瓷生产企业\",\"HK\":\"民用航空\",\"SH\":\"石油化工企业\",\"JH\":\"独立焦化企业\",\"MT\":\"煤炭生产企业\",\"ST\":\"石油和天然气生产企业\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Map<String, String> map = objectMapper.readValue(json, Map.class);
			Set<Entry<String, String>> set = map.entrySet();
			for (Entry<String, String> entry : set) {
				if (entry.getKey().equals(tradeCode)) {
					return entry.getValue();
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	// 获取当前系统时间——UUID
	public static String getCurTimeUUID() {
		return getCurTime("yyyyMMddHHmmssSSS");
	}

	// 指定格式获取当前系统时间
	public static String getCurTime(String formatStr) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		String curString = dateFormat.format(date);
		return curString;
	}

	/**
	 * 
	 * @param 判断是否是空字符串
	 * @return
	 */
	public static boolean isEmptyString(String s) {
		if (s == null || s.length() == 0 || "null".equals(s)
				|| "undefined".equals(s) || s.replaceAll(" ", "").length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * 验证传入参数字符是否合法
	 * 
	 * @param required
	 *            TODO
	 * @param params
	 * @return
	 */
	public static boolean validLawfulStr(boolean required, String... params) {
		String[] danger = { "[", "|", "]", "&", "$", "%", "@", "'", "\"", "<",
				">", "(", ")", "+", ".", "CR", "LF", "script", "document",
				"eval" };
		boolean flag = false;
		first: for (String parm : params) {
			if (required && isEmptyString(parm)) {
				flag = true;
				break;
			}
			for (String element : danger) {
				if ((!isEmptyString(parm) && parm.indexOf(element) > -1)) {
					flag = true;
					break first;
				}
			}
		}
		return flag;
	}

	/**
	 * 判断null
	 * 
	 * @param str
	 * @return
	 */
	public static String isEmpt(Object str) {
		String result = "";
		if (null == str || "".equals(str.toString())
				|| "null".equals(str.toString())) {
			result = "";
		} else {
			result = str.toString();
		}
		return result;
	}

	/**
	 * 格式化map，将value为null置为空
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> formatMap(Map<String, Object> map) {
		Map<String, String> resultMap = new HashMap<String, String>();
		Set<Entry<String, Object>> entries = map.entrySet();
		for (Entry<String, Object> entry : entries) {
			resultMap.put(entry.getKey(), isEmpt(entry.getValue()));
		}
		return resultMap;
	}

	/**
	 * 获取区域代码
	 * 
	 * @param cityCode
	 * @param countyCode
	 * @return
	 */
	public static String getLastCode(String cityCode, String countyCode) {
		String lastCode = "330000";
		if (!"".equals(isEmpt(countyCode))) {
			lastCode = countyCode;
		} else if (!"".equals(isEmpt(cityCode))) {
			lastCode = cityCode;
		}
		return lastCode;
	}

	// String 对象根据 "," 拆分成String数组，String为空或者不存在的情况下返回null
	public static String[] strToArrByPara(String strObj) {
		if (strObj != null && strObj.length() > 0) {
			return strObj.split(",");
		}
		return null;
	}

	public static String changeNull(String str) {
		if (str == null)
			return "";
		else {
			return str;
		}
	}

	public static String changeNull(Object obj, String repStr) {
		if (obj == null)
			return repStr;
		else {
			return obj.toString();
		}
	}

	public static String formatStr(Object obj) {
		String str = ",".equals(isEmpt(obj)) ? "" : isEmpt(obj);
		String result = "";
		if (str.indexOf(",") != -1) {
			String[] strArray = str.split(",");
			for (String one : strArray) {
				result += "'" + one + "',";
			}
			result = result.substring(0, result.length() - 1);
		} else if (!"".equals(str)) {
			result = "'" + str + "'";
		}
		return result;
	}

	public static Map<String, String> formatArea(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		String str = ",".equals(isEmpt(obj)) ? "" : isEmpt(obj);
		String result = "";
		if (!str.contains(",")) {
			result = str;
			if ("".equals(result)) {
				map.put("pro", result);
			} else {
				if ("330000".equals(result) || "339900".equals(result)) {
					map.put("pro", "'" + result + "'");
				} else if ("00".equals(result.substring(4))
						|| "01".equals(result.substring(4))) {
					map.put("city", "'" + result + "'");
				} else {
					map.put("county", "'" + result + "'");
				}
			}
		} else {
			if (str.contains("{")) {
				str = str.substring(1, str.length() - 1);
				String[] strArray = str.split(",");
				for (String one : strArray) {
					if (one.contains("=")) {
						result += "'" + one.split("=")[0] + "',";
					}
				}
				result = result.substring(0, result.length() - 1);
				map.put("city", result);
			} else {
				if (!"".equals(str)) {
					String[] strArray2 = str.split(",");
					for (String one2 : strArray2) {
						String spl = one2.substring(4);
						if ("00".equals(spl) || "01".equals(spl)) {
							result += "'" + one2 + "',";
						}
					}
					result = result.substring(0, result.length() - 1);
					map.put("city", result);
				}
			}
		}
		return map;
	}

	/**
	 * 分割地区代码
	 * 
	 * @param object
	 * @return
	 */
	public static String getAreas(Object object) {
		String con = "";
		String areas = isEmpt(object);
		if (areas.contains(",")) {
			for (String one : areas.split(",")) {
				con += "'" + one + "',";
			}
			con = con.substring(0, con.length() - 1);
		} else {
			con = "'" + areas + "'";
		}
		return con;
	}

	/**
	 * 判断省、市、县
	 * 
	 * @return
	 */
	public static String judgeArea(String areaCode) {
		String areaType = "";
		if ("339900".equals(areaCode) || "330000".equals(areaCode)) {
			areaType = "PRO";
		} else if ("01".equals(areaCode.substring(4))
				|| "01".equals(areaCode.substring(4))) {
			areaType = "CIT";
		} else {
			areaType = "COU";
		}
		return areaType;
	}

	/**
	 * 字符串转list
	 * 
	 * @param object
	 * @return
	 */
	public static List<String> getListByStrings(Object object) {
		List<String> list = new ArrayList<String>();
		String strs = isEmpt(object);
		if (strs.indexOf(",") != -1) {
			String[] strArray = strs.split(",");
			for (String one : strArray) {
				list.add(one);
			}
		} else {
			list.add(strs);
		}
		return list;
	}

	/**
	 * Map转换
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Object> getObjectMap(Map<String, String> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Set<Entry<String, String>> entries = map.entrySet();
		for (Entry<String, String> entry : entries) {
			resultMap.put(entry.getKey(), isEmpt(entry.getValue()));
		}
		return resultMap;
	}

	
	/**
	 * 字符串转字节数组
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToStr(byte[] bytes) {
		return new String(bytes);
	}

	/**
	 * 字节数组转字符串
	 * 
	 * @param sour
	 * @return
	 */
	public static byte[] strToBytes(String sour) {
		return sour.getBytes();
	}
	
	/**
	 * 获取当前一周时间
	 * @param dataformat
	 * @return
	 */
	public static List<String> getAWeekDate(String dataformat) {
		dataformat = "yyyy-MM-dd";
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(dataformat);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		System.out.println(df.format(cal.getTime()));
		list.add(0, df.format(cal.getTime()));
		//****************
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY); // 获取本周二的日期
		System.out.println(df.format(cal.getTime()));
		list.add(1, df.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY); // 获取本周三的日期
		System.out.println(df.format(cal.getTime()));
		list.add(2, df.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY); // 获取本周四的日期
		System.out.println(df.format(cal.getTime()));
		list.add(3, df.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY); // 获取本周五的日期
		System.out.println(df.format(cal.getTime()));
		list.add(4, df.format(cal.getTime()));
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY); // 获取本周六的日期
		System.out.println(df.format(cal.getTime()));
		list.add(5, df.format(cal.getTime()));
		
		//****************
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.add(Calendar.WEEK_OF_YEAR, 1);// 增加一个星期，才是我们中国人理解的本周日的日期
		System.out.println(df.format(cal.getTime()));
		list.add(6, df.format(cal.getTime()));
		return list;
	}
	
	/**
	 * 获取本周每天的日期
	 * @param dateformat
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getThisWeek(String dateformat) {
		// 格式说明：yyyyMMddHHmmss,"yyyy-MM-dd EEE":EEE代表星期几
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		Date mdate = new Date();
        int b = mdate.getDay();
        Date fdate;
        List<String> list = new ArrayList<String>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            String oneDate = sdf.format(fdate);
            list.add(a-1, oneDate);
        }
        return list;
    }
	
	/**
	 * 封装时间查询条件(业务需要)
	 * @param dateformat
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String weekQueryCondtion(String dateformat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		Date mdate = new Date();
        int b = mdate.getDay();
        Date fdate;
        StringBuilder condition = new StringBuilder(""); 
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            if(a==7){
            	condition = condition.append("'").append(sdf.format(fdate)).append("'");
            }else {
            	condition = condition.append("'").append(sdf.format(fdate)).append("',");
			}
        }
        System.err.println("一周日期条件封装："+condition.toString());
		return condition.toString();
	}
	
	public static String fromatJson(String userData) {
		userData = userData.replace("{", "{\"");
    	userData = userData.replace("=", "\":");
    	userData = userData.replace(", ", ", \"");
    	userData = userData.replace(",", "\",");
    	userData = userData.replace(":,", ":\"\",");
    	userData = userData.replace(":", ":\"");
    	userData = userData.replace("}", "\"}");
    	return userData;
	}
	
	/**
	 * 清空指定文件夹下所有文件
	 * @param path
	 * @return
	 */
	public static boolean deletePathFiles(String path){
		if(null==path||"".equals(path)){
			return false;
		}
		File file = new File(path);
		if(!file.exists()){
			System.err.println("path not exists!");
			return false;
		}
		
		String[] content = file.list();
		for(String name : content){
			File temp = new File(path, name);
			if(temp.isDirectory()){
				deletePathFiles(temp.getAbsolutePath());
				temp.delete();
			}else{
				if(!temp.delete()){
					System.err.println("delete failed" + name);
				}
			}
		}
		return true;
	}
	
	
	/******************************************测试主方法***************************************************/
	public static void main(String[] args) {
		/*System.out.println(Util.getCurTime("yyyyMMdd"));
		weekQueryCondtion("yyyyMMdd");
		System.out.println("--------分割线--------");
        List<String> days = getThisWeek("yyyyMMddHHmmss");
        Iterator<String> iterator = days.iterator();
        System.out.println("接口格式日期："+getCurTime("yyyyMMddHHmmss"));
        while(iterator.hasNext()){
        	System.out.println("本周日期："+iterator.next());
        }*/
//		System.out.println(Integer.parseInt("20180901")>Integer.parseInt("20160901"));
		/*String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&size=88888888888";
		String datas = HttpDeal.get(url);
		String data = "{\"pageNum\":1,\"pageSize\":20,\"size\":2,\"orderBy\":null,\"startRow\":1,\"endRow\":2,\"total\":2,\"pages\":1,\"list\":[{\"number\":\"330301131201808240055\",\"name\":\"薛纪晓\",\"anotherName\":\"无\",\"sex\":\"1\",\"sexValue\":\"男性\",\"birth\":\"19770402\",\"marriage\":\"4\",\"marriageValue\":\"离婚\",\"identityId\":\"330327197704020953\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330327\",\"originValue\":\"浙江省温州市苍南县\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330327\",\"houseAddrValue\":\"浙江省温州市苍南县\",\"houseDetailAddr\":\"宜山镇仁寿街２６号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"05\",\"identityValue\":\"农民\",\"workAddr\":\"无\",\"position\":\"无\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"1106\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"imprisonLimit\":\"20200904\",\"brief\":\"2018年8月24日，因吸食毒品后被公安机关查获。\",\"comeDate\":\"20180905093357\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"林震\",\"transactorPhone\":\"747709\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"},{\"number\":\"330301131201808210040\",\"name\":\"王丽跃\",\"sex\":\"2\",\"sexValue\":\"女性\",\"birth\":\"19700814\",\"marriage\":\"2\",\"marriageValue\":\"已婚\",\"identityId\":\"330302197008145923\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330302\",\"originValue\":\"浙江省温州市鹿城区\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330302\",\"houseAddrValue\":\"浙江省温州市鹿城区\",\"houseDetailAddr\":\"南郊街道横塘巷26--3号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"09\",\"identityValue\":\"无业人员\",\"workAddr\":\"不详\",\"position\":\"不详\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"3305\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"detoxEnd\":\"20180905\",\"imprisonLimit\":\"20200904\",\"holdBegin\":\"20180821\",\"brief\":\"2018年08月21日该王丽跃因吸食毒品被公安机关查获，尿检呈阳性。\",\"comeDate\":\"20180905092658\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"叶军\",\"transactorPhone\":\"588588\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"}],\"firstPage\":1,\"prePage\":0,\"nextPage\":0,\"lastPage\":1,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1]}";
		JSONObject jsonObject = new JSONObject(datas);
		int total = jsonObject.getInt("total");
		JSONArray dataArray = jsonObject.getJSONArray("list");
		System.out.println("数组长度："+dataArray.length());
		if(total==0){
		}
		for (int key=0;key<dataArray.length();key++) {
			JSONObject object = dataArray.getJSONObject(key);
			System.out.println(object.get("prisonName"));
			Map<String, Object> userMap = object.toMap();
			String number_id = Util.isEmpt(userMap.get("number"));
			if (true) {// 若本库有有此数据，则更新本库的时间
				}
			}*/ 
		}
}
