package talk18v_version_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPKlient {

	public static void main(String[] args) throws Exception, IOException {

		String clientMessage = "";
		String serverMessage = "";
		Socket clientSocket = new Socket("192.168.43.251", 8011);
		BufferedReader clientKeyboard = new BufferedReader(new InputStreamReader(System.in));
	
		BufferedReader pipeIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		DataOutputStream pipeOut = new DataOutputStream(clientSocket.getOutputStream());
		
		while (!clientMessage.equalsIgnoreCase("stop") || !serverMessage.equalsIgnoreCase("stop")) {
			
			clientMessage = clientKeyboard.readLine(); // Read client keyboard input
			pipeOut.writeBytes(clientMessage + "\n"); // Message is sent
			
			serverMessage = pipeIn.readLine(); // Server message received
			System.out.println("Server response: " + serverMessage); //Server message printed
		}
		
		clientSocket.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
