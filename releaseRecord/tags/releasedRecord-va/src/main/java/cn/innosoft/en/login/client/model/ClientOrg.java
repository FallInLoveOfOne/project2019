package cn.innosoft.en.login.client.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientOrg  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5076656297036655439L;

	private String oId;

	private String rOid;

	private String pOid;

	private String oType;

	private String oSerival;

	private String oDisplayOrder;

	private String oName;

	private String oPhone;

	private String oEmail;

	private String oAddress;

	private String oPostcode;

	private String institutionCode;

	private String tempSign;

	private String oNameShort;

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getrOid() {
		return rOid;
	}

	public void setrOid(String rOid) {
		this.rOid = rOid;
	}

	public String getpOid() {
		return pOid;
	}

	public void setpOid(String pOid) {
		this.pOid = pOid;
	}

	public String getoType() {
		return oType;
	}

	public void setoType(String oType) {
		this.oType = oType;
	}

	public String getoSerival() {
		return oSerival;
	}

	public void setoSerival(String oSerival) {
		this.oSerival = oSerival;
	}

	public String getoDisplayOrder() {
		return oDisplayOrder;
	}

	public void setoDisplayOrder(String oDisplayOrder) {
		this.oDisplayOrder = oDisplayOrder;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoPhone() {
		return oPhone;
	}

	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}

	public String getoEmail() {
		return oEmail;
	}

	public void setoEmail(String oEmail) {
		this.oEmail = oEmail;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getoPostcode() {
		return oPostcode;
	}

	public void setoPostcode(String oPostcode) {
		this.oPostcode = oPostcode;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getTempSign() {
		return tempSign;
	}

	public void setTempSign(String tempSign) {
		this.tempSign = tempSign;
	}

	public String getoNameShort() {
		return oNameShort;
	}

	public void setoNameShort(String oNameShort) {
		this.oNameShort = oNameShort;
	}

}