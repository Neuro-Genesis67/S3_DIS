package talk18V_version_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSender extends Thread {
	
	String message;
	DataOutputStream outMessage;
	BufferedReader inputMessage;
	
	public ThreadSender(DataOutputStream outMessage, BufferedReader inputMessage) {
		this.outMessage = outMessage;
		this.inputMessage = inputMessage;
	}
	
	public void run() {
		
	while(true) {
		try {
			message = inputMessage.readLine(); // Read client keyboard input
			outMessage.writeBytes(message + "\n"); // Message is sent		
		} catch (Exception e) {
			System.out.println("Error occured in ThreadSender");
			e.printStackTrace();
		}
	}
	
	}
}
