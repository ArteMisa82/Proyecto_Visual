/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDatos;

/**
 *
 * @author anave
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String rol;
    private boolean activo;

    public Usuario(String nombre, String username, String password, String rol, boolean activo) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.activo = true;
    }
    
    public boolean Admin(){
        return "Admin".equals(rol);
    }
    
    public boolean Cajero(){
        return "Cajero".equals(rol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return nombre + " [" + rol + "]";
    }
    
}
