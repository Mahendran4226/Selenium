package actions;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class Listeners implements ITestListener  {
	
@Override
public void onTestFailure(ITestResult result) {
	ITestNGMethod methodName = result.getMethod();
	String name = methodName.getMethodName();
	BrowserActions.takeScreenShotAction(System.getProperty("user.dir")+"\\images\\"+name+".png");
	System.out.println(methodName);
}
}
