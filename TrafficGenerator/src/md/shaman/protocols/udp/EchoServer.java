package md.shaman.protocols.udp;

import java.net.*;
import java.io.*;
import md.shaman.protocols.ProtocolThread;

public class EchoServer extends ProtocolThread {

    // Initialize Port number and Packet Size
    DatagramPacket packet;
    DatagramSocket socket;

    @SuppressWarnings("deprecation")
    public static void main(String args[]) throws InterruptedException, SocketException {
        EchoServer es = new EchoServer("127.0.0.1", 5000);
        es.start();
        es.sleep(1000);
        es.exit();
        System.out.println("3");
    }

    public EchoServer(String localAddr, int localPort) throws SocketException {
        nicPort = localPort;
        try {
            nicAddress = InetAddress.getByName(localAddr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        socket = new DatagramSocket(nicPort, nicAddress);
    }

    public void exit() {
        socket.close();
        stop();

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

