package talk18V_version_2;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReceiver extends Thread {
	
	String message;
	BufferedReader outputMessage;
	

	public ThreadReceiver(BufferedReader outputMessage) {
		this.outputMessage = outputMessage;
		
	}
	
	public void run()  {
		
		while(true) {
			try {
				message = outputMessage.readLine(); // Server message received
				System.out.println("received message: " + message); //Server message printed
			} catch (IOException e) {
				System.out.println("Error occured in ThreadReceiver");
				e.printStackTrace();
			} 
		}
	}
}
