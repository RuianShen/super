package com.dao;

import com.entity.UserPermissionEntity;

public interface UserPermissionDao {
    /**
     * @mbg.generated 2018-11-26
     */
    int insert(UserPermissionEntity record);

    /**
     * @mbg.generated 2018-11-26
     */
    int insertSelective(UserPermissionEntity record);

    UserPermissionEntity selectByPrimaryKey(Integer userId);

    int deleteByPrimaryKey(Integer id);
}