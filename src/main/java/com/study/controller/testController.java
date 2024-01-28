package com.study.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fileUploadTest")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5
)
public class testController extends HttpServlet {

    private static final String UPLOAD_DIR = "upload/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName =  "fileUpload";

        ServletContext context = getServletContext();
        String downloadPath = context.getRealPath(UPLOAD_DIR);
        String filePath = downloadPath + fileName;

        System.out.println("업로드된 파일 경로" + downloadPath);
        System.out.println("파일 전체 경로" + filePath);

        byte[] b = new byte[4098];
        FileInputStream fileInputStream = new FileInputStream(filePath);

        String mimeType = getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        resp.setContentType(mimeType);

        String sEncoding = new String(fileName.getBytes("UTF-8"));
        resp.setHeader("Content-Disposition", "attachment; fileName= " + sEncoding);

        // 파일 쓰기 OutputStream
        ServletOutputStream servletOutStream = resp.getOutputStream();

        int read;
        while((read = fileInputStream.read(b,0,b.length))!= -1){
            servletOutStream.write(b,0,read);
        }

        servletOutStream.flush();
        servletOutStream.close();
        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String applicationPath = req.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath+UPLOAD_DIR;

        System.out.println("uploadFilePath"+uploadFilePath);

        Part part = req.getPart("fileName");

        String fileName = getFilename(part);
        if (!fileName.isEmpty()) {
            part.write(uploadFilePath+fileName);
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

    }

private String getFilename(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] split = contentDisp.split(";");
    for (int i = 0; i < split.length; i++) {
        String temp = split[i];
        if (temp.trim().startsWith("filename")) {
            return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
        }
    }
    return "";
}
}
