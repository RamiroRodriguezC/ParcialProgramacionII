/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

/**
 *
 * @author Ramiro
 */
public class Constante {
    
    public static final String[] TRUE_EXPRESIONS = {"yes", "y", "si", "t", "true", "v", "verdadero", "1"};
    public static final String[] FALSE_EXPRESIONS = {"no", "n", "f", "false", "falso", "0"};
    
    public static final String SEPARADOR_1 = "O-O ==========|";
    public static final String SEPARADOR_2 = "|========== O-O";
    public static final String SEPARADOR = "=================================================";
    
    //MENU ADMINISTRADOR
    public static final String MENU_ADM =   SEPARADOR_1 + "Menu de administrador" + SEPARADOR_2 + "\n"+
                                            "[1] Gestion usuarios"      + "\n" +
                                            "[2] Gestion de productos"  + "\n" +
                                            "[3] Consulta de sistema"   + "\n" +
                                            "[4] Cerrar Sesion "        + "\n" +
                                            "[0] Salir del sistema"     + "\n";
    //SUBMENUES ADMINISTRADOR
    public static final String SM_ALTA_AU = SEPARADOR_1 + "Alta Usuarios" + SEPARADOR_2 + "\n"+
                                            "[1] Alta administrador"    + "\n" +
                                            "[2] Alta representante"    + "\n" +
                                            "[3] Alta cliente"          + "\n" +
                                            "[4] Baja usuarios"          + "\n" +
                                            "[0] volver"                + "\n" ;
    
    public static final String SM_ALTA_GP = SEPARADOR_1 + "Gestion productos" + SEPARADOR_2 + "\n"+
                                            "[1] Alta producto"          + "\n" +
                                            "[2] Agregar existencias a almacen"      + "\n" +
                                            "[3] Actualizar precio"      + "\n" +
                                            "[0] volver"                 + "\n" ;
    
    public static final String SM_ADM_CS = SEPARADOR_1 + "Consultas sistemas" + SEPARADOR_2 + "\n"+
                                            "[1] Consulta Usuarios"        + "\n" +
                                            "[2] Consulta Clientes"        + "\n" +
                                            "[3] Consulta administradores" + "\n" +
                                            "[4] Consulta Representantes"  + "\n" +
                                            "[5] Consulta Producto      "  + "\n" +
                                            "[6] Existencias en almacen"   + "\n" +
                                            "[7] Lista de precios    "     + "\n" +
                                            "[0] volver"                   + "\n" ;
    
    public static final String MENU_RPR = SEPARADOR_1 + "Menu de representante de ventas " + SEPARADOR_2 + "\n"+
                                            "[1] Gestion pedidos"          + "\n" +
                                            "[2] Gestion clientes"         + "\n" +
                                            "[3] Consulta sistema"         + "\n" +
                                            "[0] Cerrar sesion"            + "\n" ;
    
    public static final String SM_RPR_GP = SEPARADOR_1 + "Gestion pedidos" + SEPARADOR_2 + "\n"+
                                            "[1] Crear pedidos"            + "\n" +
                                            "[2] Dar pedido de baja"       + "\n" +
                                            "[0] volver"                   + "\n" ;
    
    public static final String SM_RPR_GC = SEPARADOR_1 + "Gestion clientes" + SEPARADOR_2 + "\n"+
                                            "[1] Crear cliente"            + "\n" +
                                            "[2] Baja  cliente"            + "\n" +
                                            "[0] volver"                   + "\n" ;
    
    public static final String SM_RPR_CS = SEPARADOR_1 + "Consulta sistema" + SEPARADOR_2 + "\n"+
                                            "[1] Consulta clientes"        + "\n" +
                                            "[2] Consulta pedido de cliente"+ "\n" +
                                            "[0] volver"                   + "\n" ;
    
    //MENU CLIENTE
    public static final String M_CL = SEPARADOR_1 + "Consulta sistema" + SEPARADOR_2 + "\n"+
                                            "[1] Consulta pedidos "        + "\n" +
                                            "[0] volver"                   + "\n" ;
                            
    
            
}
