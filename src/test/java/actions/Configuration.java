package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration {
	
	static WebDriver driver;

	public static void openBrowser(String driverType) {
		
		if (driverType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\webdriver\\chromedriver.exe");
			 driver= new ChromeDriver();
		}
		
		else if (driverType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",  System.getProperty("user.dir")+"\\webdriver\\msedgedriver.exe");
			 driver= new EdgeDriver(); 
		} 
		
		else if (driverType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\webdriver\\geckodriver.exe");
			 driver= new FirefoxDriver();
		}
		
		//return driver;
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void refreshBrowser() {
		driver.navigate().refresh();
	}
	
	public static void sleepThread(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void openApplication(String appURL) {
		driver.manage().window().maximize();
		driver.get(appURL);
	}

}
	




