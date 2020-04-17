/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinodef;

/**
 *
 * @author alemt
 */
public class Turno {
    Dado dadito = new Dado();
    
    public void jugarTurno(){
       dadito.lanzarDados();
       dadito.mostrarResultados();
    }
    
    public int resultadoTurno(){
        int r;
        return ( r= dadito.totalResultados());
    }
}
