import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DownloadingPDFInchromeAndFireFox {
	
	public static void main(String[] args) throws InterruptedException {
		// download using Chrome
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriverwin.exe");
		String downloadFilepath = System.getProperty("user.dir")+"\\src\\test\\resources\\Download";
		// this setting for downloading pdf from chrome
		
		/*HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("pdfjs.disabled", true);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
		chromePrefs.put("plugins.plugins_disabled", "Chrome PDF Viewer");
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);	
				
		
		*/
		//Firefox download path
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadFilepath);
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip");
		options.addPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer
		//options.setCapability("marionette", true);
		 
		WebDriver driver = new FirefoxDriver(options);
        String baseUrl = "https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/";


        driver.get(baseUrl);
        Thread.sleep(10000);
        
        driver.findElement(By.xpath("(//a[text()='Download sample pdf file'])[1]")).click();
        
		System.out.println("completed test");
		 
	}



}
