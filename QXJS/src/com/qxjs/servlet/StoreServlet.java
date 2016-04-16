package com.qxjs.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qxjs.dao.store.StoreMapper;
import com.qxjs.model.vo.store.Store;

@SuppressWarnings("serial")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class StoreServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		StoreMapper mapper = (StoreMapper)wac.getBean("storeMapper"); 
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getRealPath("/source/storeImg");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String storeName = "", provinceId = "", address = "", phone = "", img = "", storeId = "";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (item.isFormField()) {
					if(name.equals("storeName")){
						storeName = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("provinceId")){
						provinceId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("address")){
						address = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("phone")){
						phone = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("storeId")){
						storeId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}
//					String value = new String(item.getString().getBytes("iso-8859-1"),"UTF-8"); 
//					request.setAttribute(name, value);
				}
				else {
					String value = item.getName();
					int start = value.lastIndexOf("\\");
					String filename = value.substring(start + 1);
					img = filename;
					if(item.getSize() <= 0) continue;
					OutputStream out = new FileOutputStream(new File(path, filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("获取上传文件的总共的容量：" + item.getSize());
					while ((length = in.read(buf)) != -1) {
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}
			Store vo = new Store();
			vo.setStoreName(storeName);
			vo.setProvinceId(Integer.parseInt(provinceId));
			vo.setAddress(address);
			vo.setPhone(phone);
			vo.setImg(img);
			System.out.println("storeId:"+storeId);
			if(storeId.equals("")){
				mapper.insertControl(vo);
			}else{
				vo.setStoreId(Integer.parseInt(storeId));
				mapper.updateControl(vo);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("websrc/temple/store/storeManage.html");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}