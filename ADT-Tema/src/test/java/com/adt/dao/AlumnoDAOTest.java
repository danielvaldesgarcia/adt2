package com.adt.dao;

import com.adt.ConexionBD;
import com.adt.model.Alumno;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoDAOTest {

    @Test
    void listar() throws SQLException, ClassNotFoundException {
        AlumnoDAO dao = new AlumnoDAO(ConexionBD.conectar());
        List<Alumno> alumnos = dao.listar();
        System.out.println(alumnos);
    }
}