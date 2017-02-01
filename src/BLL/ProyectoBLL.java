/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ProyectoDAO;
import ENTIDAD.Proyecto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class ProyectoBLL {
    public ArrayList <Proyecto> listaProyectos() throws SQLException{
        return ProyectoDAO.obtenerProyectos();
    }
}
