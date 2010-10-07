package md.shaman.protocols.udp;

import java.net.*;
import java.security.SecureRandom;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.shaman.protocols.Protocol.Direction;
import md.shaman.protocols.Protocol.Type;
import md.shaman.protocols.ProtocolThread;
import md.shaman.utils.ThreadUtilities;

public class EchoClient extends ProtocolThread {

    DatagramSocket socket; // How we send packets
    DatagramPacket packet; // what we send it in
    byte[] data;

    public static void main(String[] args) {
        ProtocolThread e = null;
        try {
            e = new EchoClient("192.168.140.14", 5000, "192.168.140.25", 5000, 1024, new Long(1000), new Long(1000));
        } catch (IOException ex) {
            Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(e.getId());
        System.out.println(e.getClass());
        e.start();
        EchoClient pt = (EchoClient) ThreadUtilities.getThread(e.getId());
        pt.exit();
        System.out.println(pt.getId());
        System.out.println(pt.getClass());
    }

    public EchoClient(String ipAddress, int ipPort, String nicAddress, int nicPort, int packetSize, Long packetNo, Long delay) throws IOException{
        this.ipPort = ipPort;
        this.nicPort = nicPort;
        this.delay = delay;
        this.packetNo = packetNo;
        this.packetSize = packetSize;
        this.type = Type.UDP;
        this.direction = Direction.SEND;
        try {
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.nicAddress = InetAddress.getByName(nicAddress);
        } catch (UnknownHostException e) {
        }
        socket = new DatagramSocket(this.nicPort, this.nicAddress);
    }

    public void exit() {
        stop();
        socket.close();
    }

    public void pause() {
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
            do{
                Thread.sleep(delay);
                socket.send(packet);
                packetSendReceive++;
                System.out.println("send");
            }while (packetSendReceive != packetNo);
        } catch (IOException ie) {
            System.out.println("Could not Send :" + ie.getMessage());
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    } // Constructor
} // Class EchoClient

