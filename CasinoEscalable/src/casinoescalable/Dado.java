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

/*Se recuerda en las interfaces es de las pocas maneras de realizar herencia multiple en Java 
 Uno de los propositos de la declaracion de la interfaz dado, es el poder jugar con dados 
 de diferentes caras en la misma partida 
*/
public interface Dado {
    //Definicion del metodo encargado de lanzar dados
    public void lanzarDados();
    //Definicion del metodo encargado de mostrar resultados
    public void mostrarResultados();
    //Definicion del metodo encargado de mostrar el total de resultados 
    public int totalResultados();
    
}
