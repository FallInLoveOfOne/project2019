/**
 * 
 */
package cn.innosoft.en.login.client.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.util.loginUtil.StringUtils;




/**
 * @author huangwb
 * @date 2014-5-13 上午10:38:23
 */
public class SecurityLoginUser extends LoginUser implements UserDetails {

	/**
	 * 序列化ID.
	 */
	private static final long serialVersionUID = 4400416684396029095L;

	private final LoginUser loginUser;

	public SecurityLoginUser(LoginUser argloginUser) {
		this.loginUser = argloginUser;
	}

	public LoginUser getLoginUser() {
		return loginUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getAuthorities
	 * ()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<ClientResource> resources = loginUser.getSystem().getResources();
		if (resources == null) {
			return null;
		}
		List<GrantedAuthority> collectionRes = new ArrayList<GrantedAuthority>();
		for (ClientResource res : resources) {
			String resurl = res.getResUrl();
			if (StringUtils.hasText(resurl)) {
				collectionRes.add(new SimpleGrantedAuthority(resurl));
			}
		}
		return collectionRes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return loginUser.getUser().getPwd();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return loginUser.getUser().getUserAcctCn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked
	 * ()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
