
package Tutorial_6_Thread;

public class Main {
    public static void main(String[] args) {
        
        Thread example = new Thread(new Runnable() {
            @Override
            public void run() {
                long amount = 10000;
                
                for(int i=0; i<amount; i++) {}
                
                System.out.println("Thread is finished");
            }
            });
        
            example.start();
            
            System.out.println("Thread is running");
    }

}
