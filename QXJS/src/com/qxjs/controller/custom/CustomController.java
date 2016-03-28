package com.qxjs.controller.custom;

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
import com.qxjs.dao.custom.CustomMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.custom.Custom;

@Controller
@RequestMapping("/custom")
public class CustomController {

	@Autowired
	private CustomMapper mapper;
    
	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Custom vo = new Custom();
			vo.setStoreId(Integer.parseInt(request.getParameter("storeId")));
			vo.setAddress(request.getParameter("address"));
			vo.setCustomName(request.getParameter("customName"));
			vo.setPhone(request.getParameter("phone"));
			vo.setSex(Integer.parseInt(request.getParameter("sex")));
			vo.setAge(Integer.parseInt(request.getParameter("age")));
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
			String customIdStr = request.getParameter("customId");
			mapper.deleteControl(customIdStr);
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
			Custom vo = new Custom();
			vo.setCustomId(Integer.parseInt(request.getParameter("customId")));
			vo.setStoreId(Integer.parseInt(request.getParameter("storeId")));
			vo.setAddress(request.getParameter("address"));
			vo.setCustomName(request.getParameter("customName"));
			vo.setPhone(request.getParameter("phone"));
			vo.setSex(Integer.parseInt(request.getParameter("sex")));
			vo.setAge(Integer.parseInt(request.getParameter("age")));
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
			Custom vo = new Custom();
			vo.setCustomName(request.getParameter("customName"));
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
