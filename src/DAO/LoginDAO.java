/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ASUS VIVOBOOK
 */

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelosDatos.Usuario;
import proyectofinalcv.PasswordsCifradas;

public class LoginDAO {

    public Usuario login(String usuario, String password){
        
        String hashPassword = PasswordsCifradas.cifrado(password);
        String sql =
        "SELECT usuarios.id, usuarios.nombre, usuarios.username, " +
        "usuarios.password, roles.nombre AS rol " +
        "FROM usuarios, roles " +
        "WHERE usuarios.id_rol = roles.id " +
        "AND usuarios.username = ? " +
        "AND usuarios.password = ? " +
        "AND usuarios.activo = TRUE";
        
        Connection con = null;
        
        try{

            con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, hashPassword);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Usuario u = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    true
                );

                u.setId(rs.getInt("id"));

                return u;
             
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "Error de login: " + e.getMessage());
        } finally{
            Conexion.cerrarConexion(con);
        }

        return null;
    }
    
    public boolean loginSimple(String usuario, String passwordPlano) {
        return login(usuario, passwordPlano) != null;
    }
}