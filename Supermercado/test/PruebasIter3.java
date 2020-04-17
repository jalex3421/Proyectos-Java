
import supermercado.Supermercado;

/*
 *NO HE SABIDO ANALIZAR DE UNA FORMA ÓPTIMA EL ABIERTO Y CERRADO DE CAJAS. POR ELLO, 
*ESTUDIARÉ LOS RESULTADOS GENERALES CON 0, 5 Y 10 CAJAS DURANTE TODA LA SIMULACION
 */

/**
 * @author Alejandro Meza Tudela
 * Fecha realizacion: 08/12/2019
 * Clase tester: prueba los casos de prueba seleccionados. 
 */
public class PruebasIter3 {
      Supermercado sim; 
    
    public static void main(String[] args){
        ////////////////CASOS DE PRUEBA 1:  0 CAJAS EN EL SUPERMERCADO ////////////////////////////
        //TMEDIO:10
        //NUM MEDIOPROD: 10
        PruebasIter3 prueba;
        prueba = new PruebasIter3(); 
        prueba.sim = new Supermercado(10800,10,10);
        if(prueba.sim.miCont.miTrafico.tMedio == 10){
            ////////////////CAJA 1 //////////////////////////////////
            int servidos1 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getServidos();
            if(servidos1 == 0){
                System.out.println("Caja1:servidos esperado");
            }
            else{
                System.out.println("Caja1: servidos incorrectos");
            }
            int servidos11 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getMaxCarritos();
            if(servidos11 == 0){
                System.out.println("Caja1:maxcarritos esperado");
            }
            else{
                System.out.println("Caja1: maxcarritos incorrectos");
            }
            /////////////////////CAJA 5/////////////////////////////////
            int servidos2= prueba.sim.miCont.miZonaCobro.misCajas.get(4).getServidos();
             if(servidos2 == 0){
                System.out.println("Caja5:servidos esperado");
            }
            else{
                System.out.println("Caja5: servidos incorrectos");
            }
            int servidos22 = prueba.sim.miCont.miZonaCobro.misCajas.get(4).getMaxCarritos();
            if(servidos22 == 0){
                System.out.println("Caja2:maxcarritos esperado");
            }
            else{
                System.out.println("Caja2: maxcarritos incorrectos");
            }
            ///////////////////CAJA 10 //////////////////////////////////
             int servidos3= prueba.sim.miCont.miZonaCobro.misCajas.get(9).getServidos();
             if(servidos3 == 0){
                System.out.println("Caja10:servidos esperado");
            }
            else{
                System.out.println("Caja10: servidos incorrectos");
            }
             int servidos33= prueba.sim.miCont.miZonaCobro.misCajas.get(9).getMaxCarritos();
             if(servidos33 == 0){
                System.out.println("Caja10:maxservidos esperado");
            }
            else{
                System.out.println("Caja10: maxservidos incorrectos");
            }
          
        }
        System.out.println("");
         ////////////////CASOS DE PRUEBA 2:  5 CAJAS EN EL SUPERMERCADO ////////////////////////////
        //TMEDIO:10
        //NUM MEDIOPROD: 10
          prueba.sim = new Supermercado(10800,10,10);
          if(prueba.sim.miCont.miTrafico.tMedio == 10){
              /////CAJA 1///////////////////////////////////
              int servidos1_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getServidos();
              if(servidos1_10 >150 && servidos1_10<210 ){
                  System.out.println("Caja 1:servidos correctos");
              }
              else{
                  System.out.println("Caja 1: servidos incorrectos");
              }
              int servidos11_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getMaxCarritos();
              if(servidos11_10 >10 && servidos11_10<30){
                  System.out.println("Caja 1:el max de carritos es correcto");
              }
              else{
                  System.out.println("Caja 1: el max de carritos no es correcto");
              }
              //////////////////////////////CAJA 5/////////////////////
              int servidos5_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(4).getServidos();
              if(servidos5_10 >150 && servidos5_10<210 ){
                  System.out.println("Caja 5:servidos correctos");
              }
              else{
                  System.out.println("Caja 5: servidos incorrectos");
              }
              int servidos55_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(4).getMaxCarritos();
              if(servidos55_10 >10 && servidos55_10<30){
                  System.out.println("Caja 5:el max de carritos es correcto");
              }
              else{
                  System.out.println("Caja 5: el max de carritos no es correcto");
              }
              //////////////////////////////////CAJA 10////////////////////////////
              int servidos10_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(9).getServidos();
              if(servidos10_10==0 ){
                  System.out.println("Caja 10:servidos correcto");
              }
              else{
                  System.out.println("Caja 10: servidos incorrectos");
              }
              int servidos100_10 = prueba.sim.miCont.miZonaCobro.misCajas.get(9).getMaxCarritos();
              if(servidos100_10 == 0 ){
                  System.out.println("Caja 10:maxcarritos correctos");
              }
              else{
                  System.out.println("Caja 10: maxcarritos incorrectos");
              }
          }
          System.out.println("");
           ////////////////CASOS DE PRUEBA 3:  10 CAJAS EN EL SUPERMERCADO ////////////////////////////
        //TMEDIO:10
        //NUM MEDIOPROD: 10
          prueba.sim = new Supermercado(10800,10,10);
          if(prueba.sim.miCont.miTrafico.tMedio == 10){
              /////CAJA 1///////////////////////////////////
              int servidos0 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getServidos();
              if(servidos0 >140 && servidos0<170 ){
                  System.out.println("Caja 1:servidos correctos");
              }
              else{
                  System.out.println("Caja 1: servidos incorrectos");
              }
              int servidos00 = prueba.sim.miCont.miZonaCobro.misCajas.get(0).getMaxCarritos();
              if(servidos00 >2 && servidos00<6){
                  System.out.println("Caja 1:el max de carritos es correcto");
              }
              else{
                  System.out.println("Caja 1: el max de carritos no es correcto");
              }
              //////////////////////////////CAJA 5/////////////////////
              int servidosCaja5 = prueba.sim.miCont.miZonaCobro.misCajas.get(4).getServidos();
              if(servidosCaja5 >110 && servidosCaja5<130 ){
                  System.out.println("Caja 5:servidos correctos");
              }
              else{
                  System.out.println("Caja 5: servidos incorrectos");
              }
              int max5 = prueba.sim.miCont.miZonaCobro.misCajas.get(4).getMaxCarritos();
              if(max5 >12 && max5<5){
                  System.out.println("Caja 5:el max de carritos es correcto");
              }
              else{
                  System.out.println("Caja 5: el max de carritos no es correcto");
              }
              //////////////////////////////////CAJA 10////////////////////////////
              int servidosCaja10 = prueba.sim.miCont.miZonaCobro.misCajas.get(9).getServidos();
              if(servidosCaja10 >40 && servidosCaja10 <63 ){
                  System.out.println("Caja 10:servidos correcto");
              }
              else{
                  System.out.println("Caja 10: servidos incorrectos");
              }
              int max10 = prueba.sim.miCont.miZonaCobro.misCajas.get(9).getMaxCarritos();
              if(max10>0 && max10<4 ){
                  System.out.println("Caja 10:maxcarritos correctos");
              }
              else{
                  System.out.println("Caja 10: maxcarritos incorrectos");
              }
          }
          System.out.println("");
          
          System.out.println("termino de ejecucion");
    }
}
