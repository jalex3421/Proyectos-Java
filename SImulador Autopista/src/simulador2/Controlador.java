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
public class Controlador {
     //mipeaje
    public int tiempoMedio; 
    public final int  estaciones = 5 ; 
    public Peaje peaje;
    public Trafico trafico; 
  
    public Controlador(Reloj r) {
        peaje = new Peaje(estaciones);
        Scanner entrada = new Scanner(System.in); 
        System.out.print("\033[32mIntroduce el tiempo medio de llegada de vehiculos: ");
        tiempoMedio = entrada.nextInt();
        trafico = new Trafico(tiempoMedio);
        trafico.proximaLLegada(r);
    }
    //simula llegada de coche a peaje
    public void llegaCoche(Reloj r){
        if(trafico.getProximaLlegada() == r.tiempoAhora()){
            peaje.guardarCola(peaje.eligeCabina(),r);
            trafico.proximaLLegada(r);
        }
    }
    //simula salida de coche de control de peaje
    public void marchaCoche(Reloj r){
      peaje.rondaCabina(r);
    }
    //muetra como va el peaje
    public void estadoPeaje(Reloj r){
        peaje.estado();
    }
}
