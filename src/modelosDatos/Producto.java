/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDatos;

import java.math.BigDecimal;

/**
 *
 * @author anave
 */
public class Producto {
    /**
     * constructor los getters y setters 
     * ya el atributo para el codigo de barras
     */
    private int id;
    private String codigo;
    private String nombre;
    private String precio;
    private int stock;
    private String codigoBarras;
    private boolean activo;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String precio, int stock, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.activo = true;
    }
    
//    public boolean stock(int cantidad){
//        return this.stock(cantidad) >= cantidad;
//    }
//    
//    public BigDecimal calcularSubtotal(int cantidad){
//        return precio.multiply(BigDecimal.valueOf(cantidad));
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
