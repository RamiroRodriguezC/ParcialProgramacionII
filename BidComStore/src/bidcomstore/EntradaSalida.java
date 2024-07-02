/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.util.Scanner;

/**
 *
 * @author Ramiro
 */
public class EntradaSalida {

    static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public static void mostrarAdvertencia(String mensaje){
            System.err.println("[X] " + mensaje);
    }
    
    public static void titulo(String titulo){
        EntradaSalida.mostrarMensaje(Constante.SEPARADOR_1 +  titulo + Constante.SEPARADOR_2);
    }
    
    //Lee una expresion String y la compara con un arreglo con expresiones que referencian a verdadero o falso
    public static boolean leerBoolean(String texto) {
        do {
        EntradaSalida.mostrarMensaje(texto);
        Scanner entradaEscaner = new Scanner(System.in);
        
        String linea = entradaEscaner.nextLine();
         // Comprobamos si la entrada es verdadera
        for (String verdadero : Constante.TRUE_EXPRESIONS) {
            if (linea.equalsIgnoreCase(verdadero)) {
                return true;
            }
        }

        // Comprobamos si la entrada es falsa
        for (String falso : Constante.FALSE_EXPRESIONS) {
            if (linea.equalsIgnoreCase(falso)) {
                return false;
            }
        }
        // Si no contiene una expresion registrada, solicita nuevamente el boolean
        EntradaSalida.mostrarAdvertencia("La expresion ingresada es invalida. Intente yes/no \n");
        } while (true);
    }

    public static String leerString(String texto){
        EntradaSalida.mostrarMensaje(texto);
        Scanner entradaEscaner = new Scanner(System.in);
        String linea = entradaEscaner.nextLine();
        return linea;
    }
    //LEE UN STRING E INTENTA RETORNAR UN ENTERO EN BASA EL Y EN CASO DE DAR ERROR VUELVE A PEDIRLO
    public static int leerEntero(String texto){
        EntradaSalida.mostrarMensaje(texto);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                EntradaSalida.mostrarAdvertencia("Entrada inválida. Por favor, ingrese un número decimal:");
            }
        }
    }
    
    //LEE UN STRING Y COMPRUEBA SI PUEDE PASARLO A DECIMAL, EN CASO DE NO PODER VOLVERA A PEDIRLO 
    public static double leerDecimal(String texto){
        EntradaSalida.mostrarMensaje(texto );
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                EntradaSalida.mostrarAdvertencia("Entrada inválida. Por favor, ingrese un número decimal:");
            }
        }
    }
    
    public static char leerCaracter(String texto) {
        EntradaSalida.mostrarMensaje(texto);
        Scanner entradaEscaner = new Scanner (System.in); 
        char caracter = entradaEscaner.next().charAt(0);
        return caracter;
    }
    
}
