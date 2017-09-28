
package Tutorial_9;

public class Operation implements Runnable{
    
    private Thread opThread;
    
    private boolean running = false;
    
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        
        long timeAtLastUpdate = 0;
        
        int ups = 60;
        double timeBetweenUpdates = 1000 / ups;
        
        int updates = 0;
        long timeAtLastUPSCheck = 0;
        
        while (running) {
            long currentTime = System.currentTimeMillis();
            
            //If enough time has elasped, make a logic update
            if(currentTime - timeAtLastUpdate > timeBetweenUpdates) {
                //Update logic
                timeAtLastUpdate = currentTime;
                updates++;
            }
            //If one second has passed, check how many UPS occurred
            if(currentTime - timeAtLastUPSCheck > 1000) {
                System.out.println("UPS " + updates);
                updates = 0;
                timeAtLastUPSCheck = currentTime;
            }
        }
        
        System.out.println("App ran for " + (System.currentTimeMillis() - startTime)/1000 + " seconds." );
                
    }
    public void start() {
        if(!running) {
            running = true;
            opThread = new Thread(this);
            opThread.start();
        }
    }
    public void stop() {
        running = false;
    }
}
