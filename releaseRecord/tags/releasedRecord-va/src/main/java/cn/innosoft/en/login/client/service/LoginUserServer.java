package cn.innosoft.en.login.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.innosoft.en.login.client.SystemCodeContext;
import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientOrg;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientSystem;
import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.persistent.ILoinUserClient;




public class LoginUserServer {

	/**
	 * 登录用户信息
	 */
	private ILoinUserClient iLoinUserClient;

	private String systemId;

	/**
	 * 用户登录.
	 * 
	 * @param userAcct
	 *            用户账号
	 * @param userPwd
	 *            用户密码
	 * @throws Exception
	 */
	public LoginUser login(String userAcct, String userPwd) throws Exception {
		LoginUser user = iLoinUserClient.login(userAcct, userPwd, systemId);
		if (user.isRetResult()) {
			Map<String, List<ClientCode>> code = iLoinUserClient.getSystemGlobalCode(user.getToken(), systemId);
			SystemCodeContext.setGlobalCodes(code);
		}
		return user;
	}

	/**
	 * 退出.
	 * 
	 * @throws Exception
	 */
	public void logout(String token) {
		try {
			iLoinUserClient.logout(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取登录用户在在一个系统中的所有信息.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 用户信息
	 */
	public LoginUser getUserLoginInfo(String token) throws Exception {
		LoginUser user = iLoinUserClient.getUserLoginInfo(token, systemId);
		if (user.isRetResult()) {
			Map<String, List<ClientCode>> code = iLoinUserClient.getSystemGlobalCode(user.getToken(), systemId);
			SystemCodeContext.setGlobalCodes(code);
		}
		return user;
	}

	/**
	 * 判断登录用户是否有权限访问该资源.
	 * 
	 * @return 角色id集合
	 */
	public boolean decide(String url) {
		// List<String> ress = LoginUserContext.getUserResources();
		// if (StringUtils.hasText(url)) {
		// for (String res : ress) {
		// if (url.equals(res)) {
		// return true;
		// }
		// }
		// }
		return false;
	}

	public ILoinUserClient getiLoinUserClient() {
		return iLoinUserClient;
	}

	public void setiLoinUserClient(ILoinUserClient iLoinUserClient) {
		this.iLoinUserClient = iLoinUserClient;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public List<ClientRole> getUserRoles(String token, String systemId) {
		try {
			return iLoinUserClient.getUserRoles(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ClientResource> getUserResources(String token, String systemId) {
		try {
			return iLoinUserClient.getUserResources(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String, Object>> getUserBelongOrgs(String token) {
		try {
			return iLoinUserClient.getUserBelongOrgs(token);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Map<String, List<ClientCode>>> getUserSpecCodes(String token, String systemId) {
		try {
			return iLoinUserClient.getUserSpecCodes(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, List<ClientCode>> getUserGlobalCodes(String token, String systemId) {
		try {
			return iLoinUserClient.getUserGlobalCodes(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ClientRole> updateUserRoles(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserRoles(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ClientResource> updateUserResources(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserResources(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, List<ClientCode>> updateUserGlobalCodes(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserGlobalCodes(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Map<String, List<ClientCode>>> updateUserSpecCodes(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserSpecCodes(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Map<String, List<ClientOrg>>> updateUserSpecOrgs(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserSpecOrgs(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, List<ClientOrg>> updateUserGlobalOrgs(String token, String systemId) {
		try {
			return iLoinUserClient.updateUserGlobalOrgs(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Map<String, List<ClientOrg>>> getUserSpecOrgs(String token, String systemId) {
		try {
			return iLoinUserClient.getUserSpecOrgs(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, List<ClientOrg>> getUserGlobalOrgs(String token, String systemId) {
		try {
			return iLoinUserClient.getUserGlobalOrgs(token, systemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ClientSystem> updateUserSystems(String token) {
		try {
			return iLoinUserClient.updateUserSystem(token);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ClientOrg> updateUserBelongOrgs(String token) {
		try {
			return iLoinUserClient.updateUserBelongOrgs(token);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ClientResource> getUserResourcesTree(String token,String systemCode) {
		List<ClientResource> list = new ArrayList<ClientResource>();
		try {
			list = iLoinUserClient.getUserResourcesTree(token, systemCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
