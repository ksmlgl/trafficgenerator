/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman;

import java.lang.Thread.State;
import java.net.InetAddress;
import java.net.UnknownHostException;
import md.shaman.protocols.Protocol;

/**
 *
 * @author AlexandruC
 */
public class Test {

    public static void main(String args[]) throws UnknownHostException{

        //Protocol.isInetAddress("192.168.140.5");
        //System.out.println("192.18.140.556".matches("^*(([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])*$"));
        InetAddress ad = InetAddress.getByName("001.002.003.004");
        System.out.println(ad);

    }
}
