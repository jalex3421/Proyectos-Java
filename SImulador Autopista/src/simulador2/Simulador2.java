/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador2;

import java.util.Scanner; 
/**
 *
 * @author alumno
 */
public class Simulador2 {
    //atributos
    public int tSim;
    Reloj r;
    Controlador c;
    
    //constructor
    public Simulador2(int tiempo) {
        this.tSim = tiempo; 
        this.r = new Reloj();
        this.c = new Controlador(r);
    }
    
    public void simular(){
        while(r.tiempoAhora()<tSim){
            r.tic(); //aumentamos en 1 el reloj
            siguienteIteracion();
        }
    }
    
    private void siguienteIteracion(){
        c.llegaCoche(r);
        c.marchaCoche(r);
    }
    
    public void mostrarResultados(){
        c.estadoPeaje(r);
    }
    
    public static void main(String[] args) {
       Scanner tiempo = new Scanner(System.in);
       System.out.print("\033[35mIntroduce el tiempo de simulacion: ");
       Simulador2 simulador = new Simulador2(tiempo.nextInt());
       simulador.simular();
       simulador.mostrarResultados();
    }
}
