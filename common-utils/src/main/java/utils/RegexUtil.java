package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 * 2018-03-06
 * @author sh
 *
 */
public class RegexUtil {
	
	/**
	 * 正则替换字符串内容
	 * @param srcStr（源字符串）
	 * @param regex（正则式）
	 * @param replaceStr（替换为字符串）
	 * @return
	 */
	public static String replaceStrByReg(String srcStr,String regex,String replaceStr) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(srcStr);
		while(matcher.find()){
			String matchStr = matcher.group(0);
			srcStr = srcStr.replace(matchStr, replaceStr);
		}
		return srcStr;
	}
	
	/**
	 * 正则匹配校验
	 * @param content（源字符串）
	 * @param regex（正则）
	 * @return
	 */
	public static boolean regPattern(String content,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		boolean is = matcher.matches();//全字符匹配
		return is;
	}
	
	
	public static void main(String[] args) {
	}

}
