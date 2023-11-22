package demo;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class Hooks {
	private WebDriver driver;

    public Hooks(WebDriver driver) {
        this.driver = driver;
    }
	
	/*
	 * public static void captureScreenshot(WebDriver driver, String screenshotname)
	 * { try { TakesScreenshot ts=(TakesScreenshot)driver; File
	 * source=ts.getScreenshotAs(OutputType.FILE); String
	 * dest="src/test/resources/screenshot/" + screenshotname + ".png";
	 * FileUtils.copyFile(source, new File(dest));
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
    
    @After(order = 1) // This hook will run after each scenario
    public void captureScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (Exception e) {
            	 TakesScreenshot ts = (TakesScreenshot) driver;
                 byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                 scenario.attach(screenshot, "image/png", "Screenshot attached");
            }
        }
    }

}
