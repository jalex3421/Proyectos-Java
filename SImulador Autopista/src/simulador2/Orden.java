/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador2;


/**
 *
 * @author alumno
 */
public  class Orden implements Comparable <Orden> {
    public int numCabina, numCochesCola;

    public Orden(int numCabina, int numCochesCola) {
        this.numCabina = numCabina;
        this.numCochesCola = numCochesCola;
    }
    
    @Override
    public int compareTo(Orden o){
       return (this.numCochesCola -o.numCochesCola);
    }
    
   @Override
    public String toString(){
        return "Orden{" + "cabina=" +numCabina + ", coches = " + numCochesCola + '}'; 
    }  
}


/*
public class prueba orden{
public static void main(string[] args){
list<Orden> lista = new Arraylist<Orden>();
lista.add(new Orden (1m 34));
lista.add(new Orden (5, 45));
lista.add (new Orden (3,56))
lista.add (new Orden (2,5))
lista.add (new Ordden (4,2))

system.out.println("La lista sin ordenar es: ");
Collection.sort(lista)
system.out.println("La lista ordenada de ,menor a maye s: "+lista);
*/