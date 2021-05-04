package com.baeldung.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "loginCookies", value = "/login")
public class Login extends HttpServlet {

    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    MultipartServlet servletImagen = new MultipartServlet();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("userName");

        try {
            PrintWriter out = response.getWriter();

            out.println("hello" + name);

            Cookie c1 = new Cookie("userName", name);

            response.addCookie(c1);
            servletImagen.getServletInfo(c1);


            for (int i = 0; i <listaUsuarios.size(); i++) {
                System.out.println(listaUsuarios.get(i).getNombre() +" " +listaUsuarios.get(i).getFecha());
            }


            response.sendRedirect(request.getContextPath() + "/upload.jsp"); // se agrego un enlcae que se dirije a otros servlet
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}