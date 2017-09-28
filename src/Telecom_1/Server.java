package Telecom_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class Server {

    public final static String HOST = "127.0.0.1";
    public final static int PORT = 6143;
    
    //Client stuff
    private ArrayList<ClientSocket> connectedClients = new ArrayList<>();
    private Thread clientAcceptanceThread; 
    
    private ServerSocket server;
    
    public Server() {
        try {
            server = new ServerSocket(Server.PORT); 
            
            //start accepting clients
            (clientAcceptanceThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            //accept a new client                    
                            System.out.println("Listening to new clients...");
                            ClientSocket newClient = new ClientSocket(server.accept()); 
                            System.out.println("new clients accepted");
                            
                            //add the new client to the array list
                            connectedClients.add(newClient);
                            
                            //Send welcome messages
                            newClient.send("Welcome to the server");
                            
                        } catch (IOException e) {
                            e.printStackTrace(System.err);
                        }
                    }
                }
            }, "Client Acceptance Thread")).start();
            
            //Manage existing clients
            while(true) {
                ArrayList<Integer> disconnectedClients = new ArrayList<Integer>();
                
                //Check for disconnected clients and send/receive messages
                for(int i = 0; i < connectedClients.size(); i++) {
                    ClientSocket client = connectedClients.get(i);
                        try {
                        String message = "Client " + i + ":"+ client.receive();
                         if(message != null) {
                            for(int j = 0; j < connectedClients.size(); j++) {
                                if(i != j) {
                                connectedClients.get(j).send(message); 
                                }
                            }
                            }
                        } 
                        catch (SocketException ex) {  
                            disconnectedClients.add(i);
                        }
                        catch(SocketTimeoutException ex) {}
                       // catch(IOException ex) {}
                       
                    }
                   
                
            
            //Remove disconnected clients from ArrayList 
            for(int i : disconnectedClients){
                connectedClients.remove(i);
                System.out.println("Client " + i + " has disconnected.");
            }
          }
             
            
            
        } catch(IOException e) {
            e.printStackTrace(System.err);
        }
    
    }
    public static void main(String[] args) {
         new Server();
    }
}
