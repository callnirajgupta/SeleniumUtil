import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerBrowser {

	public static void main(String[] args) {
	
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		
		//WebDriverManager.chromedriver().setup();  
		WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgedriver().setup();
		//WebDriverManager.operadriver().setup();
		//WebDriverManager.phantomjs().setup();
		//WebDriverManager.iedriver().setup();
		//WebDriverManager.chromiumdriver().setup();
		
		//WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        
        
       //String screenShotPath= System.getProperty("user.dir")+"//SnapShot//";
       
       
        
        driver.findElement(By.xpath("//a[@class='blockbestsellers']")).click();
        
       
        
        driver.close();

		

	}

}
