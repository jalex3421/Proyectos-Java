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
public class Reloj {
     private int tiempo;
     
     /**
     *NOMBRE: método aCero
     *MODIFICA: Inicializa el reloj
     */
    public void aCero(){
        tiempo = 0;
    }
    
    /**
     *NOMBRE:tiempoAhora
     *USO: getter para el tiempo actual
     * @return tiempo actual
     */
    public int tiempoAhora(){
        return tiempo;
    }
    
    /**
     * NOMBRE: método tic
     * MODIFICA: simula el paso de un segundo
     */
    public void tic(){
        tiempo++;
    }
     
     
}
