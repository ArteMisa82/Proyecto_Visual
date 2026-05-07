/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalcv;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class ProyectoFinalCV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver cargado correctamente");

    } catch (Exception e) {
        System.out.println(e);
    }
        
    }
    
}
