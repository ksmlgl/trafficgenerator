package md.shaman.protocols.tcp;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import md.shaman.protocols.ProtocolThread;

public class TCPClient extends ProtocolThread{
	Socket socket = null;
	DataInputStream dis = null;
	PrintStream ps = null;


	
	public static void main(String args[]) throws IOException {
		TCPClient c = new TCPClient("192.168.140.14", 5000, "192.168.140.56",5000, 1024, 1000, 1000);
		c.start();
	}
	
	public TCPClient(String address, int port, String localAddr, int localPort, int packetSize, int packNo, int timer) throws IOException{
		this.ipPort = port;
		this.nicPort = localPort;
		this.delay = timer;
		this.packetNo = packNo;
		this.packetSize = packetSize;
		try {
			this.ipAddress = InetAddress.getByName(address);
			this.nicAddress = InetAddress.getByName(localAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		socket = new Socket(this.ipAddress, this.ipPort, this.nicAddress, this.nicPort);
	}
	
	public void exit()
	{
		// Close Socket form Client side
		try {
			socket.close();
		} catch (IOException ie) {
			System.out.println(" Close Error   :" + ie.getMessage());
		}
		stop();
		
	}
	
	public void run(){
		
		System.out.println("Trying to connect ...");
		SecureRandom random = new SecureRandom();
		 
		try {
			while(packetSendReceive != packetNo)
			{
				Thread.sleep(delay);
				socket.getOutputStream().write(random.generateSeed(packetSize));
				packetSendReceive ++;
			}
		} catch (IOException e) {
			System.out.println("IOException " + e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	} // main
} // Class Client
