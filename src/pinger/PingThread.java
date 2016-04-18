package pinger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PingThread extends Thread {
	Counter count;
    PingThread(Counter c) {
        this.count = c;
    }
    
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
           result.append(line);
        }
        rd.close();
        return result.toString();
     }
    public void run() {
    	int c;
        // compute primes larger than minPrime
    	do {
    		c = count.increment();
    		
    		if (c < 255) {
    			try {
    				getHTML("http://192.168.1." + c);
    				System.out.println("192.168.1."+c);
    			}
    			catch (Exception ex)
    			{
    				
    			}
    			try {
    				getHTML("http://192.168.1." + c +":8080");
    				System.out.println("192.168.1."+c +":8080");
    			}
    			catch (Exception ex)
    			{
    				
    			}
    		}
    	} while (c < 255);
    }
}
