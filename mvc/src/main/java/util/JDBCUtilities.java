package util;

import java.io.File; //para comprobar si una bd esta vacia validando un peso de kb o b


//paquetes para asistir la conexion a la base de datos


import java.sql.DriverManager;// gestionar conexiones
import java.sql.Connection; //establecer conexiones
import java.sql.SQLException; //manejador de exepciones

public class JDBCUtilities {

    private static final String UBCACION_BD = "C:\\Garena Smart\\ProyectosConstruccion.db";

    //construir conexion con la base de datos

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:sqlite:"+ JDBCUtilities.UBCACION_BD;

        return DriverManager.getConnection(url);
    }

    //funcion para validar si estamos en una base de datos vacias -> SQLITE

    public static boolean estaVacia(){

        File archivos = new File(JDBCUtilities.UBCACION_BD);

        //salida diagnostico
        System.out.println("Lineas identificadas "+ archivos.length());
        return archivos.length() ==0; //validar si por lo menos la base de datos tiene peso
    }
}