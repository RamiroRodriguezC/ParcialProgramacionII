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
public class ListaDePrecios implements Serializable {
    private final Map<Producto, Double> precios;

    public ListaDePrecios() {
      this.precios = new HashMap<>();
    }

    public void agregarPrecio(Producto producto, double precio) {
      this.precios.put(producto, precio);
    }

    
    public double getPrecio(Producto producto) {
      return this.precios.get(producto);
    }
}
