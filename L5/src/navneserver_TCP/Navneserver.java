package navneserver_TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Navneserver {

	static ArrayList<Entry> list;
	static String clientMessage = "";
	
	public static void main(String[] args) throws Exception, IOException {
		initiateList();
		
		ServerSocket serverSocket = new ServerSocket(8011);
		
		while (true) {
			Socket connectionSocket = serverSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientMessage = inFromClient.readLine();
			
			outToClient.writeBytes(handleRequest(clientMessage) + "\n");
			}
	}
	
	public static String handleRequest(String clientMessage) {
		String outToClient = "No such name in the list";
		
		if (clientMessage.length() >= 3 && clientMessage.substring(0, 3).equalsIgnoreCase("add")) {
			String name_Address = clientMessage.substring(4);
			String[] arr = name_Address.split(" ");
			addToList(arr[0], arr[1]);
			outToClient = "Entry has been added to the list";
			
		} else if (clientMessage.length() >= 4 && clientMessage.substring(0, 4).equalsIgnoreCase("list")) {
			outToClient = printList();
			
		} else {
			for (Entry e : list) {
				if (e.getName().equals(clientMessage)) {
					outToClient = e.getAddress();
				}
			}
		}
		return outToClient;
	}
	
	
	public static void initiateList() {
		list = new ArrayList<>();
		list.add(new Entry("Tom", "10.24.67.23"));
		list.add(new Entry("Karl", "10.24.3.135"));
	}
	
	public static String printList() {
		String printedList = "| ";
		for (Entry e : list) {
			printedList += e.getName() + " " +  e.getAddress() + " | ";
		}
		return printedList;
	}
	
	public static void addToList(String name, String address) {
		Entry new_Entry = new Entry(name, address);
		list.add(new_Entry);
	}
}

class Entry {
	
	String name = "";
	String address = "";
	
	public Entry(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
