/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.sun.tools.jconsole.JConsoleContext;
import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anave
 */
public class Configuracion {
    
    // Metodo para leer el valor de la tabla de configuración-------------
    public static String getValor(String clave){
        String sql = "Select valor from configuracion where clave = ?";
        Connection con = null;
        
        try {
            con  = Conexion.conectar();
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setString(1, clave);
            ResultSet rs = psd.executeQuery(); 
            if (rs.next()) return rs.getString("valor");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de configuración: " + ex.getMessage());
        } finally{
            Conexion.cerrarConexion(con);
        }
        return null;
    }
    
    // Metodo para guardar y actualizar el valor
    public static boolean setValor(String clave, String valor){
        String sql = "Insert into configuracion (clave, valor) Values (?,?)" +
            "ON conflict (clave) do update set valor = Excluded.valor";
        Connection con = null;
        try {
            con = Conexion.conectar();
            PreparedStatement psd = con.prepareStatement(sql);
            psd.setString(1, clave);
            psd.setString(2, valor);
            return psd.executeUpdate() > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error guadando la conf: " + ex.getMessage());
        } finally {
            Conexion.cerrarConexion(con);
        }
        return false;
    }
    
    //metodo para el manejo del IVA
    public static BigDecimal obtenerIVA(){
        String val = getValor("IVA");
        try {
            return new BigDecimal(val != null ? val : "15" ); 
        } catch (Exception e) {
            return new BigDecimal("15");
        }
    }
    
    public static boolean setIva(BigDecimal porcentaje) {
        return setValor("IVA", porcentaje.toPlainString());
    }
    
    //Nombre de la empresa para la facturacion
    public static String getEmpresaNombre() {
        String val = getValor("EMPRESA_NOMBRE");
        return val != null ? val : "Mi Empresa";
    }

    public static String getEmpresaRuc() {
        String val = getValor("EMPRESA_RUC");
        return val != null ? val : "";
    }
}

