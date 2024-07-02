/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ramiro
 */
public class SistemaBidCom implements Serializable {
    
    private ArrayList<Usuario> usuarios;
    private ArrayList<Producto> productos;
    private Almacen almacen;
    private ListaDePrecios listadeprecios;
    

    public SistemaBidCom() {
        usuarios = new ArrayList<>();
        setListadeprecios(new ListaDePrecios());
        almacen = new Almacen();
        setProductos(new ArrayList<>());
    }
 
    public SistemaBidCom deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        SistemaBidCom s = (SistemaBidCom) o.readObject();
        o.close();
        f.close();
        return s;
    }
    
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();  
    }
 
    public Usuario buscarUsuario(String username){
        int i = 0;
        
        Usuario usuarioExistente = null;
        do {
            //si el usuario existe toma el val de ese usuario, si no nulo
            usuarioExistente = getUsuarios().get(i).getUsername().equals(username) ? getUsuarios().get(i) : null;
            i += 1;
        }while (i < getUsuarios().size() && usuarioExistente == null);
        return usuarioExistente;
    }
    
    public Cliente buscarClientePorID(String IDCliente) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) { //si el usuario que se ingreso es instancia de cliente, entonces sigue
                Cliente cliente = (Cliente) usuario; // castea usuario a cliente
                if (cliente.getCodigoUnico().equals(IDCliente)) {
                    return cliente; // si el id coincide retorna el cliente
                }
            }
    }
    // No se encontró el cliente con el ID proporcionado
    return null; 
    }
    
    //elimina un usuario siempre y cuando exista, no sea otro administrador o uno mismo
    public void eliminarUsuario(String username) {
        Usuario usuario = buscarUsuario(username);
        if (usuario == null) {
            EntradaSalida.mostrarAdvertencia("El usuario ingresado no existe ");
        }else{
            if(!(usuario instanceof AdministradorDelSistema)){
                if(EntradaSalida.leerBoolean("¿Esta seguro de que desea eliminar este usuario del sistema? \n Este proceso no es revertible: ")){
                    usuarios.remove(usuario);
                }
            }
            else{
                EntradaSalida.mostrarAdvertencia("No puedes eliminarte a ti mismo o a otro administrador");
            }
        }
    }
    
    public void crearProducto(){
        String codigo = EntradaSalida.leerString("Ingrese el codigo del producto: ");
        while(buscarProducto(codigo) != null){
            EntradaSalida.mostrarAdvertencia("El producto ya existe");
            codigo = EntradaSalida.leerString("Ingresa el codigo del producto: ");
        }
        String nombre = EntradaSalida.leerString("Ingresa el nombre del producto: ");
        
        String modelo = EntradaSalida.leerString("Ingresa el modelo: ");

        String descripcion = EntradaSalida.leerString("Ingrese la descripcion: ");
        
        Double precio = EntradaSalida.leerDecimal("Ingrese el precio del producto: ");
        
        Producto producto = new Producto(codigo, nombre, modelo, descripcion);
        
        getProductos().add(producto);
        
        getListadeprecios().agregarPrecio(producto, precio);

        // agregar el producto al arreglo de productos      
    }
    
    public Producto buscarProducto(String codigo) {
    for (Producto producto : getProductos()) {
        if (producto.getCodigoDeProducto().equals(codigo)) {
            return producto;
        }
    }
    return null;
}
    
    public void agregarExistenciasAlmacen(){
        Producto producto = buscarProducto(EntradaSalida.leerString("Ingrese el codigo de producto: "));
        if (producto != null) {
            int cantidad = EntradaSalida.leerEntero("Ingrese la cantidad de productos: ");
            if (getAlmacen().getInventario().containsKey(producto)) {
                cantidad +=  getAlmacen().getExistencias(producto);
            }
            getAlmacen().agregarExistencias(producto, cantidad);
        } else { 
            EntradaSalida.mostrarAdvertencia("Producto no encontrado");
        }
    }
    
    public void actualizarPrecio(){
        Producto producto = buscarProducto(EntradaSalida.leerString("Ingrese el codigo de producto: "));
        if (producto != null) {
            Double nuevoPrecio = EntradaSalida.leerDecimal("Ingrese el nuevo precio para el producto: ");
            getListadeprecios().agregarPrecio(producto, nuevoPrecio);
        }
    }

    public void consultarUsuarios(String tipoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getClass().getSimpleName().equals(tipoUsuario)) {
                EntradaSalida.mostrarMensaje(usuario.toString());
            }
        }
    }
    
    public void consultarUsuarios() {
        for (Usuario usuario : usuarios) {
            EntradaSalida.mostrarMensaje(usuario.toString());
        }
    }
    
    public void consultarProductos() {
        EntradaSalida.mostrarMensaje("|-------------Consulta Productos-------------| \n");
        for (Producto producto : productos) {
                EntradaSalida.mostrarMensaje(producto.toString());
                EntradaSalida.mostrarMensaje("|--------------------------------------------| \n");
        }
    }
    
    public void consultarPrecios() {
        EntradaSalida.mostrarMensaje("|-------------Consulta Precios-------------| \n");
        for (Producto producto : productos) {
                EntradaSalida.mostrarMensaje("| " + producto.getCodigoDeProducto() + " |" 
                                                  + "Precio: " + getListadeprecios().getPrecio(producto));
                EntradaSalida.mostrarMensaje("|--------------------------------------------| \n");
        }
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
     public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public Almacen getAlmacen() {
        return almacen;
    }
    public ListaDePrecios getListadeprecios() {
        return listadeprecios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    public void setListadeprecios(ListaDePrecios listadeprecios) {
        this.listadeprecios = listadeprecios;
    }
    
    
   
    
    
    
}
