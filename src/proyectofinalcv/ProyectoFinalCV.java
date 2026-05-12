/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalcv;

import java.sql.*;
import controlador.Conexion;
import vistas.Login;
/**
 *
 * @author ASUS VIVOBOOK
 */
public class ProyectoFinalCV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // 1. Verificar que el driver está disponible
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado correctamente");
        } catch (Exception e) {
            System.out.println("Error cargando driver: " + e.getMessage());
            return;
        }

        // 2. Probar conexión a la BD antes de abrir la app
        Connection con = Conexion.conectar();
        if (con == null) {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "No se pudo conectar a la base de datos.\n" +
                "Verifique que PostgreSQL esté activo\n" +
                "y que los datos en Conexion.java sean correctos.",
                "Error de conexión",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        Conexion.cerrarConexion(con);

        // 3. Abrir pantalla de login
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    
}
