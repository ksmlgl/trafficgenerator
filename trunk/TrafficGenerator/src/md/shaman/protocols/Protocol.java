package md.shaman.protocols;

public class Protocol {

    public enum ProtocolType {
        UDP,
        TCP,
        MULTICAST
    }

    public enum Direction{
        SEND,
        RECEIVE
    }

    public static boolean isInetAddress(String str) {
        return str.matches("^([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$");
    }

    public static boolean isInetAddressPort(String str) {
        return str.matches("\\d+");
    }
}
