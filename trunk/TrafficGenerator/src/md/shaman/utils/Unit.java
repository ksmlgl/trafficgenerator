/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.utils;

import java.text.DecimalFormat;

/**
 *
 * @author AlexandruC
 */
public class Unit {
    public static String CapacityConvertor(double length) {
		DecimalFormat df = new DecimalFormat("0.000");
		if (length >= 1073741824)
			return df.format(length / 1024 / 1024 / 1024) + " GB";
		else if (length >= 1048576)
			return df.format(length / 1024 / 1024) + " MB";
		else if (length >= 1024)
			return df.format(length / 1024) + " KB";
		else if (length < 1024)
			return df.format(length) + " B";
		return "0 B";
	}
}
