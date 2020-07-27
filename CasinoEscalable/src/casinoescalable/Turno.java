/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoescalable;

/*
 * @author Alejandro Meza Tudela 
*  Fecha: 27 / 7 / 2020
*Version corregida por https://github.com/BryanLoor 
 */
public class Turno {
     Dado dadito = new TDado();
    
    public void jugarTurno(){
       dadito.lanzarDados();
       dadito.mostrarResultados();
    }
    
    public int resultadoTurno(){
        int r;
        return ( r= dadito.totalResultados());
    }
}
