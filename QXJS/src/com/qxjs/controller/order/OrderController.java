package com.qxjs.controller.order;

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
import com.qxjs.dao.order.OrderMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.order.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderMapper mapper;
	
	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Order vo = new Order();
			vo.setCustomId(Integer.parseInt(request.getParameter("customId")));
			vo.setTime((int)(System.currentTimeMillis()/1000));
			vo.setAddress(request.getParameter("address"));
			vo.setContent(request.getParameter("content"));
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
			String orderIdStr = request.getParameter("orderId");
			mapper.deleteControl(orderIdStr);
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
			Order vo = new Order();
			vo.setOrderId(Integer.parseInt(request.getParameter("orderId")));
			vo.setCustomId(Integer.parseInt(request.getParameter("customId")));
			vo.setTime((int)(System.currentTimeMillis()/1000));
			vo.setAddress(request.getParameter("address"));
			vo.setContent(request.getParameter("content"));
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
			Order vo = new Order();
			vo.setCustomName(request.getParameter("customName"));
			String provinceStr = request.getParameter("provinceStr");
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			String startTime = request.getParameter("startDate");
			String endTime = request.getParameter("endDate");
			pageVo.setTotalNumber(mapper.selectCount(vo, startTime, endTime));
			map.put("pageVo", pageVo);
			map.put("list", mapper.selectControl(vo, pageVo, request.getParameter("startDate"), request.getParameter("endDate"), provinceStr));
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
