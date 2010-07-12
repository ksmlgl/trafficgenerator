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

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                ///try {
                    while (true) {
                        //wait(0);
                        System.out.println("Thread");
                    }
                    
                    
                    
                //} catch (InterruptedException ex) {
                   // System.out.println("Error");
               // }
            }
        };
        t.start();
        for(int i = 0; i < 100; i++)
        {
            System.out.println(t.getState());
        }
    }
}
