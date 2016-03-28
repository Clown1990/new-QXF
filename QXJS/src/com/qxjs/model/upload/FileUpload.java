package com.qxjs.model.upload;

import java.io.File;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Iterator;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
  
public class FileUpload extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = -4330533480633607475L;
	// 限制文件的上传大小
    private int maxPostSize = 100 * 1024 * 1024;  
    private String fileName = "";
    
    public FileUpload() {  
        super();  
    }  
    public void destroy() {  
        super.destroy();  
    }  
    protected void processRequest(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        System.out.println("�?��!");  
        fileName = request.getParameter("fileName");
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        factory.setSizeThreshold(4096);  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setSizeMax(maxPostSize);  
        try {  
            request.setCharacterEncoding("UTF-8");  
            List fileItems = upload.parseRequest(request);  
            Iterator iter = fileItems.iterator();  
            while (iter.hasNext()) {  
                FileItem item = (FileItem) iter.next();  
                if (!item.isFormField()) {  
//                    String fileName = item.getName();  
                    System.out.println(fileName);  
                    String uploadPath = null;  
                    response.setContentType("text/html;charset=UTF-8");  
                    PrintWriter out = response.getWriter();  
                    uploadPath = request.getRealPath("/");  
                    System.out.println(uploadPath);  
                    item.write(new File(uploadPath +"uploadfile/"+ fileName));  
                    out.print(fileName+"上传成功");  
                }  
            }  
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }  
        System.out.println("结束");  
    }  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        try {  
            processRequest(request, response);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        try {  
            processRequest(request, response);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    public String getServletInfo() {  
        return "Short description";  
    }  
}  