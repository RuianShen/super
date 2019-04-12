package com.dao;

import com.entity.SystemPermissionEntity;

public interface SystemPermissionDao {
    /**
     *
     * @mbg.generated 2018-11-26
     */
    int deleteByPrimaryKey(Integer permissionId);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int insert(SystemPermissionEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int insertSelective(SystemPermissionEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    SystemPermissionEntity selectByPrimaryKey(Integer permissionId);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKeySelective(SystemPermissionEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKey(SystemPermissionEntity record);
}