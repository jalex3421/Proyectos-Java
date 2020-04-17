/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.ArrayList;

/**
  * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion
 */
public class Carrito {
   private int tiempoEntradaCaja; //simula el tiempo de entrada a la zona de cobro del carrito
   private int numproductos;  //representa la cantidad de número de productos que posee el carrito 
   private ArrayList <Producto> mi_carrito;  //se propone un carrito como un arraylist de productos. 
   private int precio;
   
   /**
    * Metodo constructor de la clase carrito1
    *En la primera iteracion, el numero de productos que se pase sera de 1.  
    * @param numero_productos_medio
     * @param Precio : representa el precio medio de los productos del carrito
    */
  public Carrito(int numero_productos_medio, int Precio){
      this.numproductos = (int)(-numero_productos_medio*Math.log(1-Math.random())+1);
      this.mi_carrito = new ArrayList(); 
      if(numproductos<1){
          numproductos = 1;
      }
      for(int i = 0; i<numproductos; i++){
          precio = (int)(-Precio*Math.log(1-Math.random()));
          mi_carrito.add(new Producto(precio));
      }
     
  }
 
  /**
     * metodo cobrarProducto 
     * MODIFICACION: eliminamos el primer elemento de nuestro ArrayList
     *si se ha cobrado, producto ya no esta en nuestro carrito 
     */
  public void cobrarProducto(){
      try{
          mi_carrito.remove(0);
      } 
      catch(Exception e){
          System.out.println("Tratando de cobrar, cuando no hay productos disponibles");
      }
      numproductos--; 
  }
   
    /**
     * metodo setTiempoEntradaZonaCobro 
     * Fija el tiempo en que entra el carrito en la zona de cobro 
     * @param tiempoAhora tiempo de entrada
     */
    public void setTiempoEntradaZonaCobro (int tiempoAhora) {
        tiempoEntradaCaja = tiempoAhora;
    }
    
    
    public int getNumproductos() {
        return numproductos;
    }
    
    /**
     * método tiempoEntradaPeaje
     * permite consultar el tiempo de entrada en el peaje
     * @return el tiempo de entrada en el peaje
     */
    public int getTiempoEntradaZonaCobro(){
        return tiempoEntradaCaja;
    }
    
    /**
     * método getPrecioProducto()
     * permite consultar el precio del producto del carrito
     * @return el precio del producto del carrito
     */
    public int getPrecioProducto(){
        return(mi_carrito.get(0).getprecio());
    }
    
}
