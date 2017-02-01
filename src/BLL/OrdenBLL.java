/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.OrdenDAO;
import ENTIDAD.Cliente;
import ENTIDAD.Orden;
import ENTIDAD.Proyecto;
import ENTIDAD.Usuario;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author Informatica
 */
public class OrdenBLL {
    OrdenDAO ordenDAO;
    public OrdenBLL(){
        ordenDAO=new OrdenDAO();
    }
    public String nuevaOrden(Orden ord,Usuario us,Cliente cli,Proyecto pro) throws IOException, InterruptedException{
        return ordenDAO.nuevaOrden(ord,us,cli,pro);
    }
    public String nuevoPalet(Orden ord,Usuario us,Cliente cli,int cantidad) throws IOException, InterruptedException{
        return ordenDAO.nuevoPalet(ord,us,cli,cantidad);
    }
}
