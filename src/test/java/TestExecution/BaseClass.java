package TestExecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import actions.Configuration;

public class BaseClass {

	@BeforeClass
	public void setup() {
	//chrome || edge  || firefox
	Configuration.openBrowser("edge");
	Configuration.openApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	
	}
	
	@AfterClass
	public void teardown() {
		Configuration.closeBrowser();
	}

	
	
}
