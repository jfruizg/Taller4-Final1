package com.baeldung.servlets;

import com.baeldung.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.baeldung.Constants.UPLOAD_DIRECTORY;

@WebServlet(
        name = "MultiPartServlet",
        urlPatterns = {"/multiPartServlet"}
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MultipartServlet extends HttpServlet {

    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static final long serialVersionUID = 1L;

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constants.DEFAULT_FILENAME;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();

        try {
            String fileName = "";
            String filDescripcion = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                filDescripcion = request.getParameter("descripcion");
                part.write(uploadPath + File.separator + fileName );
            }

        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/Tabla.html");

    }

    public void getServletInfo(Cookie c1) throws IOException, ServletException {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fileName = "";
        HttpServletRequest request = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            Usuario lista = new Usuario(c1.getValue(), date, getFileName(part));
            listaUsuarios.add(lista);
        }

    }
}