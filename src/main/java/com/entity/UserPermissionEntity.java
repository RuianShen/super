package com.entity;

public class UserPermissionEntity {
    /**
     * 用户自增id
     */
    private Integer userId;

    /**
     * 书架组id
     */
    private Integer rackgroupId;

    /**
     * 权限组自增id
     */
    private Integer pergroupId;

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public UserPermissionEntity(Integer userId, Integer rackgroupId, Integer pergroupId) {
        this.userId = userId;
        this.rackgroupId = rackgroupId;
        this.pergroupId = pergroupId;
    }

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public UserPermissionEntity() {
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
     * 书架组id
     * @return rackgroup_id 书架组id
     */
    public Integer getRackgroupId() {
        return rackgroupId;
    }

    /**
     * 书架组id
     * @param rackgroupId 书架组id
     */
    public void setRackgroupId(Integer rackgroupId) {
        this.rackgroupId = rackgroupId;
    }

    /**
     * 权限组自增id
     * @return pergroup_id 权限组自增id
     */
    public Integer getPergroupId() {
        return pergroupId;
    }

    /**
     * 权限组自增id
     * @param pergroupId 权限组自增id
     */
    public void setPergroupId(Integer pergroupId) {
        this.pergroupId = pergroupId;
    }
}