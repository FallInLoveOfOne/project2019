package cn.innosoft.en.releaseRecord.systemManage.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 角色与用户、组织部门之间的映射关系表
 */
@Entity
@Table(name = "T_FW_ORM_ROLE_U_O_MAP", schema = "SY_FCF", catalog = "")
public class TFwOrmRoleUOMapEntity {
    private String roleUOMapId;
    private String oId;
    private String roleId;
    private String userId;
    private Long userDisplayOrder;
    private String roleUOMapType;
    private String createDt;
    private String createUserId;
    private String createUserAcct;
    private String createUserRole;
    private String updateDt;
    private String updateUserId;
    private String updateUserAcct;
    private String updateUserRole;

    @Id
    @Column(name = "ROLE_U_O_MAP_ID")
    public String getRoleUOMapId() {
        return roleUOMapId;
    }

    public void setRoleUOMapId(String roleUOMapId) {
        this.roleUOMapId = roleUOMapId;
    }

    @Basic
    @Column(name = "O_ID")
    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_DISPLAY_ORDER")
    public Long getUserDisplayOrder() {
        return userDisplayOrder;
    }

    public void setUserDisplayOrder(Long userDisplayOrder) {
        this.userDisplayOrder = userDisplayOrder;
    }

    @Basic
    @Column(name = "ROLE_U_O_MAP_TYPE")
    public String getRoleUOMapType() {
        return roleUOMapType;
    }

    public void setRoleUOMapType(String roleUOMapType) {
        this.roleUOMapType = roleUOMapType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TFwOrmRoleUOMapEntity that = (TFwOrmRoleUOMapEntity) o;
        return Objects.equals(roleUOMapId, that.roleUOMapId) &&
                Objects.equals(oId, that.oId) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userDisplayOrder, that.userDisplayOrder) &&
                Objects.equals(roleUOMapType, that.roleUOMapType) &&
                Objects.equals(createDt, that.createDt) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createUserAcct, that.createUserAcct) &&
                Objects.equals(createUserRole, that.createUserRole) &&
                Objects.equals(updateDt, that.updateDt) &&
                Objects.equals(updateUserId, that.updateUserId) &&
                Objects.equals(updateUserAcct, that.updateUserAcct) &&
                Objects.equals(updateUserRole, that.updateUserRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleUOMapId, oId, roleId, userId, userDisplayOrder, roleUOMapType, createDt, createUserId, createUserAcct, createUserRole, updateDt, updateUserId, updateUserAcct, updateUserRole);
    }
}
