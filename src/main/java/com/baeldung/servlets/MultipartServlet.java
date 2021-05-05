package com.baeldung.servlets;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import com.baeldung.bean.Usuario;
import com.baeldung.persistencia.UsuarioDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet(
        name = "UploadServlet",
        urlPatterns = {"/uploadFile"}
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MultipartServlet extends HttpServlet {


    UsuarioDAO operacion = new UsuarioDAO();
    File file = new File("archivo.dat");
    ArrayList<Usuario>listaUsuario = operacion.leerArchivoJuegos(file);



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (ServletFileUpload.isMultipartContent(request)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            String uploadPath = getServletContext().getRealPath("./") + File.separator + "upload";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                List<FileItem> formItems = upload.parseRequest(request);

                String fileName = new File(formItems.get(0).getName()).getName();
                String filePath = uploadPath + File.separator + fileName;
                File storeFile = new File(filePath);
                formItems.get(0).write(storeFile);
                String descrFoto= formItems.get(1).getName();
                String descripcion = request.getParameter("textoDescripcion");
                System.out.println(descripcion);

                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                Cookie[] monster = request.getCookies();
                for(int i=0;i<monster.length;i++){
                    if(monster[i].getName().equals("userName")){
                        System.out.println("paso");
                        operacion.agregarUsuario(monster[i].getValue(),date,descripcion,descrFoto,fileName,listaUsuario,file);
                    }
                }

            } catch (Exception ex) {
                request.setAttribute("message", "There was an error: " + ex.getMessage());
            }
            getServletContext().getRequestDispatcher("/Tabla1.jsp").forward(request, response);
        }
    }
}
