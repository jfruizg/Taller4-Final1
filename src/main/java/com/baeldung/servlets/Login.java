package com.baeldung.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "loginCookies", value = "/login")
public class Login extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("userName");

        try {
            PrintWriter out = response.getWriter();

            out.println("hello" + name);

            Cookie c1 = new Cookie("userName", name);

            response.addCookie(c1);

            response.sendRedirect(request.getContextPath() + "/upload.jsp"); // se agrego un enlcae que se dirije a otros servlet
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}