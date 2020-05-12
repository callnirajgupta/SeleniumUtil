
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExample {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriverwin.exe");
		
		String filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\";
        String uploadFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\";
		Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "inputbox.PNG");
        Pattern openButton = new Pattern(filepath + "openbutton.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");
        s.exists(filepath+"guru.PNG");

        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        //s.wait(fileInputTextBox, 20);
        s.wait(filepath + "inputbox.PNG", 20);
        s.type(filepath + "inputbox.PNG", uploadFilePath + "abc.txt");
        //s.type(fileInputTextBox, uploadFilePath + "abc.txt");
        s.click(openButton);
        Thread.sleep(5000);
        // Close the browser
        driver.close();


	}
	public static String xpathcreation(int a){
		String xpath="//i[@class='a-icon a-icon-star-medium a-star-medium-Number']";
		
	
		 return  xpath.replace("Number", Integer.toString(a));
		}

}
