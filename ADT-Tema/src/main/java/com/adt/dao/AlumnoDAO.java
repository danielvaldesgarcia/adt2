package com.adt.dao;

import com.adt.model.Alumno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

   public class AlumnoDAO {


    private Connection conexion;

    public AlumnoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Alumno> listar() throws SQLException {

        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            int idAlumno = rs.getInt("id_alumno");

            String nombreAlumno = rs.getString("nombre");

            String apellidos = rs.getString("apellidos");

            String email = rs.getString("email");


            String curso = rs.getString("curso");
            Alumno alumno = new Alumno(idAlumno,nombreAlumno,apellidos,email,curso);
            lista.add(alumno);
        }
        return lista;
    }
}
