package com.entity;

import java.util.Date;

public class SystemUserEntity {
    /**
     * 用户自增id
     */
    private Integer userId;

    /**
     * 登陆账号
     */
    private String userLoginid;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 部门
     */
    private String department;

    /**
     * 邮件
     */
    private String email;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 状态：1可用 0不可用
     */
    private Integer state;

    /**
     * 性别 0女  1男
     */
    private Integer sex;

    /**
     * 创建者id
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 备注
     */
    private String mark;

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemUserEntity(Integer userId, String userLoginid, String userPassword, String userName, String department, String email, String idcard, String telephone, Integer state, Integer sex, Integer createUserId, Date createtime, Date updatetime, String mark) {
        this.userId = userId;
        this.userLoginid = userLoginid;
        this.userPassword = userPassword;
        this.userName = userName;
        this.department = department;
        this.email = email;
        this.idcard = idcard;
        this.telephone = telephone;
        this.state = state;
        this.sex = sex;
        this.createUserId = createUserId;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.mark = mark;
    }

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemUserEntity() {
        super();
    }

    /**
     * 用户自增id
     * @return user_id 用户自增id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户自增id
     * @param userId 用户自增id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 登陆账号
     * @return user_loginid 登陆账号
     */
    public String getUserLoginid() {
        return userLoginid;
    }

    /**
     * 登陆账号
     * @param userLoginid 登陆账号
     */
    public void setUserLoginid(String userLoginid) {
        this.userLoginid = userLoginid == null ? null : userLoginid.trim();
    }

    /**
     * 密码
     * @return user_password 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 密码
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 部门
     * @return department 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 部门
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 邮件
     * @return email 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮件
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 身份证号
     * @return idcard 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号
     * @param idcard 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 手机号
     * @return telephone 手机号
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机号
     * @param telephone 手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 状态：1可用 0不可用
     * @return state 状态：1可用 0不可用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态：1可用 0不可用
     * @param state 状态：1可用 0不可用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 性别 0女  1男
     * @return sex 性别 0女  1男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别 0女  1男
     * @param sex 性别 0女  1男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 创建者id
     * @return create_user_id 创建者id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建者id
     * @param createUserId 创建者id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 创建时间
     * @return createtime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 修改时间
     * @return updatetime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 备注
     * @return mark 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 备注
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}