package TestExecution;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.BrowserActions;
import actions.Configuration;
import actions.ReadFromExcel;

public class LoginNegativeTest extends BaseClass {
	
	
	
	
	@Test(dataProvider = "logindata")
	public void login_Negative_Test(String name,String password) {
		
		BrowserActions.explicitWaitAction("name", "username");
		BrowserActions.sendKeysAction("name", "username",name );
		BrowserActions.sendKeysAction("name", "password", password);
		BrowserActions.clickAction("xpath", "//button[@type='submit']");
		Configuration.sleepThread(1000);
		BrowserActions.assertURLAction("false",
				"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		BrowserActions.refreshpage();
	}

	@DataProvider(name = "logindata")
	public Object[][] inputdata() {
		ReadFromExcel.uploadFile(new File(System.getProperty("user.dir")+"\\testdata\\data.xlsx"));
		//int datalength = ReadFromExcel.uploadSheet("login").length;
		return ReadFromExcel.uploadSheet("login");
		
	}
	
	
	
}
