/*
 *Trabajo realizado por Alejandro Meza Tudela
* Fecha: 09-05-2020
 */
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alemt
 */
public class HiloRecividor extends Thread {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    GUI gui; //lo paso luego al constructor
    String hostAddr;
    int port; 
    
    public HiloRecividor(String hostAddr,int port, GUI gui) throws IOException {
        //abre el socket para el host y puerto 
       this.port = port;
       this.hostAddr = hostAddr;
         this.gui = gui; //obtiene el  GUI
    }
    
    public void sendMessage(String msg){
        try {
            if(! msg.isEmpty()){ 
                out.writeUTF(msg);
                out.flush(); //flush forces to send everything that may be in the buffer
            }
        }catch(IOException ex) {
            System.out.println("error");
        }
    }
    
    @Override
    public void run() {
        try {
            socket = new Socket(hostAddr, port);
        System.out.println("Socket connected to " + socket.getInetAddress() + ":" + socket.getPort());
          in = new DataInputStream(socket.getInputStream());
          out = new DataOutputStream(socket.getOutputStream());
        for(;;){ //mientras el hilo no se interrupta, se ha de hacer 
               String recv = in.readUTF(); //pendiente investigacion --> leer una linea de contenido 
              gui.mensajeRecivido(recv); //pongo el mensaje que se recive en el gui
              //despues de realizar el metodo, se llama al metodo de gui finalizarHiloRecividor para hacer saber que ha acabado
                System.out.println(recv);
          
       } }catch (IOException ex) {
               Logger.getLogger(HiloRecividor.class.getName()).log(Level.SEVERE, null, ex);
           }
        gui.finalizarHiloRecividor();
    }
    
    //metodo para cerrar el stream de entrada
    void close() {
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloRecividor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
