package cn.innosoft.orm.api.server;

import javax.jws.WebService;


/**
 * webService方式server层接口类.
 * 
 * @author yangml
 * @date 2014-5-9 下午4:02:55
 */
@WebService
public interface IWsLoginUserServer {

	/**
	 * 用户登录，返回登录结果.
	 * 
	 * @param userAcct
	 *            用户账号
	 * @param userPwd
	 *            用户密码
	 * @param systemCode
	 *            系统标识
	 * @return 登录结果，包括用户令牌，用户信息，角色，资源，全局及特定组织，全局及特定代码
	 */
	String login(String userAcct, String userPwd, String systemCode);

	/**
	 * 退出.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 退出信息
	 */
	String logout(String token);

	/**
	 * 退出.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 退出信息
	 */
	String logout2(String token, String systemCode);

	/**
	 * 根据权限令牌及系统标识获取用户登录信息
	 * 
	 * @param token令牌
	 * @param systemCode
	 *            系统标识
	 * @return 登录结果，包括用户令牌，用户信息，可访问系统，角色，资源，全局及特定组织，全局及特定代码
	 */
	String getUserLoginInfo(String token, String systemCode);

	/**
	 * 获取登录用户在某个系统中拥有的角色列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 角色列表
	 */
	String getUserRoles(String token, String systemCode);

	/**
	 * 获取用户在某个系统中能访问的资源列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 资源列表
	 */
	String getUserResources(String token, String systemCode);

	/**
	 * 获取用户在某个系统中拥有的全局代码列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 代码列表
	 */
	String getUserGlobalCodes(String token, String systemCode);

	/**
	 * 获取用户在某个系统中拥有的特定代码列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 代码列表
	 */
	String getUserSpecCodes(String token, String systemCode);

	/**
	 * 获取用户在某个系统中拥有的全局组织机构信息列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 * @return 组织机构列表
	 */
	String getUserGlobalOrgs(String token, String systemCode);

	/**
	 * 获取用户在某个系统中拥有的特定组织机构信息列表
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 组织机构列表
	 */
	String getUserSpecOrgs(String token, String systemCode);

	/**
	 * 获取用户可访问系统列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 可访问系统列表
	 */
	String getUserSystems(String token);

	/**
	 * 获取用户在某个系统中拥有的全局代码.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 系统全局代码
	 */
	String getSystemGlobalCode(String token, String systemCode);

	/**
	 * 获取指定用户信息
	 * 
	 * @param token
	 *            令牌
	 * @param userAcct
	 *            用户账号
	 * @return 用户信息
	 */
	String getSpecUser(String token, String userAcct);

	/**
	 * 获取用户登录状态
	 * 
	 * @param token
	 * @return
	 */
	String getUserLoginStatus(String token);
	
	/**
	 * 获取用户所属部门列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 用户所属部门列表
	 */
	String getUserBelongOrgs(String token);
	
	/**
	 * 更新登录用户在某个系统中拥有的角色列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 角色列表
	 */
	String updateUserRoles(String token, String systemCode);

	/**
	 * 更新用户在某个系统中能访问的资源列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 资源列表
	 */
	String updateUserResources(String token, String systemCode);

	/**
	 * 更新用户在某个系统中拥有的全局代码列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 代码列表
	 */
	String updateUserGlobalCodes(String token, String systemCode);

	/**
	 * 更新用户在某个系统中拥有的特定代码列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 代码列表
	 */
	String updateUserSpecCodes(String token, String systemCode);

	/**
	 * 更新用户在某个系统中拥有的全局组织机构信息列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 组织机构列表
	 */
	String updateUserGlobalOrgs(String token, String systemCode);

	/**
	 * 更新用户在某个系统中拥有的特定组织机构信息列表.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 组织机构列表
	 */
	String updateUserSpecOrgs(String token, String systemCode);

	/**
	 * 更新用户可访问系统列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 可访问系统列表
	 */
	String updateUserSystem(String token);

	/**
	 * 更新用户在某个系统中拥有的全局代码.
	 * 
	 * @param token
	 *            令牌
	 * @param systemCode
	 *            系统标识
	 * @return 系统全局代码
	 */
	String updateSystemGlobalCode(String token, String systemCode);

	/**
	 * 更新指定用户信息（不支持修改所属组织机构）.
	 * 
	 * @param token
	 *            令牌
	 * @param usre
	 *            用户信息
	 * @return 更新结果
	 */
	String updateSpecUser(String token, String user);
	
	/**
	 * 更新用户所属部门列表.
	 * 
	 * @param token
	 *            令牌
	 * @return 用户所属部门列表
	 */
	String updateUserBelongOrgs(String token);

	String getUserResourcesTree(String token, String systemCode);
}
