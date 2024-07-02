/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

/**
 *
 * @author Ramiro
 */
public class FactoriaDeUsuarios {
    public Usuario crearUsuario(String usuarioID,SistemaBidCom sistema) {
        Usuario u = null;
        try {
            u = (Usuario) Class.forName(this.getClass().getPackage().getName() + "." +
            usuarioID).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            EntradaSalida.mostrarAdvertencia(e.getMessage());
            return null;
        }
        
        u.setUsername(solicitarUsername("Ingrese el nombre de usuario: ",sistema));
        u.setPassword(solicitarPassword("Ingrese el password: "));

        if (u instanceof Cliente) {
            Cliente c = (Cliente) u;
            c.setCodigoUnico(solicitarIDcliente("Ingrese el ID unico de cliente: ", sistema));
            c.setNombre(solicitarNombre("Ingrese el nombre del cliente: "));
            c.setCorreo(solicitarCorreoElectronico("Ingrese el correo electronico"));
            c.setDireccion(solicitarDireccion("Ingrese la direccion: "));
            c.setNumeroTelefono(solicitarNumeroTelefono("Ingrese el numero telefonico"));
            return c;
        }else{
            EntradaSalida.mostrarMensaje(Constante.SEPARADOR_1 + "Usuario cargado" + Constante.SEPARADOR_2 
           + "\n" + u.toString() + "\n" + Constante.SEPARADOR + "\n");
            return u;
        }

    }
    //valida que el username no este tomado
    private static String solicitarUsername(String texto, SistemaBidCom sistema){
        String username = EntradaSalida.leerString(texto);
        while (username.isEmpty() || (sistema.buscarUsuario(username) != null)) {
            EntradaSalida.mostrarAdvertencia("El username es invalido o ya se encuentra en el sistema");
            username = EntradaSalida.leerString(texto);
        } 
        return username;
    }
    
    //valida que no este vacia
    private static String solicitarPassword(String texto){
        String password = EntradaSalida.leerString(texto);
        while (password.isEmpty()) {
            EntradaSalida.mostrarAdvertencia("password invalida");
            password = EntradaSalida.leerString(texto);
        } 
        return password;
    }
    
    //valida que el ID no exista y que no este vacio
    private static String solicitarIDcliente(String texto, SistemaBidCom sistema){
        String IDunico = EntradaSalida.leerString(texto);
        boolean IDexiste = false;
        while(sistema.buscarClientePorID(IDunico) != null){
            EntradaSalida.mostrarAdvertencia("el ID de cliente ingresado ya se encuentra en el sistema.");
            IDunico = EntradaSalida.leerString(texto);
        }
        return IDunico;
    }
    
    //momentaneamente no valida nada (solo que no este vacio)
    private static String solicitarNombre(String texto){
        String nombre = EntradaSalida.leerString(texto);
        while(nombre.isEmpty()){
            EntradaSalida.mostrarAdvertencia("el nombre ingresdo es invalido");
            nombre = EntradaSalida.leerString(texto);
        }
        return nombre;
    }
    
    //valida que contenga un @ y que no este ni al principio ni al final de la cadena
    private static String solicitarCorreoElectronico(String texto){
        String correo = EntradaSalida.leerString(texto);
        while(correo.isEmpty() || !correo.contains("@") || correo.indexOf('@') == 0 || correo.indexOf('@') == correo.length() - 1){
            EntradaSalida.mostrarAdvertencia("El correo ingresado es invalido");
            correo = EntradaSalida.leerString(texto);
        }
        return correo;
    }
    
    //momentaneamente no valida nada (solo que no este vacio)
    private static String solicitarDireccion(String texto){
        String direccion = EntradaSalida.leerString(texto);
        while(direccion.isEmpty()){
            EntradaSalida.mostrarAdvertencia("La direccion ingresada no es valida");
            direccion = EntradaSalida.leerString(texto);
        }
        return direccion;
    }
    
    //momentaneamente no valida nada (solo que no este vacio)
    private static String solicitarNumeroTelefono(String texto){
        String numeroTelefonico = EntradaSalida.leerString(texto);
        while(numeroTelefonico.isEmpty()){
            EntradaSalida.mostrarAdvertencia("El telefono ingresado no es valido");
            numeroTelefonico = EntradaSalida.leerString(texto);
        }
        return numeroTelefonico;
    }
    
    
    
    
}
