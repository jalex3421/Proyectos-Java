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
public class Dado {
    private int dado1, dado2;
    static final int N =6;
    int total;
    
    public void lanzarDados(){
        dado1 = (int) (Math.random()*N)+1; 
        dado2 = (int) (Math.random()*N)+1; 
    }
    
    public void mostrarResultados(){
        System.out.println("  El lanzamiento del primer dado es "+dado1);
        System.out.println("  El lanzamiento del segundo dado es "+dado2);
    }
    
    
    public int totalResultados(){
        System.out.println("  El total de los dos lanzamientos es "+(dado1 +dado2));
        return (total = dado1+dado2);
    }
}
