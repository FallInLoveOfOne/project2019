package cn.innosoft.en.login.client.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientUser  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1950691688516411292L;

	private String userId;

	private String userAcct;

	private String userAcctCn;

	private String pwd;

	private String userSex;

	private String userBirth;

	private String userEmail;

	private String userMobile;

	private String userTel;

	private String oSerial;

	private List<Map<String, Object>> iSerial; //用户所属机构

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAcct() {
		return userAcct;
	}

	public void setUserAcct(String userAcct) {
		this.userAcct = userAcct;
	}

	public String getUserAcctCn() {
		return userAcctCn;
	}

	public void setUserAcctCn(String userAcctCn) {
		this.userAcctCn = userAcctCn;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getoSerial() {
		return oSerial;
	}

	public void setoSerial(String oSerial) {
		this.oSerial = oSerial;
	}

	public List<Map<String, Object>> getiSerial() {
		return iSerial;
	}

	public void setiSerial(List<Map<String, Object>> iSerial) {
		this.iSerial = iSerial;
	}

	
}