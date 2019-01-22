package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���򹤾���
 * 2018-03-06
 * @author sh
 *
 */
public class RegexUtil {
	
	/**
	 * �����滻�ַ�������
	 * @param srcStr��Դ�ַ�����
	 * @param regex������ʽ��
	 * @param replaceStr���滻Ϊ�ַ�����
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
	 * ����ƥ��У��
	 * @param content��Դ�ַ�����
	 * @param regex������
	 * @return
	 */
	public static boolean regPattern(String content,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		boolean is = matcher.matches();//ȫ�ַ�ƥ��
		return is;
	}
	
	
	public static void main(String[] args) {
	}

}
