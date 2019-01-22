package cn.innosoft.en.login.client.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.service.LoginUserServer;



/**
 * 根据用户名，密码到服务器获取用户信息；
 * 
 * @author huangwb
 * @date 2014-4-2 下午2:38:43
 */
public class TokenUserDetailService implements UserDetailsService {

	/**
	 * 访问集成登录的服务端.
	 */
	private LoginUserServer loginUserServer;


	@Override
	public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {

		try {
			// 对传输到服务端的密码进行加密
			LoginUser loginUser = loginUserServer.getUserLoginInfo(token);
			if (!loginUser.isRetResult()) {
				throw new Exception(loginUser.getRetMsg());
			}
			SecurityLoginUser slUser = new SecurityLoginUser(loginUser);
			return slUser;
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
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