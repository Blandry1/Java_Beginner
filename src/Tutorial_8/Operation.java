package Tutorial_8;

public class Operation implements Runnable{
    private Thread opThread;
    
    private boolean running = false;
    
    @Override
    public void run() {
        System.out.println("Operation started");
        
        while(running) {
            //Application logic
            System.out.println("App logic is running");
            
            try {
                Thread.sleep(3000);
            } catch (Exception e) {}
            
            stop();
        }
        
        System.out.println("Operation finished");
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
