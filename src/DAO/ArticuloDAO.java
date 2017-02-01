/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Articulo;
import ENTIDAD.Cliente;
import ENTIDAD.Componente;
import UTILIDADES.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Informatica
 */
public class ArticuloDAO {
    public static ArrayList <Articulo> obtenerArticulos(Articulo articulo, Cliente cli) throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Articulo> Articulos=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta();
        statement=conexion.prepareStatement("SELECT art.codigo,art.DESCRIP,art.TIPOLOGIA FROM E001_articul as art "+
                                            "WHERE art.FAMILIA='"+ articulo.getFamilia() +"'");      
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Articulo art=new Articulo();            
            art.setCodigo(resultSet.getString("CODIGO"));
            art.setDescrip(resultSet.getString("DESCRIP"));
            art.setTipologia(resultSet.getString("TIPOLOGIA"));           
            Articulos.add(art);
        }
        return Articulos;
    }
    public static ArrayList <Articulo> obtenerArticulosAlias(Articulo articulo, Cliente cli) throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Articulo> Articulos=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta();
        statement=conexion.prepareStatement("SELECT art.codigo,art.DESCRIP,alias.ALIAS,art.TIPOLOGIA FROM E001_articul as art left join E001_AliasArt as alias ON art.codigo=alias.ARTICULO "+
                                            "WHERE alias.CLIENTE='"+ cli.getCodigo() +"' AND art.FAMILIA='"+ articulo.getFamilia() +"'");      
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Articulo art=new Articulo();
            art.setAlias(resultSet.getString("ALIAS"));
            art.setCodigo(resultSet.getString("CODIGO"));
            art.setDescrip(resultSet.getString("DESCRIP"));
            art.setTipologia(resultSet.getString("TIPOLOGIA"));           
            Articulos.add(art);
        }
        return Articulos;
    }
    
    public static ArrayList <Componente> obtenerComponentes(Articulo art) throws SQLException{
        Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <Componente> componentes=new ArrayList();
        Conexion con=new Conexion();
        conexion=con.connecta(); 
        statement=conexion.prepareStatement("SELECT comp.componente,comp.unidades FROM E001_Compon as comp "+
                                            "WHERE comp.ARTICULO='"+ art.getCodigo() +"' AND PACKED=1");      
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Componente comp=new Componente();
            comp.setCodigo(art.getCodigo());
            comp.setComponente(resultSet.getString("COMPONENTE"));
            comp.setUdComponente(resultSet.getInt("unidades"));                  
            componentes.add(comp);
        }
        
        return componentes;
    }
    
    public static Articulo obtenerAlias (Articulo art,Cliente cli, String accesorios) throws SQLException{
        Connection conexion=null;
        ResultSet resultSet = null;
        PreparedStatement statement;
        Conexion con=new Conexion();
        conexion=con.connecta(); 
        statement=conexion.prepareStatement("SELECT al.alias FROM E001_AliasArt as al "+
                                            "WHERE al.ARTICULO='"+ art.getCodigo() +"' AND CLIENTE='"+ cli.getCodigo() +"' AND PASOVAR='" + accesorios +"'");      
        resultSet = statement.executeQuery();
        if(resultSet.next()) {           
            art.setAlias(resultSet.getString("ALIAS"));
           
            
        }
        return art;
    }
}
