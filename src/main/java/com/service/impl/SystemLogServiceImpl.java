package com.service.impl;

import com.common.utils.ExcelUtil;
import com.dao.LogCodeDao;
import com.dao.SystemLogDao;
import com.dao.SystemUserDao;
import com.entity.LogCodeEntity;
import com.entity.SystemLogEntity;
import com.entity.SystemUserEntity;
import com.entity.param.SystemLogParam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mysql.fabric.xmlrpc.base.Array;
import com.service.SystemLogService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by LQW on 2018/11/26.
 */

@Service
public class SystemLogServiceImpl implements SystemLogService {
    private Logger logger = Logger.getLogger(getClass());
    @Resource
    private SystemLogDao systemLogDao;
    @Resource
    private LogCodeDao logCodeDao;
    @Resource
    private SystemUserDao systemUserDao;

    @Override
    public Integer insertLog(SystemLogEntity record) {
        if(record == null){
            logger.error("SystemLog is null");
            return null;
        } else if(record.getLogCode() == null){
            logger.error("Code is null");
            return null;
        }
        systemLogDao.insertSelective(record);
        return  record.getLogId();
    }

	@Override
	public Map<String, Object> selectByParam(SystemLogParam param) {
		if(param == null) {
			logger.error("SystemLog param is null");
            return null;
		}
		if(param.getPage()==null ) {
			logger.error("SystemLog param page is null");
            return null;
		}
		List<SystemLogParam> logList = systemLogDao.selectBySystemLogParam(param);
		//得到数量
		int total = systemLogDao.countBySystemLogParam(param);		
		if(logList!=null && logList.size()>0) {
			for (SystemLogParam systemLogEntity : logList) {
				//根据logCode得出权限code对象
				if(systemLogEntity.getLogCode()!=null) {
					LogCodeEntity logCode = logCodeDao.selectByCode(systemLogEntity.getLogCode());
					//赋值
					systemLogEntity.setlCodeEntity(logCode);
				}
				//根据userid得出操作员
				if(systemLogEntity.getUserId()!=null) {
					SystemUserEntity user = systemUserDao.selectByPrimaryKey(systemLogEntity.getUserId());
					//赋值
					systemLogEntity.setsUserEntity(user);
				}
			}
			Map<String, Object> map = new HashMap<>();
			map.put("rows", logList);
			map.put("total", total);
			map.put("page", param.getPage().getPage());
	        map.put("pageSize", param.getPage().getPageSize());
	        return map;
		}
		return null;
	}

	@Override
	public void exportSaleStatisticsLog(SystemLogParam param,HttpServletResponse response) {
		String name = encodingFileName("日志详情");
    	response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("content-disposition", "attachment; filename=" + name
        		+ ".xls");
        
        OutputStream out =null;
        List<SystemLogParam> logList = selectSystemLogAll(param);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
			out = new BufferedOutputStream(response.getOutputStream());
			List<String> header = new ArrayList<String>();
			header.add("序号");
	        header.add("日志类型");
	        header.add("操作时间");
	        header.add("操作员");
	        header.add("备注");
	       
	        List<String[]> size = new ArrayList<>();
	       
	        for(int i=0;i<logList.size();i++) {	
	        	String[] s = {""+(i+1),logList.get(i).getlCodeEntity().getLogDesc(),format.format(logList.get(i).getCreatetime())
	        			,logList.get(i).getsUserEntity().getUserName(),logList.get(i).getMark()};
	        	size.add(s);
	        }
	       ExcelUtil.createExcel(header,size,out);
		} catch (IOException e) {
			logger.info("下载日志详情文件异常", e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//解决中文乱码问题 
    private String encodingFileName(String name) {
       String returnFileName = "";
       try {
           returnFileName = URLEncoder.encode(name, "UTF-8");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       return returnFileName;
    }

	@Override
	public List<SystemLogParam> selectSystemLogAll(SystemLogParam param) {
		if(param==null ) {
			logger.error("SystemLog param is null");
            return null;
		}
		List<SystemLogParam> logList = systemLogDao.selectSystemLogAll(param);	
		if(logList!=null && logList.size()>0) {
			for (SystemLogParam systemLogEntity : logList) {
				//根据logCode得出权限code对象
				if(systemLogEntity.getLogCode()!=null) {
					LogCodeEntity logCode = logCodeDao.selectByCode(systemLogEntity.getLogCode());
					if(logCode==null) {
						logCode = new LogCodeEntity();
						logCode.setLogDesc("");
					}
					//赋值
					systemLogEntity.setlCodeEntity(logCode);
					
				}
				//根据userid得出操作员
				if(systemLogEntity.getUserId()!=null) {
					SystemUserEntity user = systemUserDao.selectByPrimaryKey(systemLogEntity.getUserId());
					if(user==null) {
						user = new SystemUserEntity();
						user.setUserName("");
					}
					//赋值
					systemLogEntity.setsUserEntity(user);
					
				}
			}
	        return logList;
		}
		return null;
	}

	@Override
	public Map<String, Object> selectByParamPopular(SystemLogParam param) {
		if(param.getPage()==null ) {
			logger.error("SystemLog param page is null");
            return null;
		}
		List<SystemLogParam> logList = systemLogDao.selectByParamPopular(param);
		//得到数量
		int total = systemLogDao.countBySystemPopular(param);		
		if(logList!=null && logList.size()>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("rows", logList);
			map.put("total", total);
			map.put("page", param.getPage().getPage());
	        map.put("pageSize", param.getPage().getPageSize());
	        return map;
		}
		return null;
	}
	/**
	 * 查看热门阅览
	 */
	@Override
	public Map<String, Object> selectHotLookByParam(SystemLogParam systemLogParam) {
		if(systemLogParam.getPage()==null ) {
			logger.error("SystemLog param page is null");
            return null;
		}
		List<SystemLogParam> systemLogParamList= systemLogDao.selectHotLookByParam(systemLogParam);
		Map<String, Object> map=new HashMap<>();
		if(systemLogParamList!=null){
			map.put("systemLogParamList", systemLogParamList);
			map.put("page", systemLogParam.getPage().getPage());
			map.put("pagesize", systemLogParam.getPage().getPageSize());
			return map;
		}
		return null;
	}
}
