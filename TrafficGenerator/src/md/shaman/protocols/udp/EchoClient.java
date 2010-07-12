package md.shaman.protocols.udp;

import java.net.*;
import java.security.SecureRandom;
import java.io.*;
import md.shaman.protocols.Protocol.Type;
import md.shaman.protocols.ProtocolThread;

public class EchoClient extends ProtocolThread {

    DatagramSocket socket; // How we send packets
    DatagramPacket packet; // what we send it in

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

    public EchoClient(String ipAddress, int ipPort, String nicAddress, int nicPort, int packetSize, int packetNo, int delay) throws SocketException {
        this.ipPort = ipPort;
        this.nicPort = nicPort;
        this.delay = delay;
        this.packetNo = packetNo;
        this.packetSize = packetSize;
        type = Type.UDP;
        try {
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.nicAddress = InetAddress.getByName(nicAddress);
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

    public void pause(){
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

