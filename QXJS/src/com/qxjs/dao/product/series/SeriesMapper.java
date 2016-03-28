package com.qxjs.dao.product.series;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.product.series.Series;

public interface SeriesMapper
{
	public void insertControl(Series vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Series vo);
	
	public List<Series> selectControl();

}
