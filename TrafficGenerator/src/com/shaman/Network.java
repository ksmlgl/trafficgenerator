package com.shaman;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import org.eclipse.swt.widgets.Combo;



public class Network {

	
	public static void GetNetworkInterface(Combo combo)
	{
		combo.removeAll();
	try {
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets))
        {
        	Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            	combo.add(inetAddress.toString().substring(1));
            }
        }
		if (combo.getItemCount() != 0) {
			combo.select(0);
		}
	} catch (SocketException e) {
		e.printStackTrace();
	}
	}
	
}
