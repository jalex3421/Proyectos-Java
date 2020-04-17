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
public class Vehiculo {
    private int tiempoEntradaPeaje;
    //establece  tiempo de entrada
    public void setTiempoEntradaPeaje(int tiempoAhora) {
        tiempoEntradaPeaje = tiempoAhora;
    }
    //retorna el tiempo de entrada
    public int tiempoEntradaPeaje() {
        return tiempoEntradaPeaje;  
    }    
}
