package Talk18v_v1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception, IOException {
		String clientMessage;
		String serverMessage;
		ServerSocket welcomeSocket = new ServerSocket(8011);
		
		Socket connectionSocket = welcomeSocket.accept();
		System.out.println("Connection established");
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		
		
		BufferedReader outFromServer = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			
			clientMessage = inFromClient.readLine();
			System.out.println("FROM CLIENT: " + clientMessage);
			serverMessage = outFromServer.readLine();
			outToClient.writeBytes(serverMessage + '\n');
		}
	}

}
