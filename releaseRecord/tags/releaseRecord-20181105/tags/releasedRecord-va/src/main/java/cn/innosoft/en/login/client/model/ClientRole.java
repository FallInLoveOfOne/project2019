package cn.innosoft.en.login.client.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientRole  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2396085688044552821L;

	private String roleId;

	private String roleSystemId;

	private String roleNegativeFlag;

	private String roleSerial;

	private String roleNameCn;

	private String roleNameEn;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleSystemId() {
		return roleSystemId;
	}

	public void setRoleSystemId(String roleSystemId) {
		this.roleSystemId = roleSystemId;
	}

	public String getRoleNegativeFlag() {
		return roleNegativeFlag;
	}

	public void setRoleNegativeFlag(String roleNegativeFlag) {
		this.roleNegativeFlag = roleNegativeFlag;
	}

	public String getRoleSerial() {
		return roleSerial;
	}

	public void setRoleSerial(String roleSerial) {
		this.roleSerial = roleSerial;
	}

	public String getRoleNameCn() {
		return roleNameCn;
	}

	public void setRoleNameCn(String roleNameCn) {
		this.roleNameCn = roleNameCn;
	}

	public String getRoleNameEn() {
		return roleNameEn;
	}

	public void setRoleNameEn(String roleNameEn) {
		this.roleNameEn = roleNameEn;
	}

}