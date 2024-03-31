package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	public static Properties properties;
	private static String cofigPath = "config.properties";
	
	public static void init() {
		properties = new Properties();
		try {
			File jarPath=new File(ConfigProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
	        System.out.println(" propertiesPath-"+propertiesPath);
	        properties.load(new FileInputStream(propertiesPath + "\\config\\config.properties"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
