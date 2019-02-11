package talk18V_version_2;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReciever extends Thread {
	
	String message;
	BufferedReader outputMessage;
	
	public ThreadReciever(BufferedReader outputMessage) {
		this.outputMessage = outputMessage;
	}
	
	public void run() {
		while (true) {
			try {
			message = outputMessage.readLine();
			System.out.println("Recieved message: " + message);
			} catch (IOException e) {
				System.out.println("Error occured in ThreadReciever");
				e.printStackTrace();
			}
		}
	}
}
