package com.qxjs.controller.store;

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
import com.qxjs.dao.store.StoreMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.store.Store;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreMapper mapper;

	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Store vo = new Store();
			vo.setProvinceId(Integer.parseInt(request.getParameter("provinceId")));
			vo.setAddress(request.getParameter("address"));
			vo.setStoreName(request.getParameter("storeName"));
			vo.setPhone(request.getParameter("phone"));
			vo.setImg(request.getParameter("img"));
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
			String storeIdStr = request.getParameter("storeId");
			mapper.deleteControl(storeIdStr);
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
			Store vo = new Store();
			vo.setStoreId(Integer.parseInt(request.getParameter("storeId")));
			vo.setProvinceId(Integer.parseInt(request.getParameter("provinceId")));
			vo.setAddress(request.getParameter("address"));
			vo.setStoreName(request.getParameter("storeName"));
			vo.setPhone(request.getParameter("phone"));
			vo.setImg(request.getParameter("img"));
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
			Store vo = new Store();
			vo.setStoreName(request.getParameter("storeName"));
			vo.setProvinceName(request.getParameter("province"));
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
