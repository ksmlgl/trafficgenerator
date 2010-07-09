package md.shaman.protocols.udp;

import java.net.*;
import java.security.SecureRandom;
import java.io.*;
import md.shaman.protocols.ProtocolThread;

public class EchoClient extends ProtocolThread {

    DatagramSocket socket; // How we send packets
    DatagramPacket packet; // what we send it in
    NetworkInterface nif; // NIC to send
    String messageReturn; // What we get back from the Server

    byte[] data;


    public static void main(String[] args) {
        EchoClient e = null;
        try {
            e = new EchoClient("192.168.140.14", 5000, "192.168.140.56", 5000, 1024, 1000, 1000);
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        e.start();
    }

    public EchoClient(String address, int port, String localAddr, int localPort, int packetSize, int packNo, int timer) throws SocketException {
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
        socket = new DatagramSocket(this.nicPort, this.nicAddress);
    }

    public void exit() {
        socket.disconnect();
        socket.close();
        stop();

    }

    public void run() {

        // Gets the IP address of the Server
        // Generate Random Data
        SecureRandom random = new SecureRandom();
        data = random.generateSeed(packetSize);
        // remember datagrams hold bytes
        packet = new DatagramPacket(data, data.length, ipAddress, ipPort);

        try {
            // sends the packet
            while (packetSendReceive != packetNo) {
                Thread.sleep(delay);
                socket.send(packet);
                packetSendReceive++;
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

