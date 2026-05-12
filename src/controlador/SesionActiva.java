/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelosDatos.Usuario;

/**
 *
 * @author anave
 */
public class SesionActiva {
    
    private static Usuario usuarioLogueado = null;
    
    public static void setUsuario(Usuario u) {
        usuarioLogueado = u;
    }

    public static Usuario getUsuario() {
        return usuarioLogueado;
    }

    public static boolean esAdmin() {
        return usuarioLogueado != null && usuarioLogueado.Admin();
    }

    public static boolean esCajero() {
        return usuarioLogueado != null && usuarioLogueado.Cajero();
    }

    public static boolean haySesion() {
        return usuarioLogueado != null;
    }

    public static void cerrarSesion() {
        usuarioLogueado = null;
    }
}
