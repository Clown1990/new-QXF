package com.qxjs.dao.product.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.product.category.Category;

public interface CategoryMapper
{
	public void insertControl(Category vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Category vo);
	
	public List<Category> selectControl();
	

}
