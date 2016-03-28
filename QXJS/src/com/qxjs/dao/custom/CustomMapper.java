package com.qxjs.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.custom.Custom;

public interface CustomMapper
{
	public void insertControl(Custom vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Custom vo);
	
	public List<Custom> selectControl(@Param(value="vo")Custom vo,@Param(value="page")PageVo page);
	
	public int selectCount(Custom vo);

}
