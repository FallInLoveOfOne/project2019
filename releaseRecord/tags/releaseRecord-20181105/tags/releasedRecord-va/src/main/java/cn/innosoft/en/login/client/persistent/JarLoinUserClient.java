package cn.innosoft.en.login.client.persistent;

import java.util.List;
import java.util.Map;

import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientOrg;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientSystem;
import cn.innosoft.en.login.client.model.LoginUser;



public class JarLoinUserClient implements ILoinUserClient {

	@Override
	public LoginUser login(String userAcct, String userPwd, String systemId) throws Exception {
		return null;
	}

	@Override
	public LoginUser logout(String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientRole> getUserRoles(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientResource> getUserResources(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<ClientCode>> getUserGlobalCodes(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, List<ClientCode>>> getUserSpecCodes(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<ClientOrg>> getUserGlobalOrgs(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, List<ClientOrg>>> getUserSpecOrgs(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> getUserBelongOrgs(String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientSystem> getUserSystems(String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientRole> updateUserRoles(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientResource> updateUserResources(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<ClientCode>> updateUserGlobalCodes(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, List<ClientCode>>> updateUserSpecCodes(String token, String systemId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<ClientOrg>> updateUserGlobalOrgs(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, List<ClientOrg>>> updateUserSpecOrgs(String token, String systemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientOrg> updateUserBelongOrgs(String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientSystem> updateUserSystem(String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<ClientCode>> getSystemGlobalCode(String token, String systemCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.innosoft.orm.api.client.persistent.ILoinUserClient#getUserLoginInfo
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public LoginUser getUserLoginInfo(String token, String systemCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientResource> getUserResourcesTree(String token, String systemCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
