package talk18V_version_2;

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
		ServerSocket serverSocket = new ServerSocket(8012);
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
		Socket connectionSocket = serverSocket.accept();
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
		ThreadSender ts = new ThreadSender(inFromServer, outToClient);
		ThreadReciever tr = new ThreadReciever(inFromClient);
		
		
			ts.start();
			tr.start();
		
		}
	}

}
