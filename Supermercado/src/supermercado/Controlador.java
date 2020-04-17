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
 * Version: tercera iteracion
 */
public class Controlador {  
    public Trafico miTrafico;
    public ZonaCobro miZonaCobro;
    public final int num_cajas = 10;
    private int num_cajas_abiertas; //representa el numero de cajas que se tiene abiertas  
    
    /**
     * Constructor del controlador
     * @param r el reloj para que se calcule el tiempo de primera llegada
     * @param tMedio indica el tiempo medio de llegada de carritos a zona de cobro
     * @param numMedioProd indica el número medio de productos
     */
    public Controlador(Reloj r, int tMedio, int numMedioProd){
        miTrafico = new Trafico(tMedio);
        miZonaCobro = new ZonaCobro(num_cajas, numMedioProd); 
         miTrafico.proximaLlegada(r);
    }
    
    /** 
     * Método LlegaCarrito
     * Comprueba si es el momento de que llegue un nuevo carrito y, en tal caso
     * simula su llegada y lo incluye en la caja que corresponda. Tras ello 
     * programa la siguiente llegada
     * @param r reloj para concultar el tiempo actual
     */
    public void llegaCarrito(Reloj r){
 
        if (r.tiempoAhora() == miTrafico.getProximaLlegada()) {
               miTrafico.proximaLlegada(r);
            int eleccion = miZonaCobro.eligeCaja();
            //REVISAR COMO ELIJO CAJA
            miZonaCobro.guardarCola(eleccion, r);
        }
    }
  
    /** 
     * Método actualizarCajas
     * Permite decidir el numero de cajas abiertas
     */
    public void actualizarCajas(){
        int input,j, abiertasAhora;
        System.out.println("Decida el numero de cajas que se desee tener abiertas");
        System.out.println("Esto no va a poder ser siempre asi, puesto que si una caja posee un carrito no puede cerrar");
        System.out.println("Recuerdese que el numero de cajas maximo es de 10"); 
        System.out.println("");
        do{
              Scanner scanner = new Scanner(System.in);
              input = scanner.nextInt(); 
              if(input<1||input>10){
                  System.out.println("El numero de cajas abiertas no es valido.");
                  System.out.println("Debe de estar entre 1 y 10. Vuelva a intentarlo"); 
              }
        }while(input<1||input>10);
        abiertasAhora = num_cajas_abiertas;
        //cerramos cajas
        if(input < num_cajas_abiertas){
            System.out.println("Se van a cerrar "+(num_cajas_abiertas-input)+" cajas");
            j= num_cajas_abiertas; //el numero de cajas abiertas actualmente
            //si se tienen mas cajas abiertas de las que se quieren--> 0 cerrar cajas
            while(abiertasAhora >input && j>0){
                if(miZonaCobro.modCaja(j-1,0)==1){
                    System.out.println("");
                    System.out.println("Caja "+j+"  ha sido cerrada");
                    abiertasAhora--; 
                }
                else{
                    System.out.println("");
                    System.out.println("No se ha podido cerrar la caja "+j);
                }
                j--;
            }   
        }
        //procedemos a abir cajas que faltan por ser abiertas: 1-->abiertas
        else if(input >num_cajas_abiertas){
            System.out.println("Se van a abrir "+(input-num_cajas_abiertas)+" nuevas cajas");
            j=1;
            while(abiertasAhora<input &&  j<=num_cajas){
                 if(miZonaCobro.modCaja(j-1,1)==1){  //llamo a metodo que me permite modificar una caja
                    System.out.println("");
                    System.out.println("Caja "+j+" ha sido abierta");
                    abiertasAhora++; 
                }
                 else{
                     System.out.println("No se ha podido abrir la caja adecuadamente");
                 }
                 j++;
            }
        }
        num_cajas_abiertas = abiertasAhora;
        miZonaCobro.setNumCajasAbiertas(abiertasAhora); 
    } 
    
    /**
     * Método estadoZonaCobro
     * Le indica a la zona de cobro que saque por pantalla los resultados de la simulacion
     * @param r tiempo actual
     */
    public void estadoZonaCobro(Reloj r){
        miZonaCobro.estado(r);
    }
    
    /**
     * Método estadoCola
     * Le indica a la zona de cobro  que saque por pantalla los resultados de la simulacion
     * @param r tiempo actual
     */
     public void estadoCola(Reloj r){
        miZonaCobro.situacionCola(r);
    }
    
    /**
     * Metodo marchaCarrito
     * Le dice al peaje que haga una ronda de comprobación entre sus cabinas
     * @param r tiempo actual
     */
    public void marchaCarrito(Reloj r){
        miZonaCobro.rondaCajas(r);
    }
    
}
