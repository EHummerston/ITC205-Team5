package datamanagement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class AppProperties {
	
	private static AppProperties appProperties_ = null;
	private Properties properties_;

	
	public static AppProperties getInstance() {
		if (appProperties_ == null ) {
			appProperties_ = new AppProperties(); 
			
		} 
		return appProperties_;
		
	}
	
	
	private AppProperties() {
		properties_ = new Properties();
		try {
			properties_.load(new FileInputStream("Properties.prop"));
		} 
		catch (IOException e) {
			throw new RuntimeException("Could not read property file");
		}
		
	}
	
	
    public Properties getProperties() {
    	return properties_;
    	
    }

}
