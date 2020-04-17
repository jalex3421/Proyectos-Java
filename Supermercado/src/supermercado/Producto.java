/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion
 */
public class Producto {
    private int precio_producto; //atributo que representa el precio del producto  

    /**
    * Metodo constructor de la clase Producto  
     * @param precio_producto : representa el precio de los productos del carrito
    */
    public Producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }
    
    /*
    METODO GETTER
    */
    public int getprecio(){
        return precio_producto;
    }
    
    /*
    METODO SETTER
    */
    public void setprecio(int precio_nuevo){
        precio_producto= precio_nuevo; 
    }
}
