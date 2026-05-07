/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;
import java.sql.Connection;
/**
 *
 * @author ASUS VIVOBOOK
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = Conexion.conectar();

        if(con != null){

            System.out.println("🔥 Conexión exitosa");

        }else{

            System.out.println("💀 Error de conexión");

        }
    }
    
}
