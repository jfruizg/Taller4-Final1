package com.baeldung.servlets;

import com.baeldung.bean.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "loginCookies", value = "/login")
public class Login extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("userName");


        try {

            Cookie[] monster = request.getCookies();
            for(int i=0;i<monster.length;i++){
                if(monster[i].getName().equals(name)){
                    System.out.println("Welcome back: "+monster[i].getValue());
                    response.sendRedirect(request.getContextPath() + "/upload.jsp");
                }else{
                    PrintWriter out = response.getWriter();


                    Cookie c1 = new Cookie("userName", name);

                    response.addCookie(c1);


                    response.sendRedirect(request.getContextPath() + "/upload.jsp"); // se agrego un enlcae que se dirije a otros servlet
                    out.close();
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}