/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman;

import java.lang.Thread.State;

/**
 *
 * @author AlexandruC
 */
public class Test {

    public static void main(String args[]){
        for(State s : Thread.State.values())
            System.out.println(s.toString());
    }
}
