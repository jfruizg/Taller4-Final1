package com.baeldung.servlets;

import com.baeldung.Constants;
import com.baeldung.bean.Usuario;
import com.baeldung.persistencia.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    UsuarioDAO us = new UsuarioDAO();
    File file = new File("../Data/archivo.dat");
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

                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Cookie[] monster = request.getCookies();

                for(int i = 0; i<monster.length; i++) {

                    Usuario listaU = new Usuario(monster[i].getValue(), date, fileName);
                    listaUsuarios.add(listaU);
                }
                us.escribirEnArchivoJuegos(listaUsuarios,file);

                for(int i = 0; i<listaUsuarios.size(); i++){
                    System.out.println(listaUsuarios.get(i));
                }
            }
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/Tabla1.jsp");
    }
}