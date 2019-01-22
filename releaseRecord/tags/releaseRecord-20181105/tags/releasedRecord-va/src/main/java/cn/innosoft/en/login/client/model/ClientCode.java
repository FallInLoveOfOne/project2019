package cn.innosoft.en.login.client.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientCode  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2644928857330488717L;

	private String codeId;

	private String pCodeId;

	private String codeValue;

	private String codeSerial;

	private String codeNameCn;

	private String codeNameEn;

	private String codeIdxId;

	private String codeIdxSerial;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getpCodeId() {
		return pCodeId;
	}

	public void setpCodeId(String pCodeId) {
		this.pCodeId = pCodeId;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeSerial() {
		return codeSerial;
	}

	public void setCodeSerial(String codeSerial) {
		this.codeSerial = codeSerial;
	}

	public String getCodeNameCn() {
		return codeNameCn;
	}

	public void setCodeNameCn(String codeNameCn) {
		this.codeNameCn = codeNameCn;
	}

	public String getCodeNameEn() {
		return codeNameEn;
	}

	public void setCodeNameEn(String codeNameEn) {
		this.codeNameEn = codeNameEn;
	}

	public String getCodeIdxSerial() {
		return codeIdxSerial;
	}

	public void setCodeIdxSerial(String codeIdxSerial) {
		this.codeIdxSerial = codeIdxSerial;
	}

	public String getCodeIdxId() {
		return codeIdxId;
	}

	public void setCodeIdxId(String codeIdxId) {
		this.codeIdxId = codeIdxId;
	}

}