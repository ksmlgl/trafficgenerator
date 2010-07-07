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

        for(Protocol.Type pt : Protocol.Type.values())
        {
            System.out.println(pt.ordinal());
        }
    }
}
