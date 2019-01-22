package cn.innosoft.en.login.client.persistent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cn.innosoft.en.login.client.OrmFwConfig;
import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientOrg;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientSystem;
import cn.innosoft.en.login.client.model.LoginSystem;
import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.util.loginUtil.JsonUtils;
import cn.innosoft.orm.api.server.IWsLoginUserServer;


public class WsLoginUserClient implements ILoinUserClient {

	private static volatile IWsLoginUserServer wsLoginUserServer;

	/**
	 * webservice 地址.
	 */
	private static String URL;

	/**
	 * webservice 服务名.
	 */
	private static QName SERVICE_NAME;

	static {
		URL = OrmFwConfig.getProValue("WsURL");
		SERVICE_NAME = new QName(OrmFwConfig.getProValue("WsNamespaceURI"), "IWsLoginUserServerService");
	}

	/**
	 * 获得Webservice接口
	 * 
	 * @return Webservice接口
	 * @throws MalformedURLException
	 */
	private static IWsLoginUserServer getValidatorService() throws MalformedURLException {
		if (wsLoginUserServer == null) {
			URL url = new URL(URL);
			Service service = Service.create(url, SERVICE_NAME);
			try {
			wsLoginUserServer = service.getPort(IWsLoginUserServer.class);
			} catch (Exception e) {	
				throw new MalformedURLException(e.getMessage());
			}
		}
		return wsLoginUserServer;
	}

	@Override	
	public LoginUser login(String userAcct, String userPwd, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.login(userAcct, userPwd, systemId);
		LoginUser loginUser = JsonUtils.parseJsonToObject(result, LoginUser.class);
		return loginUser;
	}

	@Override
	public LoginUser logout(String token) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.logout(token);
		LoginUser loginUser = JsonUtils.parseJsonToObject(result, LoginUser.class);
		return loginUser;
	}

	@Override
	public List<ClientRole> getUserRoles(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserRoles(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getRoles();
	}

	@Override
	public List<ClientResource> getUserResources(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserResources(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getResources();
	}

	@Override
	public Map<String, List<ClientCode>> getUserGlobalCodes(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserGlobalCodes(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getGlobalCodes();
	}

	@Override
	public Map<String, Map<String, List<ClientCode>>> getUserSpecCodes(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserSpecCodes(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getSpecCodes();
	}

	@Override
	public Map<String, List<ClientOrg>> getUserGlobalOrgs(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserGlobalOrgs(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getGlobalOrgs();
	}

	@Override
	public Map<String, Map<String, List<ClientOrg>>> getUserSpecOrgs(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserSpecOrgs(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getSpecOrgs();
	}

	@Override
	public List<Map<String, Object>> getUserBelongOrgs(String token) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserBelongOrgs(token);
		Map<String, Object> beLongOrg = JsonUtils.parseJsonToObject(result, Map.class);
		return  (List<Map<String, Object>>)beLongOrg.get("belongOrgs");
	}

	@Override
	public List<ClientSystem> getUserSystems(String token) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserSystems(token);
		LoginUser LoginUser = JsonUtils.parseJsonToObject(result, LoginUser.class);
		return LoginUser.getAccessSystems();
	}

	@Override
	public List<ClientRole> updateUserRoles(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserRoles(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getRoles();
	}

	@Override
	public List<ClientResource> updateUserResources(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserResources(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getResources();
	}

	@Override
	public Map<String, List<ClientCode>> updateUserGlobalCodes(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserGlobalCodes(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getGlobalCodes();
	}

	@Override
	public Map<String, Map<String, List<ClientCode>>> updateUserSpecCodes(String token, String systemId)
			throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserSpecCodes(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getSpecCodes();
	}

	@Override
	public Map<String, List<ClientOrg>> updateUserGlobalOrgs(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserGlobalOrgs(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getGlobalOrgs();
	}

	@Override
	public Map<String, Map<String, List<ClientOrg>>> updateUserSpecOrgs(String token, String systemId) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserSpecOrgs(token, systemId);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getSpecOrgs();
	}

	@Override
	public List<ClientOrg> updateUserBelongOrgs(String token) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserBelongOrgs(token);
		Map<String, Object> beLongOrg = JsonUtils.parseJsonToObject(result, Map.class);
		return (List<ClientOrg>) beLongOrg.get("belongOrgs");
	}

	@Override
	public List<ClientSystem> updateUserSystem(String token) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.updateUserSystem(token);
		result = result.replace("\"system\"", "\"accessSystems\"");
		LoginUser LoginUser = JsonUtils.parseJsonToObject(result, LoginUser.class);
		return LoginUser.getAccessSystems();
	}

	@Override
	public Map<String, List<ClientCode>> getSystemGlobalCode(String token, String systemCode) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getSystemGlobalCode(token, systemCode);
		result = result.replace("\"systemGlobalCode\"", "\"globalCodes\"");
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getGlobalCodes();
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
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserLoginInfo(token, systemCode);
		LoginUser loginUser = JsonUtils.parseJsonToObject(result, LoginUser.class);
		return loginUser;
	}

	@Override
	public List<ClientResource> getUserResourcesTree(String token, String systemCode) throws Exception {
		IWsLoginUserServer hw = getValidatorService();
		String result = hw.getUserResourcesTree(token, systemCode);
		LoginSystem loginSystem = JsonUtils.parseJsonToObject(result, LoginSystem.class);
		return loginSystem.getResources();
	}

}
