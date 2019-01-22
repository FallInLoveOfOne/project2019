package cn.innosoft.en.releaseRecord.systemManage.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 用户信息
 */
@Entity
@Table(name = "T_FW_ORM_USER", schema = "SY_FCF", catalog = "")
public class TFwOrmUserEntity {
    private String userId;
    private String createDt;
    private String createUserId;
    private String createUserAcct;
    private String createUserRole;
    private String updateDt;
    private String updateUserId;
    private String updateUserAcct;
    private String updateUserRole;
    private String validSign;
    private String userAcct;
    private String userAcctCn;
    private String userAcctPwd;
    private String userAcctDesc;
    private String userAcctType;
    private String userSerial;
    private String userSex;
    private String userBirth;
    private String userEmail;
    private String userMobile;
    private String userTel;
    private String userHeadPic;
    private String oSerial;
    private String userInitialPwd;
    private String userFax;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CREATE_DT")
    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    @Basic
    @Column(name = "CREATE_USER_ID")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "CREATE_USER_ACCT")
    public String getCreateUserAcct() {
        return createUserAcct;
    }

    public void setCreateUserAcct(String createUserAcct) {
        this.createUserAcct = createUserAcct;
    }

    @Basic
    @Column(name = "CREATE_USER_ROLE")
    public String getCreateUserRole() {
        return createUserRole;
    }

    public void setCreateUserRole(String createUserRole) {
        this.createUserRole = createUserRole;
    }

    @Basic
    @Column(name = "UPDATE_DT")
    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    @Basic
    @Column(name = "UPDATE_USER_ID")
    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Basic
    @Column(name = "UPDATE_USER_ACCT")
    public String getUpdateUserAcct() {
        return updateUserAcct;
    }

    public void setUpdateUserAcct(String updateUserAcct) {
        this.updateUserAcct = updateUserAcct;
    }

    @Basic
    @Column(name = "UPDATE_USER_ROLE")
    public String getUpdateUserRole() {
        return updateUserRole;
    }

    public void setUpdateUserRole(String updateUserRole) {
        this.updateUserRole = updateUserRole;
    }

    @Basic
    @Column(name = "VALID_SIGN")
    public String getValidSign() {
        return validSign;
    }

    public void setValidSign(String validSign) {
        this.validSign = validSign;
    }

    @Basic
    @Column(name = "USER_ACCT")
    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    @Basic
    @Column(name = "USER_ACCT_CN")
    public String getUserAcctCn() {
        return userAcctCn;
    }

    public void setUserAcctCn(String userAcctCn) {
        this.userAcctCn = userAcctCn;
    }

    @Basic
    @Column(name = "USER_ACCT_PWD")
    public String getUserAcctPwd() {
        return userAcctPwd;
    }

    public void setUserAcctPwd(String userAcctPwd) {
        this.userAcctPwd = userAcctPwd;
    }

    @Basic
    @Column(name = "USER_ACCT_DESC")
    public String getUserAcctDesc() {
        return userAcctDesc;
    }

    public void setUserAcctDesc(String userAcctDesc) {
        this.userAcctDesc = userAcctDesc;
    }

    @Basic
    @Column(name = "USER_ACCT_TYPE")
    public String getUserAcctType() {
        return userAcctType;
    }

    public void setUserAcctType(String userAcctType) {
        this.userAcctType = userAcctType;
    }

    @Basic
    @Column(name = "USER_SERIAL")
    public String getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(String userSerial) {
        this.userSerial = userSerial;
    }

    @Basic
    @Column(name = "USER_SEX")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "USER_BIRTH")
    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    @Basic
    @Column(name = "USER_EMAIL")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "USER_MOBILE")
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "USER_TEL")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Basic
    @Column(name = "USER_HEAD_PIC")
    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    @Basic
    @Column(name = "O_SERIAL")
    public String getoSerial() {
        return oSerial;
    }

    public void setoSerial(String oSerial) {
        this.oSerial = oSerial;
    }

    @Basic
    @Column(name = "USER_INITIAL_PWD")
    public String getUserInitialPwd() {
        return userInitialPwd;
    }

    public void setUserInitialPwd(String userInitialPwd) {
        this.userInitialPwd = userInitialPwd;
    }

    @Basic
    @Column(name = "USER_FAX")
    public String getUserFax() {
        return userFax;
    }

    public void setUserFax(String userFax) {
        this.userFax = userFax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TFwOrmUserEntity that = (TFwOrmUserEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(createDt, that.createDt) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createUserAcct, that.createUserAcct) &&
                Objects.equals(createUserRole, that.createUserRole) &&
                Objects.equals(updateDt, that.updateDt) &&
                Objects.equals(updateUserId, that.updateUserId) &&
                Objects.equals(updateUserAcct, that.updateUserAcct) &&
                Objects.equals(updateUserRole, that.updateUserRole) &&
                Objects.equals(validSign, that.validSign) &&
                Objects.equals(userAcct, that.userAcct) &&
                Objects.equals(userAcctCn, that.userAcctCn) &&
                Objects.equals(userAcctPwd, that.userAcctPwd) &&
                Objects.equals(userAcctDesc, that.userAcctDesc) &&
                Objects.equals(userAcctType, that.userAcctType) &&
                Objects.equals(userSerial, that.userSerial) &&
                Objects.equals(userSex, that.userSex) &&
                Objects.equals(userBirth, that.userBirth) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userMobile, that.userMobile) &&
                Objects.equals(userTel, that.userTel) &&
                Objects.equals(userHeadPic, that.userHeadPic) &&
                Objects.equals(oSerial, that.oSerial) &&
                Objects.equals(userInitialPwd, that.userInitialPwd) &&
                Objects.equals(userFax, that.userFax);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, createDt, createUserId, createUserAcct, createUserRole, updateDt, updateUserId, updateUserAcct, updateUserRole, validSign, userAcct, userAcctCn, userAcctPwd, userAcctDesc, userAcctType, userSerial, userSex, userBirth, userEmail, userMobile, userTel, userHeadPic, oSerial, userInitialPwd, userFax);
    }
}
