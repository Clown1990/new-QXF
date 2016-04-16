package com.qxjs.controller.product.param;

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
import com.qxjs.dao.product.param.ParamMapper;
import com.qxjs.model.vo.product.param.Param;

@Controller
@RequestMapping("/param")
public class ParamController {
	
	@Autowired
	private ParamMapper mapper;
    
	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Param vo = new Param();
			vo.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			vo.setLevel(Integer.parseInt(request.getParameter("level")));
			vo.setCname(request.getParameter("cname"));
			vo.setEname(request.getParameter("ename"));
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
			String paramIdStr = request.getParameter("paramId");
			mapper.deleteControl(paramIdStr);
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
			Param vo = new Param();
			vo.setParamId(Integer.parseInt(request.getParameter("paramId")));
			vo.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			vo.setLevel(Integer.parseInt(request.getParameter("level")));
			vo.setCname(request.getParameter("cname"));
			vo.setEname(request.getParameter("ename"));
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
			map.put("list", mapper.selectControl());
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
	
	@RequestMapping(value="/downloadData", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> downloadData(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map.put("list", mapper.downloadData());
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
	
	@RequestMapping(value="/selectParamByCategoryId", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> selectParamByCategoryId(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			map.put("list", mapper.selectParamByCategoryId(categoryId));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
