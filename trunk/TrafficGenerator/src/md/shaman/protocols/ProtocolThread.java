/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.protocols;

import java.net.InetAddress;

/**
 *
 * @author AlexandruC
 */
public class ProtocolThread extends Thread {

    private Protocol.Type type = null;
    private InetAddress ipAddress;
    private int ipPort;
    private InetAddress nicAddress;
    private int nicPort;
    private long packetNo;
    private long trafficSize;

//    public ProtocolThread(Protocol.Type t)
//    {
//        type = t;
//    }

    /**
     * @return the type
     */
    public Protocol.Type getType() {
        return type;
    }

    /**
     * @return the ipAddress
     */
    public InetAddress getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the ipPort
     */
    public int getIpPort() {
        return ipPort;
    }

    /**
     * @param ipPort the ipPort to set
     */
    public void setIpPort(int ipPort) {
        this.ipPort = ipPort;
    }

    /**
     * @return the nicAddress
     */
    public InetAddress getNicAddress() {
        return nicAddress;
    }

    /**
     * @param nicAddress the nicAddress to set
     */
    public void setNicAddress(InetAddress nicAddress) {
        this.nicAddress = nicAddress;
    }

    /**
     * @return the nicPort
     */
    public int getNicPort() {
        return nicPort;
    }

    /**
     * @param nicPort the nicPort to set
     */
    public void setNicPort(int nicPort) {
        this.nicPort = nicPort;
    }

    /**
     * @return the packetNo
     */
    public long getPacketNo() {
        return packetNo;
    }

    /**
     * @return the trafficSize
     */
    public long getTrafficSize() {
        return trafficSize;
    }
}
