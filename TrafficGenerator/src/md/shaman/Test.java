/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman;

import java.lang.Thread.State;
import md.shaman.protocols.Protocol;

/**
 *
 * @author AlexandruC
 */
public class Test {

    public static void main(String args[]){
        for(Protocol.ProtocolType s : Protocol.ProtocolType.values())
            System.out.println(s.toString());
    }
}
