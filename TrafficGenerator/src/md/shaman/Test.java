/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman;

import java.io.IOException;
import java.lang.Thread.State;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import md.shaman.protocols.Protocol;
import md.shaman.protocols.ProtocolThread;
import md.shaman.protocols.ProtocolThreadUtilities;
import md.shaman.protocols.udp.EchoClient;
import md.shaman.protocols.udp.EchoServer;
import md.shaman.utils.ThreadUtilities;

/**
 *
 * @author AlexandruC
 */
public class Test {

    public static void main(String args[]) throws UnknownHostException, InterruptedException, IOException, ClassNotFoundException{
        ProtocolThread pt = new EchoClient("localhost",5000,"127.0.0.1",5000,500, 3, 1000);
           System.out.println("Thread[" + pt.getId() + ":" + pt.getName()
                        + ":" + pt.getClass() + ":"+pt.getThreadGroup().getName()+"]");
           System.out.println(pt);
           
           pt.start();
           Thread.sleep(4000);
           System.out.println(pt);
//           ProtocolThread ptu =  ProtocolThreadUtilities.getProtocolThread(pt.getId(),Thread.currentThread().getThreadGroup());
//           System.out.println("Thread[" + ptu.getId() + ":" + ptu.getName()
//                        + ":" + ptu.getClass() + ":"+ptu.getThreadGroup().getName()+"]");
           
           // Walk up all the way to the root thread group
//        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
//        ThreadGroup parent;
//        while ((parent = rootGroup.getParent()) != null) {
//            rootGroup = parent;
//        }
       // listThreads(ProtocolThreadUtilities.getRootThreadGroup(), "");
           //pt.exit();
    }
    // List all threads and recursively list all subgroup
    public static void listThreads(ThreadGroup group, String indent) {
        System.out.println(indent + "Group[" + group.getName() +
                        ":" + group.getClass()+"]");
        int nt = group.activeCount();
        Thread[] threads = new Thread[nt*2 + 10]; //nt is not accurate
        nt = group.enumerate(threads, false);

        // List every thread in the group
        for (int i=0; i<nt; i++) {
            Thread t = threads[i];
            System.out.println(indent + "  Thread[" + t.getId() + ":" + t.getName()
                        + ":" + t.getClass() + "]");
        }

        // Recursively list all subgroups
        int ng = group.activeGroupCount();
        ThreadGroup[] groups = new ThreadGroup[ng*2 + 10];
        ng = group.enumerate(groups, false);

        for (int i=0; i<ng; i++) {
            listThreads(groups[i], indent + "  ");
        }
    }
}
