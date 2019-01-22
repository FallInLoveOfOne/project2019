package cn.innosoft.en.login.client.security;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * TODO.
 * 
 * @author huangwb
 * @date 2014-3-13 下午4:39:12
 */
public class ClientFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/*
	 * TODO.
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// String url = ((FilterInvocation) object).getRequestUrl();
		// Set<ConfigAttribute> roleIds = new HashSet<ConfigAttribute>();
		// roleIds.add(new SecurityConfig(url));
		// return roleIds;
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}