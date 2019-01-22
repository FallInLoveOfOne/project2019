/**
 * 标题: AccessRedirectInvalidSessionFilter.java
 * 包名： cn.innosoft.framework.interceptor.access
 * 功能描述：TODO
 * 作者： LIUL
 * 创建时间： 2012-9-19 下午6:09:30
 * @version V1.0   
 */
package cn.innosoft.en.login.client.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import cn.innosoft.en.login.client.LoginUserContext;


/**
 * 匿名用户过滤器，把没有登录或者匿名用户拦截并转到{@link #destinationUrl}指定页面.
 * <p>
 * spring security默认有一个匿名用户过滤器，而本过滤器用于匿名过滤器之后，不允许匿名访问，强制需要登录。
 * </p>
 * 
 * @author huangwb
 * @date 2014-3-13 下午4:30:36
 */
public class ClientAnonymousFilter implements Filter {

	/**
	 * 技术日志记录类.
	 */
	// protected ITechFwLog techLog = FwLogFactory.getTechLog(getClass());

	/**
	 * 授权认证类.
	 */
	private final AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	/**
	 * 没有登录，转向页面地址.
	 */
	private String destinationUrl;


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String token = request.getParameter("token");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authenticationTrustResolver.isAnonymous(authentication)) { // 如果没有登录，或者是匿名用户
			if (StringUtils.hasText(token)) {
				// 已经在单点登录过，获取用户信息，并构造认证信息
				response.sendRedirect(request.getContextPath() + "/logon_token?token=" + token);
				return;
			}
			if (destinationUrl == null) { // 没有指定跳转页面，转向401末授权页面
				System.out.println("没有登录，无法匿名请求该资源。");
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无法匿名请求该资源。 ");
			} else { // 转到指定页面，一般指向登录页
				System.out.println("没有登录，转向" + destinationUrl + "页面");
				String redirectUrl = request.getContextPath() + destinationUrl;
				if (destinationUrl.indexOf("http:") > -1 || destinationUrl.indexOf("https:") > -1) {
					redirectUrl = destinationUrl;
				}
				response.sendRedirect(redirectUrl);
			}
			return;
		} else if (!LoginUserContext.getCurrentLoginUserToken().equals(token)) {// 切换了用户,重新登录
			if (StringUtils.hasText(token)) {
				// 已经在单点登录过，获取用户信息，并构造认证信息
				response.sendRedirect(request.getContextPath() + "/logon_token?token=" + token);
				return;
			}
		} else if (token != null && !"".equals(token)) {// 切换了用户,重新登录
			response.sendRedirect(request.getContextPath() + "/logon_token?token=" + token);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	public String getDestinationUrl() {
		return destinationUrl;
	}

	public void setDestinationUrl(String destinationUrl) {
		this.destinationUrl = destinationUrl;
	}

}
