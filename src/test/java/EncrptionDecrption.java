

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncrptionDecrption {
	
	
	private static SecretKeySpec secretKey;
    private static byte[] key;
    public static void main(String[] args) throws IOException, InterruptedException 
    
    {
    	
    	FileReader reader=new FileReader(System.getProperty("user.dir")+"//src/test//resources//config.properties");
    	
    	Properties propert= new Properties();
    	propert.load(reader);
    	
    	String userName=propert.get("UserName").toString();
    	//String original_password= propert.get("original_password").toString();
    	String encyptedPassword=propert.get("pasword").toString();
    	String secretKey=propert.get("key").toString();
    	
        
         
     
        //String encryptedString = EncrptionDecrption.encrypt("password1", secretKey) ;
       String decryptedString = EncrptionDecrption.decrypt(encyptedPassword, secretKey) ;
         
        System.out.println("*******************");
        //System.out.println(encryptedString);
        System.out.println(decryptedString);
        
        login(userName,decryptedString);
    }
    
    
    public static void login(String user,String pass) throws InterruptedException{
    	
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("http://automationpractice.com/index.php");
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
    	Thread.sleep(5000);
    	driver.findElement(By.className("login")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.id("email")).sendKeys(user);
    	driver.findElement(By.id("passwd")).sendKeys(pass);
    	driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[text()='niraj gupta']")).isDisplayed();
    	Thread.sleep(3000);
    	
    }
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
