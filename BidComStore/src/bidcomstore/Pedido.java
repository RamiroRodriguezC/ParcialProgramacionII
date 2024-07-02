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
import java.util.ArrayList;
import java.util.Date;

public class Pedido implements Serializable {
    private Date fechaHoraCreacion;
    private String estado;
    private ArrayList<Item> items;

    public Pedido() {
        setItems(new ArrayList<>());
        this.estado = "en sucursal";
    }
    
    public void agregarItem(Producto producto, int cantidad, double precio) {
        Item item = new Item(producto, cantidad, precio);
        items.add(item);
    }

    public void registrarFechaHora() {
        this.fechaHoraCreacion = new Date();
    }
        
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    @Override
    public String toString() {
        String s = "";
        for (Item i : items) {
            s += i.toString();
        }
        s += "\n" + this.fechaHoraCreacion;
        s +=  "\n" + Constante.SEPARADOR;
        return s;
    }
    
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

class Item implements Serializable{
    private Producto producto;
    private int cantidad;
    private double precio;

    public Item(Producto producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return getProducto().toString() + "\n Precio: " + getPrecio() + "\n Unidades: " + getCantidad();
    }

    public Producto getProducto() {
        return this.producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    public double getPrecio() {
        return this.precio;
    }
}