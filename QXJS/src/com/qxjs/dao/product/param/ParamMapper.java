package com.qxjs.dao.product.param;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParamMapper
{
	public void insertControl(com.qxjs.model.vo.product.param.Param vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(com.qxjs.model.vo.product.param.Param vo);
	
	public List<com.qxjs.model.vo.product.param.Param> selectControl();

}
