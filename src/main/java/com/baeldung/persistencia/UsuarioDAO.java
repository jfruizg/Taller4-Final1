package com.baeldung.persistencia;

import com.baeldung.bean.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioDAO {


    private ObjectInputStream entrada;
    private ObjectOutputStream salida;


    public UsuarioDAO(File archivo) {

        if (archivo.exists()) {
            System.out.println("Existe");
        } else {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UsuarioDAO() {

    }

    public ArrayList<Usuario> leerArchivoJuegos(File archivo) {
        ArrayList<Usuario> juegos = new ArrayList<Usuario>();
        if (archivo.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                juegos = (ArrayList<Usuario>) entrada.readObject();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return juegos;
    }

    public void escribirEnArchivoJuegos(ArrayList<Usuario> juegos, File archivo) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(juegos);
            salida.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean agregarUsuario(String nombre, Date fecha, String descripcion, String imagen, ArrayList<Usuario> listaUsuarios, File file) {
        Usuario nuevoUsuario = new Usuario(nombre, fecha, descripcion, imagen);
        boolean proceso = false;
        if (nombre != null) {
            proceso = true;
            listaUsuarios.add(nuevoUsuario);
            escribirEnArchivoJuegos(listaUsuarios, file);
        }
        return proceso;
    }



}
