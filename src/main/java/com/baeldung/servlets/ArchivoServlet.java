package com.baeldung.servlets;

import com.baeldung.persistencia.operacionArchivo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoServlet extends HttpServlet {

    ArrayList<Usuario>listaUsuarios = new ArrayList<Usuario>();
    operacionArchivo archivo = new operacionArchivo();
    File file = new File("/Dara/archivo.dat");

    public ArchivoServlet() {
        archivo.leerArchivoJuegos(file);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {










    }
}
