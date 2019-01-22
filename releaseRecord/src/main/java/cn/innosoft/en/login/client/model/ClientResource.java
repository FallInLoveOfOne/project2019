package cn.innosoft.en.login.client.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResource  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5457853899114406227L;

	private String resId;

	private String resSystemId;

	private String resUrl;

	private String resSerial;

	private String resNameCn;

	private String resNameEn;

	private String resType;

	private String pResId;

	private String rResId;
	
	private List<ClientResource> children;

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResSystemId() {
		return resSystemId;
	}

	public void setResSystemId(String resSystemId) {
		this.resSystemId = resSystemId;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public String getResSerial() {
		return resSerial;
	}

	public void setResSerial(String resSerial) {
		this.resSerial = resSerial;
	}

	public String getResNameCn() {
		return resNameCn;
	}

	public void setResNameCn(String resNameCn) {
		this.resNameCn = resNameCn;
	}

	public String getResNameEn() {
		return resNameEn;
	}

	public void setResNameEn(String resNameEn) {
		this.resNameEn = resNameEn;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getpResId() {
		return pResId;
	}

	public void setpResId(String pResId) {
		this.pResId = pResId;
	}

	public String getrResId() {
		return rResId;
	}

	public void setrResId(String rResId) {
		this.rResId = rResId;
	}

	public List<ClientResource> getChildren() {
		return children;
	}

	public void setChildren(List<ClientResource> children) {
		this.children = children;
	}

}