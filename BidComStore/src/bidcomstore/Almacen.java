/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ramiro
 */
public class Almacen implements Serializable {
    private Map<Producto, Integer> inventario;

    public Almacen() {
      this.inventario = new HashMap<>();
    }

    public void agregarExistencias(Producto producto, Integer inventario) {
        this.getInventario().put(producto, inventario);
    }

    public int getExistencias(Producto producto) {
      return this.getInventario().get(producto);
    }


    public Map<Producto, Integer> getInventario() {
        return inventario;
    }
    
    public void setInventario(Map<Producto, Integer> inventario) {
        this.inventario = inventario;
    }
    
    public void consultarExistencias(){
        for (Map.Entry<Producto, Integer> entry : inventario.entrySet()) {
            Producto producto = entry.getKey();
            Integer cantidad = entry.getValue();
            EntradaSalida.mostrarMensaje("Código de producto: " + producto.getCodigoDeProducto()+ ", Cantidad: " + cantidad);
        }
    }
    
    public boolean despacharProductos(Producto producto, int cant){
        boolean despachado = false;
        if (inventario.containsKey(producto)) {
            int existenciasActuales = inventario.get(producto);
        if (existenciasActuales >= cant) {
            int nuevasExistencias = existenciasActuales - cant;
            inventario.put(producto, nuevasExistencias);
            despachado = true;
        } else {
            EntradaSalida.mostrarAdvertencia("No hay suficientes existencias del producto " + producto.getNombre());
        }
    } else {
        EntradaSalida.mostrarAdvertencia("El producto " + producto.getNombre() + " no existe en el inventario");
    }
        return despachado;
    }
}
