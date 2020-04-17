/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador2;

import java.util.*;

/**
 *
 * @author alumno
 */
public class Peaje {
    
    final int [][] tipoCobro = {{15,30}, {15,30}, {15,45},{15,45},{30,60}};
    public int numCabinas; 
    private ArrayList<Cabina> myCabinas;
    ArrayList<Orden>  ordenCabinas;
     
    public Peaje(int estaciones){
        myCabinas = new  ArrayList<>();
        this.numCabinas = estaciones;
        for(int i = 0; i<numCabinas; i++){
           myCabinas.add(new Cabina(tipoCobro[i][0], tipoCobro[i][1]));
        }
        //my cabinas es un array de cabinas con minserv y maxserv
    }
    
     public void guardarCola(int nCab, Reloj myReloj){
        Cabina cab;
        cab = myCabinas.get(nCab);
        cab.encolarCoche(myReloj);
    }
    
    public int eligeCabina(){
        this.ordenCabinas = new ArrayList<>();
        for(int i =0; i<numCabinas; i++){
            ordenCabinas.add(new Orden(i,myCabinas.get(i).cuantosCoches()));
            //add en la cola elementos de orden
            //a cada index se le pasa un elem del mismo index de cabina
            //mas concretamente, cuantos coches
        }
        Collections.sort(ordenCabinas);
        return (eleccionCabina(ordenCabinas));
    }
    
    private int eleccionCabina( ArrayList<Orden>  ordenCabinas){
        final double  [] elec = {0.6, 0.9, 1.0};
        double x = Math.random();
        int n = 1;
        while((elec[n]<x)&& (n<3)){
            n++;
        }
        return(ordenCabinas.get(n).numCabina);
    }
    
    
    public void rondaCabina(Reloj r){
        Cabina cab;
        for (int i = 0; i<numCabinas; i++){
            cab = myCabinas.get(i);
            cab.servirCabina(r);
        }
    }
    
    public void estado(){
        for(int i = 0; i<numCabinas; i++){
            System.out.println("\033[32mSe muestra el resultado de la cabina numero:  "+(i+1));
            myCabinas.get(i).estado(i+1);
        }
    }
    
}
