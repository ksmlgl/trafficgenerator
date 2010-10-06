package md.shaman.protocols.udp;

import java.net.*;
import java.io.*;
import md.shaman.protocols.Protocol.Direction;
import md.shaman.protocols.Protocol.Type;
import md.shaman.protocols.ProtocolThread;

public class EchoServer extends ProtocolThread {

    // Initialize Port number and Packet Size
    DatagramPacket packet;
    DatagramSocket socket;

    public EchoServer(String ipAddress, int ipPort, String nicAddress, int nicPort) throws IOException {
        this.ipPort = ipPort;//Deprication
        this.nicPort = nicPort;
        this.type = Type.UDP;
        this.direction = Direction.RECEIVE;
        try {
            this.ipAddress = InetAddress.getByName(ipAddress);//Deprication
            this.nicAddress = InetAddress.getByName(nicAddress);
        } catch (UnknownHostException e) {
        }
        socket = new DatagramSocket(this.nicPort, this.ipAddress);
    }
    
    public void exit() {
        stop();
        socket.close();
    }

    public void run() {
        byte[] data; // For data to be Sent in packets

        for (;;) {

            data = new byte[packetSize];

            // Create packets to receive the message

            packet = new DatagramPacket(data, getPacketSize());
            System.out.println("Waiting to receive the packets");

            try {
                // wait infinetely for arrive of the packet
                socket.receive(packet);
                packetSendReceive++;
            } catch (IOException ie) {
                System.out.println(" Could not Receive :" + ie.getMessage());
                System.exit(0);
            }
        } // for loop
    } // main
} // class EchoServer

