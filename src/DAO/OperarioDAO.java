/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Operario;
import UTILIDADES.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class OperarioDAO {
         public static ArrayList <Operario> obtenerOperarios() throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Operario> Operarios=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta();
        statement=conexion.prepareStatement("SELECT CODIGO,NOMBRE FROM E001_OPERARIO");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Operario op=new Operario();            
            op.setCodigo(resultSet.getString("CODIGO"));
            op.setNombre(resultSet.getString("NOMBRE"));                    
            Operarios.add(op);
        }
        return Operarios;
     }
}
