package cn.innosoft.en.releaseRecord.releaseManager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 出所节点记录表
 * The persistent class for the T_FCF_RECORD database table.
 * 
 */
@Entity
@Table(name="T_FCF_RECORD")
@NamedQuery(name="TFcfRecord.findAll", query="SELECT t FROM TFcfRecord t")
public class TFcfRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="CREATE_TIME")
	private String createTime;

	@Column(name="CREATE_USER_CODE")
	private String createUserCode;

	@Column(name="CREATE_USER_NAME")
	private String createUserName;

	@Column(name="DETOX_NAME")
	private String detoxName;

	@Column(name="DETOX_NUM")
	private String detoxNum;

	@Column(name="HAVE_EXCEP")
	private String haveExcep;

	private String item;

	@Column(name="NOW_STAGE")
	private String nowStage;

	@Column(name="UPDATE_TIME")
	private String updateTime;

	@Column(name="UPDATE_USER_CODE")
	private String updateUserCode;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;
	
	@Column(name="HISTORY_ID")
	private String historyId;

	public TFcfRecord() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserCode() {
		return this.createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getDetoxName() {
		return this.detoxName;
	}

	public void setDetoxName(String detoxName) {
		this.detoxName = detoxName;
	}

	public String getDetoxNum() {
		return this.detoxNum;
	}

	public void setDetoxNum(String detoxNum) {
		this.detoxNum = detoxNum;
	}

	public String getHaveExcep() {
		return this.haveExcep;
	}

	public void setHaveExcep(String haveExcep) {
		this.haveExcep = haveExcep;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNowStage() {
		return this.nowStage;
	}

	public void setNowStage(String nowStage) {
		this.nowStage = nowStage;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserCode() {
		return this.updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	
	public String getHistoryId() {
		return this.historyId;
	}
	
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

}