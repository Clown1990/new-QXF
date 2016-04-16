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

import com.qxjs.dao.product.product.ProductMapper;
import com.qxjs.model.vo.product.product.Product;

@SuppressWarnings("serial")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ProductServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		ProductMapper mapper = (ProductMapper)wac.getBean("productMapper"); 
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getRealPath("/source/productImg");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String groupId = "", categoryId = "", productName = "", productCd = "", 
			imgPath = "", comment = "", productId = "", paramJson = "";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			System.out.println(list.size());
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (item.isFormField()) {
					if(name.equals("groupId")){
						groupId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("productId")){
						productId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("categoryId")){
						categoryId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("productName")){
						productName = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("productCd")){
						productCd = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("imgPath")){
						imgPath = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("comment")){
						comment = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("param1")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param2")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param3")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param4")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param5")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param6")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}else if(name.equals("param7")){
						paramJson += new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						paramJson += "@#";
					}
				}else {
					String value = item.getName();
					int start = value.lastIndexOf("\\");
					String filename = value.substring(start + 1);
					imgPath = filename;
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
			if(paramJson.length() > 0) paramJson = paramJson.substring(0, paramJson.length()-2);
			Product vo = new Product();
			vo.setGroupId(Integer.parseInt(groupId));
			vo.setCategoryId((Integer.parseInt(categoryId)));
			vo.setEnable(1);
			vo.setProductName(productName);
			vo.setProductCd(productCd);
			vo.setImgPath(imgPath);
			vo.setComment(comment);
			vo.setParamJson(paramJson);
			if(productId.equals("")){
				mapper.insertControl(vo);
			}else{
				vo.setProductId(Integer.parseInt(productId));
				mapper.updateControl(vo);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("websrc/temple/product/product.html");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}