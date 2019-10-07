package Base;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {
	public WebDriver driver;
	public static Properties property;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static LinkedHashMap<String, String> testdataMap;
	public static int rownum = 1;
	public static String scenarioName;
	public static String description;
	
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"src/test/resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//System.getProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/MicrosoftWebDriver");
			driver = new EdgeDriver();
		}
		else {
			System.out.println(browserName+" not found, Please specify the correct browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tdriver.set(driver);
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public Properties init_properties() {
		property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
			property.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return property;
	}

}
