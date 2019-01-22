package cn.innosoft.en.login.client.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import cn.innosoft.en.login.client.service.LoginUserServer;

/**
 * 集成登录退出成功时处理类.
 * <p>
 * 主要功能有两点，1.在请求端记录日志；2.通知服务端，由服务端进行处理，处理内容有清除服务端相关记录，记录业务日志等。
 * </p>
 * 
 * @author huangwb
 * @date 2014-3-16 下午2:44:22
 */
public class ClientUrlLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements
		LogoutSuccessHandler {

	/**
	 * 技术日志记录类.
	 */
	// protected ITechFwLog techLog = FwLogFactory.getTechLog(getClass());

	/**
	 * 集成服务端调用类，用来访问服务端代码.
	 */
	private LoginUserServer loginUserServer;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		if (authentication != null) { // 没有登录或者登录已超时
			SecurityLoginUser securityLoginUser = (SecurityLoginUser) authentication.getPrincipal();
			if (securityLoginUser != null) {
				String userAcct = securityLoginUser.getLoginUser().getUser().getUserAcct();
				// 记录日志
				// techLog.info("用户[" + userAcct + "]退出系统");
				// 通知服务端
				try {
					loginUserServer.logout(securityLoginUser.getLoginUser().getToken());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		super.handle(request, response, authentication);
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
