package md.shaman.protocols.multicast;

import java.net.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import md.shaman.protocols.Protocol.Direction;
import md.shaman.protocols.Protocol.Type;
import md.shaman.protocols.ProtocolThread;

public class BroadcastServer extends ProtocolThread {

    MulticastSocket socket;
    DatagramPacket packet;
    byte[] data;

    public static void main(String args[]) throws Exception {
    } // main

    public BroadcastServer(String ipAddress, int ipPort, String nicAddress, int nicPort, int packetSize, Long packetNo, Long delay) throws IOException {
        this.ipPort = ipPort;
        this.nicPort = nicPort;
        this.packetNo = packetNo;
        this.packetSize = packetSize;
        this.delay = delay;
        this.type = Type.MULTICAST;
        this.direction = Direction.SEND;
        try {
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.nicAddress = InetAddress.getByName(nicAddress);
        } catch (UnknownHostException e) {
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

