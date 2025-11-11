package com.adt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public
class ConexionBD {
    // TODO: Cambiar el nombre de la base de datos según el proyecto
    private
    static
    final
    String URL =
            "jdbc:mysql://localhost:3306/adt-bd?serverTimezone=UTC"
            ;
    // TODO: Comprobar usuario y contraseña del servidor MySQL
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "CasaMorada05";
    // TODO: Crear método para conectar con la base de datos
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        // 1️⃣ Registrar el driver (opcional en JDBC 4.0+)
        Class.forName("com.mysql.cj.jdbc.Driver");

// 2️⃣  Establecer conexión
        conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        System.out.println("✅ Conexión establecida correctamente.");


        // TODO: Registrar el driver JDBC de MySQL (opcional desde JDBC 4.0)
// TODO: Establecer conexión usando la clase DriverManager
        // TODO: Devolver el objeto Connection si se conecta correctamente
        return conexion;
    }
}