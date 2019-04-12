package com.entity;

public class SetupBookrackgroupEntity {
    /**
     * 自动盘点频率id
     */
    private Integer setupId;

    /**
     * 书架组id
     */
    private Integer groupId;

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SetupBookrackgroupEntity(Integer setupId, Integer groupId) {
        this.setupId = setupId;
        this.groupId = groupId;
    }

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SetupBookrackgroupEntity() {
        super();
    }

    /**
     * 自动盘点频率id
     * @return setup_id 自动盘点频率id
     */
    public Integer getSetupId() {
        return setupId;
    }

    /**
     * 自动盘点频率id
     * @param setupId 自动盘点频率id
     */
    public void setSetupId(Integer setupId) {
        this.setupId = setupId;
    }

    /**
     * 书架组id
     * @return group_id 书架组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 书架组id
     * @param groupId 书架组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}