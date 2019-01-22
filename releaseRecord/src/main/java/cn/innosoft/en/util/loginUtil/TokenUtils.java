/**
 * 
 */
package cn.innosoft.en.util.loginUtil;

import java.util.UUID;

/**
 * 令牌帮助类，用于令牌操作.
 * 
 * @author huangwb
 * @date 2013-11-20 上午9:19:26
 * @version
 */
public final class TokenUtils {

	/**
	 * 私有构建函数.
	 */
	private TokenUtils() {

	}

	/**
	 * 产生一个令牌.
	 * 
	 * @return 令牌
	 */
	public static String genToken() {
		return UUID.randomUUID().toString();
	}

}
