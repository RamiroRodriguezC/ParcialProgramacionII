/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.Serializable;

/**
 *
 * @author Ramiro
 */
public class Producto implements Serializable{
    private String codigoDeProducto;
    private String nombre;
    private String modelo;
    private String descripcion;

    public Producto(String codigoDeProducto, String nombre, String modelo, String descripcion) {
        setCodigoDeProducto(codigoDeProducto);
        setNombre(nombre);
        setModelo(modelo);
        setDescripcion(descripcion);
    }

    
    
    public String getCodigoDeProducto() {
        return codigoDeProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getModelo() {
        return modelo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigoDeProducto(String codigoDeProducto) {
        this.codigoDeProducto = codigoDeProducto;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return   "codigo: "         + getCodigoDeProducto() 
                + "\n  nombre: "    + getNombre()
                + "\n  modelo: "    + getModelo()  
                + "\n  descripcion: " + getDescripcion();
    }
    
    
    
}
