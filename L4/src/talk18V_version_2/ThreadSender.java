package talk18V_version_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class ThreadSender extends Thread {

	BufferedReader inputMessage;
	DataOutputStream outMessage;
	String message = "";
	
	public ThreadSender(BufferedReader inputMessage, DataOutputStream outMessage) {
		this.inputMessage = inputMessage;
		this.outMessage = outMessage;
	}
	
	public void run() {
		while(true) {
			try {
				message = inputMessage.readLine();
				outMessage.writeBytes(message + '\n');
			} catch (IOException e) {
				System.out.println("Error occured in ThreadSender");
				e.printStackTrace();
			}
		}
	}
}
