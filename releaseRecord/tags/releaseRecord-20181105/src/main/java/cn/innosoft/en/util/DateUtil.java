package cn.innosoft.en.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DateUtil {

	/**
	 * 获取过去或者未来 任意天内的日期数组
	 * 
	 * @param intervals
	 *            intervals天内
	 * @return 日期数组
	 */
	/*public static ArrayList<String> test(int intervals) {
		ArrayList<String> pastDaysList = new ArrayList<>();
		ArrayList<String> fetureDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			pastDaysList.add(getPastDate(i));
			fetureDaysList.add(getFetureDate(i));
		}
		return pastDaysList;
	}*/
	
	/**
	 * 获取过去几天的日期集合
	 * @param intervals
	 * @return
	 */
	public static List<String> pastDays(int days,String format) {
		ArrayList<String> pastDaysList = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			pastDaysList.add(getPastDate(i,format));
		}
		return pastDaysList;
	}
	
	/**
	 * 获取未来几天的日期集合
	 * @param intervals
	 * @return
	 */
	public static List<String> fetureDays(int days,String format) {
		ArrayList<String> fetureDaysList = new ArrayList<>();
		for (int i = 0; i < days; i++) {
			fetureDaysList.add(getFetureDate(i,format));
		}
		return fetureDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past,String formats) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				- past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formats/*"yyyy-MM-dd"*/);
		String result = format.format(today);
		// Log.e(null, result);
		return result;
	}

	/**
	 * 获取未来 第 past 天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getFetureDate(int past,String formats) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				+ past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formats/*"yyyy-MM-dd"*/);
		String result = format.format(today);
		// Log.e(null, result);
		return result;
	}
	
	/**
	 * 业务条件
	 * @param past
	 * @param formats
	 * @return
	 */
	public static String fetureDaysContion(int past,String formats) {
		List<String> fetureDatesList = fetureDays(past, formats);
		StringBuilder conditonBuilder = new StringBuilder("");
		Iterator<String> iterator = fetureDatesList.iterator();
		while (iterator.hasNext()) {
			conditonBuilder = conditonBuilder.append("'").append(iterator.next()).append("',");
		}
		return conditonBuilder.toString().substring(0, conditonBuilder.toString().length()-1);
	}
	
	public static void main(String[] args) {
		System.out.println(fetureDays(7, "yyyy-MM-dd").get(6));
		System.out.println(getFetureDate(7, "yyyyMMdd"));
	}

}
