package com.entity;

import java.util.Date;

public class SystemLogEntity {
    /**
     * 自增id
     */
    private Integer logId;

    /**
     * 日志代码
     */
    private String logCode;

    /**
     * 日志数据
     */
    private Integer logdata1;

    /**
     * 日志数据
     */
    private String logdata2;

    /**
     * 日志数据
     */
    private String logdata3;

    /**
     * 操作员id
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 备注
     */
    private String mark;

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemLogEntity(Integer logId, String logCode, Integer logdata1, String logdata2, String logdata3, Integer userId, Date createtime, String mark) {
        this.logId = logId;
        this.logCode = logCode;
        this.logdata1 = logdata1;
        this.logdata2 = logdata2;
        this.logdata3 = logdata3;
        this.userId = userId;
        this.createtime = createtime;
        this.mark = mark;
    }

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemLogEntity() {
        super();
    }

    /**
     * 自增id
     * @return log_id 自增id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 自增id
     * @param logId 自增id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 日志代码
     * @return log_code 日志代码
     */
    public String getLogCode() {
        return logCode;
    }

    /**
     * 日志代码
     * @param logCode 日志代码
     */
    public void setLogCode(String logCode) {
        this.logCode = logCode == null ? null : logCode.trim();
    }

    /**
     * 日志数据
     * @return logdata1 日志数据
     */
    public Integer getLogdata1() {
        return logdata1;
    }

    /**
     * 日志数据
     * @param logdata1 日志数据
     */
    public void setLogdata1(Integer logdata1) {
        this.logdata1 = logdata1;
    }

    /**
     * 日志数据
     * @return logdata2 日志数据
     */
    public String getLogdata2() {
        return logdata2;
    }

    /**
     * 日志数据
     * @param logdata2 日志数据
     */
    public void setLogdata2(String logdata2) {
        this.logdata2 = logdata2 == null ? null : logdata2.trim();
    }

    /**
     * 日志数据
     * @return logdata3 日志数据
     */
    public String getLogdata3() {
        return logdata3;
    }

    /**
     * 日志数据
     * @param logdata3 日志数据
     */
    public void setLogdata3(String logdata3) {
        this.logdata3 = logdata3 == null ? null : logdata3.trim();
    }

    /**
     * 操作员id
     * @return user_id 操作员id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 操作员id
     * @param userId 操作员id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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