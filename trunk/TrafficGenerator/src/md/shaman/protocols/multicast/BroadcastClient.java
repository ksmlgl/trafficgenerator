package md.shaman.protocols.multicast;

import java.net.*;
import java.io.*;
import md.shaman.protocols.ProtocolThread;

public class BroadcastClient extends ProtocolThread{
	MulticastSocket socket;
	DatagramPacket packet;
	
	public static void main(String args[]) throws Exception {


	} // main
	
	public BroadcastClient(String address, String localAddr, int localPort) throws IOException {
		this.nicPort = localPort;
		try {
			this.nicAddress = InetAddress.getByName(localAddr);
			this.ipAddress = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		socket = new MulticastSocket(localPort);
		socket.setInterface(this.nicAddress);
		socket.joinGroup(this.ipAddress);
	}
	

	
	public void exit()
	{
		socket.close();
		stop();
		
	}
	public void run() {
		
		byte[] data = new byte[packetSize];
		packet = new DatagramPacket(data, data.length);

		for (;;) {
			// receive the packets
			try {
				socket.receive(packet);
				packetSendReceive ++;
				String str = new String(packet.getData());
				System.out.println(" Time signal received from"
						+ packet.getAddress() + " Time is : " + str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} // for
	}

} // class Broadcast
