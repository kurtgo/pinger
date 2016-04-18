package pinger;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		
        System.out.println("Pinging local subnet..."); // Display the string.
        PingThread[] x = new PingThread[20];
        int i;
        Counter counter = new Counter();
        
        for (i=0;i<20;++i) {
        	x[i] = new PingThread(counter);
        	x[i].start();
        }
       
        for (i=0;i<20;++i) {
        	x[i].join();
        }
        System.out.println("Pinging local subnet..."); // Display the string.
	}
}
