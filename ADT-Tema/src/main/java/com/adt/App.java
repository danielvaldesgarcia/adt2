package com.adt;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hello World!");
        ConexionBD.conectar();
    }
}
