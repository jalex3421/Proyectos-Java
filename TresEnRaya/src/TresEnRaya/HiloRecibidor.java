/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRaya;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Meza Tudela
 * FECHA: 17-05-2020
 */
public class HiloRecibidor extends Thread {

    String hostAddr;
    int port;
    GUI gui;
    DataInputStream in;
    DataOutputStream out;

    public HiloRecibidor(String hostAddr, int port, GUI clientFrame) {
        this.hostAddr = hostAddr;
        this.port = port;
        this.gui = clientFrame;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(hostAddr, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            for (;;) {
                String recv = in.readUTF(); //this call will be blocked until something arrives
                String partes[] = recv.split(",");
                System.out.println("He recivido: "+recv);
                if(partes[0].equals("X") || partes[0].equals("O")){
                    gui.pintarTablero(recv);
                    System.out.println("Estoy pintando el tablero");
                }
                else{
                    System.out.println("No recivo el partes "+recv);
                     gui.msgReceived(recv);
                }
               
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloRecibidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.finalizarHiloRecibidor(); 
    }

    void close() {
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloRecibidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void sendMsg(String msg) throws IOException {
        out.writeUTF(msg);
        out.flush();
    }

}
