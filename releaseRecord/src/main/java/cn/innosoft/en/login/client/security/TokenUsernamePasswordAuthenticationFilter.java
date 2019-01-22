package cn.innosoft.en.login.client.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.service.LoginUserServer;
import cn.innosoft.en.util.loginUtil.DESUtils;


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
public class TokenUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/**
	 * 技术日志.
	 */
	// protected ITechFwLog techLog = FwLogFactory.getTechLog(getClass());
	/**
	 * 访问集成登录的服务端.
	 */
	private LoginUserServer loginUserServer;

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
		String token = getToken(request);
		// techLog.info("用户[" + token + "]，尝试登录");
		LoginUser loginUser = null;
		try {
			loginUser = loginUserServer.getUserLoginInfo(token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("登录失败");
		}
		if (loginUser != null) {
			if (!loginUser.isRetResult()) {
				throw new UsernameNotFoundException(loginUser.getRetMsg());
			}
			try {
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(token,
						loginUser.getUser().getPwd());
				setDetails(request, authRequest);
				return this.getAuthenticationManager().authenticate(authRequest);
			} catch (Exception e) {
				throw new UsernameNotFoundException("密码加密错误");
			}
		} else {
			throw new UsernameNotFoundException("登录失败");
		}
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

	private String getToken(HttpServletRequest request) {
		return request.getParameter("token");
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

	/**
	 * 解密.
	 * 
	 * @param str
	 *            密文
	 * @return 明文
	 * @throws Exception
	 *             解密异常
	 */
	private static String decrypt(String str) throws Exception {
		try {
			return DESUtils.decrypt(str);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(DESUtils.decrypt("48C04AEDF4B5C3C7"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
