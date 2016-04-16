package com.qxjs.dao.collocation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.collocation.Collocation;
import com.qxjs.model.vo.common.PageVo;

public interface CollocationMapper
{
	public void insertControl(Collocation vo);
	
	public void deleteControl(@Param(value="collocationIdStr")String collocationIdStr);
	
	public void updateControl(Collocation vo);
	
	public List<Collocation> selectControl(@Param(value="vo")Collocation vo, @Param(value="page")PageVo page);
	
	public int selectCount(@Param(value="vo")Collocation vo);

	public List<Collocation> downloadData();
}
