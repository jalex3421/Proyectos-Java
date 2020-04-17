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
public class CasinoDef {

    public void iniciarCasino(){
        Partida p = new Partida();
        p.pedirNombre();
        p.jugarPartida();
    }
    
    public static void main(String[] args) {
        CasinoDef casino = new CasinoDef();
        casino.iniciarCasino();
    }
}
