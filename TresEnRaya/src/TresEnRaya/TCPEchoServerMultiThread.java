package TresEnRaya;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPEchoServerMultiThread extends Thread{    
    public static void main(String[] args) {
        TCPEchoServerMultiThread server = new TCPEchoServerMultiThread(12000);
        server.start();
    }
    
    final int port;
    final List<ClientThread> clients = new LinkedList<>();
    
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
        String clientName;
        final List<ClientThread> clients;
        final Socket socket;
        DataOutputStream out;

        public ClientThread(List<ClientThread> clients, Socket socket) {
            this.clients = clients;
            this.socket = socket;
            this.clientName = socket.getInetAddress() + ":" + socket.getPort();
        }
        
        //only one thread at the time can send messages through the socket
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
                System.out.println("Connection from " +clientName) ;
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                //now that we have managed to stablish proper connection, we add ourselve into the list
                synchronized (clients) { //we must sync because other clients may be iterating over it
                    clients.add(this);
                }

                for (String line; (line = in.readUTF()) != null;) {
                    //si la linea contiene ",", se le realiza un split
                    if(line.contains(",")){
                        String parts[] = line.split(",");
                        String linea = line;
                        if(parts[0].equals("X")|| parts[0].equals("O")){ //si la linea contiene las posiciones del tablero
                             synchronized (clients) { //other clients may be trying to add to the list
                            clients.forEach(c -> c.sendMsg(linea));
                            }
                        }
                        else{
                             synchronized (clients) { //other clients may be trying to add to the list
                            clients.forEach(c -> c.sendMsg(clientName+">"+linea ));
                        }
                        }
                    }
                    
                    else{
                           String parts[] = line.split(" ");
                    if(line.equals("/list")){
                        line = "La lista de jugadores es: : ";
                        for (ClientThread client : clients) {
                            line = line.concat(client.clientName+" ");
                        }
                        sendMsg("Server>"+line);
                    }else if(line.equals("/exit")){
                        sendMsg("Server>Conexion cerrada.");
                        socket.close();
                    }else if(parts[0].equals("/name")){
                        if(parts.length==2){
                            clientName = parts[1];
                            sendMsg("Server>Has cambiado el nombre a: "+clientName+"!");
                        }else{
                            sendMsg("Server>Error: Por favor, introduzca un nuevo nombre");
                        }
                    }else{
                        String msg = line;
                        //when we read a line we send it to the rest of the clients in mayus
                        synchronized (clients) { //other clients may be trying to add to the list
                            clients.forEach(c -> c.sendMsg(clientName+">"+msg ));
                        }
                    }   
                    }
                } //fin del for
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally { //we have finished or failed so let's close the socket and remove ourselves from the list
                try{ socket.close(); } catch(Exception ex){} //this will make sure that the socket closes
                synchronized (clients) {
                    clients.remove(this);
                }
            }
        }        
    }
    
}
