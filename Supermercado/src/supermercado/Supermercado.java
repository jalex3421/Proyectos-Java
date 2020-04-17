/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Scanner;

/**
 * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion DEF
 */
public class Supermercado {
    public int tSim; // tiempo de simulación
    public Reloj miReloj; 
    public Controlador miCont;
    
    /**
     * Constructor de Supermercado a partir de los valores que debe contener
     * @param tSim
     * @param tMedio
     * @param numMedioProd
     */
    public Supermercado(int tSim, int tMedio, int numMedioProd) {
        this.tSim = tSim;
        miReloj = new Reloj();
        miReloj.aCero();
        miCont = new Controlador(miReloj, tMedio,numMedioProd);
    }
    
    /**
     * Metodo simular: simula el funcionamiento del supermercado
     * Cada hora muestra el estado de las colas
     * Pide al usuario abrir y cerrar las cajas
     */
     public void simular(){
        while (miReloj.tiempoAhora()<tSim) {
            if((miReloj.tiempoAhora()%3600) == 0){ //mostrar resultado por cada hora de simulacion
                 System.out.println("");
                 System.out.println("\033[34m----------------------------------------");
                System.out.println("\033[34mResultados de la hora "+miReloj.tiempoAhora()/3600+" de simulacion"); 
                System.out.println("\033[34m----------------------------------------");
                mostrarResultadoCaja();
                System.out.println("");
                miCont.actualizarCajas(); 
            }
             miReloj.tic();
            siguienteIteracion();
        }
    }
    
     /**
     * Metodo siguienteIteracion: simula cada iteracion del programa
     */
      private void siguienteIteracion(){
        miCont.llegaCarrito(miReloj); //llegada de carrito 
        miCont.marchaCarrito(miReloj); //salido de carrito de lugar donde se cobra(zona de cobro) 
    }
     
     /**
     * Metodo mostrarResultado: llama al metodo estado de ZonaCobro
     */ 
     public void mostrarResultados(){
        miCont.estadoZonaCobro(miReloj);
       }
       
     /**
     * Metodo mostrarResultadoCaja: muestra el estado de cada caja: numero de carritos
     */
       public void mostrarResultadoCaja(){
           miCont.estadoCola(miReloj);
       }
       

    public static void main(String[] args) {
       int tMedio, numMedioProductos;
        System.out.println("\033[34m----------------------------------------");
        System.out.println("\033[34mLidl: la calidad no es cara");
        System.out.println("\033[34m----------------------------------------");
        System.out.println(" ");
        Supermercado sim;
        System.out.println("Introduce el tiempo medio de llegada de carritos: ");
        Scanner s = new Scanner(System.in);
        do{
                tMedio = s.nextInt();
                if(tMedio<0){
                    System.out.println("tiempo incorrecto");
                    System.out.println("pruebe a introducir un tiempo mayor que 0");
                }
        }while(tMedio<0);
        System.out.println("Introduce el numero medio de productos: ");
        do{
             numMedioProductos=s.nextInt();
             if(numMedioProductos<0){
                 System.out.println("Introduce un numero de productos medio mayor que 0");
             }
        }while(numMedioProductos<0);
        sim= new Supermercado(10800,tMedio,numMedioProductos);
        sim.simular(); 
        System.out.println("");
         System.out.println("\033[34m-----------------------------------------------------");
        System.out.println("\033[34mSe presentan los resultados del supermercado");
        System.out.println("\033[34m-------------------------------------------------------");
        System.out.println(" ");
        sim.mostrarResultados();
    }
}
