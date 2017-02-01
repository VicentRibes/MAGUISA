/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.Cliente;
import ENTIDAD.Orden;
import ENTIDAD.Proyecto;
import ENTIDAD.Usuario;
import UTILIDADES.CargandoEspere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Compiler.command;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Informatica
 */
public class OrdenDAO {
   
    public String nuevaOrden(Orden ord,Usuario us,Cliente cli, Proyecto pro)  throws  IOException, InterruptedException{
        
           
        String operacion="AddOrden";
        URL apiURL=null;
        
       // if(ord.getArticulo().getAlias()==null){
             apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades());        
       // }else{
             apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades());        
      //  }
      
      
        if(ord.getArticulo().getAlias()!=null && ord.getArticulo().getVariables()!=null){
            apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades()+"&p6="+ord.getArticulo().getVariables());        
        }else if(ord.getArticulo().getAlias()!=null && ord.getArticulo().getVariables()==null){
            apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p3="+ord.getArticulo().getAlias()+"&p5="+ord.getUnidades());        
        }else if(ord.getArticulo().getAlias()==null && ord.getArticulo().getVariables()!=null){
            apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades()+"&p6="+ord.getArticulo().getVariables());        
        }else{
            apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1="+ord.getEntrada()+"&p2=\\\\proyecto:"+pro.getNumero()+"\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"\\\\Almacen:"+ord.getAlmacen()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades());        
        }
        
        
        URLConnection apiURLCon=apiURL.openConnection();    
        System.out.println(apiURL);
     
        CargandoEspere cargando=new CargandoEspere("Cargando 1");
       
        cargando.start();
   
              
        //barra.iniciarHilo();        
    
        BufferedReader br=null;
        br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));     
       
       // barra.pararHilo(true);
        
        cargando.interrupt();
        String cadena;
        cadena=br.readLine();          
        return cadena;
    }
    
    public String nuevoPalet(Orden ord,Usuario us,Cliente cli,int cantidad) throws  IOException, InterruptedException{
        String operacion="AddOrden";
        CargandoEspere cargando=new CargandoEspere("Cargando 1");
        cargando.start();
        String cadena="";
       /*LOS ESPACIOS EN BLANCO EN LA URL TIENEN QUE SER AÑADIDOS CON CARACTER ESPECIAL %20*/
            System.out.println("palet ");
            
            URL apiURL=new URL("http://192.0.3.246/api/ordenes.php?usr="+us.getUsername()+"&pass="+us.getPassword()+"&op="+operacion+"&p1=-1&p2=\\\\cliente:"+cli.getCodigo()+"\\\\tipo:"+ord.getTipo()+"\\\\SerOrden:"+ord.getSerOrden()+"\\\\Estado:"+ord.getEstado()+"&p3="+ord.getArticulo().getAlias()+"&p4="+ord.getArticulo().getCodigo()+"&p5="+ord.getUnidades()+"&p6="+ord.getVariablesOrden());        
            URLConnection apiURLCon=apiURL.openConnection();                     

            BufferedReader br=null;
            br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));     
          
            cadena=cadena+"/"+br.readLine();   
                
               
        cargando.interrupt();       
                
        return cadena;
        
    }
    
    
}
