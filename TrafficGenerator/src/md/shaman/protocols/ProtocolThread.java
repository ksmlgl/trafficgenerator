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

    protected Protocol.Type type = null;
    protected Protocol.Direction direction = null;
    protected InetAddress ipAddress;//Internet Protocol address
    protected int ipPort;//Internet Protocol port
    protected InetAddress nicAddress;//Network Interface Address
    protected int nicPort;//Network Interface Card port
    protected long packetNo = 0;//How meny packets need to send
    protected long packetSendReceive = 0; //How meny packets are Send/Receive {Statistic}
    protected  int packetSize;//Packet Size
    protected long trafficSize;//Calculate Send/Receive Traffic {Statistic}
    protected long delay;//Delay between packets
    protected boolean randomMessage = true;

    /**
     * Reset Protocol Statistics
     */
    public void resetStatistic()
    {
        packetSendReceive = 0;
        trafficSize = 0;
    }

    /*
     * Pause Protocol Thread
     */
    public void pause(){}

    /*
     * Restart Protocol Thread
     */
    public void restart(){}

    

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

    /**
     * @return the packetSize
     */
    public int getPacketSize() {
        return packetSize;
    }

    /**
     * @param packetSize the packetSize to set
     */
    public void setPacketSize(int packetSize) {
        this.packetSize = packetSize;
    }

    /**
     * @return the delay
     */
    public long getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * @return the packetSendReceive
     */
    public long getPacketSendReceive() {
        return packetSendReceive;
    }

    /**
     * @return the direction
     */
    public Protocol.Direction getDirection() {
        return direction;
    }

    /**
     * @return the randomMessage
     */
    public boolean isRandomMessage() {
        return randomMessage;
    }

    /**
     * @param randomMessage the randomMessage to set
     */
    public void setRandomMessage(boolean randomMessage) {
        this.randomMessage = randomMessage;
    }
}
