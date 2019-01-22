package cn.innosoft.en.login.client.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import cn.innosoft.en.login.client.service.LoginUserServer;


/**
 * 判断是否有权限访问资源.通过对比某个资源需要的角色与用户拥有的角色.
 * <ul>
 * <li>如果资源不需要角色，则所有用户可以访问资源；</li>
 * <li>如果用户拥有资源需要的角色则能访问资源，否则不能访问；</li>
 * </ul>
 * 
 * @author huangwb
 * @date 2014-3-13 下午4:55:55
 */
public class ClientAccessDecisionManager implements AccessDecisionManager {
	/**O
	 * 技术日志记录类.
	 */
	// protected ITechFwLog techLog = FwLogFactory.getTechLog(getClass());

	/**
	 * 集成服务端调用类，用来访问服务端代码.
	 */
	private LoginUserServer loginUserServer;

	/**
	 * 判断是否有权限访问资源.
	 * <ol>
	 * <li>
	 * 通过AccessUser.getAuthorities()获取用户具有的角色,放置在authentication.getAuthorities;</li>
	 * <li>filterInvocation--->过滤器调用对象，用于获取请求Url;</li>
	 * <li>
	 * 通过CustomFilterInvocationSecurityMetadataSource.getAttributes获取访问该资源所需的权限;
	 * </li>
	 * </ol>
	 * 
	 * @param authentication
	 *            权限认证对象
	 * @param filterInvocation
	 *            过滤器对象
	 * @param configAttributes
	 *            资源对应的角色集合
	 * @throws AccessDeniedException
	 *             无权访问异常
	 * @throws InsufficientAuthenticationException
	 *             不完全可信异常
	 */
	@Override
	public void decide(Authentication authentication, Object filterInvocation,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		HttpServletRequest request = ((FilterInvocation) filterInvocation).getRequest();
		String url = ((FilterInvocation) filterInvocation).getRequestUrl();
		// 判断是否有权限访问资源
		boolean access = loginUserServer.decide(FuncPathRequestMatcher.getRequestPath(request));
		if (access) {
			// TODO，设置当前url对应的代码集，
		} else {
			// techLog.info("无权限访问资源[" + url + "]");
			throw new AccessDeniedException("无权限访问资源[" + url + "]");
		}
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	/**
	 * 设置服务端调用类.
	 * 
	 * @return 服务端调用类
	 */
	public LoginUserServer getLoginUserServer() {
		return loginUserServer;
	}

	/**
	 * 设置服务端调用类.
	 * 
	 * @param loginUserServer
	 *            服务端调用类
	 */
	public void setLoginUserServer(LoginUserServer loginUserServer) {
		this.loginUserServer = loginUserServer;
	}

}