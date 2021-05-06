package com.baeldung.servlets;


import com.baeldung.bean.Usuario;
import com.baeldung.persistencia.UsuarioDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "GetCities", urlPatterns = {"/GetCities"})
public class GetUsuario extends HttpServlet {

    UsuarioDAO us = new UsuarioDAO();
    File file = new File("archivo.dat");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            List<Usuario> cities = us.leerArchivoJuegos(file);

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

           out.print(gson.toJson(cities));

        }
    }
}