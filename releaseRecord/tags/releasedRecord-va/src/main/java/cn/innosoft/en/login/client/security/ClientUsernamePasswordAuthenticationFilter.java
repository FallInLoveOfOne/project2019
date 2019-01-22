package cn.innosoft.en.login.client.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 集成登录过滤器，继承自{@code UsernamePasswordAuthenticationFilter}.
 * <p>
 * 从request中获取用户名与密码，用户名与密码的名称在配置文件中配置。
 * </p>
 * <p>
 * 1.用户名，密码的比较在authenticationManager中完成;
 * </p>
 * <p>
 * 2.其中密码加密方法需要与用户注册时的密码加密方法相同;
 * </p>
 * <p>
 * 3.只有filterProcessesUrl指定的页面需要进行密码比较,比较成功后表示登录成功；以后的请求不再需要进行密码比较。
 * filterProcessesUrl在配置文件中配置。
 * </p>
 * 
 * @author huangwb
 * @date 2014-3-13 下午3:06:14
 */
public class ClientUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/**
	 * 技术日志.
	 */
	// protected ITechFwLog techLog = FwLogFactory.getTechLog(getClass());

	/**
	 * 单点登录需要把用户名，密码传送出去，而在UserDetailsService的loadUserByUsername方法中只有用户名一个参数
	 * 故在本类把用户名密码以分隔符连接起来.
	 */
	private static final String SPLIT = "#SPLIT#";

	/**
	 * 尝试进行认证.
	 * 
	 * @param request
	 *            请求对象
	 * @param response
	 *            响应对象
	 * @throws AuthenticationException
	 *             认证异常
	 * @return 认证对象
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// techLog.info("用户[" + super.obtainUsername(request) + "]，尝试登录");
		String username = super.obtainUsername(request);
		String password = super.obtainPassword(request);
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username + SPLIT
				+ password, password);
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	/**
	 * 判断是否需要进行认证.
	 * 
	 * @param request
	 *            请求对象
	 * @param response
	 *            响应对象
	 * @return 是否需要认证
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		int pathParamIndex = uri.indexOf(';');
		if (pathParamIndex > 0) {
			uri = uri.substring(0, pathParamIndex);
		}
		return uri.equals(request.getContextPath() + super.getFilterProcessesUrl());
	}

}
