package com.qxjs.controller.product.photo;

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
import com.qxjs.dao.product.photo.PhotoMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.photo.Photo;

@Controller
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private PhotoMapper mapper;

	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Photo vo = new Photo();
			vo.setUserId(Integer.parseInt(request.getParameter("userId")));
			vo.setProductId(Integer.parseInt(request.getParameter("productId")));
			vo.setType(Integer.parseInt(request.getParameter("type")));
			vo.setEnable(Integer.parseInt(request.getParameter("enable")));
			vo.setProductCd(request.getParameter("photoCd"));
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
			String photoIdStr = request.getParameter("photoId");
			mapper.deleteControl(photoIdStr);
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
			Photo vo = new Photo();
			vo.setPhotoId(Integer.parseInt(request.getParameter("photoId")));
			vo.setUserId(Integer.parseInt(request.getParameter("userId")));
			vo.setProductId(Integer.parseInt(request.getParameter("productId")));
			vo.setType(Integer.parseInt(request.getParameter("type")));
//			vo.setEnable(Integer.parseInt(request.getParameter("enable")));
			vo.setProductCd(request.getParameter("photoCd"));
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
			Photo vo = new Photo();
			vo.setProductCd(request.getParameter("productCd"));
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
}
