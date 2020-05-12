

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.google.common.io.Files;

public class VisualTestingUsingSekuli {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//BeforeDeployment();
		afterDeployment();


	}
	
public static void BeforeDeployment() throws Exception{
		
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriverwin.exe");
		
		
        
       
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        
        
       //String screenShotPath= System.getProperty("user.dir")+"//SnapShot//";
       
        takeSnapShot(driver,"home");
        
        driver.findElement(By.xpath("//a[@class='blockbestsellers']")).click();
        
        takeSnapShot(driver,"BestSeller");
        
        driver.close();

		
	}
	
	public static void afterDeployment() throws FindFailed{
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriverwin.exe");
		
       String screenShotPath= System.getProperty("user.dir")+"\\SnapShot\\";
        
		Screen s = new Screen();
        //Pattern home = new Pattern(screenShotPath + "home.png");
        
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        //s.wait(screenShotPath + "BestSeller.png", 20);
        Match flag= s.exists(screenShotPath+"BestSeller.PNG",20);
        //Match flag=  s.find(screenShotPath+"BestSeller.PNG");  // this will fail
        System.out.println("match"+flag);
        	if(flag!=null){
        		System.out.println("ScreenShot present");
        	}else{
        		System.out.println("screen Shot not matching");
        	}
        

        driver.findElement(By.xpath("//a[@class='blockbestsellers']")).click();
        s.exists(screenShotPath+"BestSeller.PNG");
        driver.close();


	}
	
	public static void takeSnapShot(WebDriver driver,String filename) throws Exception{

	
		String screenShotPath= System.getProperty("user.dir")+"//SnapShot//";
			Date date= new Date();
			Long time=date.getTime();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File(screenShotPath +filename+".png"));
			
		}
                
    }


