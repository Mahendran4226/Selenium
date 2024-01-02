package TestExecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import actions.Configuration;

public class BaseClass {

	@BeforeClass
	public void setup() {
	//Configure the browser tha you want to test, keep your browser under the webdriver folder
	//chrome || edge  || firefox
	Configuration.openBrowser("edge");
	Configuration.openApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	
	}
	
	//This action will close your current browser
	
	@AfterClass
	public void teardown() {
		Configuration.closeBrowser();
	}

	
	
}
