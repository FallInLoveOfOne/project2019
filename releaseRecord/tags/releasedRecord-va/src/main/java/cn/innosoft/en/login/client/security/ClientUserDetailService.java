package cn.innosoft.en.login.client.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.service.LoginUserServer;



/**
 * 根据用户名，密码到服务器获取用户信息；
 * 
 * @author huangwb
 * @date 2014-4-2 下午2:38:43
 */
@SuppressWarnings("deprecation")
public class ClientUserDetailService implements UserDetailsService {

	/**
	 * 分隔符.
	 */
	private static final String SPLIT = "#SPLIT#";

	/**
	 * 访问集成登录的服务端.
	 */
	private LoginUserServer loginUserServer;

	/**
	 * 密码加密类.
	 */
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String nameAndPwd) throws UsernameNotFoundException {

		String[] arr = nameAndPwd.split(SPLIT);
		String userAcct = arr[0];
		String password = arr[1];
		try {
			// 对传输到服务端的密码进行加密
			LoginUser loginUser = loginUserServer.login(userAcct, password);
			if (!loginUser.isRetResult()) {
				throw new Exception(loginUser.getRetMsg());
			}
			SecurityLoginUser slUser = new SecurityLoginUser(loginUser);
			// 设置session永不过期 2018-11-02
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String acct = request.getParameter("account");
			System.out.println("session 当前账号："+acct);
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(-1);
			// 设置session永不过期 2018-11-02 END
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

	/**
	 * 设置密码加密类.
	 * 
	 * @param passwordEncoder
	 *            密码加密类
	 */
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");
		this.passwordEncoder = passwordEncoder;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

}