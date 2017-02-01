/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ClienteDAO;
import ENTIDAD.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Informatica
 */
public class ClienteBLL {
    public ArrayList <Cliente> listaClientes() throws SQLException{
        return ClienteDAO.obtenerClientes();
        
    }
}
