package md.shaman.protocols.tcp;

import java.net.*;
import java.io.*;
import md.shaman.protocols.ProtocolThread;
import md.shaman.utils.StringUtils;

public class TCPServer extends ProtocolThread {

	ServerSocket sersock;
	Socket sock;

	public static void main(String args[]) throws IOException {
		TCPServer s = new TCPServer("192.168.140.56", 5000);
		s.start();
	}

	public TCPServer(String localAddr, int localPort) throws IOException {
		this.nicPort = localPort;
		try {
			this.nicAddress = InetAddress.getByName(localAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		sersock = new ServerSocket(this.nicPort, 1, this.nicAddress);
	}


	public void exit() {
		try {
			// Close Socket Connection
			sock.close();
			// Close Server Socket Connection
			sersock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stop();

	}

	public void run() {
		System.out.println(" Wait !! ");
		try {
			// Initialising the ServerSocket
			
			// Gives the Server Details Machine name, Port number

			System.out.println("Server Started  :" + sersock);
			sock = sersock.accept();
			System.out.println("Client Connected  :" + sock);
			try {
				// Receive message from client i.e Request from client
				System.out.println("Message : "+StringUtils.InputStreamToString(sock.getInputStream()));
			} catch (SocketException se) {
				System.out.println("Server Socket problem  " + se.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Couldn't start " + e.getMessage());
		}
		
		System.out.println("SERVER IS OFF!!!");
	} 

} // Server class
