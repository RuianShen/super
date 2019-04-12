package com.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.entity.SystemLogEntity;
import com.entity.param.SystemLogParam;

/**
 * Created by LQW on 2018/11/26.
 */


public interface SystemLogService {

    Integer insertLog(SystemLogEntity record);
    
    /**
	 * 查询分页数据
	 * @param param
	 * @return
	 */
	Map<String,Object> selectByParam(SystemLogParam param);
	
	/**
	 * excel导出日志
	 * @param response
	 */
	void exportSaleStatisticsLog(SystemLogParam param,HttpServletResponse response);
	
	/**
	 * 不分页根据筛选查询日志
	 * @return
	 */
	List<SystemLogParam> selectSystemLogAll(SystemLogParam param);
	
	/**
	 * 分页查询热门关键词
	 * @param param
	 * @return
	 */
	Map<String,Object> selectByParamPopular(SystemLogParam param);
	/**
	 * 分页查热门阅览
	 * @param systemLogParam
	 * @return
	 */
	Map<String, Object> selectHotLookByParam(SystemLogParam systemLogParam);

}
