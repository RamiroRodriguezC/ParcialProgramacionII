/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bidcomstore;
/**
 * 
 *
 * @author Ramiro
 */
public class Main {
    public static void main(String[] args) {
        //MAIN
        Control c = new Control();
        try {
            c.ejecutar();
        } catch (NullPointerException e) {
            EntradaSalida.mostrarMensaje(e.getMessage());
        }
    }
}
