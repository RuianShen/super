package com.dao;

import com.entity.SystemUserEntity;
import com.entity.param.OperatorParam;

import java.util.List;

public interface SystemUserDao {
    /**
     * @mbg.generated 2018-11-26
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * @mbg.generated 2018-11-26
     */
    int insert(SystemUserEntity record);

    /**
     * @mbg.generated 2018-11-26
     */
    int insertSelective(SystemUserEntity record);

    /**
     * @mbg.generated 2018-11-26
     */
    SystemUserEntity selectByPrimaryKey(Integer userId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param systemUserEntity
     * @return 对象列表
     * @author ZYL
     * @date 2018-11-28
     */
    List<SystemUserEntity> queryAll(SystemUserEntity systemUserEntity);

    /**
     * 分页查询数据
     *
     * @param systemUserEntity
     * @return
     * @author ZYL
     * @date 2018-11-28
     */
    List<OperatorParam> selectByParam(SystemUserEntity systemUserEntity);

    /**
     * 根据条件查询数量
     *
     * @param param
     * @return
     * @author ZYL
     * @date 2018-11-28
     */
    int countByParam(OperatorParam param);

    /**
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKeySelective(SystemUserEntity record);

    /**
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKey(SystemUserEntity record);
}