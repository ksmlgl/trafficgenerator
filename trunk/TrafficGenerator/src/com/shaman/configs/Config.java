package com.shaman.configs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	static Properties cnfg = new Properties();
	static String filePath = "./config/config.properties";
	static 
	{
		try
		{
			
			cnfg.load(new FileInputStream(filePath));

		}
		catch (Exception e)
		{
			throw new Error("Can't load TNT configuration", e);
		}
	}
	public static void Store()
	{
		
		try {
			cnfg.store(new FileOutputStream(filePath), "System Store");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getGeneralRefrash()
	{
		return Integer.parseInt(cnfg.getProperty("general.refrash","1000"));
	}
	public static void setGeneralRefrash(int generalRefrash)
	{
		cnfg.setProperty("general.refrash", ""+generalRefrash);
	}
}
