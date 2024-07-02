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
public class AdministradorDelSistema extends Usuario implements Serializable{

    public AdministradorDelSistema(String username, String password) {
        super(username,password);
    }
    public AdministradorDelSistema() {
    
    }
    @Override
    public boolean menu(SistemaBidCom sistema){
        boolean seguir = true;
        char choice = 0, subchoice = 0;
        do{
            choice = EntradaSalida.leerCaracter(Constante.MENU_ADM);
            switch(choice){
                    //GESTION USUARIOS
                    case '1': 
                        FactoriaDeUsuarios f = new FactoriaDeUsuarios();
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_ALTA_AU);
                            switch(subchoice){
                                case '1' -> sistema.agregarUsuario(f.crearUsuario("AdministradorDelSistema", sistema));
                                case '2' -> sistema.agregarUsuario(f.crearUsuario("RepresentanteDeVentas", sistema));
                                case '3' -> sistema.agregarUsuario(f.crearUsuario("Cliente", sistema));
                                case '4' -> sistema.eliminarUsuario(EntradaSalida.leerString("Ingrese el username del usuario que desea eliminar: "));
                                case '0' -> EntradaSalida.mostrarMensaje("");
                            }
                        } while (subchoice != '0');
                        break;
                    //GESTION PRODUCTOS
                    case '2':   
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_ALTA_GP);
                            switch(subchoice){
                                case '1' -> sistema.crearProducto();
                                case '2' -> sistema.agregarExistenciasAlmacen();
                                case '3' -> sistema.actualizarPrecio();
                                case '0' -> EntradaSalida.mostrarMensaje("");
                            }
                        } while (subchoice != '0');
                        break;
                    //CONSULTAS SISTEMA
                    case '3':
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_ADM_CS);
                            switch(subchoice){
                                case '1' -> sistema.consultarUsuarios();
                                case '2' -> sistema.consultarUsuarios("Cliente");
                                case '3' -> sistema.consultarUsuarios("AdministradorDelSistema");
                                case '4' -> sistema.consultarUsuarios("RepresentanteDeVentas");
                                case '5' -> sistema.consultarProductos(); 
                                case '6' -> sistema.getAlmacen().consultarExistencias();
                                case '7' -> sistema.consultarPrecios();
                                case '0' -> EntradaSalida.mostrarMensaje("");
                            }
                        } while (subchoice != '0');
                        break;
                    //VOLVER A INICIO
                    case '4': 
                        seguir = true;
                        break;
                    //SALIR DEL SISTEMA
                    case '0': 
                        seguir = false;
                        break;    
            }
        }while(choice != '0' && choice != '4');
        return seguir;
    }
    
    
    
    
    @Override
    public String toString() {
        return "|Administrador| "+ super.toString() + "\n" ;
    }
}
