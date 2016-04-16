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

import com.qxjs.dao.product.photo.PhotoMapper;
import com.qxjs.model.vo.product.photo.Photo;

@SuppressWarnings("serial")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class PhotoServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		PhotoMapper mapper = (PhotoMapper)wac.getBean("photoMapper"); 
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getRealPath("/source/photoImg");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String photoId = "", userId = "", productId = "", productCd = "", 
			imgPath = "", comment = "", enable = "0";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (item.isFormField()) {
					if(name.equals("photoId")){
						photoId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("userId")){
						userId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("productId")){
						productId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("productCd")){
						productCd = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("comment")){
						comment = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("enable")){
						enable = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}
				}
				else {
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
			Photo vo = new Photo();
			vo.setUserId(Integer.parseInt(userId));
			vo.setProductId(Integer.parseInt(productId));
			vo.setProductCd(productCd);
			vo.setPath(imgPath);
			vo.setComment(comment);
			vo.setEnable(Integer.parseInt(enable));
			if(photoId.equals("")){
				mapper.insertControl(vo);
			}else{
				vo.setPhotoId(Integer.parseInt(photoId));
				mapper.updateControl(vo);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		request.getRequestDispatcher("/store/insertControl?"+paramStr.substring(1,paramStr.length())).forward(request, response);
//		request.getRequestDispatcher("/websrc/temple/store/storeManage.html").forward(request, response);
		response.sendRedirect("websrc/temple/product/pictures.html");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}