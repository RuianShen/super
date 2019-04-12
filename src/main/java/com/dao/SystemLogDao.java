package com.dao;

import java.util.List;

import com.entity.SystemLogEntity;
import com.entity.param.SystemLogParam;

public interface SystemLogDao {
    /**
     *
     * @mbg.generated 2018-11-26
     */
    int deleteByPrimaryKey(Integer logId);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int insert(SystemLogEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int insertSelective(SystemLogEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    SystemLogEntity selectByPrimaryKey(Integer logId);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKeySelective(SystemLogEntity record);

    /**
     *
     * @mbg.generated 2018-11-26
     */
    int updateByPrimaryKey(SystemLogEntity record);
    
    /**
     * 分页查询数据
     * @param param
     * @return
     */
    List<SystemLogParam> selectBySystemLogParam(SystemLogParam param);
    
    /**
     * 查询数量
     * @param param
     * @return
     */
    int countBySystemLogParam(SystemLogParam param);
    
    /**
     * 根据条件查询日志
     * @param param
     * @return
     */
    List<SystemLogParam> selectSystemLogAll(SystemLogParam param);
    
    /**
     * 分页查询热门检索词
     * @param param
     * @return
     */
    List<SystemLogParam> selectByParamPopular(SystemLogParam param);
    
    /**
     * 查询热门关键词数量
     * @param param
     * @return
     */
    int countBySystemPopular(SystemLogParam param);
    /**
     * 分页查热门阅览
     * @param systemLogParam
     * @return
     */
	List<SystemLogParam> selectHotLookByParam(SystemLogParam systemLogParam);
}