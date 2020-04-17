/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador2;

/**
 *
 * @author alumno
 */
public class Reloj {
    private int tiempo; 
    
    public int tiempoAhora(){
        return tiempo; 
    } 
    
    public void tic(){
        tiempo+=1; 
    }
    
    public Reloj() {
        this.tiempo = 0;
    }
}
