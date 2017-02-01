/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDAD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author miguel
 */
public class FichajeOperarios {
    private String Codigo;
    private String Nombre;
    private String Ficha_inicio;
    private String Ficha_fin;
    private String Fecha;      
    private String Hora;
    private String Hora_Entrada;
    private String Hora_Salida;
    private String Fecha_Entrada;
    private String Fecha_Salida;

    public String getHora_Entrada() {
        return Hora_Entrada;
    }

    public void setHora_Entrada(String Hora_Entrada) {
        this.Hora_Entrada = Hora_Entrada;
    }

    public String getHora_Salida() {
        return Hora_Salida;
    }

    public void setHora_Salida(String Hora_Salida) {
        this.Hora_Salida = Hora_Salida;
    }

    public String getFecha_Entrada() {
        return Fecha_Entrada;
    }

    public void setFecha_Entrada(String Fecha_Entrada) {
        this.Fecha_Entrada = Fecha_Entrada;
    }

    public String getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(String Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }
    private String Tipo;
    private String Centro;
//    Date dat=new Date();
//    DateFormat hora=new SimpleDateFormat("HH:mm:ss");
    public FichajeOperarios(){}
    
    public String getNombre() {
        return Nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCentro() {
        return Centro;
    }

    public void setCentro(String Centro) {
        this.Centro = Centro;
    }

    public String getFicha_inicio() {
        return Ficha_inicio;
    }

    public void setFicha_inicio(String Ficha_inicio) {
        this.Ficha_inicio = Ficha_inicio;
    }

    public String getFicha_fin() {
        return Ficha_fin;
    }

    public void setFicha_fin(String Ficha_fin) {
        this.Ficha_fin = Ficha_fin;
    }
    
}
