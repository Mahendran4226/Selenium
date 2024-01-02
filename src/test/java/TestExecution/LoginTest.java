package TestExecution;

import org.testng.annotations.Test;

import actions.BrowserActions;

public class LoginTest extends BaseClass {

	
	
	@Test
	public void login_Positive_Test() {
		
		BrowserActions.explicitWaitAction("name", "username");
		BrowserActions.sendKeysAction("name", "username", "Admin");
		BrowserActions.sendKeysAction("name", "password", "admin123");
		BrowserActions.clickAction("xpath", "//button[@type='submit']");
		BrowserActions.explicitWaitAction("xpath", "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
		BrowserActions.assertURLAction("true","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		
		
	}
}
