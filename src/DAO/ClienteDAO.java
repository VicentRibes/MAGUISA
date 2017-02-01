/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Articulo;
import ENTIDAD.Cliente;
import UTILIDADES.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Informatica
 */
public class ClienteDAO {
     public static ArrayList <Cliente> obtenerClientes() throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Cliente> Clientes=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta();
        statement=conexion.prepareStatement("SELECT CODIGO,NOMBRE FROM E001_Clientes WHERE SEGCOM='022' OR CODIGO='0183' ORDER BY CODIGO");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Cliente cli=new Cliente();            
            cli.setCodigo(resultSet.getString("CODIGO"));
            cli.setNombre(resultSet.getString("NOMBRE"));                    
            Clientes.add(cli);
        }
        return Clientes;
     }
}
