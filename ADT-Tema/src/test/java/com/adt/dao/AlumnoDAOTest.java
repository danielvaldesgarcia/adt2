package com.adt.dao;

import com.adt.ConexionBD;
import com.adt.model.Alumno;
import com.adt.model.Empresa;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoDAOTest {

    @Test
    void listar() throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionBD.conectar();
        AlumnoDAO alumnoDAO = new AlumnoDAO(conexion);
        List<Alumno> listaEmpresas = alumnoDAO.listar();
        System.out.println(listaEmpresas);
    }

    @Test
    void insertar() throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = new AlumnoDAO(ConexionBD.conectar());
        Alumno alumno = new Alumno(8,"Julian SL","valdes","julian@julian.com","3");
        int registros = alumnoDAO.insertar(alumno);
        System.out.println(registros);
    }

    @Test
    void buscarPorId() throws SQLException, ClassNotFoundException {
        Connection connection = ConexionBD.conectar();
        AlumnoDAO alumnoDAO = new AlumnoDAO(connection);
        Alumno alumno = alumnoDAO.buscarPorId(3);
        System.out.println(alumno);
    }

    @Test
    void actualizar() throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = new AlumnoDAO(ConexionBD.conectar());
        Alumno alumno = new Alumno(2,"Julia","ramirez","7@gmail","3");
        alumnoDAO.actualizar(alumno);
    }

    @Test
    void eliminar() throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = new AlumnoDAO(ConexionBD.conectar());
        alumnoDAO.eliminar(3);
    }

    @Test
    void consultarAlumnosPorSector() throws SQLException, ClassNotFoundException {
        AlumnoDAO alumnoDAO = new AlumnoDAO(ConexionBD.conectar());
        List<Alumno> alumnos = alumnoDAO.consultarAlumnosPorSector("3");
        System.out.println(alumnos);
    }
}