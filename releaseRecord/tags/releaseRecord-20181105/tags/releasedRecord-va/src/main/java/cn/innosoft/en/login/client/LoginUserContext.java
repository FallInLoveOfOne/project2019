/**
 * 
 */
package cn.innosoft.en.login.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;

import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientOrg;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientSystem;
import cn.innosoft.en.login.client.model.LoginSystem;
import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.security.SecurityLoginUser;
import cn.innosoft.en.login.client.service.LoginUserServer;
import cn.innosoft.fw.biz.GlobalContext;

/**
 * 登录用户上下文类.
 * 
 * @author huangwb
 * @date 2014-5-13 上午10:17:07
 */
public class LoginUserContext {

	private static LoginUserServer loginUserServer = (LoginUserServer) GlobalContext.getBean("loginUserServer");

	/**
	 * 把系统id转换为系统标志.
	 * 
	 * @param systemId
	 *            系统id
	 * @return 系统标志
	 */
	private static String convertSystemIdToCode(String systemId) {
		LoginUser user = getCurrentLoginUser();
		List<ClientSystem> systems = user.getAccessSystems();
		for (ClientSystem system : systems) {
			String id = system.getSystemId();
			if (id.equals(systemId)) {
				return system.getSystemCode();
			}
		}
		return null;
	}

	/**
	 * 获取当前登录用户系统信息.
	 * 
	 * @return 当前登录用户系统信息
	 */
	private static LoginSystem getCurrentLoginSystem() {
		return getCurrentLoginUser().getSystem();
	}

	public static String getCurrentLoginSystemId() {
		LoginUser user = getCurrentLoginUser();
		List<ClientSystem> list = user.getAccessSystems();
		if (list == null) {
			list = new ArrayList<ClientSystem>();
		}
		for (ClientSystem ele : list) {
			String systemCode = ele.getSystemCode();
			if (loginUserServer.getSystemId().equals(systemCode)) {
				return ele.getSystemId();
			}
		}
		return null;
	}

	/**
	 * 获取当前登录用户信息.
	 * 
	 * @return 当前登录用户信息
	 */
	public static LoginUser getCurrentLoginUser() {
		return ((SecurityLoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getLoginUser();
	}

	/**
	 * 获取当前登录用户id.
	 * 
	 * @return 登录用户id
	 */
	public static String getCurrentLoginUserId() {
		return getCurrentLoginUser().getUser().getUserId();
	}

	/**
	 * 获取当前登录用户token.
	 * 
	 * @return 登录用户token
	 */
	public static String getCurrentLoginUserToken() {
		return getCurrentLoginUser().getToken();
	}

	private static List<String> getUserCodes() {
		LoginSystem system = getCurrentLoginSystem();
		Map<String, List<ClientCode>> map = system.getGlobalCodes();
		List<String> ids = getUserCodesId(map);
		return ids;
	}

	public static List<String> getUserCodes(String systemId) {
		if (isLoginSystem(systemId)) {
			return getUserCodes();
		}
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		Map<String, List<ClientCode>> map = loginUserServer.getUserGlobalCodes(token, systemCode);
		List<String> ids = getUserCodesId(map);
		return ids;
	}

	private static List<String> getUserCodesId(Map<String, List<ClientCode>> map) {
		List<ClientCode> list = new ArrayList<ClientCode>();
		if (map == null) {
			map = new HashMap<String, List<ClientCode>>();
		}
		Set<String> set = map.keySet();
		for (String key : set) {
			list.addAll(map.get(key));
		}
		Set<String> ids = new HashSet<String>();
		for (ClientCode ele : list) {
			ids.add(ele.getCodeId());
		}
		List<String> retIds = new ArrayList<String>();
		retIds.addAll(ids);
		return retIds;
	}

	private static List<String> getUserCodesIndex() {
		LoginSystem system = getCurrentLoginSystem();
		Map<String, List<ClientCode>> map = system.getGlobalCodes();
		List<String> list = getUserCodesIndexId(map);
		return list;
	}

	public static List<String> getUserCodesIndex(String systemId) {
		if (isLoginSystem(systemId)) {
			return getUserCodesIndex();
		}
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		Map<String, List<ClientCode>> map = loginUserServer.getUserGlobalCodes(token, systemCode);
		List<String> list = getUserCodesIndexId(map);
		return list;
	}

	private static List<String> getUserCodesIndexId(Map<String, List<ClientCode>> map) {
		List<String> list = new ArrayList<String>();
		if (map == null) {
			map = new HashMap<String, List<ClientCode>>();
		}
		Set<String> set = map.keySet();
		list.addAll(set);
		return list;
	}

	/**
	 * 获取用户拥有本系统的组织机构信息id.
	 * 
	 * @return 组织机构id
	 */
	public static List<String> getUserOrgs() {
		LoginUser user = getCurrentLoginUser();
		Map<String, List<ClientOrg>> map = user.getSystem().getGlobalOrgs();
		List<ClientSystem> systems = user.getAccessSystems();
		Set<String> sets = new HashSet<String>();
		sets.addAll(getUserOrgsId(map));
		for (ClientSystem system : systems) {
			String systemId = system.getSystemId();
			if (!isLoginSystem(systemId)) {
				sets.addAll(getUserOrgs(systemId));
			}
		}
		List<String> ids = new ArrayList<String>();
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 获取用户拥有指定系统的组织机构信息id.
	 * 
	 * @return 组织机构id
	 */
	public static List<String> getUserOrgs(String systemId) {
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		Map<String, List<ClientOrg>> map = loginUserServer.getUserGlobalOrgs(token, systemCode);
		return getUserOrgsId(map);
	}

	/**
	 * 获取组织机构信息id.
	 * 
	 * @param list
	 *            组织机构信息集合
	 * @return 组织机构信息id集合
	 */
	private static List<String> getUserOrgsId(Map<String, List<ClientOrg>> map) {
		if (map == null) {
			map = new HashMap<String, List<ClientOrg>>();
		}
		List<ClientOrg> list = map.get(LoginSystem.ORG_CODE_KEY);
		if (list == null) {
			list = new ArrayList<ClientOrg>();
		}
		List<String> ids = new ArrayList<String>();
		Set<String> sets = new HashSet<String>();
		for (ClientOrg ele : list) {
			sets.add(ele.getoId());
		}
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 获取用户本系统能访问的资源id.
	 * 
	 * @return 资源id集合
	 */
	public static List<String> getUserResources() {
		LoginSystem system = getCurrentLoginSystem();
		List<ClientResource> list = system.getResources();
		List<String> ids = getUserResourcesId(list);
		return ids;
	}

	/**
	 * 获取用户本系统能访问的资源详细信息.
	 * 
	 * @return 资源详细信息集合
	 */
	private static List<ClientResource> getUserResourcesDetail() {
		LoginSystem system = getCurrentLoginSystem();
		return system.getResources();
	}

	/**
	 * 获取用户本指定系统能访问的资源id.
	 * 
	 * @return 资源集合
	 */
	public static List<String> getUserResources(String systemId) {
		if (isLoginSystem(systemId)) {
			return getUserResources();
		}
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		List<ClientResource> list = loginUserServer.getUserResources(token, systemCode);
		List<String> ids = getUserResourcesId(list);
		return ids;
	}

	/**
	 * 获取用户本指定系统能访问的资源id.
	 * 
	 * @return 资源详细信息集合
	 */
	public static List<ClientResource> getUserResourcesDetail(String systemId) {
		if (isLoginSystem(systemId)) {
			return getUserResourcesDetail();
		}
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		return loginUserServer.getUserResources(token, systemCode);
	}
	
	/**
	 * 获取用户本指定系统能访问的资源树.
	 * 
	 * @return 资源详细信息集合
	 */
	public static List<ClientResource> getUserResourcesTreeDetail(String systemCode) {
		String token = getCurrentLoginUserToken();
		return loginUserServer.getUserResourcesTree(token, systemCode);
	}
	
	/**
	 * 获取用户所属部门列表
	 * 
	 * @return 部门信息列表
	 */
	public static List<Map<String, Object>> getUserBelongOrgs() {
		LoginUser user = getCurrentLoginUser();
		String token = user.getToken();
		List<Map<String, Object>> list = loginUserServer.getUserBelongOrgs(token);
//		user.setBelongOrg(list);
		return list;
	}

	/**
	 * 获取资源id.
	 * 
	 * @param list
	 *            资源集合
	 * @return 资源id集合
	 */
	private static List<String> getUserResourcesId(List<ClientResource> list) {
		if (list == null) {
			list = new ArrayList<ClientResource>();
		}
		List<String> ids = new ArrayList<String>();
		Set<String> sets = new HashSet<String>();
		for (ClientResource ele : list) {
			sets.add(ele.getResId());
		}
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 获取登录用户本系统拥有的角色id.
	 * 
	 * @return 角色id集合
	 */
	private static List<String> getUserRoles() {
		LoginSystem system = getCurrentLoginSystem();
		List<ClientRole> list = system.getRoles();
		List<String> ids = getUserRolesId(list);
		return ids;
	}

	/**
	 * 获取登录用户指定系统系统拥有的角色id.
	 * 
	 * @return 角色id集合
	 */
	public static List<String> getUserRoles(String systemId) {
		if (isLoginSystem(systemId)) {
			return getUserRoles();
		}
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		List<ClientRole> list = loginUserServer.getUserRoles(token, systemCode);
		List<String> ids = getUserRolesId(list);
		return ids;
	}

	public static List<String> getUserAllSystemRoles() {
		List<String> ids = new ArrayList<String>();
		LoginUser user = getCurrentLoginUser();
		List<ClientSystem> systems = user.getAccessSystems();
		Set<String> sets = new HashSet<String>();
		for (ClientSystem system : systems) {
			String systemId = system.getSystemId();
			sets.addAll(getUserRoles(systemId));
		}
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 获取角色id.
	 * 
	 * @param list
	 *            角色集合
	 * @return 角色id集合
	 */
	private static List<String> getUserRolesId(List<ClientRole> list) {
		if (list == null) {
			list = new ArrayList<ClientRole>();
		}
		List<String> ids = new ArrayList<String>();
		Set<String> sets = new HashSet<String>();
		for (ClientRole ele : list) {
			sets.add(ele.getRoleId());
		}
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 获取用户拥有的系统id.
	 * 
	 * @return 系统id
	 */
	public static List<String> getUserSystem() {
		LoginUser user = getCurrentLoginUser();
		List<ClientSystem> list = user.getAccessSystems();
		if (list == null) {
			list = new ArrayList<ClientSystem>();
		}
		List<String> ids = new ArrayList<String>();
		Set<String> sets = new HashSet<String>();
		for (ClientSystem ele : list) {
			sets.add(ele.getSystemId());
		}
		ids.addAll(sets);
		return ids;
	}

	/**
	 * 是否为登录系统.
	 * 
	 * @param systemId
	 *            系统id
	 * @return 判断结果
	 */
	private static boolean isLoginSystem(String systemId) {
		String code = convertSystemIdToCode(systemId);
		if (code != null && code.equals(loginUserServer.getSystemId())) {
			return true;
		}
		return false;
	}

	/**
	 * 更新用户指定系统拥有的代码id.
	 * 
	 * @param systemId
	 *            系统id
	 */
	public static void updateUserCodes(String systemId) {
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		Map<String, List<ClientCode>> Global = loginUserServer.updateUserGlobalCodes(token, systemCode);
		Map<String, Map<String, List<ClientCode>>> Spec = loginUserServer.updateUserSpecCodes(token, systemCode);
		if (isLoginSystem(systemId)) {
			getCurrentLoginSystem().setGlobalCodes(Global);
			getCurrentLoginSystem().setSpecCodes(Spec);
		}
	}

	/**
	 * 更新用户拥有的组织机构信息id.
	 */
	public static void updateUserOrgs() {
		List<String> ids = getUserSystem();
		for (String systemId : ids) {
			updateUserOrgs(systemId);
		}
	}

	/**
	 * 更新用户拥有的组织机构信息id.
	 */
	public static void updateUserOrgs(String systemId) {
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		Map<String, List<ClientOrg>> Global = loginUserServer.updateUserGlobalOrgs(token, systemCode);
		Map<String, Map<String, List<ClientOrg>>> Spec = loginUserServer.updateUserSpecOrgs(token, systemCode);
		if (isLoginSystem(systemId)) {
			getCurrentLoginSystem().setGlobalOrgs(Global);
			getCurrentLoginSystem().setSpecOrgs(Spec);
		}
	}

	/**
	 * 更新用户本指定系统能访问的资源id.
	 * 
	 * @param systemId
	 *            系统id
	 */
	public static void updateUserResources(String systemId) {
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		List<ClientResource> list = loginUserServer.updateUserResources(token, systemCode);
		if (isLoginSystem(systemId)) {
			getCurrentLoginSystem().setResources(list);
		}
	}

	/**
	 * 更新用户指定系统系统拥有的角色id.
	 * 
	 * @param systemId
	 */
	public static void updateUserRoles(String systemId) {
		String token = getCurrentLoginUserToken();
		String systemCode = convertSystemIdToCode(systemId);
		List<ClientRole> list = loginUserServer.updateUserRoles(token, systemCode);
		if (isLoginSystem(systemId)) {
			getCurrentLoginSystem().setRoles(list);
		}
	}

	/**
	 * 更新用户指定系统系统拥有的角色id.
	 */
	public static void updateUserSystem() {
		LoginUser user = getCurrentLoginUser();
		String token = user.getToken();
		List<ClientSystem> list = loginUserServer.updateUserSystems(token);
		user.setAccessSystems(list);
	}
	
	/**
	 * 更新用户所属部门信息
	 */
	public static void updateUserBelongOrgs() {
		LoginUser user = getCurrentLoginUser();
		String token = user.getToken();
		List<ClientOrg> list = loginUserServer.updateUserBelongOrgs(token);
		user.setBelongOrg(list);
	}

}
