/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTIDAD.FichajeOperarios;
import UTILIDADES.Conexion;
import UTILIDADES.Conexion2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author miguel
 */
public class FichajeOperariosDAO {
   /* private date fecha;
    fecha=fecha.getDay();*/
    
    public static ArrayList <FichajeOperarios> obtenerFichajeOperarios() throws SQLException{
    Connection conexion=null;
    Connection conexion2=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <FichajeOperarios> FichajeOperarios=new ArrayList();
        Conexion con=new Conexion();

        //java.util.Date fecha = new Date();
        
        //para saber la fecha actual
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        //System.out.println(formatoFecha.format(fechaActual));
        
        try {

            conexion = con.connecta();


           statement=conexion.prepareStatement("select codigo,nombre,HORA_ENTRADA,centro from "
            + "                               (SELECT op.codigo,op.nombre,F2.FECHA AS FECHA_ENTRADA,F2.HORA AS HORA_ENTRADA,F2.FECHA+f2.HORA AS FICHA_ENTRADA,centro.DESCRIP as CENTRO,"
            + "                                      (select top(1) f22.fecha "
            + "                                          from e001_fichajes2 as f22 where f22.OPERARIO=f2.OPERARIO and f22.tipo='S' and f22.recno>f2.recno order by f22.recno) AS FECHA_SALIDA,"
            + "                                      (select top(1) f22.hora "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and  f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno) AS HORA_SALIDA,"
            + "                                      (select top(1) f22.fecha "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and  f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno)+"
            + "                                      (select top(1) f22.hora "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno) as FICHA_SALIDA "
            + "                                FROM E001_OPERARIO as op left join e001_fichajes2 as f2 on op.codigo=f2.OPERARIO and f2.tipo='E' JOIN E001_centrost as centro on f2.CENTROTRAB=centro.CODIGO "
            + "                                 WHERE F2.FECHA='"+formatoFecha.format(fechaActual)+"' and f2.HORA=(select max(hora) from e001_fichajes2 as f22 where  f2.operario=f22.operario and f22.tipo='e' and f22.FECHA=f2.FECHA)) as a"
                    + "                     where FICHA_SALIDA is null "
         + "                                ORDER BY codigo");
            
           resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FichajeOperarios fiop=new FichajeOperarios();            
                fiop.setCodigo(resultSet.getString("CODIGO"));
                fiop.setNombre(resultSet.getString("NOMBRE"));
                fiop.setHora_Entrada(resultSet.getString("HORA_ENTRADA"));
                //fiop.setHora_Salida(resultSet.getString("HORA_SALIDA"));
                fiop.setCentro(resultSet.getString("CENTRO"));
                FichajeOperarios.add(fiop);
            }
            
            } catch (SQLException ex) {
                    System.out.println(ex);
                
            }
            return FichajeOperarios;
        
        
    }
    
    
    
    
 public static ArrayList <FichajeOperarios> obtenerFichajeOperariosSalida() throws SQLException{
Connection conexion=null;
Connection conexion2=null;

        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <FichajeOperarios> FichajeOperarios=new ArrayList();
        Conexion con=new Conexion();
        Conexion2 con2=new Conexion2();
        //java.util.Date fecha = new Date();
        
        //para saber la fecha actual
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        //System.out.println(formatoFecha.format(fechaActual));
        
        try {

            conexion = con.connecta();
            conexion2 =con2.connecta();
            /*
           statement=conexion.prepareStatement("select codigo,nombre,HORA_SALIDA,centro from "
            + "                               (SELECT op.codigo,op.nombre,F2.FECHA AS FECHA_ENTRADA,F2.HORA AS HORA_ENTRADA,F2.FECHA+f2.HORA AS FICHA_ENTRADA,centro.DESCRIP as CENTRO,"
            + "                                      (select top(1) f22.fecha "
            + "                                          from e001_fichajes2 as f22 where f22.OPERARIO=f2.OPERARIO and f22.tipo='S' and f22.recno>f2.recno order by f22.recno) AS FECHA_SALIDA,"
            + "                                      (select top(1) f22.hora "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and  f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno) AS HORA_SALIDA,"
            + "                                      (select top(1) f22.fecha "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and  f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno)+"
            + "                                      (select top(1) f22.hora "
            + "                                          from e001_fichajes2 as f22 "
            + "                                          where f22.OPERARIO=f2.OPERARIO and f22.tipo='S' and f22.recno>f2.recno "
            + "                                          order by f22.recno) as FICHA_SALIDA "
            + "                                FROM E001_OPERARIO as op left join e001_fichajes2 as f2 on op.codigo=f2.OPERARIO and f2.tipo='E' JOIN E001_centrost as centro on f2.CENTROTRAB=centro.CODIGO "
            + "                                 WHERE F2.FECHA='"+formatoFecha.format(fechaActual)+"' and f2.HORA=(select max(hora) from e001_fichajes2 as f22 where  f2.operario=f22.operario and f22.tipo='e' and f22.FECHA=f2.FECHA)) as a"
                   
                    + "                     where FICHA_SALIDA is not null or codigo not in(select codigo from CARPINGEST.dbo.e001_fichajes2 left join PRESENCIA.dbo.MAG_ANEXO_OPERARIOS as dp on operario=dp.codigo "
                   + "                                                                      where Departamento = '10' and CARPINGEST.dbo.e001_fichajes2.fecha='"+formatoFecha.format(fechaActual)+"'"
                   + "                                                                     group by codigo)");// ORDER BY codigo");
*/
                   
             statement=conexion.prepareStatement("select OP.CODIGO,OP.NOMBRE,isnull((select top(1) hora "
                     + "                                                             from e001_fichajes2 where operario=op.codigo and fecha='"+formatoFecha.format(fechaActual)+"' order by recno desc),'') AS HORA_SALIDA,"
                     + "                          isnull((select top(1) ct.DESCRIP from e001_fichajes2 as f2 LEFT JOIN E001_centrost as ct on f2.CENTROTRAB=ct.CODIGO "
                     + "                                  where f2.fecha='"+formatoFecha.format(fechaActual)+"' and f2.operario=op.codigo and f2.tipo='E' "
                     + "                                  order by f2.recno desc),'') as CENTRO "
                     + "                          from carpingest.dbo.E001_OPERARIO as op left join presencia.dbo.MAG_Anexo_Operarios as anexop on op.CODIGO=anexop.CODIGO "
                     + "                          WHERE OP.BAJA=0 AND ANEXOP.Departamento<>10 and "
                     + "                                  isnull((select top(1) tipo from e001_fichajes2 where operario=op.codigo and fecha='"+formatoFecha.format(fechaActual)+"' order by recno desc),'S')='S'");

                   
                   
                   
                   
           resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FichajeOperarios fiop=new FichajeOperarios();            
                fiop.setCodigo(resultSet.getString("CODIGO"));
                fiop.setNombre(resultSet.getString("NOMBRE"));
                //fiop.setHora_Entrada(resultSet.getString("HORA_ENTRADA"));
                fiop.setHora_Salida(resultSet.getString("HORA_SALIDA"));
                fiop.setCentro(resultSet.getString("CENTRO"));
                FichajeOperarios.add(fiop);
            }
            
            } catch (SQLException ex) {
                    System.out.println(ex);
                
            }
            return FichajeOperarios;
            
    }
 
     public static ArrayList <FichajeOperarios> obtenerFichajeOperariosInforme(String codigo,Date fecha) throws SQLException{
    Connection conexion=null;
        ResultSet resultSet;
        PreparedStatement statement;
        ArrayList <FichajeOperarios> FichajeOperarios=new ArrayList();
        Conexion con=new Conexion();
        //java.util.Date fecha = new Date();
        
        //para saber la fecha actual
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        //System.out.println(formatoFecha.format(fechaActual));
        
        try {

            conexion = con.connecta();
     

           
           statement=conexion.prepareStatement("select f2.hora,f2.tipo,centro.DESCRIP as CENTRO "
                   + "                          from E001_OPERARIO as op LEFT JOIN E001_Fichajes2 as f2 ON op.CODIGO=f2.OPERARIO JOIN E001_centrost as centro on f2.CENTROTRAB=centro.CODIGO "
                   + "                          where f2.tipo='e' and op.codigo='"+codigo+"' and f2.fecha='"+formatoFecha.format(fecha)+"' "
//                   + "                          where f2.tipo='e' and op.codigo='"+codigo+"' and f2.fecha='"+formatoFecha.format(fechaActual)+"' "
                   + "                          group by f2.hora,f2.tipo,centro.DESCRIP "
                   + "                          union "
                   + "                              select f2.hora,f2.tipo,centro.DESCRIP as CENTRO "
                   + "                              from E001_OPERARIO as op LEFT JOIN E001_Fichajes2 as f2 ON op.CODIGO=f2.OPERARIO JOIN E001_centrost as centro on f2.CENTROTRAB=centro.CODIGO "
                   + "                              where f2.tipo='s' and op.codigo='"+codigo+"' and f2.fecha='"+formatoFecha.format(fecha)+"' "
                   + "                              group by op.codigo,op.nombre,f2.fecha,f2.hora,f2.tipo,centro.DESCRIP");
           
           resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FichajeOperarios fiop=new FichajeOperarios();            

                fiop.setHora(resultSet.getString("hora"));
                fiop.setTipo(resultSet.getString("TIPO"));

                fiop.setCentro(resultSet.getString("CENTRO"));
                FichajeOperarios.add(fiop);
            }
            
            } catch (SQLException ex) {
                    System.out.println(ex);
                
            }
            return FichajeOperarios;
        
        
    }
}
