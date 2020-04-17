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
public class Trafico {
    public int tMedioLlegada;
    private int tProxLlegada;

    public Trafico(int tiempoMedio) {
        tMedioLlegada = tiempoMedio; 
    }
    
    public void proximaLLegada(Reloj r){
       tProxLlegada = (int)(r.tiempoAhora()+1-tMedioLlegada*Math.log(1-Math.random()));
    }
    //metodo getter
    public int getProximaLlegada(){
        return tProxLlegada; 
    }
}
