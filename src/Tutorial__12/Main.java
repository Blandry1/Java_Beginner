package Tutorial__12;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        Canvas c = new Canvas();
        c.setSize(800,600);
        c.setVisible(true);
        
        final RenderManager rm = new RenderManager(c);
        
        JFrame frame = new JFrame() {
            @Override
            public void paint (Graphics g) {
                rm.update();
                repaint();
            }
        };
        
        frame.setSize(800,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        frame.add(c);       
        
        rm.add(new Renderable() {
            @Override
            public void draw(Graphics g) {
                g.setColor(Color.red);
                g.fillOval(100,100,200,200);
            }
        });

    }

}
