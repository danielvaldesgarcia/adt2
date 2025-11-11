package com.adt;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adt.dao.EmpresaDAO;
import com.adt.model.Empresa;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */

        @Test
        void conexionBD() throws SQLException, ClassNotFoundException {

            assertNotNull(ConexionBD.conectar());

        }
        @Test
        void listarEmpresas() throws SQLException, ClassNotFoundException {

            Connection conexion = ConexionBD.conectar();
            EmpresaDAO empresaDAO = new EmpresaDAO(conexion);
            List<Empresa> listaEmpresas = empresaDAO.listar();
            System.out.println(listaEmpresas);




        }
        @Test
        void buscarPorId() throws SQLException, ClassNotFoundException {
            Connection connection = ConexionBD.conectar();
            EmpresaDAO empresaDAO = new EmpresaDAO(connection);
            Empresa empresa = empresaDAO.buscarPorId(1);
            System.out.println(empresa);
        }

        @Test
        void insertar() throws SQLException, ClassNotFoundException {
            EmpresaDAO empresaDAO = new EmpresaDAO(ConexionBD.conectar());
            Empresa empresa = new Empresa(4,"Julian SL","Alimentacion","7868595494","julian@julian.com","calle julian");
            int registros = empresaDAO.insertar(empresa);
            System.out.println(registros);
        }
        @Test
        void eliminar() throws SQLException, ClassNotFoundException {
            EmpresaDAO empresaDAO = new EmpresaDAO(ConexionBD.conectar());
            empresaDAO.eliminar(3);
        }
        @Test
        void actualizar() throws SQLException, ClassNotFoundException {
            EmpresaDAO empresaDAO = new EmpresaDAO(ConexionBD.conectar());
            Empresa empresa = new Empresa(2,"Julian SLU","Alimentacion","7868595494","julian@julian.com","calle julian");
            empresaDAO.actualizar(empresa);

        }

        @Test
        void buscarPorSector() throws SQLException, ClassNotFoundException {
            EmpresaDAO empresaDAO = new EmpresaDAO(ConexionBD.conectar());
            List<Empresa> empresas = empresaDAO.consultarEmpresasPorSector("Alimentacion");
            System.out.println(empresas);

        }



}
