/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILIDADES;

import UTILIDADES.leeFichero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicent
 */
public class Conexion {
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    
    private String rdbms="sqlserver";
    private String db= "CARPINGEST";    
    private String url;
    public void Conexion() {}
    public Connection connecta(){ 
                //ArrayList<String> lineasConfig=new ArrayList();
                //lineasConfig=leeFichero.leeConfigServ();
		Connection connexio = null;
		//url="jdbc:"+rdbms+"://"+lineasConfig.get(0)+";databaseName="+lineasConfig.get(1)+";integratedSecurity=true";                
                url="jdbc:"+rdbms+"://MGSGESTION;databaseName="+ db +";integratedSecurity=true;authenticationScheme=NativeAuthentication";                
		try {
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Carrying  the driver
                    connexio = DriverManager.getConnection(url);
                   // connexio = DriverManager.getConnection(url, "poryectoVicent", "poryectoVicent");// Making the connection
                    System.out.println ( "Connexió realitzada amb éxit!" );
			
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();
			 JOptionPane.showMessageDialog(null, e, "ERROR EN CLASS", JOptionPane.ERROR_MESSAGE);
		}
		catch (SQLException e ){
			
			e.printStackTrace();
			 JOptionPane.showMessageDialog(null, e, "ERROR EN SQL", JOptionPane.ERROR_MESSAGE);
		}
		
		return connexio;
	}

    
}
