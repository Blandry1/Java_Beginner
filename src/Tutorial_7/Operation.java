package Tutorial_7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Operation  implements Runnable {
    
    private boolean finished = false;
    
    private int progress = 0;
    private boolean progressUpdated = true;
    
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) { ex.printStackTrace(); }
         progress += 5;
         progressUpdated = true;
        }
    finished = true;
    }
      
    
    public boolean isFinished() {
        return finished;
    }
    public String getProgress() {
        progressUpdated = false;
        return progress + "%";
    }
    
    public boolean hasProgressUpdated() {
        return progressUpdated;
    }
}
