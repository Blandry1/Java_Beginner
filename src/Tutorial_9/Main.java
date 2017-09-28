
package Tutorial_9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

    Operation op = new Operation();
    op.start();
    
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) { }
            
    op.stop();
        
    }

}
