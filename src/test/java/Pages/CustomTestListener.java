package Pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener{
	private WebDriver driver;
	
	

   // TODO Auto-generated constructor stub
	

	public CustomTestListener(WebDriver driver) {
		 this.driver = driver;
	}

	public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName() + "_Failure");
    }

    public void onTestSuccess(ITestResult result) {
        captureScreenshot(result.getName() + "_Success");
    }

    public void onTestSkipped(ITestResult result) {
        // Implement if needed
    }

    public void onTestStart(ITestResult result) {
        // Implement if needed
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implement if needed
    }

    public void onStart(ITestContext context) {
        // Initialize WebDriver or other setup
    }

    public void onFinish(ITestContext context) {
        // Cleanup and quit WebDriver
    }

    private void captureScreenshot(String screenshotName) {
        try {
        	//driver = ((saucedemo1) result.getInstance()).getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "src/test/resources/screenshot/" + screenshotName + ".png";
            System.out.println("Screenshot Path: " + dest);
            FileUtils.copyFile(source, new File(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
