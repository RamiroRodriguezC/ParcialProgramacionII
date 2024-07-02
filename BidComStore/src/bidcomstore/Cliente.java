/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ramiro
 */
public class Cliente extends Usuario implements Serializable {

    private String CodigoUnico;
    private ArrayList<Pedido> pedidos;
    private String nombre;
    private String correo;
    //el programa no lo aclara, pero podria ser una clase |provincia |barrio |calle | numero |
    private String direccion;
    private String numeroTelefono;

    public Cliente() {
        setPedidos(new ArrayList<>());
    }
    
    
    
    
    @Override
    public boolean menu(SistemaBidCom sistema){
        char choice = 0;
        do{
            choice = EntradaSalida.leerCaracter(Constante.M_CL);
            switch(choice){ 
                case '1' -> EntradaSalida.mostrarMensaje(consultaPedidos());
                case '0' -> EntradaSalida.mostrarMensaje("");
            }
        }while(choice != '0');
        
        return true;
    }
    
    public void crearPedido(SistemaBidCom sistema){
        Pedido p = new Pedido();
        boolean seguir = false;
        do {
            Producto producto = sistema.buscarProducto(EntradaSalida.leerString("Ingrese el codigo de producto a agregar: "));
            if (producto != null) {
                Double precio = sistema.getListadeprecios().getPrecio(producto);
                int cant = EntradaSalida.leerEntero("Ingrese la cantidad del producto que desea solicitar: ");
                boolean despachado = sistema.getAlmacen().despacharProductos(producto,cant);
                if(despachado){
                    p.agregarItem(producto, cant, precio);
                } 
                }else{
                    EntradaSalida.mostrarAdvertencia("El producto elegido no existe");
                }
            seguir = EntradaSalida.leerBoolean("Desea agregar mas productos al pedido?");
        } while (seguir);
        if (!(p.getItems().isEmpty())) {
            p.registrarFechaHora();
            this.getPedidos().add(p);
        }else{
            EntradaSalida.mostrarAdvertencia("El pedido no se puedo crear exitosamente");
        }
        
    }
    
    public void bajaPedido(){
        
        consultaPedidos();
        int choice = EntradaSalida.leerEntero("Ingrese el pedido que desea eliminar: ") - 1;
        while(!(0 <= choice && choice <= pedidos.size())){
            EntradaSalida.mostrarAdvertencia("El pedido no existe");
            choice = EntradaSalida.leerEntero("Ingrese el pedido que desea eliminar: ");
        }
        
        pedidos.remove(choice);
    }
    
    public String consultaPedidos(){
        String s = Constante.SEPARADOR_1 + "Pedidos cliente [" + super.getUsername() + "]"+ Constante.SEPARADOR_2 +"\n";
        for (int i = 0; i < pedidos.size(); i++) {
            s += "["+(i+1)+"]\n" + getPedidos().get(i).toString() + Constante.SEPARADOR;
        }
        return s;
    }
    /**
     * GETTERS Y SETTERS
     */

    public String getCodigoUnico() {
        return CodigoUnico;
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    
    public void setCodigoUnico(String CodigoUnico) {
        this.CodigoUnico = CodigoUnico;
    }
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    /**
     * GETTERS Y SETTERS
     */
    @Override
    public String toString() {
        return "|Cliente| "+ super.toString()  +
                "\n\tID unico de cliente: " + getCodigoUnico() +
                "\n\tNombre: " + getNombre() +
                "\n\tCorreo Electronico: " + getCorreo() +
                "\n\tDireccion: " + getDireccion() +
                "\n\tTelefono: " + getNumeroTelefono() + "\n";
    }
    
}
