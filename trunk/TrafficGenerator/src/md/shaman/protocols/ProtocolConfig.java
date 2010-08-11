/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.protocols;

import java.io.IOException;
import md.shaman.protocols.multicast.BroadcastClient;
import md.shaman.protocols.multicast.BroadcastServer;
import md.shaman.protocols.tcp.TCPClient;
import md.shaman.protocols.tcp.TCPServer;
import md.shaman.protocols.udp.EchoClient;
import md.shaman.protocols.udp.EchoServer;

/**
 *
 * @author AlexandruC
 */
public class ProtocolConfig {

    private static Protocol.Type type;
    private static Protocol.Direction direction;
    //Remote
    private static String ipAddress;
    private static int ipPort;
    //Local
    private static String nicAddress;
    private static int nicPort;
    //Traffic Sender
    private static int packetNo;
    private static int dataSize;
    private static int delay;
    //Configuration
    private static boolean startNow;

    static {
        clean();
    }

    public static void clean() {
        type = null;
        direction = null;
        //Remote
        ipAddress = "";
        ipPort = 0;
        //Local
        nicAddress = "";
        nicPort = 0;

        //Traffic Sender
        dataSize = 1024;
        delay = 1000;
    }

    public static ProtocolThread execute() throws IOException {
        switch (direction) {
            case SEND: {
                switch (type) {
                    case UDP:
                        return new EchoClient(ipAddress, ipPort, nicAddress, nicPort, dataSize, packetNo, delay);
                    case TCP:
                        return new TCPClient(ipAddress, ipPort, nicAddress, nicPort, dataSize, packetNo, delay);
                    case MULTICAST:
                        return new BroadcastServer(ipAddress, ipPort, nicAddress, nicPort, dataSize, packetNo, delay);
                }
            }
            case RECEIVE: {
                switch (type) {
                    case UDP:
                        return new EchoServer(nicAddress, nicPort);
                    case TCP:
                        return new TCPServer(nicAddress, nicPort);
                    case MULTICAST:
                        return new BroadcastClient(ipAddress, nicAddress, nicPort);
                }
            }
        }
        return null;
    }

    /**
     * @return the type
     */
    public static Protocol.Type getType() {
        return type;
    }

    /**
     * @param aType the type to set
     */
    public static void setType(Protocol.Type aType) {
        type = aType;
    }

    public static void setType(String aType) {
        type = Protocol.Type.valueOf(aType);
    }

    /**
     * @return the direction
     */
    public static Protocol.Direction getDirection() {
        return direction;
    }

    /**
     * @param aDirection the direction to set
     */
    public static void setDirection(Protocol.Direction aDirection) {
        direction = aDirection;
    }

    public static void setDirection(String aDirection) {
        direction = Protocol.Direction.valueOf(aDirection);
    }

    /**
     * @return the ipAddress
     */
    public static String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param aIp the ipAddress to set
     */
    public static void setIpAddress(String aIpAddress) {
        ipAddress = aIpAddress;
    }

    /**
     * @return the ipPort
     */
    public static int getIpPort() {
        return ipPort;
    }

    /**
     * @param aIpPort the ipPort to set
     */
    public static void setIpPort(int aIpPort) {
        ipPort = aIpPort;
    }

    public static void setIpPort(String aIpPort) {
        if (!aIpPort.isEmpty()) {
            ipPort = Integer.parseInt(aIpPort);
        }
    }

    /**
     * @return the nicAddress
     */
    public static String getNicAddress() {
        return nicAddress;
    }

    /**
     * @param aNic the nicAddress to set
     */
    public static void setNicAddress(String aNicAddress) {
        nicAddress = aNicAddress;
    }

    /**
     * @return the nicPort
     */
    public static int getNicPort() {
        return nicPort;
    }

    /**
     * @param aNicPort the nicPort to set
     */
    public static void setNicPort(int aNicPort) {
        nicPort = aNicPort;
    }

    public static void setNicPort(String aNicPort) {
        if (!aNicPort.isEmpty()) {
            nicPort = Integer.parseInt(aNicPort);
        }
    }

    /**
     * @return the dataSize
     */
    public static int getDataSize() {
        return dataSize;
    }

    /**
     * @param aDataSize the dataSize to set
     */
    public static void setDataSize(int aDataSize) {
        dataSize = aDataSize;
    }

    public static void setDataSize(String aDataSize) {
        dataSize = Integer.parseInt(aDataSize);
    }

    /**
     * @return the delay
     */
    public static int getDelay() {
        return delay;
    }

    /**
     * @param aDelay the delay to set
     */
    public static void setDelay(int aDelay) {
        delay = aDelay;
    }

    public static void setDelay(String aDelay) {
        delay = Integer.parseInt(aDelay);
    }

    /**
     * @return the packetNo
     */
    public static int getPacketNo() {
        return packetNo;
    }

    /**
     * @param aPacketNo the packetNo to set
     */
    public static void setPacketNo(int aPacketNo) {
        packetNo = aPacketNo;
    }
    public static void setPacketNo(String aPacketNo) {
        packetNo = Integer.parseInt(aPacketNo);
    }

    /**
     * @return the startNow
     */
    public static boolean isStartNow() {
        return startNow;
    }

    /**
     * @param aStartNow the startNow to set
     */
    public static void setStartNow(boolean aStartNow) {
        startNow = aStartNow;
    }
}
