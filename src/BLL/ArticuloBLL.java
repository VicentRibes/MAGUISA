/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ArticuloDAO;
import ENTIDAD.Articulo;
import ENTIDAD.Cliente;
import ENTIDAD.Componente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Informatica
 */
public class ArticuloBLL {
    public ArrayList <Articulo> listaArticulos(Articulo articulo,Cliente cliente) throws SQLException{
        return ArticuloDAO.obtenerArticulos(articulo,cliente);
    }
     public ArrayList <Articulo> listaArticulosAlias(Articulo articulo,Cliente cliente) throws SQLException{
        return ArticuloDAO.obtenerArticulos(articulo,cliente);
    }
    public ArrayList <Componente> listaComponentes(Articulo articulo) throws SQLException{
        return ArticuloDAO.obtenerComponentes(articulo);
    }
    public Articulo obtenerAlias (Articulo articulo,Cliente cliente, String accesorios) throws SQLException{
        return ArticuloDAO.obtenerAlias(articulo, cliente,accesorios);
    }
}
