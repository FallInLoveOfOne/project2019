package cn.innosoft.en.login.client.security;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;

import cn.innosoft.en.util.loginUtil.AssertUtils;
import cn.innosoft.en.util.loginUtil.DESUtils;


/**
 * DES,密码加密类.
 * <p>
 * 用于Spring Security里的DaoAuthenticationProvider的passwordEncoder属性
 * </p>
 * 
 * @author huangwb
 * @date 2014-3-12 下午2:17:51
 */
public class DESPasswordEncoder extends BasePasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt) {
		AssertUtils.notNull(rawPass, "rawPass,原始密码不能为null");
		try {
			return DESUtils.encrypt(rawPass);
		} catch (Exception e) {
			//just throw
			throw new RuntimeException("DES加密失败，需要加密的字符=" + rawPass, e);
		}
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		AssertUtils.notNull(encPass, "encPass,加密后密码不能为null");
		AssertUtils.notNull(rawPass, "rawPass,原始密码不能为null");
		return encPass.equals(encodePassword(rawPass, salt));
	}

}
