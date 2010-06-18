package md.shaman.udp;

import java.net.*;
import java.security.SecureRandom;
import java.io.*;

public class EchoClient extends Thread{

	DatagramSocket socket; // How we send packets
	DatagramPacket packet; // what we send it in
	InetAddress address; // Where to send
	NetworkInterface nif; // NIC to send
	String messageReturn; // What we get back from the Server
	int port;
	int localPort;
	int packetSize;
	int timer;
	int packNo;
	public int getPackNo() {
		return packNo;
	}

	InetAddress localAddr;
	byte[] data;
	int sendNoPack = 0;
	
	public InetAddress getAddress() {
		return address;
	}


	public int getPort() {
		return port;
	}


	public int getLocalPort() {
		return localPort;
	}


	public InetAddress getLocalAddr() {
		return localAddr;
	}

	
	public int getSendNoPack() {
		return sendNoPack;
	}


	public static void main(String[] args) {
			EchoClient e = null;
			try {
				e = new EchoClient("192.168.140.14", 5000, "192.168.140.56",5000, 1024, 1000, 1000);
			} catch (SocketException e1) {
				e1.printStackTrace();
			}
			e.start();
	}
	

	public EchoClient(String address, int port, String localAddr,int localPort, int packetSize, int packNo, int timer) throws SocketException{
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
		socket = new DatagramSocket(this.localPort, this.localAddr);
	}
	
	public void exit()
	{
		socket.disconnect();
		socket.close();
		stop();
		
	}
	
	public void run(){
		
		// Gets the IP address of the Server
		// Generate Random Data
		SecureRandom random = new SecureRandom();
		data = random.generateSeed(packetSize);
		// remember datagrams hold bytes
		packet = new DatagramPacket(data, data.length, address, port);
		
		try {
			// sends the packet
			while(sendNoPack != packNo)
			{
				Thread.sleep(timer);
				socket.send(packet);
				sendNoPack ++;
				System.out.println("send");
			}
		} catch (IOException ie) {
			System.out.println("Could not Send :" + ie.getMessage());
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	} // Constructor

} // Class EchoClient

