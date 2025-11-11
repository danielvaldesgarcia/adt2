package com.adt.dao;

import com.adt.model.Empresa;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpresaDAO {
    private Connection conexion;
    // Recibe la conexión de BD inicializada //
    public EmpresaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    // TODO: Listar todas las empresas
    public List<Empresa> listar() throws SQLException {

        List<Empresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            int idEmpresa = rs.getInt("id_empresa");
            System.out.println(idEmpresa);
            String nombreEmpresa = rs.getString("nombre");
            System.out.println(nombreEmpresa);
            String sector = rs.getString("sector");
            System.out.println(sector);
            String telefono = rs.getString("telefono");
            System.out.println(telefono);
            String email = rs.getString("email");
            String direccion = rs.getString("direccion");
            Empresa empresa = new Empresa(idEmpresa,nombreEmpresa,sector,telefono,email,direccion);
            lista.add(empresa);
        }
        return lista;
    }
    // TODO: Insertar una nueva empresa
    public int insertar(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO empresa(nombre,sector,telefono,email,direccion) " + "VALUES (?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,empresa.getNombre());
        ps.setString(2,empresa.getVector());
        ps.setString(3,empresa.getTelefono());
        ps.setString(4,empresa.getEmail());
        ps.setString(5,empresa.getDireccion());
        int registrosAfectados = ps.executeUpdate();
        return registrosAfectados;
    }
    // TODO: Buscar una empresa por su ID

    public Empresa buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM empresa WHERE id_empresa = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, id); // primer parametro ?
        ResultSet rs = ps.executeQuery();
        Empresa empresa = null;
        while(rs.next()){
            int idEmpresa = rs.getInt("id_empresa");
            System.out.println(idEmpresa);
            String nombreEmpresa = rs.getString("nombre");
            System.out.println(nombreEmpresa);
            String sector = rs.getString("sector");
            System.out.println(sector);
            String telefono = rs.getString("telefono");
            System.out.println(telefono);
            String email = rs.getString("email");
            String direccion = rs.getString("direccion");
            empresa = new Empresa(idEmpresa,nombreEmpresa,sector,telefono,email,direccion);

        }


        return empresa;
    }
    // TODO: Actualizar los datos de una empresa
    public int actualizar(Empresa empresa) throws SQLException {

        String sql = "UPDATE empresa SET nombre=?, sector=?,telefono=?,email=?,direccion=? " + "WHERE id_empresa=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,empresa.getNombre());
        ps.setString(2,empresa.getVector());
        ps.setString(3,empresa.getTelefono());
        ps.setString(4,empresa.getEmail());
        ps.setString(5,empresa.getDireccion());
        ps.setInt(6,empresa.getIdEmpresa());
        int registrosAfectados = ps.executeUpdate();
        return registrosAfectados;



    }
    // TODO: Eliminar una empresa por su ID
    public int eliminar(int id) throws SQLException {

        String sql = "DELETE FROM empresa WHERE id_empresa = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,id);
        int registrosAfectados = ps.executeUpdate();
        return registrosAfectados;

    }


    public List<Empresa> consultarEmpresasPorSector(String sector) throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "select * from empresa where sector = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, sector); // primer parametro ?
        ResultSet rs = ps.executeQuery();
        Empresa empresa = null;
        while(rs.next()){
            empresa = new Empresa(
            rs.getInt("id_empresa"),

            rs.getString("nombre"),

            rs.getString("sector"),

            rs.getString("telefono"),

            rs.getString("email"),
            rs.getString("direccion")


            );
            empresas.add(empresa);

        }

        return empresas;
    }
}
