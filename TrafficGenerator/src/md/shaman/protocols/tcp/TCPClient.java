package md.shaman.protocols.tcp;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import md.shaman.protocols.Protocol;
import md.shaman.protocols.ProtocolThread;

public class TCPClient extends ProtocolThread {

    Socket socket = null;
    DataInputStream dis = null;
    PrintStream ps = null;

    public static void main(String args[]) throws IOException {
        TCPClient c = new TCPClient("192.168.140.14", 5000, "192.168.140.56", 5000, 1024, new Long(1000), new Long(1000));
        c.start();
    }

    public TCPClient(String ipAddress, int ipPort, String nicAddress, int nicPort, int packetSize, Long packetNo, Long delay) throws IOException {
        this.ipPort = ipPort;
        this.nicPort = nicPort;
        this.delay = delay;
        this.packetNo = packetNo;
        this.packetSize = packetSize;
        this.type = Protocol.Type.TCP;
        this.direction = Protocol.Direction.SEND;
        try {
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.nicAddress = InetAddress.getByName(nicAddress);
        } catch (UnknownHostException e) {
        }
        socket = new Socket(this.ipAddress, this.ipPort, this.nicAddress, this.nicPort);
    }

    public void exit() {
        // Close Socket form Client side
        try {
            socket.close();
        } catch (IOException ie) {
            System.out.println(" Close Error   :" + ie.getMessage());
        }
        stop();

    }

    public void run() {

        System.out.println("Trying to connect ...");
        SecureRandom random = new SecureRandom();

        try {
            while (packetSendReceive != packetNo) {
                Thread.sleep(delay);
                socket.getOutputStream().write(random.generateSeed(packetSize));
                packetSendReceive++;
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    } // main
} // Class Client

