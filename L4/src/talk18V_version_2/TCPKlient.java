package talk18V_version_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPKlient {

	public static void main(String[] args) throws Exception, IOException {

		Socket clientSocket = new Socket("localhost", 8011);
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
	
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		ThreadSender sender = new ThreadSender(outToServer, inFromServer);
		ThreadReceiver receiver = new ThreadReceiver(inFromServer);
		
		sender.start();
		receiver.start();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
