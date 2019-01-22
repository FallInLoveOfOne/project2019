package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author sh
 *
 */
public class UUIDUtil {
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 获取时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		return getCurrTime("yyyyMMddHHmmssSSS");
	}
	
	/**
	 * 获取格式化时间出串
	 * @param format
	 * @return
	 */
	public static String getCurrTime(String format) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);//"yyyyMMddHHmmssSSS"
		String curString = dateFormat.format(date);
		return curString;
	}
	
	/**
	 * 获取格式化、长度的时间串
	 * @param format
	 * @param length
	 * @return
	 */
	public static String getTime(String format,int length) {
		String data = getCurrTime(format);
		if(length>data.length()){
			return data;
		}
		return data.substring(0, length);
	}
	
	
	public static void main(String[] args) throws Exception {
		
	}

}
