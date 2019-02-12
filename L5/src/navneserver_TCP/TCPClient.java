package navneserver_TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	static String clientMessage = "";
	static String DNSMessage = "";
	
	public static void main(String[] args) throws Exception, IOException {

		Socket DNSSocket = new Socket("localhost", 8011);
		while(true) {
			
		//Keyboard input
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader inFromDNS = new BufferedReader(new InputStreamReader(DNSSocket.getInputStream()));		
		DataOutputStream outToDNS = new DataOutputStream(DNSSocket.getOutputStream());
		
		//Send besked til DNS
		System.out.println("Muligheder: \nIndtast navn og modtag tilsvarende IP-Adresse\nIndtast \"add navn ip\" for at opdatere listen\nIndtast \"list\" for at modtage DNS serverens liste af addresser og navne");
		clientMessage = inFromClient.readLine();
		outToDNS.writeBytes(clientMessage + "\n");
		
		//Modtag besked fra DNS
		System.out.println("--------------");
		DNSMessage = inFromDNS.readLine();
		System.out.println(DNSMessage);
		
		}
//		DNSSocket.close();
		
		
		
		
		

	}

}
