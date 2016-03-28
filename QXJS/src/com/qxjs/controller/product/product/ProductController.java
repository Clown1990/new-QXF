package com.qxjs.controller.product.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxjs.common.NameSpace;
import com.qxjs.dao.product.product.ProductMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.product.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductMapper mapper;

	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Product vo = new Product();
			vo.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			vo.setGroupId(Integer.parseInt(request.getParameter("groupId")));
			vo.setEnable(Integer.parseInt(request.getParameter("enable")));
			vo.setProductName(request.getParameter("productName"));
			vo.setProductCd(request.getParameter("productCd"));
			vo.setImgPath(request.getParameter("imgPath"));
//			vo.setParamJson(request.getParameter("paramJson"));
			vo.setComment(request.getParameter("comment"));
			mapper.insertControl(vo);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/deleteControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String productIdStr = request.getParameter("productId");
			mapper.deleteControl(productIdStr);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/updateControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Product vo = new Product();
			vo.setProductId(Integer.parseInt(request.getParameter("productId")));
			vo.setGroupId(Integer.parseInt(request.getParameter("groupId")));
			vo.setEnable(Integer.parseInt(request.getParameter("enable")));
			vo.setProductName(request.getParameter("productName"));
			vo.setProductCd(request.getParameter("productCd"));
			vo.setImgPath(request.getParameter("imgPath"));
			vo.setComment(request.getParameter("comment"));
			mapper.updateControl(vo);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/selectControl", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> selectControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Product vo = new Product();
			vo.setProductCd(request.getParameter("productCd"));
			vo.setGroupId(Integer.parseInt(request.getParameter("groupId")));
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			pageVo.setTotalNumber(mapper.selectCount(vo));
			map.put("pageVo", pageVo);
			map.put("list", mapper.selectControl(vo, pageVo));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
