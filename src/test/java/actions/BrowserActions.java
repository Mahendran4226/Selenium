package actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class BrowserActions {
	
	public static void clickAction(String locatorType,String locatorValue) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		Configuration.driver.findElement(byvalue).click();
	}
	
	public static void sendKeysAction(String locatorType,String locatorValue,String text) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		Configuration.driver.findElement(byvalue).sendKeys(text);
	}
	
	public String getTextAction(String locatorType,String locatorValue) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		String textvalue = Configuration.driver.findElement(byvalue).getText();
		return textvalue;
	}
	
	public String getAttributeValueAction(String locatorType,String locatorValue,String attribute) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		String attributevalue =  Configuration.driver.findElement(byvalue).getAttribute(attribute);
		return attributevalue;
	}
	
	public void selectByTextAction(String locatorType,String locatorValue,String selecttype, String selectvalue) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		Select select= new Select(Configuration.driver.findElement(byvalue));
		
		if(selecttype.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(selectvalue));
		}
		else if(selecttype.equalsIgnoreCase("text")) {
			select.deselectByVisibleText(selectvalue);
		}
	}
	
	public static void takeScreenShotAction(String storepath) {
		
		TakesScreenshot sc= (TakesScreenshot)Configuration.driver;
		File srcFile=  sc.getScreenshotAs(OutputType.FILE);
		File destFile = new File(storepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void assertURLAction(String booleanvalue,String expectedURL) {
		
		if (booleanvalue.equalsIgnoreCase("true")) {
		String actualURL = Configuration.driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		}
		else if (booleanvalue.equalsIgnoreCase("false")) {
			String actualURL = Configuration.driver.getCurrentUrl();
			Configuration.sleepThread(2000);
			Assert.assertNotEquals(actualURL,expectedURL);
		}
	}
	
	public static void performAction(String locatorType,String locatorValue, String actiontype) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		Actions act= new Actions(Configuration.driver);
		WebElement tagetelement = Configuration.driver.findElement(byvalue);
		if(actiontype.equalsIgnoreCase("movetoelement")) {
		act.moveToElement(tagetelement).perform();
		}
		else if (actiontype.equalsIgnoreCase("click")) {
			act.click(tagetelement);
		}
	}
	
	public static void alertHandleAction(String alertaction) {
		Alert alert= Configuration.driver.switchTo().alert();
		
		if(alertaction.equalsIgnoreCase("accept")) {
			alert.accept();
		}
		else if(alertaction.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}
	}
	
	public static void getImageAction(String locatorType,String locatorValue) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		 WebElement logo = Configuration.driver.findElement(byvalue);
	     String logoSRC = logo.getAttribute("src");
	     try {
	    	 
	     URL imageURL = new URL(logoSRC);
	     BufferedImage saveImage = ImageIO.read(imageURL);
	     
	     ImageIO.write(saveImage, "png", new File(System.getProperty("user.dir")+"\\images\\"+"copyimage.png"));
	    
	     }catch (Exception e) {
			// TODO: handle exception
	    	 System.out.println(e);
		}
	}
	
	public static  void assertImageAction(String locatorType,String locatorValue,String expectediamgepath) {
		
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		 WebElement logo = Configuration.driver.findElement(byvalue);
	     String logoSRC = logo.getAttribute("src");
	     try {
	     BufferedImage expectediamge = ImageIO.read(new File(expectediamgepath));
	     URL imageURL = new URL(logoSRC);
	     BufferedImage actualImage = ImageIO.read(imageURL);
	     
	     //ImageIO.write(actualImage, "png", new File(System.getProperty("user.dir")+"\\images\\"+"copyimage.png"));
	   
	     ImageDiffer imgDiff = new ImageDiffer();
	        ImageDiff diff = imgDiff.makeDiff(actualImage, expectediamge);
	        if(diff.hasDiff()==true)
	        {
	         System.out.println("Images are Not Same");
	        }
	        else {
	         System.out.println("Images are Same");
	        }
	     
	     }catch (Exception e) {
				// TODO: handle exception
		    	 System.out.println(e);
			}
	}
	
	public static void jsscrolltAction(String locatorType,String locatorValue,String scrollType) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		WebElement element = Configuration.driver.findElement(byvalue);
		JavascriptExecutor js = (JavascriptExecutor)Configuration.driver;
		if (scrollType.equalsIgnoreCase("view")) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		else if (scrollType.equalsIgnoreCase("bottom")){
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}
		else if (scrollType.equalsIgnoreCase("top")){
			js.executeScript("window.scrollTo(0, 0);");
		}	
	}
	
	public static void jsmouseAction(String locatorType,String locatorValue,String actiontype) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		WebElement element = Configuration.driver.findElement(byvalue);
		JavascriptExecutor js = (JavascriptExecutor)Configuration.driver;
		if (actiontype.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click();", element);
		}
		else if (actiontype.equalsIgnoreCase("mouseover")) {
			js.executeScript("arguments[0].onmouseover();", element);
		}
	}
	 
	public static void refreshpage() {
		JavascriptExecutor js = (JavascriptExecutor)Configuration.driver;
		js.executeScript("location.reload();");
	}
	
	public static void explicitWaitAction(String locatorType,String locatorValue) {
		By byvalue = LocatorsOptions.locatorType(locatorType, locatorValue);
		WebDriverWait wait=new WebDriverWait(Configuration.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(byvalue));
	}
	
public void jsotheractions() {
		
		///Handling Alerts, Prompts, and Confirmations:
		//Accept an alert:
		//((JavascriptExecutor) driver).executeScript("window.confirm = function() { return true; }");
		
		//Dismiss an alert:
		//((JavascriptExecutor) driver).executeScript("window.confirm = function() { return false; }");
		
		//Enter text in a prompt:
		//((JavascriptExecutor) driver).executeScript("window.prompt = function(msg) { return 'your_text'; }");
		
		//Working with Windows and Frames:
		//((JavascriptExecutor) driver).executeScript("window.prompt = function(msg) { return 'your_text'; }");
		
		//Switch to a frame:
		//((JavascriptExecutor) driver).executeScript("driver.switchTo().frame(arguments[0]);", frameElement);
		
		//Injecting Code:
		//((JavascriptExecutor) driver).executeScript("your_javascript_code_here");
		
		//Handling Dynamic Content:
		//((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", element);
		
		//Retrieving Information:
		//Get the text of an element:
		//String text = (String)((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
		
		//Get the value of an attribute:
		//String value = (String)((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('value');", element);
	}
	
}
