package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtilities {
 public String readDataFromProperties(String key) throws IOException {
	 FileInputStream pfis = new FileInputStream("./congAppData/commonData.properties");
	 Properties prop = new Properties();
	 prop.load(pfis);
	String data = prop.getProperty(key);
	 return data;
	 
 }
}
