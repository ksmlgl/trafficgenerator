package md.shaman.tcp;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;

public class TCPClient extends Thread{
	Socket socket = null;
	DataInputStream dis = null;
	PrintStream ps = null;
	InetAddress address;
	InetAddress localAddr;
	int port;
	int localPort;
	int packetSize;
	int timer;
	int packNo;
	public InetAddress getAddress() {
		return address;
	}

	public InetAddress getLocalAddr() {
		return localAddr;
	}

	public int getPort() {
		return port;
	}

	public int getLocalPort() {
		return localPort;
	}

	public int getPackNo() {
		return packNo;
	}

	public long getSendNoPack() {
		return sendNoPack;
	}

	long sendNoPack = 0;
	
	public static void main(String args[]) throws IOException {
		TCPClient c = new TCPClient("192.168.140.14", 5000, "192.168.140.56",5000, 1024, 1000, 1000);
		c.start();
	}
	
	public TCPClient(String address, int port, String localAddr, int localPort, int packetSize, int packNo, int timer) throws IOException{
		this.port = port;
		this.localPort = localPort;
		this.timer = timer;
		this.packNo = packNo;
		this.packetSize = packetSize;
		try {
			this.address = InetAddress.getByName(address);
			this.localAddr = InetAddress.getByName(localAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		socket = new Socket(this.address, this.port, this.localAddr, this.localPort);
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
			while(sendNoPack != packNo)
			{
				Thread.sleep(timer);
				socket.getOutputStream().write(random.generateSeed(packetSize));
				sendNoPack ++;
			}
		} catch (IOException e) {
			System.out.println("IOException " + e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	} // main
} // Class Client
