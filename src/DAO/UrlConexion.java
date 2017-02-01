/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Informatica
 */
public class UrlConexion {
    public String UrlConexion(Object o) throws MalformedURLException, IOException{        
                
        URL apiURL=new URL("http://192.0.3.246/api/ordenes2.php?usr=Informatic&pass=d7358i&op=AddOrden&p1=-1&p2=\\cliente:0183\\tipo:I\\SerOrden:I\\Estado:K&p4=04458&p5=150");
        URLConnection apiURLCon=apiURL.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(apiURLCon.getInputStream()));
        String cadena;
        cadena=br.readLine();
        return cadena;    
        
    }
}
