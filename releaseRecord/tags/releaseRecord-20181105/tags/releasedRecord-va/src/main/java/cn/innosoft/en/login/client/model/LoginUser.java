package cn.innosoft.en.login.client.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser implements Serializable {

	private static final long serialVersionUID = -7841930700136559642L;

	private boolean retResult;

	private String retMsg;

	private String token;

	/**
	 * 请求的url地址,每次请求时都会修改该字段
	 */
	private String url;

	/**
	 * 用户基本信息
	 */
	private ClientUser user;

	/**
	 * 系统权限信息
	 */
	private LoginSystem system;

	/**
	 * 当前用户能访问的所有系统
	 */
	private List<ClientSystem> accessSystems;

	/**
	 * 用户所属机构
	 */
	private List<ClientOrg> belongOrg ;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ClientUser getUser() {
		return user;
	}

	public void setUser(ClientUser user) {
		this.user = user;
	}

	public LoginSystem getSystem() {
		return system;
	}

	public void setSystem(LoginSystem system) {
		this.system = system;
	}

	public boolean isRetResult() {
		return retResult;
	}

	public void setRetResult(boolean retResult) {
		this.retResult = retResult;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ClientSystem> getAccessSystems() {
		return accessSystems;
	}

	public void setAccessSystems(List<ClientSystem> accessSystems) {
		this.accessSystems = accessSystems;
	}

	 public List<ClientOrg> getBelongOrg() {
	 return belongOrg;
	 }
	
	 public void setBelongOrg(List<ClientOrg> belongOrg) {
	 this.belongOrg = belongOrg;
	 }

}