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
public class TDado implements Dado {

    private int dado1, dado2; //valores que se obtiene del dado1 y del dado2 
    static final int N = 6; //numero de caras del dado se puede cambiar 
    int total; //variable que le asigna el resultado total de la tirasa
    
    @Override
    public void lanzarDados() {
        dado1 = (int) (Math.random() * N) + 1;
        dado2 = (int) (Math.random() * N) + 1;
    }

    @Override
    public void mostrarResultados() {
        System.out.println("  El lanzamiento del primer dado es " + dado1);
        System.out.println("  El lanzamiento del segundo dado es " + dado2);
    }

    @Override
    public int totalResultados() {
    System.out.println("  El total de los dos lanzamientos es " + (dado1 + dado2));
     return (total = dado1 + dado2);
    }
    
}
