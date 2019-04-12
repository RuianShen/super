package com.entity.param;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

import com.entity.LogCodeEntity;
import com.entity.SystemLogEntity;
import com.entity.SystemUserEntity;

public class SystemLogParam extends SystemLogEntity {
	private Page page;
	private LogCodeEntity lCodeEntity;
	private SystemUserEntity sUserEntity;
	private String strDate;		//开始时间
	private String endDate;		//结束时间
	private String order;		//排序
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public LogCodeEntity getlCodeEntity() {
		return lCodeEntity;
	}
	public void setlCodeEntity(LogCodeEntity lCodeEntity) {
		this.lCodeEntity = lCodeEntity;
	}
	public SystemUserEntity getsUserEntity() {
		return sUserEntity;
	}
	public void setsUserEntity(SystemUserEntity sUserEntity) {
		this.sUserEntity = sUserEntity;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	
}
