package com.qxjs.dao.product.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.product.Product;

public interface ProductMapper
{
	public void insertControl(Product vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Product vo);
	
	public List<Product> selectControl(@Param(value="vo")Product vo,@Param(value="page")PageVo page);
	
	public int selectCount(Product vo);

	public List<Product> downloadData();
}
