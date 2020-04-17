/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion
 */
public class Caja {
    private final Queue<Carrito> miColaCarritos;    //cola de carritos
    private int nCarritos;    //numero de carritos en la cola
    private int maxCarritos;  //numero máximo de carritos en la cola
    private final int maxServ;  // tiempo maximo de espera del siguiente cobro
    private final int minServ;  //tiempo minimo de espera del siguiente cobro
    private int servidos;   //numero de coches servidos
    private int totalEsperado;  //tiempo total esperado por los coches servidos
    private int proxServ;   //tiempo del proximo servicio simulado
    private final int num_medio_productos; 
    private int cajaAbierta;  //atributo para determinar si caja esta abierta o cerrada
    private int caja_libre;  //para saber si la caja esta lubre o no durante la simulacion 
    private int n_productos; 
    private Carrito carrito; 
    private int precioMedio;
    private int cobradoCaja;
    
    /**
     * Constructor de Caja
     * @param minServ Indica el tiempo mímino del servicio para la caja
     * @param maxServ Indica el tiempo máximo de espera por el servicio 
     * @param num_medio_prod indica el numero medio de productos de un carrito en la caja: 1 en la primera iteracion
     * @param pMedio precio medio
     */
    public Caja(int minServ, int maxServ, int num_medio_prod, int pMedio){ //AQUI SE LE PASA EL NUMERO MEDIO DE PRODUCTOS
        miColaCarritos = new LinkedList<>();
        nCarritos = 0;
        maxCarritos= 0;
        this.maxServ = maxServ;
        this.minServ = minServ;
        servidos = 0; //ATENCION
        totalEsperado = 0;
        proxServ = 0;
        num_medio_productos= num_medio_prod; //el numero medio de productos sera el que se pase como parametro
        caja_libre = 0;  //por defecto se establece que la caja no esté libre. 
        n_productos = 0;
        precioMedio = pMedio;
        cobradoCaja = 0;
        cajaAbierta = 0; //la nicializo como cerrada
        carrito= null;
    }
    
    /** 
     * Metodo proximoCobro
     * Calcula el tiempo del proximo cobro en funcion de los tiempos de servicio
     * de la caja y el tiempo actual siguiendo una distribución equiprobable
     * @param reloj el reloj con el tiempo actual
     * @return instante de tiempo en que se cobrará al siguiente carrito
     */
    private int proximoCobro(Reloj reloj){
        return (int)(((maxServ - minServ) * Math.random()) + minServ + 
                reloj.tiempoAhora());
    }
    
    /**
     * Método contarCarrito
     * Si es necesario establecer un tiempo de cobro porque no había coches en
     * la cabina, lo establece. Contabiliza el coche en la cola y si es superior
     * al maximo de coches encolados hasta ahora, modifica dicho valor
     * @param reloj el reloj con el tiempo actual
     */
    private void contarCarrito(Reloj reloj){
        if (nCarritos == 0){
           caja_libre = 1; //se indica que la caja ahora esta libre
           proxServ = proximoCobro(reloj); //se espera proximo cobro 
        }
        nCarritos++;  //aumentamos el numero de carritos
        if (nCarritos > maxCarritos){
            maxCarritos = nCarritos;
        }
    }
    
    /**
     * Método encolarCarrito
     * Simula la llegada de un nuevo carrito a la caja. Se contabiliza, se crea
     * el vehiculo con su tiempo de entrada y se encola
     * @param reloj el reloj con el tiempo actual
     */
    public void encolarCarrito(Reloj reloj){
        contarCarrito(reloj);
        Carrito carritoNuevo = new Carrito(num_medio_productos, precioMedio); //el constructor de carrito precisa que se la pase el numero de productos 
        carritoNuevo.setTiempoEntradaZonaCobro(reloj.tiempoAhora());
        //offer: add elementos al arraylist -->los encola por asi decirlo
       try{
           miColaCarritos.offer(carritoNuevo);
       }  
       catch(Exception e){
           System.out.println("CLASS CAJA: encolando en cola llena");
       }
    }
    
    /**
     * Metodo servirCaja
     * Si ha llegado el momento de servir un carrito, se le da servicio. Se
     * contabiliza como servido, se elimina el carrito de la cola, se 
     * contabiliza el tiempo que ha estado esperando y, si es necesario, se
     * programa un nuevo servicio
     * @param reloj el reloj con el tiempo actual
     * @throws NoSuchElementException cuando se trata de acceder a una lista 
     * vacia
     */
    //CAMBIAR 
    public void servirCaja(Reloj reloj) throws NoSuchElementException{
      if(caja_libre ==1){ //la caja esta libre 
          carrito= miColaCarritos.poll(); //se obtiene el primer elemento de la cola
          //si carrito es null, se determina    que ya no hay mas elementos en la cola 
          if(carrito == null){
              System.out.println("La cola esta vacia"); 
              System.exit(0); //REVISAR
          }
              caja_libre = 0; //si hay carrito, la caja no esta libre para poder ser usada
      }
          //se procede a atender el carrito 
          if(reloj.tiempoAhora() == proxServ && carrito!=null){
              cobradoCaja = cobradoCaja + carrito.getPrecioProducto();
              carrito.cobrarProducto(); //eliminamos un producto de nuestro array
              n_productos++; 
              if(carrito.getNumproductos() == 0){
                  //se actualiza el tiempo esperado por un carrito
                  totalEsperado = totalEsperado + reloj.tiempoAhora() - carrito.getTiempoEntradaZonaCobro();
                  nCarritos--;
                 this.servidos++;
                  //si el numero de carritos no es 0 -->NO ENTRA AQUI
                  if(nCarritos!=0){
                      proxServ = proximoCobro(reloj); 
                      caja_libre = 1;
                  }
                  else{ //si no hay mas carritos
                      carrito = null;
                  }
              }
              else{
                  proxServ = proximoCobro(reloj);
              }
          }
      }
    /**
     * Método getTotalEsperadoConCola
     * @param reloj tiempo actual
     * @return tiempo esperado en la cola considerando tanto servidos como aun 
     * no servidos
     */
    public int getTotalEsperadoConCola(Reloj reloj){
        int suma = 0;
        Iterator<Carrito> i;
        i = miColaCarritos.iterator();
        while (i.hasNext())
            suma += reloj.tiempoAhora()-i.next().getTiempoEntradaZonaCobro();
        return suma+totalEsperado;
    }
    /**
     * Método resultados_caja()
     * Se muestran los resultados de la caja:
     * -tiempo medio de espera de clientes
     * -numero maximo de carritos en la caja
     * -numero de carritos servidos
     * -numero de productos cobrados en la caja
     */
    public void resultados_caja(){
       if((getServidos()) == 0){
           System.out.println("No se ha servido ningun carrito en la caja");
           //FALLO AQUI
       }
       else{
            System.out.println("El tiempo medio de espera de los clientes en la caja ha sido de: :"+(getTotalEsperado()/getServidos()));
            System.out.print("");
            System.out.println("El numero maximo de carritos en la caja ha sido de: "+(getMaxCarritos()));
            System.out.print("");
            System.out.println("El numero de productos cobrados en la caja ha sido de: "+(getTotalProductos())); 
            System.out.print("");
            System.out.println("El numero de carritos servidos en la caja ha sido de: "+(getServidos())); 
            System.out.println("");
            System.out.println("El total recaudado ha sido de: "+cobradoCaja);
            System.out.println("");
       }
    }
    
    /**
     * Metodo getMaxCoches
     * @return numero de carritos maximo en la cola
     */
    public int getMaxCarritos(){
        return this.maxCarritos;
    } 
    
    /** 
     * Metodo getproxServ
     * @return tiempo del proximo servicio
     */
    public int getproxServ(){
        return proxServ;
    } 
    
    /**
     * Metodo getNCoches
     * @return Tamaño de la cola de carritos
     */
    public int getNCarritos(){
        return nCarritos;
    }
    
    /**
     * metodo getServidos
     * @return numero de carritos que han sido servidos
     */
    public int getServidos(){
        return servidos; //SE LE ESTA PASANDO 0 SERVIDOS 
    }
    
    /**
     * Metodo getTotalEsperado
     * @return tiempo total esperado por los carritos servidos
     */
    public int getTotalEsperado(){
        return totalEsperado;
    }
    
    
     /**
     * Metodo getTotalProductos() 
     * @return numero de productos servidos.
     */
    public int getTotalProductos(){
        return n_productos; 
    }
    
     /**
     * Metodo getTotalRecaudado() 
     * @return numero total de dinero recaudado
     */
    public int getTotalRecaudado(){
        return cobradoCaja;
    }
    
     /**
     * Metodo getTotalRecaudado() 
     * @return estado de la caja: si esta abierta o cerrada
     */
    public int getCajaAbierta(){
        return (cajaAbierta); 
    }
    
     /**
     * Metodo setCajaAbierta() 
     * @param nuevoValor modifica el estado de la caja actual. 
     */
     public void setCajaAbierta(int nuevoValor){
        cajaAbierta = nuevoValor; 
    }
}
