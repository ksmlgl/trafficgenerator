package md.shaman.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StringUtils {
	public static String InputStreamToString(InputStream is)
	{
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;
			
			try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
			}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return sb.toString();
			} else {       
			return "";
			}
	}

}
