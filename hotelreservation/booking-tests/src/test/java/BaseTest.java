import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author Raja
 *
 */
public class BaseTest {
	
	protected WebDriver driver;
	


	@BeforeClass
	@Parameters({"navigateTo_url","browser"})
	public void init(String navigateTo_Url,String browser) throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(navigateTo_Url);
		driver.manage().window().maximize();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void createDriver(String browser) throws MalformedURLException
	{
        if(browser.equalsIgnoreCase("chrome")){
        	
            ChromeOptions options = new ChromeOptions();
           
            driver = new ChromeDriver(options);
	    }
	    else if(browser.equalsIgnoreCase("ie")){
	        driver = new InternetExplorerDriver();
	    }
	    else{
	        driver = new FirefoxDriver();
	    }
	
	}
	
	@AfterTest
	public void quitDriver()
	{
	   driver.quit();
	}

}
