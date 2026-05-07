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

public class LoginDAO {

    public boolean login(String usuario, String password){

        String sql =
        "SELECT * FROM usuarios " +
        "WHERE username = ? " +
        "AND password = ? " +
        "AND activo = TRUE";

        try{

            Connection con = Conexion.conectar();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return true;

            }

        }catch(Exception e){

            System.out.println(e);

        }

        return false;
    }
}