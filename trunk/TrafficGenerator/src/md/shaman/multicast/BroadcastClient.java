package md.shaman.multicast;

import java.net.*;
import java.io.*;

public class BroadcastClient extends Thread{
	MulticastSocket socket;
	DatagramPacket packet;
	InetAddress localAddr;
	InetAddress address;
	int localPort;
	long recieveNoPacket = 0;
	
	public InetAddress getLocalAddr() {
		return localAddr;
	}

	public int getLocalPort() {
		return localPort;
	}

	public long getRecieveNoPacket() {
		return recieveNoPacket;
	}

	public static void main(String args[]) throws Exception {


	} // main
	
	public BroadcastClient(String address, String localAddr, int localPort) throws IOException {
		this.localPort = localPort;
		try {
			this.localAddr = InetAddress.getByName(localAddr);
			this.address = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		socket = new MulticastSocket(localPort);
		socket.setInterface(this.localAddr);
		socket.joinGroup(this.address);
	}
	
	public InetAddress getAddress() {
		return address;
	}

	
	public void exit()
	{
		socket.close();
		stop();
		
	}
	public void run() {
		
		byte[] data = new byte[1024];
		packet = new DatagramPacket(data, data.length);

		for (;;) {
			// receive the packets
			try {
				socket.receive(packet);
				recieveNoPacket ++;
				String str = new String(packet.getData());
				System.out.println(" Time signal received from"
						+ packet.getAddress() + " Time is : " + str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} // for
	}

} // class Broadcast
