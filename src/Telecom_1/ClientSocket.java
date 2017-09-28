package Telecom_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket { //from viewpoint of server; socket object

    private Socket client;
    private DataInputStream fromClient;
    private DataOutputStream toClient;
     
    
    public ClientSocket(Socket socket) throws IOException { //constructor
        client = socket;
        fromClient = new DataInputStream(socket.getInputStream());
        toClient = new DataOutputStream(socket.getOutputStream());
        
        client.setSoTimeout(50);
    }
    
    public String receive() throws IOException {
        return fromClient.readUTF();
    }
    public void send(String str) throws IOException {
        toClient.writeUTF(str);
    }
   
}
