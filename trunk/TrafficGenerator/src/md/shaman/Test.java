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

        String s1 = "aaaa";
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("Editing .....");
        s1= "bbbbb";
        System.out.println(s1);
        System.out.println(s2);
    }
}
