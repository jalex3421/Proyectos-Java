/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador2;

import java.util.LinkedList;

/**
 *
 * @author alumno
 */
public class Cabina {
    private int nCoches, maxCoches, maxServ, minServ;
    private int totalServido, totalEsperado, proxServ;
    //private?
    LinkedList <Vehiculo> miColaVehiculos; 
   
    public Cabina(int minServ, int maxServ) {
        this.maxServ = maxServ;
        this.minServ = minServ;
        this.nCoches = 0;
        this.maxCoches = 0;
        this.totalServido = 0;
        this.totalEsperado = 0;
        this.proxServ = 0;
        this.miColaVehiculos = new LinkedList<>();
    }
    
    private int proximoCobro(Reloj r){
        return((int)(((maxServ-minServ)*Math.random())+ minServ
           + r.tiempoAhora()));
    }
    
    private void contarCoche(Reloj r){
       if(nCoches>=0){
        this.proxServ = proximoCobro(r);
        this.nCoches +=1; 
         if(this.nCoches > this.maxCoches){
           this.maxCoches = this.nCoches;
        }  
        }
    }
       
    public void encolarCoche(Reloj r){
        contarCoche(r);
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTiempoEntradaPeaje(r.tiempoAhora());
        miColaVehiculos.add(vehiculo);
    }
    
    public void servirCabina(Reloj r){
       if(r.tiempoAhora() == this.proxServ){
          this.totalServido+=1;
          Vehiculo w;
          w = this.miColaVehiculos.remove();
          this.totalEsperado = this.totalEsperado + (r.tiempoAhora() - w.tiempoEntradaPeaje());
          this.nCoches -= 1;
          if(nCoches != 0){
              this.proxServ = proximoCobro(r);
          }
       }
    }
    //metodo getter
    
    public int cuantosCoches(){
        return(nCoches);
    }
    
    public void estado(int i){
        System.out.println("El maximo de coches en la cola "+i+" es " + maxCoches+"\n");
        System.out.println("Numero de coches servidos en la cola " + i+" es " + totalServido+ "\n");
        if(totalServido>0){
            System.out.println("Tiempo medio de espera en la cola "+i+" es "+ totalEsperado/totalServido
                 +"\n");
        }
        else{
            System.out.println("Tiempo medio de espera en la cola " +i +" es 0\n");
        }
    }
    
}
