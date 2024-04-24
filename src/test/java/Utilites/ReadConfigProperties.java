package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {
	Properties prop;
	public ReadConfigProperties() throws IOException {
	 prop=new Properties();
	File file=new File(".\\config.properties");
	FileInputStream fis=new FileInputStream(file);
	prop.load(fis);
		
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	public String getBrowserName() {
		return prop.getProperty("browser");
	}
}
