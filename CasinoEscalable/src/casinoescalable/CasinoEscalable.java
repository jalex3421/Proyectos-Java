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
public class CasinoEscalable {

     public void iniciarCasino(){
        Partida p = new Partida();
        p.pedirNombre();
        p.jugarPartida();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CasinoEscalable casino = new CasinoEscalable();
        casino.iniciarCasino();
    }
    
}
