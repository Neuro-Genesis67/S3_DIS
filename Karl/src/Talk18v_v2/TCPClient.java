package Talk18v_v2;

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
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("localhost", 8011);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		ThreadSender ts = new ThreadSender(inFromClient, outToServer);
		ThreadReciever tr = new ThreadReciever(inFromServer);
		
		
		ts.start();
		tr.start();

	}

}
