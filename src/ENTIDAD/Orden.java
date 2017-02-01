/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDAD;

/**
 *
 * @author Informatica
 */
public class Orden {
    private double entrada;
    private String tipo;
    private Proyecto proyecto;
    private String SerOrden;
    private String Estado;
    private Articulo Articulo;  
    private int Unidades;
    private String variablesOrden;
    private String almacen;
    
    
    public Orden() {
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerOrden() {
        return SerOrden;
    }

    public void setSerOrden(String SerOrden) {
        this.SerOrden = SerOrden;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Articulo getArticulo() {
        return Articulo;
    }

    public void setArticulo(Articulo Articulo) {
        this.Articulo = Articulo;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
    }

    public String getVariablesOrden() {
        return variablesOrden;
    }

    public void setVariablesOrden(String variablesOrden) {
        this.variablesOrden = variablesOrden;
    }

   
    
    
    
}
