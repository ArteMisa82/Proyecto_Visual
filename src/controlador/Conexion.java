/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class Conexion {
    //Nombre del HOST o la IP donde esta La base PostgresSQL.
    private static final String HOST = "localhost";
    
    // Nombre de la base de datos
    private static final String BD = "xxxxxxxxx";

    // Usuario de PostgreSQL
    private static final String USER = "xxxxxxx";

    // Contraseña de PostgreSQL
    private static final String PASS = "xxxxxx";

    // URL de conexión
    private static final String URL =
            "jdbc:postgresql://" + HOST + ":5432/" + BD;

    public static Connection conectar() {

        Connection con = null;

        try {
            // Cargar driver
            Class.forName("org.postgresql.Driver");

            // Conexión
            con = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("✅ Conexión exitosa a PostgreSQL");

        } catch (ClassNotFoundException e) {

            System.out.println("❌ No se encontró el driver");
            System.out.println(e.getMessage());

        } catch (SQLException e) {

            System.out.println("❌ Error de conexión");
            System.out.println(e.getMessage());

        }

        return con;
    }
    
    public static void cerrarConexion(Connection con){
        if (con != null) {
            try {
                if (!con.isClosed()) con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar: " + ex.getMessage());
            }         
        }
    }
}
