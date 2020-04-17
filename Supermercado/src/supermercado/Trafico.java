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
public class Trafico {
    public final int tMedio; //media de la distribución de llegadas
    private int tLlegada; // tiempo de la próxima llegada
    
    /**
     * Constructor del Trafico
     * @param tiempo tiempo medio de llegada
     */
    public Trafico(int tiempo){
         tMedio = tiempo;
    }
    
    /**
     * método getProximaLlegada
     * @return tiempo de proxima llegada
     */
    public int getProximaLlegada(){
        return tLlegada;
    }
    /** 
     * método proximaLlegada
     * Calcula el timepo de proxima llegada teniendo en cuenta la distribucion
     * considerada y el tiempo actual
     * @param r reloj con el tiempo actual
     */
    public void proximaLlegada(Reloj r){
        tLlegada = (int)(r.tiempoAhora()+1-tMedio*Math.log(1-Math.random()));
    }
    
}
