/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.protocols;

/**
 *
 * @author AlexandruC
 */
public class ProtocolConfig {

    private static Protocol.Type type;
    private static Protocol.Direction direction;
    //Remote
    private static String ip;
    private static int ipPort;
    //Local
    private static String nic;
    private static int nicPort;
    //Traffic Sender
    private static int dataSize;
    private static int delay;

    static {
        clean();
    }

    public static void clean() {
        type = null;
        direction = null;
        //Remote
        ip = "";
        ipPort = 0;
        //Local
        nic = "";
        nicPort = 0;

        //Traffic Sender
        dataSize = 1024;
        delay = 1000;
    }

    public static void execute() {
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
     * @return the ip
     */
    public static String getIp() {
        return ip;
    }

    /**
     * @param aIp the ip to set
     */
    public static void setIp(String aIp) {
        ip = aIp;
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
     * @return the nic
     */
    public static String getNic() {
        return nic;
    }

    /**
     * @param aNic the nic to set
     */
    public static void setNic(String aNic) {
        nic = aNic;
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
}
