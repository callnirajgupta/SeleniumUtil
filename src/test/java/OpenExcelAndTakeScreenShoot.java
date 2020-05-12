

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OpenExcelAndTakeScreenShoot {

	public static void main(String[] args) throws HeadlessException, AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		try{  
	          Runtime.getRuntime().exec("cmd /c" +System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelUsedForScreenShot.xlsx");  
	          }catch(IOException  e){
	              e.printStackTrace();
	          }  
		
		Thread.sleep(10000);
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(System.getProperty("user.dir")+"//src//test//resources//screenshot.png"));
     
		
		
		try {
	        Runtime.getRuntime().exec("taskkill /f /t /IM EXCEL.EXE");
	        Thread.sleep(1000);
	    }
	    catch (IOException ex) {
	        //Logger.getLogger(ClassName.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

}
