package com.adt.dao;

import com.adt.model.Alumno;
import com.adt.model.Alumno;
import com.adt.model.Alumno;
import com.adt.model.Alumno;

import java.sql.*;
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
           while (rs.next()) {
               int idAlumno = rs.getInt("id_alumno");

               String nombreAlumno = rs.getString("nombre");

               String apellidos = rs.getString("apellidos");

               String email = rs.getString("email");


               String curso = rs.getString("curso");
               Alumno alumno = new Alumno(idAlumno, nombreAlumno, apellidos, email, curso);
               lista.add(alumno);
           }
           return lista;
       }


       public int insertar(Alumno alumno) throws SQLException {
           String sql = "INSERT INTO alumno(nombre,apellidos,email,curso) " + "VALUES (?,?,?,?)";
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setString(1, alumno.getNombre());
           ps.setString(2, alumno.getApellidos());
           ps.setString(3, alumno.getEmail());
           ps.setString(4, alumno.getCurso());
           int registrosAfectados = ps.executeUpdate();
           return registrosAfectados;
       }


       public Alumno buscarPorId(int id) throws SQLException {
           String sql = "SELECT * FROM alumno WHERE id_alumno = ?";
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setInt(1, id); // primer parametro ?
           ResultSet rs = ps.executeQuery();
           Alumno alumno = null;
           while (rs.next()) {
               int idAlumno = rs.getInt("id_alumno");
               System.out.println(idAlumno);
               String nombreAlumno = rs.getString("nombre");
               System.out.println(nombreAlumno);
               String apellidos = rs.getString("apellidos");
               System.out.println(apellidos);
               String email = rs.getString("email");
               String curso = rs.getString("curso");
               alumno = new Alumno(idAlumno, nombreAlumno, apellidos, email, curso);

           }
           return alumno;
       }

       public int actualizar(Alumno alumno) throws SQLException {

           String sql = "UPDATE alumno SET nombre=?, apellidos=?,email=?,curso=? " + "WHERE id_alumno=?";
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setString(1, alumno.getNombre());
           ps.setString(2, alumno.getApellidos());
           ps.setString(3, alumno.getEmail());
           ps.setString(4, alumno.getCurso());
           ps.setInt(5, alumno.getIdAlumno());
           int registrosAfectados = ps.executeUpdate();
           return registrosAfectados;
       }

       public int eliminar(int id) throws SQLException {

           String sql = "DELETE FROM alumno WHERE id_alumno = ?";
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setInt(1, id);
           int registrosAfectados = ps.executeUpdate();
           return registrosAfectados;

       }

       public List<Alumno> consultarAlumnosPorSector(String curso) throws SQLException {
           List<Alumno> alumnos = new ArrayList<>();
           String sql = "select * from alumno where curso = ?";
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setString(1, curso); // primer parametro ?
           ResultSet rs = ps.executeQuery();
           Alumno alumno = null;
           while (rs.next()) {
               alumno = new Alumno(
                       rs.getInt("id_alumno"),

                       rs.getString("nombre"),

                       rs.getString("apellidos"),

                       rs.getString("email"),

                       rs.getString("curso")


               );
               alumnos.add(alumno);

           }
           return alumnos;
       }


   }
