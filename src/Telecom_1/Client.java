package Telecom_1;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
    
/*  Where is the data being store from the server to client, in the socket. i.e what is the socket doing?
    What is the purpose of the socket?
    How can the client make the server send data to the client?
    
*/
    
    private Socket client; 
        //object that connects to server class.
        //a socket/hole where you hold the data until you input/output it.
    private DataInputStream fromServer; //uses socket to input the data, from server to client
    private DataOutputStream toServer; //uses socket to output the data, from client to server
    
    private JTextField input;
    private JTextArea chat;
    private JFrame window;
    
    
    public Client() {
        //initialize chat window
        input = new JTextField();
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {  }
            @Override
            public void keyPressed(KeyEvent ke) { }
            
            @Override
            public void keyReleased(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    String message = input.getText();
                    if((message.length() > 0) && message.length() < 250) {
                        input.setText("");
                        chat.append("You: " + message + "\n");

                    }
                    try { 
                        send(message);
                    } catch (IOException ex) {
                            ex.printStackTrace(System.err);
                    }
                }
                    
            }
        });
        
        chat = new JTextArea(34,50);
        chat.setEditable(false);
        
        window = new JFrame("Networking");
        window.setVisible(true);
        window.setResizable(false);
        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(chat, BorderLayout.PAGE_START);
        window.add(input, BorderLayout.PAGE_END);
        
        //initialize networking
        
        
        try {
            client = new Socket(Server.HOST, Server.PORT);
            if(client.isConnected()) {
                fromServer = new DataInputStream(client.getInputStream()); 
                toServer = new DataOutputStream(client.getOutputStream());
                
                //receive welcome message
                receive(); 
                 
                while(!client.isClosed()) {
                    receive();
                }
                //send a message
               
                //Safely Disconnects
                
            }
            else {
                System.err.println("Could not connect to server");
            }
            
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        
    }
    
    private void receive() throws IOException {
        String message = fromServer.readUTF(); // read message from Server
        chat.append(message + "\n");
    }
    private void send(String str) throws IOException {
        toServer.writeUTF(str);
    }
    
    
    public static void main(String[] args) {
        new Client();
    }
}
