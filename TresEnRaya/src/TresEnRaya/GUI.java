/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRaya;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Alejandro Meza Tudela
 * FECHA: 17-05-2020
 */
public class GUI extends javax.swing.JFrame {

    private HiloRecibidor hiloRecibidor= null;  //hiloRecibidor inicializado a null
    private int puerto ; //entero que representa el puerto por defecto de la aplicacion -->12000
    boolean jugador1, jugador2; //booleanos que determinaran si soy el jugador 1 o soy el jugador 2
    String host;  //127.0.0.1 --> por defecto 
    Puntuacion puntuacion ; // atributo de tipo puntuacion
    //JUGADOR 1 --> 'X'
    //JUGADOR 2 --> 'O'
    ArrayList<Integer> player1position = new ArrayList <>(); //arraylist donde el jugador 1 tendra sus posiciones en el tablero
    ArrayList<Integer> player2position = new ArrayList <>(); //arraylist donde el jugadro 2 tendra sus posiciones en el tablero
    private int victorias1 = 0; //variable que almacenera el numero de victorias del jugador1
    private int victorias2 = 0; //variable que almacenera el numero de vicorias del jugador2
    /**
     * Creates new form GUI
     * @param puerto
     * @param host
     * @param puntuacion
     */
    public GUI(int puerto, String host, Puntuacion puntuacion) {
        initComponents();
       this.puerto= puerto;
       this.host = host;
       this.puntuacion = puntuacion;
       Up1.setText(host);
    }

    private GUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHost = new javax.swing.JLabel();
        Up1 = new javax.swing.JTextField();
        labelPort = new javax.swing.JLabel();
        Up2 = new javax.swing.JTextField();
        ConDis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaChat = new javax.swing.JTextArea();
        tex2 = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        botonPuntuacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatClient");

        labelHost.setText("Host:");

        Up1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Up1ActionPerformed(evt);
            }
        });

        labelPort.setText("JUGADOR");

        Up2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Up2ActionPerformed(evt);
            }
        });

        ConDis.setText("START");
        ConDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConDisActionPerformed(evt);
            }
        });

        textAreaChat.setColumns(20);
        textAreaChat.setRows(5);
        jScrollPane1.setViewportView(textAreaChat);

        tex2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex2ActionPerformed(evt);
            }
        });

        SendButton.setText("Enviar");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        botonPuntuacion.setText("Puntuacion");
        botonPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuntuacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tex2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelHost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Up1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                    .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(labelPort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Up2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(botonPuntuacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ConDis)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelHost)
                        .addComponent(Up1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPort)
                        .addComponent(Up2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ConDis))
                    .addComponent(botonPuntuacion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(ClearButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tex2)
                    .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConDisActionPerformed
        //si no existe el hilo recividor, se procede a crear uno
         String opcion; //string que recoge la opcion del JOptionPane
        if (hiloRecibidor != null) {
                ConDis.setText("END GAME");
                hiloRecibidor = new HiloRecibidor(host, puerto, this);
               hiloRecibidor.start();
                opcion = JOptionPane.showInputDialog("Introduce lo que desees ser: P1 o P2: ");
            System.out.println(opcion);
            if(opcion.compareTo("P1") == 0){   //en caso de que se haya introducido P1
                System.out.println("Soy el jugador 1");
                Up2.setText("PLAYER 1");
                jugador1 = true;
                jugador2 = false;
            }else if (opcion.compareTo("P2") == 0){ //en caso de que se haya introducido P2
                System.out.println("Soy el jugador 2");
                 Up2.setText("PLAYER 2");
                jugador1 = false;
                jugador2 = true;
            }
        } else {
            //cuando cerramos la conexion, reestablecemos los booleanos al estado inicial, para una futura nueva partida
            if(jugador1 == true){
                jugador1 = false;
            }else{
                jugador2 = false;
            }
            borrarJugadas();  //borramos las jugadas del tablero
            Up2.setText(""); //borramos el texto que nos indica que numero de jugador somos
            hiloRecibidor.close(); //cerramos el inputstream del hilo 
           hiloRecibidor.interrupt(); 
        }


    }//GEN-LAST:event_ConDisActionPerformed

    /*
    ACCION: borrarJugadas()
    MODIFICA: accion que se encarga de borrar todo el tablero, dejandolo como al principio
    */
    private void borrarJugadas(){
        b1.setText("");
       b2.setText("");
       b3.setText("");
       b4.setText("");
       b5.setText("");
       b6.setText("");
       b7.setText("");
       b8.setText("");
       b9.setText("");
    }
    
    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        if (hiloRecibidor == null){
            try {
                hiloRecibidor.sendMsg(tex2.getText());
                tex2.setText("");
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }//GEN-LAST:event_SendButtonActionPerformed

    private void Up2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Up2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Up2ActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        textAreaChat.setText(" ");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void tex2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tex2ActionPerformed
       if (hiloRecibidor != null){
            try {
                hiloRecibidor.sendMsg(tex2.getText());
                tex2.setText(" ");
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tex2ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
       if (hiloRecibidor  != null){
            try {
                if(jugador1 == true){
                      hiloRecibidor.sendMsg("X,2");
                }else{
                    hiloRecibidor.sendMsg("O,2");
                 }
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
         if (hiloRecibidor != null){
            try {
                if(jugador1 == true){    
                         hiloRecibidor.sendMsg("X,1");
                }else{                     
                     hiloRecibidor.sendMsg("O,1");
                 }            
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
         if (hiloRecibidor != null){
            try {
                if(jugador1 == true){                      
                      hiloRecibidor.sendMsg("X,3");
                }else{                  
                      hiloRecibidor.sendMsg("O,3");
                 }           
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){                       
                         hiloRecibidor.sendMsg("X,4");
                }else{               
                      hiloRecibidor.sendMsg("O,4");
                 }         
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){                 
                        hiloRecibidor.sendMsg("X,5");
                }else{             
                    hiloRecibidor.sendMsg("O,5");
                 }          
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
       if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){
                         hiloRecibidor.sendMsg("X,6");
                }else{
               hiloRecibidor.sendMsg("O,6");
                 }       
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
            if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){
                       hiloRecibidor.sendMsg("X,7");
                }else{
                    hiloRecibidor.sendMsg("O,7");
                 }         
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
         if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){                    
                      hiloRecibidor.sendMsg("X,8");
                }else{                    
                     hiloRecibidor.sendMsg("O,8");
                 }           
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
          if (hiloRecibidor !=null){
            try {
                if(jugador1 == true){                      
                      hiloRecibidor.sendMsg("X,9");
                }else{                    
                    hiloRecibidor.sendMsg("O,9");
                 }            
            } catch (IOException ex) {
                System.out.println("No se pudo mandar error a hilo recividor");
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_b9ActionPerformed

    private void botonPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPuntuacionActionPerformed
       JOptionPane.showMessageDialog(rootPane, "VICTORIAS JUGADOR1 : "+victorias1+"\n"+"VICTORIAS JUGADOR2: "+victorias2);
    }//GEN-LAST:event_botonPuntuacionActionPerformed

    private void Up1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Up1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Up1ActionPerformed

    void msgReceived(String msg) {
        textAreaChat.append(msg + "\n");
        textAreaChat.setCaretPosition(textAreaChat.getDocument().getLength());
    }
    
    void finalizarHiloRecibidor() {
        ConDis.setText("START");
        hiloRecibidor= null;
        //despues de finalizar el hilo, se reinicia el contador de victorias de ambos jugadores
        victorias1 = 0;
        victorias2 = 0;
    }
    
    //despues de pintar, checkear si ha habido empate
    //tambien se ha de checkear si ha habido victoria  e incluso si se ha realizado trampas por parte de un jugador
   //Trampas: para el tres en raya, he considerado que sea trampas el hecho de mover dos veces seguidas
    void pintarTablero(String input) throws IOException{
        String partes[] = input.split(",");
        int posficha= Integer.parseInt(partes[1]); //aqui se tendra desde 1 hasta 9, dependiendo del indice de la ficha
        //en caso que sea el jugador numero 1
        if(partes[0].equals("X")){
            switch(posficha){
                case 1: b1.setText("X");
                           player1position.add(posficha);
                           checkearTrampas();
                          checkearVictoria();
                          break;
                case 2: b2.setText("X");
                          player1position.add(posficha);
                           checkearTrampas();
                          checkearVictoria();
                          break;
                case 3: b3.setText("X");
                         player1position.add(posficha);
                          checkearTrampas();
                          checkearVictoria();
                          break;
                case 4: b4.setText("X");
                          player1position.add(posficha);
                           checkearTrampas();
                           checkearVictoria();
                        break;
                case 5: b5.setText("X");
                          player1position.add(posficha);
                           checkearTrampas();
                           checkearVictoria();
                         break;
                case 6:  b6.setText("X");
                             player1position.add(posficha);
                              checkearTrampas();
                             checkearVictoria();
                           break;
                case 7: b7.setText("X");
                             player1position.add(posficha);
                              checkearTrampas();
                             checkearVictoria();
                          break;
                case 8: b8.setText("X");
                          player1position.add(posficha);
                           checkearTrampas();
                            checkearVictoria();
                         break;
                case 9: b9.setText("X");
                          player1position.add(posficha);
                           checkearTrampas();
                           checkearVictoria();
                       break;
            }
        }else if(partes[0].equals("O")){ //si soy el jugador numero 2
            switch(posficha){
                case 1: b1.setText("O");
                          player2position.add(posficha);
                           checkearTrampas();
                          checkearVictoria();
                          break;
                case 2: b2.setText("O");
                           player2position.add(posficha);
                            checkearTrampas();
                           checkearVictoria();
                          break;
                case 3: b3.setText("O");
                           player2position.add(posficha);
                            checkearTrampas();
                             checkearVictoria();
                          break;
                case 4: b4.setText("O");
                           player2position.add(posficha);
                            checkearTrampas();
                           checkearVictoria();
                        break;
                case 5: b5.setText("O");
                           player2position.add(posficha);
                            checkearTrampas();
                             checkearVictoria();
                         break;
                case 6:  b6.setText("O");
                            player2position.add(posficha);
                             checkearTrampas();
                              checkearVictoria();
                           break;
                case 7: b7.setText("O");
                        player2position.add(posficha);
                         checkearTrampas();
                         checkearVictoria();
                          break;
                case 8: b8.setText("O");
                        player2position.add(posficha);
                         checkearTrampas();
                         checkearVictoria();
                         break;
                case 9: b9.setText("O");
                        player2position.add(posficha);
                         checkearTrampas();
                         checkearVictoria();
                       break;
            }
        }
    }
    //metodo que escribe el resultado en un fichero de registro
    void escribirResultado(String input) throws IOException{
             BufferedWriter out = null;
            try {
                FileWriter fstream = new FileWriter("registro.txt", true); //con true, indico que ha de adicionar texto al fichero
                out = new BufferedWriter(fstream);
                out.write(input+ "\n");
            }
            catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            finally {
                if(out != null) {
                    out.close();
                }
          }
    }
    
     public void checkearVictoria() throws IOException{
        //si la posicion del jugador, contiene alguna de las siguientes posiciones, entonces gana
        List topRow = Arrays.asList(1,2,3); 
        List midRow = Arrays.asList(4,5,6);  
        List bottomRow = Arrays.asList(7,8,9);
        List firstCol = Arrays.asList(1,4,7);  
        List secondCol = Arrays.asList(2,5,8);  
         List thirdCol = Arrays.asList(3,6,9);  
         List cross1 = Arrays.asList(1,5,9);  
        List cross2 = Arrays.asList(7,5,3);  
        
        List<List> winningConditions = new ArrayList<>(); //array que va a contener al conjunto de posiciones ganadoras
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(bottomRow);
        winningConditions.add(firstCol);
        winningConditions.add(secondCol);
         winningConditions.add(thirdCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        //recorro la lista de posiciones ganadoras, y las voy comparando con las posiciones de los jugadores
        for(List l: winningConditions){
            if(player1position.containsAll(l)){
                JOptionPane.showMessageDialog(rootPane, "VICTORIA DEL JUGADOR 1");
                 if(jugador1 == true){
                puntuacion.EscribirResultado("VICTORIA DEL JUGADOR 1");
                }
                player1position.removeAll(player1position); //despues de una victoria, borro todas las posiciones del array
                 player2position.removeAll(player2position); //despues de una victoria, borro todas las posiciones del array
                 victorias1++; //se aumenta en uno el contador de victorias
                //escribir en el fichero el ganador--> escribe unicamente el ganador
                 if(jugador1 == true){
                 String msg1 = "Victoria jugador 1";
                 escribirResultado(msg1);
                 }
                borrarJugadas();
            }else if(player2position.containsAll(l)){
                JOptionPane.showMessageDialog(rootPane, "VICTORIA DEL JUGADOR 2");
                if(jugador2 == true){
                  puntuacion.EscribirResultado("VICTORIA DEL JUGADOR 2");  
                }
                   player1position.removeAll(player1position);//despues de una victoria, borro todas las posiciones del array
                 player2position.removeAll(player2position);//despues de una victoria, borro todas las posiciones del array
                   victorias2++; //se aumenta en uno el contador de victorias
                 //escribir en el fichero el ganador -->escribe unicamente el ganador
                   if(jugador2 == true){
                 String msg2 = "Victoria jugador 2";
                 escribirResultado(msg2);
                 }
                  borrarJugadas(); //dejo el tablero como al principio
            }
        }
         if (player1position.size()+player2position.size() == 9) {
                JOptionPane.showMessageDialog(rootPane, "EMPATE");
                   player1position.removeAll(player1position);//despues de un empate, borro todas las posiciones del array
                 player2position.removeAll(player2position);//despues de un empate, borro todas las posiciones del array
                //da igual quien escriba, pero solo lo ha de hacer uno, ya que sino el texto se repetiria
                  if(jugador2 == true){
                 String msg3 = "Empate";
                 escribirResultado(msg3);
                 }
                  borrarJugadas();//dejo el tablero como al principio
            }
       
    }
     //Metodo que checkeara si algun usuario ha realizado trampas: mover dos veces seguidas
     public void checkearTrampas() throws IOException{
         if(player1position.size() - player2position.size() == 2){ //si el jugador 1 es el tramposo...
                JOptionPane.showMessageDialog(rootPane, "JUGADOR 1 HA MOVIDO 2 VECES SEGUIDA" + "\n" +"SE DA VICTORIA A JUGADOR 2");
                 player1position.removeAll(player1position);//despues de una victoria, borro todas las posiciones del array
                 player2position.removeAll(player2position);//despues de una victoria, borro todas las posiciones del array
                   victorias2++; //se aumenta en uno el contador de victorias
                 //escribir en el fichero el ganador -->escribe el que no ha hecho trampas
                   if(jugador2 == true){
                 String msg3 = "Victoria jugador 2";
                 escribirResultado(msg3);
                 }
                  borrarJugadas(); //dejo el tablero como al principio
         }else if(player2position.size() - player1position.size() == 2){  //si el jugador 2 es el tramposo...
                JOptionPane.showMessageDialog(rootPane, "JUGADOR 2 HA MOVIDO 2 VECES SEGUIDA" + "\n" +"SE DA VICTORIA A JUGADOR 1");
                 player1position.removeAll(player1position);//despues de una victoria, borro todas las posiciones del array
                 player2position.removeAll(player2position);//despues de una victoria, borro todas las posiciones del array
                   victorias1++; //se aumenta en uno el contador de victorias
                  //escribir en el fichero el ganador -->escribe el que no ha hecho trampas
                   if(jugador1 == true){
                 String msg4 = "Victoria jugador 1";
                 escribirResultado(msg4);
                 }
                  borrarJugadas(); //dejo el tablero como al principio
         }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ConDis;
    private javax.swing.JButton SendButton;
    private javax.swing.JTextField Up1;
    private javax.swing.JTextField Up2;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton botonPuntuacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHost;
    private javax.swing.JLabel labelPort;
    private javax.swing.JTextField tex2;
    private javax.swing.JTextArea textAreaChat;
    // End of variables declaration//GEN-END:variables

    
}
