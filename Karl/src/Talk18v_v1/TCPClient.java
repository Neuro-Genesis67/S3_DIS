package Talk18v_v1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception, IOException {
		
		String clientMessage = "";
		String serverMessage = "";
		String safeWord = "stop";
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("192.168.43.217", 8011);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		while(!clientMessage.equalsIgnoreCase(safeWord) || !serverMessage.equalsIgnoreCase(safeWord)) {
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			clientMessage = inFromUser.readLine();
			outToServer.writeBytes(clientMessage + '\n');
			serverMessage = inFromServer.readLine();
			System.out.println("FROM SERVER: " + serverMessage);
		}
		
		clientSocket.close();

	}

}
