package com.qxjs.dao.activity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.activity.Activity;
import com.qxjs.model.vo.common.PageVo;

public interface ActivityMapper
{
	public void insertControl(Activity vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Activity vo);
	
	public List<Activity> selectControl(@Param(value="page")PageVo page, @Param(value="startDate")String startDate, @Param(value="endDate")String endDate);
	
	public int selectCount(@Param(value="startDate")String startDate, @Param(value="endDate")String endDate);

}
