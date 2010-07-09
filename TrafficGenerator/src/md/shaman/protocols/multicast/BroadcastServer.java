package md.shaman.protocols.multicast;

import java.net.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import md.shaman.protocols.ProtocolThread;

public class BroadcastServer extends ProtocolThread {

    MulticastSocket socket;
    DatagramPacket packet;
    byte[] data;

    public static void main(String args[]) throws Exception {
    } // main

    public BroadcastServer(String address, int port, String localAddr, int localPort, int packetSize, int packNo, int timer) throws IOException {
        this.ipPort = port;
        this.nicPort = localPort;
        this.packetNo = packNo;
        this.packetSize = packetSize;
        this.delay = timer;
        try {
            this.ipAddress = InetAddress.getByName(address);
            this.nicAddress = InetAddress.getByName(localAddr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        socket = new MulticastSocket(this.nicPort);
        socket.setInterface(this.nicAddress);
        // join a Multicast group and send the group salutations
        socket.joinGroup(this.ipAddress);
    }

    public void exit() {
        socket.close();
        stop();

    }

    public void run() {
        SecureRandom random = new SecureRandom();
        while (packetSendReceive != packetNo) {
            try {
                //data = random.generateSeed(packetSize);
                Thread.sleep(delay);
                System.out.println("Sending ");
                String str = (new Date()).toString();
                data = str.getBytes();
                packet = new DatagramPacket(data, str.length(), ipAddress, ipPort);
                // Sends the packet
                socket.send(packet);
                packetSendReceive++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
} // class BroadcastServer

