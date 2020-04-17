/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 * @author Alejandro Meza Tudela
 * FECHA: 11/12/2019
 * Version: tercera iteracion
 */
public class Orden {
    public int caja;
    public int num_carritos;
    
    /**
     * Constructor de Orden a partir de los valores que debe contener
     * @param caja
     * @param num 
     */
    public Orden(int caja, int num){
        this.caja = caja;
        num_carritos = num;
    }
    
    /*
     METODO GETTER
    */
    public int getCaja() {
        return caja;
    }
    
    /*
    METODO GETTER
    */
    public int getNum_carritos() {
        return num_carritos;
    }
    
}
