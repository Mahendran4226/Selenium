package actions;

import org.openqa.selenium.By;

public class LocatorsOptions {

	static By byValue;
	 

	public static By locatorType(String locatorType, String locatorvalue) {

		if (locatorType.equalsIgnoreCase("id")) {
			byValue = By.id(locatorvalue);
		} 
		
		else if (locatorType.equalsIgnoreCase("name")) {
			byValue = By.name(locatorvalue);
		}
		
		else if (locatorType.equalsIgnoreCase("className")) {
			byValue = By.className(locatorvalue);
		}
		
		else if (locatorType.equalsIgnoreCase("tagName")) {
			byValue = By.tagName(locatorvalue);
		}
		
		else if (locatorType.equalsIgnoreCase("xpath")) {
			byValue = By.xpath(locatorvalue);
		}
		
		else if (locatorType.equalsIgnoreCase("linkText")) {
			byValue = By.linkText(locatorvalue);
		}
		
		else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			byValue = By.partialLinkText(locatorvalue);
		}

		else if (locatorType.equalsIgnoreCase("CSSselector")) {
			byValue = By.cssSelector(locatorvalue);
		}
		
		return byValue;
		
	}

}
