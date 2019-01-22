package cn.innosoft.en.login.client.persistent;

import java.util.List;
import java.util.Map;

import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientOrg;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientSystem;
import cn.innosoft.en.login.client.model.LoginUser;



public interface ILoinUserClient {

	/**
	 * 用户登录，返回登录结果.
	 * 
	 * @param userAcct
	 *            用户账号
	 * @param userPwd
	 *            用户密码
	 * @param systemId
	 *            系统Id
	 * @return 登录结果，包括用户令牌，用户信息，角色，资源，全局及特定组织，全局及特定代码
	 */
	public LoginUser login(String userAcct, String userPwd, String systemId) throws Exception;

	/**
	 * 退出.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 退出信息
	 */
	public LoginUser logout(String token) throws Exception;

	/**
	 * 获取登录用户在某个系统中拥有的角色列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 角色列表
	 */
	public List<ClientRole> getUserRoles(String token, String systemId) throws Exception;

	/**
	 * 获取用户在某个系统中能访问的资源列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 资源列表
	 */
	public List<ClientResource> getUserResources(String token, String systemId) throws Exception;

	/**
	 * 获取用户在某个系统中拥有的全局代码列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 代码列表
	 */
	public Map<String, List<ClientCode>> getUserGlobalCodes(String token, String systemId) throws Exception;

	/**
	 * 获取用户在某个系统中拥有的特定代码列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 代码列表
	 */
	public Map<String, Map<String, List<ClientCode>>> getUserSpecCodes(String token, String systemId) throws Exception;

	/**
	 * 获取用户在某个系统中拥有的全局组织机构信息列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 * @return 组织机构列表
	 */
	public Map<String, List<ClientOrg>> getUserGlobalOrgs(String token, String systemId) throws Exception;

	/**
	 * 获取用户在某个系统中拥有的特定组织机构信息列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 * @return 组织机构列表
	 */
	public Map<String, Map<String, List<ClientOrg>>> getUserSpecOrgs(String token, String systemId) throws Exception;

	/**
	 * 获取用户所属部门信息列表
	 * 
	 * @param token
	 *            令牌
	 * @return 部门列表
	 */
	public List<Map<String, Object>> getUserBelongOrgs(String token) throws Exception;
	
	/**
	 * 获取用户可访问系统列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 可访问系统列表
	 */
	public List<ClientSystem> getUserSystems(String token) throws Exception;

	/**
	 * 更新登录用户在某个系统中拥有的角色列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 角色列表
	 */
	public List<ClientRole> updateUserRoles(String token, String systemId) throws Exception;

	/**
	 * 更新用户在某个系统中能访问的资源列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 资源列表
	 */
	public List<ClientResource> updateUserResources(String token, String systemId) throws Exception;

	/**
	 * 更新用户在某个系统中拥有的全局代码列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 代码列表
	 */
	public Map<String, List<ClientCode>> updateUserGlobalCodes(String token, String systemId) throws Exception;

	/**
	 * 更新用户在某个系统中拥有的特定代码列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 代码列表
	 */
	public Map<String, Map<String, List<ClientCode>>> updateUserSpecCodes(String token, String systemId)
			throws Exception;

	/**
	 * 更新用户在某个系统中拥有的全局组织机构信息列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 组织机构列表
	 */
	public Map<String, List<ClientOrg>> updateUserGlobalOrgs(String token, String systemId) throws Exception;

	/**
	 * 更新用户在某个系统中拥有的特定组织机构信息列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemId
	 *            系统id
	 * @return 组织机构列表
	 */
	public Map<String, Map<String, List<ClientOrg>>> updateUserSpecOrgs(String token, String systemId) throws Exception;

	/**
	 * 更新用户可访问系统列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 可访问系统列表
	 */
	public List<ClientSystem> updateUserSystem(String token) throws Exception;

	/**
	 * 更新用户所属部门信息列表
	 * 
	 * @param token
	 *            令牌
	 * @return 部门列表
	 */
	public List<ClientOrg> updateUserBelongOrgs(String token) throws Exception;

	public Map<String, List<ClientCode>> getSystemGlobalCode(String token, String systemCode) throws Exception;

	/**
	 * 获取登录用户在在一个系统中的所有信息.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 用户信息
	 */
	public LoginUser getUserLoginInfo(String token, String systemCode) throws Exception;
	
	List<ClientResource> getUserResourcesTree(String token, String systemCode) throws Exception;

}
