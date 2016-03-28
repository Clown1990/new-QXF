package com.qxjs.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.order.Order;

public interface OrderMapper
{
	public void insertControl(Order vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Order vo);
	
	public List<Order> selectControl(@Param(value="vo")Order vo, @Param(value="page")PageVo page, @Param(value="startDate")String startDate, @Param(value="endDate")String endDate);
	
	public int selectCount(@Param(value="vo")Order vo, @Param(value="startDate")String startDate, @Param(value="endDate")String endDate);

}
