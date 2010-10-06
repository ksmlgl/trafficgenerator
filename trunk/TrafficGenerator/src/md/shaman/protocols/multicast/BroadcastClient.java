package md.shaman.protocols.multicast;

import java.net.*;
import java.io.*;
import md.shaman.protocols.Protocol.Direction;
import md.shaman.protocols.Protocol.Type;
import md.shaman.protocols.ProtocolThread;

public class BroadcastClient extends ProtocolThread {

    MulticastSocket socket;
    DatagramPacket packet;

    public static void main(String args[]) throws Exception {
    } // main

    public BroadcastClient(String ipAddress, int ipPort, String nicAddress, int nicPort) throws IOException {
        this.ipPort = ipPort;//Deprication
        this.nicPort = nicPort;
        this.type = Type.MULTICAST;
        this.direction = Direction.RECEIVE;
        try {
            this.nicAddress = InetAddress.getByName(nicAddress);
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
        }
        socket = new MulticastSocket(this.nicPort);
        socket.setInterface(this.nicAddress);
        socket.joinGroup(this.ipAddress);
    }

    public void exit() {
        stop();
        socket.close();
    }

    public void run() {

        byte[] data = new byte[packetSize];
        packet = new DatagramPacket(data, data.length);

        for (;;) {
            // receive the packets
            try {
                socket.receive(packet);
                packetSendReceive++;
                String str = new String(packet.getData());
                System.out.println(" Time signal received from"
                        + packet.getAddress() + " Time is : " + str);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // for
    }
} // class Broadcast

