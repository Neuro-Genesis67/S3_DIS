package talk18V_version_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception, IOException  {
		
		ServerSocket serverSocket = new ServerSocket(8011);
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		Socket connectionSocket = serverSocket.accept();
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
		ThreadSender sender = new ThreadSender(outToClient, inFromServer);
		ThreadReceiver receiver = new ThreadReceiver(inFromServer);
		
		sender.start();
		receiver.start();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
