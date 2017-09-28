
package Tutorial_7;

public class Main {
    public static void main(String[] args) {
       
        Operation op = new Operation();
        Thread opThread = new Thread(op);
        opThread.start();
        
        while(!op.isFinished()) {
             try {
                Thread.sleep(10);
            } catch (InterruptedException ex) { ex.printStackTrace(); }
            if(op.hasProgressUpdated()) {
                System.out.println(op.getProgress());
            }
        }
    
    System.out.println("Operation is finished!");

    }
}
