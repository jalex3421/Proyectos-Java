/**
 *Trabajo realizado por Alejandro Meza Tudela
* Fecha: 09-05-2020
 */
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Meza
 */
public class TCPEchoServerMultiThread extends Thread {
    public static void main(String[] args) {
        TCPEchoServerMultiThread server = new TCPEchoServerMultiThread(12000);
        server.start();
    }
    
    final int port;
    final List<ClientThread> clients = new LinkedList<>(); //lista de clientes que resulta ser una lista de hilos
    
    public TCPEchoServerMultiThread(int port) {
        this.port = port;
    }

    @Override
    public void run(){
        try( ServerSocket serverSocket = new ServerSocket(port); ){
        System.out.println("Started server on port " + port);
            // repeatedly wait for connections
            while(! interrupted() ){
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clients, clientSocket);
                clientThread.start();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public class ClientThread extends Thread{
        final List<ClientThread> clients;
        final Socket socket;
        DataOutputStream out;
        String nombreCliente;

        public ClientThread(List<ClientThread> clients, Socket socket) {
            this.clients = clients;
            this.socket = socket;
            this.nombreCliente = socket.getInetAddress()+ ":"+socket.getPort();
        }
        
        //only one thread at the time can send messages through the socket
        //with this method you can send messages to the clients
        synchronized public void sendMsg(String msg){
            try {
                out.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(TCPEchoServerMultiThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            try {
                System.out.println("Connection from " + nombreCliente);
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                //now that we have managed to stablish proper connection, we add ourselve into the list
                synchronized (clients) { //we must sync because other clients may be iterating over it
                    clients.add(this);
                }
               //the thing that we have read, we store it in a variable called line
                for (String line; (line = in.readUTF()) != null;) {
                   String partes[] = line.split(" ");
                   if(line.equals("/exit")){ /* Si leemos exit, cerramos el socket   */
                       sendMsg("Servidor>conexion cerrada");
                       socket.close();
                   }else if(line.equals(("/list"))){ /* Si leemos list, se procede a dar una lista de los usuarios conectados   */
                       line = "La lista de clientes es: ";
                       for(ClientThread cliente: clients){
                           line = line.concat(cliente.nombreCliente+ "  ");
                       }
                       sendMsg("Servidor>Lista: " + line);
                   }else if(partes[0].equals("/name")){  /* Si leemos name, se permite al usuario cambiar de nombre   */
                       if(partes.length == 2){
                             nombreCliente = partes[1];
                            sendMsg("Servidor>Has cambiado el nombre a: " + nombreCliente);
                       }else{
                           sendMsg("Servidor>ERROR: por favor introduzca un nombre");
                       }
                   }else{  /* Si no se lee ninguna de las palabras clavesm se manda el mensaje corriente   */
                       String linea = line;
                        synchronized (clients) { //other clients may be trying to add to the list
                        clients.forEach(c -> c.sendMsg(nombreCliente + ">"+  linea ));
                    }
                   }
                  
                }

            } catch (Exception ex) {
                System.out.println("");
            } finally { //we have finished or failed so let's close the socket and remove ourselves from the list
                try{ socket.close(); } catch(Exception ex){} //this will make sure that the socket closes
                synchronized (clients) {
                    clients.remove(this);
                }
            }
        }

        
    }
    
}
