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
public class RepresentanteDeVentas extends Usuario implements Serializable {
    public RepresentanteDeVentas() {
    
    }
    
    @Override
    public boolean menu(SistemaBidCom sistema){
        char choice = 0, subchoice = 0;
        do{
            choice = EntradaSalida.leerCaracter(Constante.MENU_RPR);
            switch(choice){ 
                    //GESTION PEDIDOS
                    case '1':
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_RPR_GP);
                            switch(subchoice){
                                case '1':
                                    try{
                                        Cliente cliente = sistema.buscarClientePorID(EntradaSalida.leerString("Ingrese el codigo de cliente: "));
                                        cliente.crearPedido(sistema);
                                    }catch(Exception e){
                                        EntradaSalida.mostrarAdvertencia("El cliente ingresado no existe");
                                    }
                                    break;
                                case '2':
                                    try{
                                        Cliente cliente = sistema.buscarClientePorID(EntradaSalida.leerString("Ingrese el codigo de cliente: "));
                                        cliente.bajaPedido();
                                    }catch(Exception e){
                                        EntradaSalida.mostrarAdvertencia("El cliente ingresado no existe");
                                    }
                                    break;
                                case '0': EntradaSalida.mostrarMensaje("");
                                    break;
                            }
                        }while ('0' != subchoice);
                        break;
                    //GESTION CLIENTES
                    case '2':
                        FactoriaDeUsuarios f = new FactoriaDeUsuarios();
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_RPR_GC);
                            switch(subchoice){
                                case '1' -> sistema.agregarUsuario(f.crearUsuario("Cliente", sistema));
                                case '2' -> sistema.eliminarUsuario(EntradaSalida.leerString("Ingrese el username del usuario que desea eliminar: "));
                                case '0' -> EntradaSalida.mostrarMensaje("");
                            }
                        }while(subchoice != '0');
                        break;
                    //CONSULTA SISTEMA
                    case '3':
                        do {
                            subchoice = EntradaSalida.leerCaracter(Constante.SM_RPR_CS);
                            switch(subchoice){
                                case '1': 
                                        sistema.consultarUsuarios("Cliente");
                                        break;
                                case '2':   
                                    try{
                                        Cliente cliente = sistema.buscarClientePorID(EntradaSalida.leerString("Ingrese el codigo de cliente: "));
                                        EntradaSalida.mostrarMensaje(cliente.consultaPedidos());
                                        
                                    }catch(Exception e){
                                        EntradaSalida.mostrarAdvertencia("El cliente ingresado no existe ");
                                    }
                                    break;
                                case '0': EntradaSalida.mostrarMensaje("");
                                    break;
                            }
                        }while(subchoice != '0');
                        break;
                    case '0': EntradaSalida.mostrarMensaje(""); 
                    break;
                    }
        }while(choice != '0');               
        return true;
    }
    
    @Override
    public String toString() {
        return "|Representante| "+ super.toString() + "\n" ;
    }
    
}
