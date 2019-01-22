package cn.innosoft.en.releaseRecord.releaseManager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the T_SYS_ACC database table.
 * 
 */
@Entity
@Table(name="T_SYS_ACC")
@NamedQuery(name="TSysAcc.findAll", query="SELECT t FROM TSysAcc t")
public class TSysAcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACC_ID")
	private String accId;

	@Column(name="ACC_FILE_NAME")
	private String accFileName;

	@Column(name="ACC_FILE_SIZE")
	private BigDecimal accFileSize;

	@Column(name="ACC_STORAGE_NAME")
	private String accStorageName;

	@Column(name="ACC_STORAGE_PATH")
	private String accStoragePath;

	@Column(name="ACC_SUFFIX_NAME")
	private String accSuffixName;

	@Column(name="ACC_TYPE")
	private String accType;

	@Column(name="BUSINESS_ID")
	private String businessId;

	@Column(name="CREATE_DT")
	private String createDt;

	@Column(name="CREATE_USER_ACCT")
	private String createUserAcct;

	@Column(name="CREATE_USER_ID")
	private String createUserId;

	@Column(name="CREATE_USER_NAME")
	private String createUserName;

	@Column(name="UPDATE_DT")
	private String updateDt;

	@Column(name="UPDATE_USER_ACCT")
	private String updateUserAcct;

	@Column(name="UPDATE_USER_ID")
	private String updateUserId;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	@Column(name="VALID_SIGN")
	private String validSign;

	public TSysAcc() {
	}

	public String getAccId() {
		return this.accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccFileName() {
		return this.accFileName;
	}

	public void setAccFileName(String accFileName) {
		this.accFileName = accFileName;
	}

	public BigDecimal getAccFileSize() {
		return this.accFileSize;
	}

	public void setAccFileSize(BigDecimal accFileSize) {
		this.accFileSize = accFileSize;
	}

	public String getAccStorageName() {
		return this.accStorageName;
	}

	public void setAccStorageName(String accStorageName) {
		this.accStorageName = accStorageName;
	}

	public String getAccStoragePath() {
		return this.accStoragePath;
	}

	public void setAccStoragePath(String accStoragePath) {
		this.accStoragePath = accStoragePath;
	}

	public String getAccSuffixName() {
		return this.accSuffixName;
	}

	public void setAccSuffixName(String accSuffixName) {
		this.accSuffixName = accSuffixName;
	}

	public String getAccType() {
		return this.accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getCreateUserAcct() {
		return this.createUserAcct;
	}

	public void setCreateUserAcct(String createUserAcct) {
		this.createUserAcct = createUserAcct;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getUpdateUserAcct() {
		return this.updateUserAcct;
	}

	public void setUpdateUserAcct(String updateUserAcct) {
		this.updateUserAcct = updateUserAcct;
	}

	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getValidSign() {
		return this.validSign;
	}

	public void setValidSign(String validSign) {
		this.validSign = validSign;
	}

}