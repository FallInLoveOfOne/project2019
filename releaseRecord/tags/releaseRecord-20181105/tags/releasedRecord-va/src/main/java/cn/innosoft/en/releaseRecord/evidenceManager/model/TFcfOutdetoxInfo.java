package cn.innosoft.en.releaseRecord.evidenceManager.model;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the T_FCF_OUTDETOX_INFO database table.
 * 
 */
@Entity
@Table(name="T_FCF_OUTDETOX_INFO")
@NamedQuery(name="TFcfOutdetoxInfo.findAll", query="SELECT t FROM TFcfOutdetoxInfo t")
public class TFcfOutdetoxInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ALREADY_OUT")
	private String alreadyOut;

	@Column(name="BASE_COFIRM_STA")
	private String baseCofirmSta;

	private String birth;

	private String brief;

	@Column(name="COME_DATE")
	private String comeDate;

	@Column(name="COME_REASON")
	private String comeReason;

	@Column(name="COME_RESON_VALUE")
	private String comeResonValue;

	@Column(name="DETOX_BEGIN")
	private String detoxBegin;

	@Column(name="DETOX_END")
	private String detoxEnd;

	@Column(name="DETOX_LIMIT")
	private String detoxLimit;

	@Column(name="DETOX_LIMIT_VALUE")
	private String detoxLimitValue;

	@Column(name="DORM_CODE")
	private String dormCode;

	private String education;

	@Column(name="EDUCATION_VALUE")
	private String educationValue;

	@Column(name="EMPHASIS_PERSONER")
	private String emphasisPersoner;

	@Column(name="EMPHASIS_PERSONER_VALUE")
	private String emphasisPersonerValue;

	@Column(name="ETHNIC_GROUP")
	private String ethnicGroup;

	@Column(name="ETHNIC_GROUP_VALUE")
	private String ethnicGroupValue;

	@Column(name="\"EXCEPTION\"")
	private String exception;

	@Column(name="HOLD_BEGIN")
	private String holdBegin;

	@Column(name="HOLD_DAY")
	private String holdDay;

	@Column(name="HOLD_END")
	private String holdEnd;

	@Column(name="HOUSE_ADDR")
	private String houseAddr;

	@Column(name="HOUSE_ADDR_VALUE")
	private String houseAddrValue;

	@Column(name="HOUSE_DETAIL_ADDR")
	private String houseDetailAddr;

	@Column(name="\"IDENTITY\"")
	private String identity;

	@Column(name="IDENTITY_ID")
	private String identityId;

	@Column(name="IDENTITY_TYPE")
	private String identityType;

	@Column(name="IDENTITY_TYPE_VALUE")
	private String identityTypeValue;

	@Column(name="IDENTITY_VALUE")
	private String identityValue;

	@Column(name="KS_USER_ID")
	private String ksUserId;

	@Column(name="MANAGE_TYPE")
	private String manageType;

	@Column(name="MANAGE_TYPE_VALUE")
	private String manageTypeValue;

	private String marriage;

	@Column(name="MARRIAGE_VALUE")
	private String marriageValue;

	private String name;

	private String nationality;

	@Column(name="NATIONALITY_VALUE")
	private String nationalityValue;
	
	@Id
	@Column(name="\"NUMBER\"")
	private String number;

	private String origin;

	@Column(name="ORIGIN_VALUE")
	private String originValue;

	@Column(name="OTHER_NAME")
	private String otherName;

	@Column(name="OUT_DATE")
	private String outDate;

	@Column(name="OUT_DOC_STATE")
	private String outDocState;

	@Column(name="OUT_DOC_TIME")
	private String outDocTime;

	@Column(name="OUT_PLACE_VALUE")
	private String outPlaceValue;

	@Column(name="OUT_REASON")
	private String outReason;

	@Column(name="OUT_REASON_VALUE")
	private String outReasonValue;

	@Column(name="OUT_TYPE")
	private String outType;

	@Column(name="OUT_TYPE_VALUE")
	private String outTypeValue;

	@Lob
	@Column(name="PICTURE_BYTE")
	private byte[] pictureByte;

	@Column(name="PICTURE_STATE")
	private String pictureState;

	@Column(name="PICTURE_TIME")
	private String pictureTime;

	@Column(name="POLITICAL_STATUS")
	private String politicalStatus;

	@Column(name="POLITICAL_STATUS_VALUE")
	private String politicalStatusValue;

	@Column(name="\"POSITION\"")
	private String position;

	@Column(name="PROCESS_STATE")
	private String processState;

	@Column(name="PROCESS_TIME")
	private String processTime;

	private String sex;

	@Column(name="SEX_VALUE")
	private String sexValue;

	@Column(name="SPECIAL_INDENTITY")
	private String specialIndentity;

	@Column(name="SPECIAL_INDENTITY_VALUE")
	private String specialIndentityValue;

	private String specialty;

	@Column(name="SPECIALTY_VALUE")
	private String specialtyValue;

	@Lob
	@Column(name="SUCCESS_PHOTO")
	private byte[] successPhoto;

	@Column(name="TRUE_OUT_DATA")
	private String trueOutData;

	@Column(name="UPDATE_TIME")
	private String updateTime;

	@Column(name="\"WORK\"")
	private String work;

	@Column(name="WORK_ADDR")
	private String workAddr;

	@Column(name="WORK_VALUE")
	private String workValue;
	
	@Column(name="IMPRISON_LIMIT")
	private String imprisonLimit;

	@Column(name="HISTORY_ID")
	private String history_id;

	public String getHistory_id() {
		return history_id;
	}

	public void setHistory_id(String history_id) {
		this.history_id = history_id;
	}
	
	public String getImprisonLimit() {
		return imprisonLimit;
	}

	public void setImprisonLimit(String imprisonLimit) {
		this.imprisonLimit = imprisonLimit;
	}

	public TFcfOutdetoxInfo() {
	}

	public String getAlreadyOut() {
		return this.alreadyOut;
	}

	public void setAlreadyOut(String alreadyOut) {
		this.alreadyOut = alreadyOut;
	}

	public String getBaseCofirmSta() {
		return this.baseCofirmSta;
	}

	public void setBaseCofirmSta(String baseCofirmSta) {
		this.baseCofirmSta = baseCofirmSta;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getComeDate() {
		return this.comeDate;
	}

	public void setComeDate(String comeDate) {
		this.comeDate = comeDate;
	}

	public String getComeReason() {
		return this.comeReason;
	}

	public void setComeReason(String comeReason) {
		this.comeReason = comeReason;
	}

	public String getComeResonValue() {
		return this.comeResonValue;
	}

	public void setComeResonValue(String comeResonValue) {
		this.comeResonValue = comeResonValue;
	}

	public String getDetoxBegin() {
		return this.detoxBegin;
	}

	public void setDetoxBegin(String detoxBegin) {
		this.detoxBegin = detoxBegin;
	}

	public String getDetoxEnd() {
		return this.detoxEnd;
	}

	public void setDetoxEnd(String detoxEnd) {
		this.detoxEnd = detoxEnd;
	}

	public String getDetoxLimit() {
		return this.detoxLimit;
	}

	public void setDetoxLimit(String detoxLimit) {
		this.detoxLimit = detoxLimit;
	}

	public String getDetoxLimitValue() {
		return this.detoxLimitValue;
	}

	public void setDetoxLimitValue(String detoxLimitValue) {
		this.detoxLimitValue = detoxLimitValue;
	}

	public String getDormCode() {
		return this.dormCode;
	}

	public void setDormCode(String dormCode) {
		this.dormCode = dormCode;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducationValue() {
		return this.educationValue;
	}

	public void setEducationValue(String educationValue) {
		this.educationValue = educationValue;
	}

	public String getEmphasisPersoner() {
		return this.emphasisPersoner;
	}

	public void setEmphasisPersoner(String emphasisPersoner) {
		this.emphasisPersoner = emphasisPersoner;
	}

	public String getEmphasisPersonerValue() {
		return this.emphasisPersonerValue;
	}

	public void setEmphasisPersonerValue(String emphasisPersonerValue) {
		this.emphasisPersonerValue = emphasisPersonerValue;
	}

	public String getEthnicGroup() {
		return this.ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

	public String getEthnicGroupValue() {
		return this.ethnicGroupValue;
	}

	public void setEthnicGroupValue(String ethnicGroupValue) {
		this.ethnicGroupValue = ethnicGroupValue;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getHoldBegin() {
		return this.holdBegin;
	}

	public void setHoldBegin(String holdBegin) {
		this.holdBegin = holdBegin;
	}

	public String getHoldDay() {
		return this.holdDay;
	}

	public void setHoldDay(String holdDay) {
		this.holdDay = holdDay;
	}

	public String getHoldEnd() {
		return this.holdEnd;
	}

	public void setHoldEnd(String holdEnd) {
		this.holdEnd = holdEnd;
	}

	public String getHouseAddr() {
		return this.houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	public String getHouseAddrValue() {
		return this.houseAddrValue;
	}

	public void setHouseAddrValue(String houseAddrValue) {
		this.houseAddrValue = houseAddrValue;
	}

	public String getHouseDetailAddr() {
		return this.houseDetailAddr;
	}

	public void setHouseDetailAddr(String houseDetailAddr) {
		this.houseDetailAddr = houseDetailAddr;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityTypeValue() {
		return this.identityTypeValue;
	}

	public void setIdentityTypeValue(String identityTypeValue) {
		this.identityTypeValue = identityTypeValue;
	}

	public String getIdentityValue() {
		return this.identityValue;
	}

	public void setIdentityValue(String identityValue) {
		this.identityValue = identityValue;
	}

	public String getKsUserId() {
		return this.ksUserId;
	}

	public void setKsUserId(String ksUserId) {
		this.ksUserId = ksUserId;
	}

	public String getManageType() {
		return this.manageType;
	}

	public void setManageType(String manageType) {
		this.manageType = manageType;
	}

	public String getManageTypeValue() {
		return this.manageTypeValue;
	}

	public void setManageTypeValue(String manageTypeValue) {
		this.manageTypeValue = manageTypeValue;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMarriageValue() {
		return this.marriageValue;
	}

	public void setMarriageValue(String marriageValue) {
		this.marriageValue = marriageValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityValue() {
		return this.nationalityValue;
	}

	public void setNationalityValue(String nationalityValue) {
		this.nationalityValue = nationalityValue;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOriginValue() {
		return this.originValue;
	}

	public void setOriginValue(String originValue) {
		this.originValue = originValue;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getOutDate() {
		return this.outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getOutDocState() {
		return this.outDocState;
	}

	public void setOutDocState(String outDocState) {
		this.outDocState = outDocState;
	}

	public String getOutDocTime() {
		return this.outDocTime;
	}

	public void setOutDocTime(String outDocTime) {
		this.outDocTime = outDocTime;
	}

	public String getOutPlaceValue() {
		return this.outPlaceValue;
	}

	public void setOutPlaceValue(String outPlaceValue) {
		this.outPlaceValue = outPlaceValue;
	}

	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getOutReasonValue() {
		return this.outReasonValue;
	}

	public void setOutReasonValue(String outReasonValue) {
		this.outReasonValue = outReasonValue;
	}

	public String getOutType() {
		return this.outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public String getOutTypeValue() {
		return this.outTypeValue;
	}

	public void setOutTypeValue(String outTypeValue) {
		this.outTypeValue = outTypeValue;
	}

	public byte[] getPictureByte() {
		return this.pictureByte;
	}

	public void setPictureByte(byte[] pictureByte) {
		this.pictureByte = pictureByte;
	}

	public String getPictureState() {
		return this.pictureState;
	}

	public void setPictureState(String pictureState) {
		this.pictureState = pictureState;
	}

	public String getPictureTime() {
		return this.pictureTime;
	}

	public void setPictureTime(String pictureTime) {
		this.pictureTime = pictureTime;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getPoliticalStatusValue() {
		return this.politicalStatusValue;
	}

	public void setPoliticalStatusValue(String politicalStatusValue) {
		this.politicalStatusValue = politicalStatusValue;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProcessState() {
		return this.processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSexValue() {
		return this.sexValue;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public String getSpecialIndentity() {
		return this.specialIndentity;
	}

	public void setSpecialIndentity(String specialIndentity) {
		this.specialIndentity = specialIndentity;
	}

	public String getSpecialIndentityValue() {
		return this.specialIndentityValue;
	}

	public void setSpecialIndentityValue(String specialIndentityValue) {
		this.specialIndentityValue = specialIndentityValue;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getSpecialtyValue() {
		return this.specialtyValue;
	}

	public void setSpecialtyValue(String specialtyValue) {
		this.specialtyValue = specialtyValue;
	}

	public byte[] getSuccessPhoto() {
		return this.successPhoto;
	}

	public void setSuccessPhoto(byte[] successPhoto) {
		this.successPhoto = successPhoto;
	}

	public String getTrueOutData() {
		return this.trueOutData;
	}

	public void setTrueOutData(String trueOutData) {
		this.trueOutData = trueOutData;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWorkAddr() {
		return this.workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}

	public String getWorkValue() {
		return this.workValue;
	}

	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}

}