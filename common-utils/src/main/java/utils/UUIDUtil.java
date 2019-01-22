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
	 * ��ȡUUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * ��ȡʱ���
	 * @return
	 */
	public static String getTimeStamp() {
		return getCurrTime("yyyyMMddHHmmssSSS");
	}
	
	/**
	 * ��ȡ��ʽ��ʱ�����
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
	 * ��ȡ��ʽ�������ȵ�ʱ�䴮
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
