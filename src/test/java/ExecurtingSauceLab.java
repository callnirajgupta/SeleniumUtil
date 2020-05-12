

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExecurtingSauceLab {

	
		// TODO Auto-generated method stub
		
		public static final String USERNAME = "roboticautomation";
		  public static final String ACCESS_KEY = "5a8cbd77-9240-46e2-bc4d-8db1a4190794";
		  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		 
		  public static void main(String[] args) throws Exception {
		 
		    DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "65");
		 
		    RemoteWebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		 
		    /**
		     * Goes to Sauce Lab's guinea-pig page and prints title
		     */
		 
		    driver.get("http://www.amazon.com");
		    System.out.println("title of page is: " + driver.getTitle());
		 
		    driver.quit();


	}

}
