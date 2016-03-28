package com.qxjs.dao.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.common.Province;

public interface ProvinceMapper
{
	public void insertControl(Province vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Province vo);
	
	public List<Province> selectControl(@Param(value="vo")Province vo,@Param(value="page")PageVo page);
	
	public int selectCount(Province vo);

}
