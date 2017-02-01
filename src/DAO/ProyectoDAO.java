/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import ENTIDAD.Proyecto;
import UTILIDADES.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class ProyectoDAO {
    public static ArrayList <Proyecto> obtenerProyectos() throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Proyecto> Proyectos=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta();
        statement=conexion.prepareStatement("SELECT pro.numero,pro.DESCRIP FROM E001_proyecto as pro");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Proyecto pro=new Proyecto(); 
            pro.setNumero(resultSet.getString("numero"));
            pro.setDesc(resultSet.getString("DESCRIP"));          
            Proyectos.add(pro);
        }
        return Proyectos;
    }
}
