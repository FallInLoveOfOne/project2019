/**
 * 标题: FuncPathRequestMatcher.java
 * 包名： cn.innosoft.framework.interceptor.access
 * 功能描述：TODO
 * 作者：LIUL
 * 创建时间： 2012-11-2 下午6:05:21
 * @version V1.0   
 */
package cn.innosoft.en.login.client.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.RequestMatcher;

/**
 * url字符串构造匹配类.
 * 
 * @author liul
 * @date 2014-4-2 上午9:18:39
 */
@SuppressWarnings("deprecation")
public class FuncPathRequestMatcher implements RequestMatcher {

	/**
	 * url字符串以/分隔后内容.
	 */
	private final String[] patt;

	/**
	 * 通过url字符串构造匹配类.
	 * 
	 * @param pattern
	 *            url字符串
	 */
	public FuncPathRequestMatcher(String pattern) {
		patt = getNeedUrl(pattern).split("/");
	}

	/**
	 * 判断访问路径是否与匹配.
	 * 
	 * @param request
	 *            访问对象
	 * @return 匹配结果
	 */
	@Override
	public boolean matches(HttpServletRequest request) {
		return matches(getRequestPath(request));
	}
	
	/**
	 * 判断url是否与匹配.
	 * 
	 * @param url
	 *            url字符串
	 * @return 匹配结果
	 */
	public boolean matches(String url) {
		String[] uArray = getNeedUrl(url).split("/");
		if (patt.length != uArray.length) {
			return false;
		}

		for (int i = 0; i < uArray.length; i++) {
			String p = uArray[i];
			if (p.indexOf("{") != -1) {
				continue;
			}

			if (!p.equals(patt[i])) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 从请求对象中获取访问路径，不包括查询参数部分.
	 * 
	 * @param request
	 *            请求对象
	 * @return 访问路径
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String url = request.getServletPath();

		if (request.getPathInfo() != null) {
			url += request.getPathInfo();
		}

		url = getNeedUrl(url);
		return url;
	}

	/**
	 * 对url字符串进行处理，把？转化为/,如字符串不以/结尾则在字符串后加上/.
	 * 
	 * @param path
	 *            url字符串
	 * @return 处理后的字符串
	 */
	private static String getNeedUrl(String path) {
		path = path.toLowerCase();

		int j = path.indexOf("?");
		if (j != -1) {
			path = path.substring(0, j) + "/" + path.substring(j + 1);
		}

		if (!path.endsWith("/")) {
			path += "/";
		}
		return path;
	}
}
