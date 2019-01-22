package cn.innosoft.en.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import cn.innosoft.en.login.client.LoginUserContext;
import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.ClientResource;
import cn.innosoft.en.login.client.model.ClientRole;
import cn.innosoft.en.login.client.model.ClientUser;
import cn.innosoft.en.login.client.model.LoginUser;
import cn.innosoft.en.login.client.security.SecurityLoginUser;
import cn.innosoft.en.login.client.service.LoginUserServer;
import cn.innosoft.fw.biz.GlobalContext;

public class OrmHelper {

	private static LoginUserServer loginUserServer = null;

	static {
		loginUserServer = (LoginUserServer) GlobalContext.getBean("loginUserServer");
	}

	/**
	 * 获取security托管的用户对象
	 * 
	 * @return
	 */
	public static SecurityLoginUser getSecurityLoginUser() {
		return (SecurityLoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	/**
	 * 获取当前登录完整用户（包含权限）.
	 * 
	 * @return
	 */
	private static LoginUser getLoginUser() {
		return getSecurityLoginUser().getLoginUser();
	}

	/**
	 * 获取系统标识
	 * 
	 * @return
	 */
	private static String getSystemCode() {
		String systemCode = loginUserServer.getSystemId();
		return systemCode;
	}

	/**
	 * 获取登录用户的token
	 * 
	 * @return
	 */
	public static String getToken() {
		LoginUser loginUser = ((SecurityLoginUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal()).getLoginUser();
		return loginUser.getToken();
	}

	/**
	 * 获取用户资源（资源平铺）
	 * 
	 * @return
	 */
	public static List<ClientResource> getResource() {
		return loginUserServer.getUserResources(getToken(), getSystemCode());
	}

	/**
	 * 获取用户资源（资源树）
	 * 
	 * @return
	 */
	public static List<ClientResource> getResourceTree() {
		return loginUserServer.getUserResourcesTree(getToken(), getSystemCode());
	}

	/**
	 * 获取当前用户信息.
	 * 
	 * @return
	 */
	public static ClientUser getCurrentUser() {
		return getLoginUser().getUser();
	}

	/**
	 * 获取当前登录用户的id.
	 * 
	 * @return
	 */
	public static String getCurrentUserId() {
		return LoginUserContext.getCurrentLoginUserId();
	}

	/**
	 * 获取当前登录用户的账号.
	 * 
	 * @return
	 */
	public static String getCurrentUserAcct() {
		return getCurrentUser().getUserAcct();
	}

	/**
	 * 获取当前登录用户的名称.
	 * 
	 * @return
	 */
	public static String getCurrentUserName() {
		return getCurrentUser().getUserAcctCn();
	}

	/**
	 * 获取用户ID
	 * 
	 * @return
	 */
	public static String getUserId() {
		LoginUser loginUser = getLoginUser();
		ClientUser user = loginUser.getUser();
		return user.getUserId();
	}

	private static List<String> getCode(String codeIndexId) throws Exception {
		Map<String, List<ClientCode>> codesInd = getLoginUser().getSystem().getGlobalCodes();
		return getCode(codeIndexId, codesInd);
	}

	private static List<String> getCode(String codeIndexId, Map<String, List<ClientCode>> codesInd) throws Exception {
		List<ClientCode> fcodes = codesInd.get(codeIndexId);
		List<String> codes = new ArrayList<String>();
		if (fcodes == null || fcodes.size() == 0) {
			String msg = "用户【" + getCurrentUserAcct() + "】没有授予'" + codeIndexId + "'代码权限";
			throw new Exception(msg);
		}
		for (ClientCode code : fcodes) {
			String value = code.getCodeValue();
			codes.add(value);
		}
		return codes;
	}

	/**
	 * 获取用户的领域代码权限集合
	 * 
	 * @return
	 */
	public static List<String> getDepCodeList() {
		String codeIndexId = getSystemCode() + "_DEP";
		List<String> codes = new ArrayList<String>();
		try {
			codes = getCode(codeIndexId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codes;
	}

	/**
	 * 获取用户的领域代码权限
	 * 
	 * @return
	 */
	public static String getDepCode() {
		List<String> codes = getDepCodeList();
		String val = "";
		for (int i = 0; i < codes.size(); i++) {
			String code = codes.get(i);
			if (i == 0) {
				val += code;
			} else {
				val += "," + code;
			}
		}
		return val;
	}

	/**
	 * 获取当前用户所拥有的地域代码权限集合
	 * 
	 * @return
	 */
	public static List<String> getAreaCodeList() {
		String codeIndexId = getSystemCode() + "_AREA";
		List<String> codes = new ArrayList<String>();
		try {
			codes = getCode(codeIndexId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codes;
	}

	/**
	 * 获取当前用户所拥有的地域代码权限集合，登陆校验的时候使用，需要传入用户的全局代码
	 * 
	 * @param codesInd
	 * @return
	 */
	public static List<String> getAreaCodeList(Map<String, List<ClientCode>> codesInd) {
		String codeIndexId = getSystemCode() + "_AREA";
		List<String> codes = new ArrayList<String>();
		try {
			codes = getCode(codeIndexId, codesInd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return codes;
	}

	/************************************* 新增处理函数 *****************************************/

	/**
	 * 获取用户角色：省牵头（PR-QT）、省发改（PR-FG）、市发改(CI-FG)、县发改(CO-FG)
	 * 
	 * @return
	 */
	public static String getUserRole() {
		String userType = getUserType(); 
		if("ZG_ROLE_CK".equals(userType)){
			return "PR-CK";//查看人员角色自定义标识
		}
		String areaCode = getAreaArray();
		 String userRole = "CO-FG";
		 if(areaCode.contains("330000")){
			 userRole = "PR-FG";
		 }else if(areaCode.contains("339900")){
			 userRole = "PR-QT";
		 }else{
			 String[] codeArray = areaCode.split(",");
			 for(String ondeCode : codeArray ){
				 String flag = ondeCode.substring(4);
				 if("00".equals(flag)||"01".equals(flag)){
					 userRole = "CI-FG";
				 }else{
					 userRole = "CO-FG";
				 }
			 }
		 }
		return userRole;
		//return "PR-FG";//测试-----------县发改用户
	}
	
	//判断权限使用
	public static String getAreaArray() {
		List<String> areaList = getAreaCodeList();
		String area = "";
		if(areaList.size()>0){
			for(String one : areaList){
				area = area+one+",";
			}
			area = area.substring(0, area.length()-1);
		}
		return area;
		//return "339900";//测试-----------县发改用户
	}
	
	public static String getArea() {
		List<String> areaList = getAreaCodeList();
		String area = "";
		if(areaList.size()>0){
			for(String one : areaList){
				area = area+one+",";
			}
			area = area.substring(0, area.length()-1);
		}
		if(area.contains("330000")||area.contains("339900")){
			area = "339900";
		}
		return area;
		//return "339900";//测试-----------县发改用户
	}
	
	public static String getDep() {
		return getDepCode();
		//return "FO";//测试--------省牵头单领域
	}
	
	/**
	 * 获取人员类型（关键用户处理查看人员权限）
	 * @return
	 */
	public static String getUserType() {
		String userType = "SH";
		Map<String, List<ClientCode>> clientMap =  getLoginUser().getSystem().getGlobalCodes();
		List<ClientCode> typeList =  clientMap.get("ZG_ROLE_TYPE");
		if(null!=typeList){
			if(typeList.size()>0){
				ClientCode clientCode = typeList.get(0);
				userType = null!=clientCode?clientCode.getCodeValue():"SH";
			}
		}
		return userType;
	}
	
	/**
	 * 获取当前登录用户角色
	 * @return
	 */
	public static String getLoginRole() {
		StringBuilder roles = new StringBuilder("");
		List<ClientRole> roleList = loginUserServer.getUserRoles(getToken(), getSystemCode());
//		List<ClientRole> roles = getLoginUser().getSystem().getRoles();
		if(null!=roleList){
			if(roleList.size()>0){
				for(ClientRole role : roleList){
					roles.append(role.getRoleNameEn()).append(",");
				}
			}
		}
		System.out.println("当前用户角色:"+roles.toString());
		return roles.toString();
	}
}
