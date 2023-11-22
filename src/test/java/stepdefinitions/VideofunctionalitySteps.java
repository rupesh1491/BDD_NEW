package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class VideofunctionalitySteps {
	
	


private WebDriver driver;
private WebDriverWait wait;
private Actions actions;

@Given("I am on the Daily Mail Video Page")
public void launchApp() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
    driver = new ChromeDriver(options);
    
    actions = new Actions(driver);
    driver.manage().window().maximize();
    driver.get("https://www.dailymail.co.uk/video/index.html");
    wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
}



@And("I click on a video to begin playback")
public void clickToPlayVideo() throws InterruptedException {
    WebElement videoPlayer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vjs-play-control vjs-control ' and @role='button']")));
    videoPlayer.click();
    Thread.sleep(1000);
}

@And("I click the video to pause playback")
public void clickToPauseVideo() {
    WebElement videoPlayer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vjs-play-control vjs-control  vjs-playing' and @role='button']")));
    videoPlayer.click();
}

@And("I click the forward arrow")
public void clickForwardArrow() throws InterruptedException {
	
	 
	Thread.sleep(100);
	//Actions actions = new Actions(driver);
	WebElement forwardArrow = driver.findElement(By.xpath("(//div[@class='mol-skip-control vjs-control' and @role='button'])[1]"));

	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forwardArrow);
	// forwardArrow.click();
     Thread.sleep(1000);

	
	forwardArrow.click();
}

@And("I click the back arrow")
public void clickBackArrow() throws InterruptedException {
	Actions actions = new Actions(driver);
	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50000));
    WebElement backArrow = driver.findElement(By.xpath("(//div[@class='mol-previous-control vjs-control'])[1]"));
    actions.moveToElement(backArrow).build().perform();
	Thread.sleep(1000);
    actions.click(backArrow).build().perform();
}

@And("I click on the speaker icon to mute the video")
public void clickToMuteVideo() throws InterruptedException {
	Actions actions = new Actions(driver);

    WebElement speakerIcon = driver.findElement(By.xpath("//div[text()='LIVE']//following::div[1]"));
	actions.moveToElement(speakerIcon);
	Thread.sleep(1000);
    speakerIcon.click();
}

@And("I click on the speaker icon again to unmute the video")
public void clickToUnmuteVideo() throws InterruptedException {
    
//WebElement speakerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='LIVE']//following::div)[1]")));
WebElement speakerIcon = driver.findElement(By.xpath("(//div[text()='LIVE']//following::div)[1]"));
	actions.moveToElement(speakerIcon);
	Thread.sleep(1000);
    speakerIcon.click();
}

//@SuppressWarnings("deprecation")
@And("I verify next video autoplay after current video finishes")
public void verifyAutoplay() throws InterruptedException {
	 WebElement currentTitleElement = driver.findElement(By.xpath("//*[@class='vjs-title-text']//div"));
	    String currentTitle = currentTitleElement.getText();

	    // Wait for the current video to finish playing
	    WebDriverWait currentVideoWait = new WebDriverWait(driver, Duration.ofSeconds(900));
	    currentVideoWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(), '" + currentTitle + "')]")));

	    // Wait for the next video's title to appear
	    WebElement nextTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='vjs-title-text']//div")));
	    
	    // Get the text of the next video's title
	    String nextTitle = nextTitleElement.getText();
	   Assert.assertNotSame("Next video did not auto-play after current video finished", currentTitle, nextTitle) ;
	   
	   // Assert.assertNotEquals("Next video did not auto-play after current video finished", currentTitle, nextTitle);
	}
	



 @After public void tearDown() { 
	 if (driver != null) {
         driver.quit();
     } 
	 } 
 
}