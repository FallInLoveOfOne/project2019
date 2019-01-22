package cn.innosoft.en.login.client.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginSystem  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5462342764236308768L;

	/**
	 * 系统标志
	 */
	private String systemCode;

	/**
	 * 用户拥有的角色合集
	 */
	private List<ClientRole> roles;

	/**
	 * 用户拥有的资源合集
	 */
	private List<ClientResource> resources;

	/**
	 * 用户拥有的全局代码合集
	 */
	private Map<String, List<ClientCode>> globalCodes;

	/**
	 * 用户拥有的个性化代码合集
	 */
	private Map<String, Map<String, List<ClientCode>>> specCodes;

	/**
	 * 用户拥有的全局组织机构合集
	 */
	private Map<String, List<ClientOrg>> globalOrgs;

	/**
	 * 用户拥有的个性化组织机构合集
	 */
	private Map<String, Map<String, List<ClientOrg>>> specOrgs;

	/**
	 * 组织机构代码集合中key值
	 */
	public static final String ORG_CODE_KEY = "orgCode";

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public List<ClientRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ClientRole> roles) {
		this.roles = roles;
	}

	public List<ClientResource> getResources() {
		return resources;
	}

	public void setResources(List<ClientResource> resources) {
		this.resources = resources;
	}

	public Map<String, List<ClientCode>> getGlobalCodes() {
		return globalCodes;
	}

	public void setGlobalCodes(Map<String, List<ClientCode>> globalCodes) {
		this.globalCodes = globalCodes;
	}

	public Map<String, Map<String, List<ClientCode>>> getSpecCodes() {
		return specCodes;
	}

	public void setSpecCodes(Map<String, Map<String, List<ClientCode>>> specCodes) {
		this.specCodes = specCodes;
	}

	public Map<String, List<ClientOrg>> getGlobalOrgs() {
		return globalOrgs;
	}

	public void setGlobalOrgs(Map<String, List<ClientOrg>> globalOrgs) {
		this.globalOrgs = globalOrgs;
	}

	public Map<String, Map<String, List<ClientOrg>>> getSpecOrgs() {
		return specOrgs;
	}

	public void setSpecOrgs(Map<String, Map<String, List<ClientOrg>>> specOrgs) {
		this.specOrgs = specOrgs;
	}

}