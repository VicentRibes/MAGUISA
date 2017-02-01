/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.OperarioDAO;
import ENTIDAD.Operario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class OperarioBLL {
        public ArrayList <Operario> listaOperarios() throws SQLException{
        return OperarioDAO.obtenerOperarios();
        
    }
}
