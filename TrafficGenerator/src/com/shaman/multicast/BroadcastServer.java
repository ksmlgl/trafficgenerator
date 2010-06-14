package com.shaman.multicast;

import java.net.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;

public class BroadcastServer extends Thread{
	MulticastSocket socket;
	DatagramPacket packet;
	InetAddress address;
	InetAddress localAddr;
	byte[] data;
	int port;
	int localPort;
	int packNo;
	int sendNoPack = 0;
	int timer;
	int packetSize;
	
	public static void main(String args[]) throws Exception {
		
		
	} // main
	
	public BroadcastServer(String address, int port, String localAddr,int localPort, int packetSize, int packNo, int timer) throws IOException {
		this.port = port;
		this.localPort = localPort;
		this.packNo = packNo;
		this.packetSize = packetSize;
		this.timer = timer;
		try {
			this.address = InetAddress.getByName(address);
			this.localAddr = InetAddress.getByName(localAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		socket = new MulticastSocket(this.localPort);
		socket.setInterface(this.localAddr);
		// join a Multicast group and send the group salutations
		socket.joinGroup(this.address);
	}
	
	public void exit()
	{
		socket.close();
		stop();
		
	}
	
	public void run() {
		SecureRandom random = new SecureRandom();
		while(sendNoPack  != packNo){
			try {
				//data = random.generateSeed(packetSize);
				Thread.sleep(timer);
				System.out.println("Sending ");
				String str = (new Date()).toString();
				data = str.getBytes();
				packet = new DatagramPacket(data, str.length(), address, port);
				// Sends the packet 
				socket.send(packet);
				sendNoPack ++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

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

	public int getSendNoPack() {
		return sendNoPack;
	}
	
} // class BroadcastServer
