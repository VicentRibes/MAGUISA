/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.UsuarioDAO;
import ENTIDAD.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Informatica
 */
public class UsuarioBLL {
    UsuarioDAO usuarioDAO;
    public UsuarioBLL(){
        usuarioDAO=new UsuarioDAO();
    }
    public Usuario obtenerUsuario() throws SQLException{
        return usuarioDAO.obtenerUsuario();
        
    }
}
