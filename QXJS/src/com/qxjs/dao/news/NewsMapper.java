package com.qxjs.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.news.News;

public interface NewsMapper
{
	public void insertControl(News vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(News vo);
	
	public List<News> selectControl(@Param(value="page")PageVo page, @Param(value="startDate")String startDate, @Param(value="endDate")String endDate);
	
	public int selectCount(@Param(value="startDate")String startDate, @Param(value="endDate")String endDate);

	public List<News> downloadData();
	
	public News selectNewsById(@Param(value="newsId")int newsId);
}
