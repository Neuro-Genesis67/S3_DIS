package talk18v_version_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception, IOException  {
		
		String clientMessage = "";
		String serverMessage = "";
		ServerSocket serverSocket = new ServerSocket(8011);
		Socket connectionSocket = serverSocket.accept();
		BufferedReader serverInputStream = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader pipeIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream pipeOut = new DataOutputStream(connectionSocket.getOutputStream());
		
		
		while (true) {
			
			clientMessage = pipeIn.readLine();
			System.out.println("Client message: " + clientMessage);
			
			serverMessage = serverInputStream.readLine();
			pipeOut.writeBytes(serverMessage + "\n");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
