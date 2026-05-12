/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalcv;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convertir una contraseña en texto plano a un hash SHA-256.
 * Verificar si una contraseña ingresada por el usuario coincide
 *    con el hash almacenado en la base de datos.
 * @author anave
 */
public class PasswordsCifradas {
    
    //Metodo ue recibe una contraseña y devuelve su hash SHA-256 en formato hexadecimal.
    public static String cifrado(String password){
        
        try {
            MessageDigest cifrado = MessageDigest.getInstance("SHA-256");
            byte[] bytes = cifrado.digest(password.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("SHA-256 no disponible", ex);
        }    
    }
    
    //Metodo  ue recibe una contraseña escrita por el usuario y el hash almacenado.
    //Devuelve true si ambos coinciden, o false si son diferentes.
    public static boolean verificar(String passwordPlano, String hashGuardado) {
        return cifrado(passwordPlano).equals(hashGuardado);
    }
}
