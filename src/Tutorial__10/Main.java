
package Tutorial__10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        class InputListener implements KeyListener {

            int x = 100, y = 100;
            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    y -= 10;
                }
                else if(ke.getKeyCode() ==KeyEvent.VK_DOWN){
                    y += 10;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.println(ke.getKeyChar() + "is released"); 

            }
            
             @Override
            public void keyTyped(KeyEvent ke) {
                
            }
        }
        
        final InputListener inputListener = new InputListener();
        
        JFrame frame = new JFrame("User Input to Frame"){
            
            @Override
            public void paint (Graphics g) {
                g.setColor(Color.RED);
                g.fillOval(inputListener.x,inputListener.y,100,100); 
                
                repaint();
            }
        };
        
        
        //Add Listeners
        frame.addKeyListener(inputListener);
        
        //Set Frame Options
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
    }

}
