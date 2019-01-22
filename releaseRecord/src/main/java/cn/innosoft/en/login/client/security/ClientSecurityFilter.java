package cn.innosoft.en.login.client.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 安全过滤器，通过对比某个资源需要的角色与用户拥有的角色，判断是否有权限访问.
 * <ol>
 * <li>如果资源不需要角色，则所有用户可以访问资源；</li>
 * <li>如果用户拥有资源需要的角色则能访问资源，否则不能访问；</li>
 * <li>判断逻辑在{@code CustomAccessDecisionManager}具体实现</li>
 * </ol>
 * 
 * @author huangwb
 * @date 2014-3-13 下午4:11:43
 */
public class ClientSecurityFilter extends AbstractSecurityInterceptor implements Filter {
	/**
	 * 资源对应角色的查找类.
	 */
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		FilterInvocation fileInvocation = new FilterInvocation(req, resp, chain);
		//前置拦截
		InterceptorStatusToken interceptorStatusToken = this.beforeInvocation(fileInvocation);
		
		//继续过滤器的链路
		fileInvocation.getChain().doFilter(req, resp);
		
		//后置拦截
		this.afterInvocation(interceptorStatusToken, null);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

}