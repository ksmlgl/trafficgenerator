/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman;

import java.lang.Thread.State;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.shaman.protocols.Protocol;

/**
 *
 * @author AlexandruC
 */
public class Test {

    public static void main(String args[]) throws UnknownHostException{
           InetAddress i = InetAddress.getByName("192.168.140.25");
           System.out.println(i.toString().substring(1));
    }
}
