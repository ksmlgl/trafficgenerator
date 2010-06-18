/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.configs;

import java.util.prefs.Preferences;

/**
 *
 * @author AlexandruC
 */
public class Config {

    static Preferences pref = Preferences.userNodeForPackage(Config.class);
	private static String GENERAL_REFRASH = "general.refrash";

	public static int getGeneralRefrash()
	{
		return pref.getInt(GENERAL_REFRASH, 1000);
	}
	public static void setGeneralRefrash(int generalRefrash)
	{
		pref.putInt(GENERAL_REFRASH, generalRefrash);
	}
}
