package cn.innosoft.en.releaseRecord.releaseManager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_OUT_HISTORY database table.
 * 
 */
@Entity
@Table(name="T_OUT_HISTORY")
@NamedQuery(name="TOutHistory.findAll", query="SELECT t FROM TOutHistory t")
public class TOutHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OUT_HISTORY_ID")
	private String outHistoryId;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_USER_NAME")
	private String createUserName;

	@Column(name="OUT_PERSON_NAME")
	private String outPersonName;

	@Column(name="OUT_PERSON_NUMBER")
	private String outPersonNumber;

	@Column(name="OUT_PLACE")
	private String outPlace;

	@Column(name="OUT_REASON")
	private String outReason;

	@Column(name="OUT_RECORD")
	private String outRecord;

	@Column(name="OUT_TIME")
	private String outTime;

	@Column(name="OUT_TYPE")
	private String outType;

	@Column(name="OUT_TYPE_VAL")
	private String outTypeVal;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	public TOutHistory() {
	}

	public String getOutHistoryId() {
		return this.outHistoryId;
	}

	public void setOutHistoryId(String outHistoryId) {
		this.outHistoryId = outHistoryId;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getOutPersonName() {
		return this.outPersonName;
	}

	public void setOutPersonName(String outPersonName) {
		this.outPersonName = outPersonName;
	}

	public String getOutPersonNumber() {
		return this.outPersonNumber;
	}

	public void setOutPersonNumber(String outPersonNumber) {
		this.outPersonNumber = outPersonNumber;
	}

	public String getOutPlace() {
		return this.outPlace;
	}

	public void setOutPlace(String outPlace) {
		this.outPlace = outPlace;
	}

	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getOutRecord() {
		return this.outRecord;
	}

	public void setOutRecord(String outRecord) {
		this.outRecord = outRecord;
	}

	public String getOutTime() {
		return this.outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getOutType() {
		return this.outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public String getOutTypeVal() {
		return this.outTypeVal;
	}

	public void setOutTypeVal(String outTypeVal) {
		this.outTypeVal = outTypeVal;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

}