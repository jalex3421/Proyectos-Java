/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion
 */
public class ZonaCobro {
    //Las 5 primeras cabinas están el intervalo {2,10}
    //Las 5 ultimas cabinas estan en el intervalo {3,20}
    private final int [][] tipoCobro = {
        {2,10}, // tiempos mínimos y máximos de cobro de los coches que llegan
        {2,10}, // a ser los primeros en cada una de las cabinas consideradas
        {2,10}, // Cada para se asigna a la cabina que le corresponde según
        {2,10}, // su número de orden
        {2,10},
        {3,20}, // tiempos mínimos y máximos de cobro de los coches que llegan
        {3,20}, // a ser los primeros en cada una de las cabinas consideradas
        {3,20}, // Cada para se asigna a la cabina que le corresponde según
        {3,20}, // su número de orden
        {3,20}, 
        };
    private final int numCajas;
   
    private int numCajasAbiertas; //importante saber el numero de cajas abiertas  
    
    public final ArrayList<Caja> misCajas; // las cabinas
    
    private ArrayList<Orden> miOrden; //los ordenes para ordenar cajas
    
    private int precioMedio = 0;
    
       Scanner s = new Scanner(System.in);
    /**
     * Constructor de Peaje
     * Crea un nuevo peaje con el numero de cabinas que se le indica. Asigna a 
     * cada cabina los tiempo smáximos y mínimos de cobro
     * @param num_cajas
     * @param num_medio_productos 
     */
    public ZonaCobro(int num_cajas, int num_medio_productos){ //estaciones = numero de cajas en el supermercado
        misCajas = new ArrayList<>(); 
        this.numCajas = num_cajas;
       System.out.println("Introduce el precio medio:");
        do{
            precioMedio = s.nextInt();
            if(precioMedio<0){
                System.out.println("Introduce un precio medio que sea mayor que 0");
            }
        }while(precioMedio<0);
        //////YA TENGO EL PRECIO MEDIO///
        for (int i = 0; i < numCajas; i++){
             misCajas.add(new Caja(tipoCobro[i][0], tipoCobro[i][1],num_medio_productos,precioMedio));
        }
    }
    
    /**
     * método guardarCola
     * Mete un nuevo carrito en la cola que se le indica con el tiempo de lle-
     * gada que también se le indica
     * @param nCaj
     * @param myReloj hora de llegada
     */
    public void guardarCola(int nCaj, Reloj myReloj){
        Caja miCaja = (Caja)misCajas.get(nCaj);
        miCaja.encolarCarrito(myReloj);
    }
    
    /**
     * método ordenar
     * Ordena el ArrayList de ordenes en función del número de coches que esté 
     * esperando en la cabina a la que representa el orden (de menor a mayor)
     * @param miOrden ArrayList a ordenar
     */
    private void ordenar(ArrayList<Orden> miOrden){
        Collections.sort(miOrden,new Comparator<Orden>(){
         @Override
         public int compare(Orden o1, Orden o2){
                return new Integer(o1.num_carritos).compareTo(o2.num_carritos);
            }
        });
    }
    
    /**
     * método eligeCaja
     * Elige una caja. 60% de probabilidad que sea la de menos coches, 30% la
     * segunda de menos coches y 10% la tercera de menos coches
     * @return el número de cabina que se ha elegido
     */
    public int eligeCaja(){
        int numCaja= 0;
        miOrden = new ArrayList<>();
        for (int i = 0; i < numCajas; i++){
            //ordena aquellas cajas que esten abiertas
            if(misCajas.get(i).getCajaAbierta()==1){
                miOrden.add(new Orden(i, misCajas.get(i).getNCarritos()));
            }
        }
         ordenar(miOrden);
        //si hay 2 se elige la mas vacia-->la que este en la primera pos del array ordenado
        if(numCajasAbiertas<3){
            numCaja = miOrden.get(0).getCaja();
        }
        else if(numCajasAbiertas >2){
            //se redefinen las probabilidades
            final double [] elec = {0.5, 0.8, 0.9,1.0};
             double x = Math.random();
             int n = 0;
             while ((elec[n]<x) && (n<3)){
                   n++;
                }
               if(n==3){
                     numCaja=(int)((numCajasAbiertas-1)*Math.random());
                }
               else{
                    numCaja = miOrden.get(n).getCaja();
                }
         }
        return numCaja;
    }
    
     /**
     * método modCaja
     * Se encarga de abrir y cerrar cajas al gusto del usuario 
     * @param numCaja numero de caja sobre el que se quiere operar
     * @param op operacion sobre caja. 
     * 1--->abrir cajas que faltan
     * 0-->cerrar cajas que faltan 
     * @return  value
     */
    public int  modCaja(int numCaja, int op){
        int value = 0; 
        //si esta abierta, procedo a cerrar la caja de interes
        try{
         if(misCajas.get(numCaja).getNCarritos() == 0 && (op == 0) && misCajas.get(numCaja).getCajaAbierta()==1){
            misCajas.get(numCaja).setCajaAbierta(0);
            // System.out.println("CIERROOOO");
            value=1;
         }//Procedo a abrir cajas de interes
         else if(op ==1 && misCajas.get(numCaja).getCajaAbierta()==0 ){
             misCajas.get(numCaja).setCajaAbierta(1);
            //System.out.println("ABROOOOOOO");
              value=1;
        }
        }
        catch(Exception e){
            System.out.println("Entrando a elemento de array que no existe");
        }
        return (value);
    }
    /**
     * método rondaCajas
     * Mira a ver si hay que servir alguna de las cajas del supermercado
     * @param miOrloj tiempo actual
     */
    public void rondaCajas(Reloj miOrloj){
        for (int i=0; i<numCajas;i++){
            try{
             misCajas.get(i).servirCaja(miOrloj);
                 }
             catch(Exception e){
                System.out.println("CLASS Z.COBRO: Sirviendo caja que no existe");
          }
        }
    }      
    
    /**
     * método estado
     * Saca por pantalla los resultados de la simulación
     * @param reloj tiempo del reloj
     */
    
    public void estado(Reloj reloj){
        float totalServidos = 0;
        float totalTiempoEspera = 0;
        float totalProductos = 0;
        float totalRecaudado = 0;
       for(int i =0; i<numCajas; i++){
           try{
           System.out.println("");
           System.out.println("Resultado de la caja numero: "+(i+1));
           misCajas.get(i).resultados_caja();
           totalServidos = totalServidos+ misCajas.get(i).getServidos();
           totalTiempoEspera = totalTiempoEspera + misCajas.get(i).getTotalEsperado();
           totalProductos = totalProductos + misCajas.get(i).getTotalProductos();
           totalRecaudado = totalRecaudado + misCajas.get(i).getTotalRecaudado();
           System.out.println("");
       }
        catch(Exception e){
            System.out.println("ERROR Z.COBRO: Entrando a pos de array inexistente");
        }
    }
   if(totalServidos== 0){
       System.out.println("Ningún carrito ha entrado en la zona de cobro");
   }
   
   else{
       System.out.println("El total de carritos servidos ha sido de: "+totalServidos);
       System.out.println("El total de tiempo esperado ha sido de: "+totalTiempoEspera);
       System.out.println("El total de productos que han pasado por caja ha sodo: "+totalProductos);
       System.out.println("El tiempo medio de espera total (calculado entre todas las cajas): "+(totalTiempoEspera/totalServidos));
       System.out.println("El total recaudado por el supermercado es de: "+totalRecaudado);
       System.out.println("");
   }
   
   }
    
      /**
     * método situacionCola
     * Saca por pantalla el numero de carritos de las colas de las cajas
     * @param reloj tiempo del reloj
     */
     public void situacionCola(Reloj reloj){
         if(numCajasAbiertas>0){
             System.out.println("info de colas");
                 for(int i =0; i<numCajas; i++){
                 try{
                        if(misCajas.get(i).getCajaAbierta()==1){
                        int numCarritos = misCajas.get(i).getNCarritos();
                         System.out.println("");
                          System.out.println("Numero de carritos en la cola de la caja numero "+(i+1)+": "+numCarritos);
                          }
                     }
                    catch(Exception e){
                        System.out.println("ERROR Z.COBRO: Entrando a pos de array inexistente");
                     }
                    }
                     System.out.println("");
         }
         else{
             System.out.println("Ninguna caja esta disponible");
             System.out.println("");
         }
   }
     
      /*
    METODO SETTER
    */
    public void setNumCajasAbiertas(int num){
        numCajasAbiertas = num;
    }
}
