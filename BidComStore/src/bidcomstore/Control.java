/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.IOException;

/**
 *
 * @author Ramiro
 */

public class Control {

    public void ejecutar() {
        SistemaBidCom sistemaGestion = new SistemaBidCom();
        boolean seguir = false;
        try {
            sistemaGestion = sistemaGestion.deSerializar("BidCom.txt");
            EntradaSalida.titulo("Sistema de gestion de pedidos BidCom");
            seguir = EntradaSalida.leerBoolean("Desea ingresar?: ");
        }catch(Exception e){
            arranqueInicial(sistemaGestion);
            try{
                sistemaGestion.serializar("BidCom.txt");
            }catch (IOException ex) {
                ex.printStackTrace();
            }
            
            seguir = false;
        }
        
        while (seguir){
            seguir = iniciarSesion(sistemaGestion);
            try{
                sistemaGestion.serializar("BidCom.txt");
            }catch (IOException ex) {
                            ex.printStackTrace();
            }
            EntradaSalida.mostrarMensaje("Sesion cerrada correctamente");
        }
    }
    
    //PIDE USUARIO Y CONTRASEÑA, VALIDA QUE EL USUARIO EXISTA Y LA CONTRASEÑA COINCIDA
    private boolean iniciarSesion(SistemaBidCom sistemaGestion){
        
            EntradaSalida.mostrarMensaje(Constante.SEPARADOR_1 + "Inicio de sesion" + Constante.SEPARADOR_2);
            String username = EntradaSalida.leerString("Ingrese su nombre de usuario: ");

                Usuario u = sistemaGestion.buscarUsuario(username);

                if (u == null) {
                        EntradaSalida.mostrarAdvertencia("Nombre de usuario invalido.");
                } else {
                    String password = EntradaSalida.leerString("Ingrese su contraseña: ");
                    if (!u.getPassword().equals(password)) {
                        EntradaSalida.mostrarAdvertencia("La combinacion Usuario-Contraseña es incorreecta");
                    }else{
                       return u.menu(sistemaGestion);
                    }
                }
            boolean seguir = EntradaSalida.leerBoolean("Seguir en el sistema?: ");
            return seguir;
    }
    
    //REGISTRA AL PRIMER USUARIO (ADMINISTRADOR) CON USUARIO Y CONTRASEÑA
    private void arranqueInicial(SistemaBidCom sistema){
        String username = EntradaSalida.leerString("Arranque inicial del sistema .\n Sr/a Administrador/a, ingrese su nombre de usuario:");
            if (username.isEmpty()) {
                throw new NullPointerException("ERROR: El usuario no puede ser nulo.");
            }
            String password = EntradaSalida.leerString("Ingrese su password:");
            if (password.isEmpty()){
                throw new NullPointerException("ERROR: La password no puede ser nula.");
            }
            sistema.agregarUsuario(new AdministradorDelSistema(username, password));
            try {
                sistema.serializar("BidCom.txt");
                EntradaSalida.mostrarMensaje("El arranque ha sido exitoso. \n");
            } catch (IOException ex) {
            }
    }
}
