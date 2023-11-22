package stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewspaperDownloadSteps {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the MailPlus website")
    public void i_am_on_the_mail_plus_website() {
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get("https://www.mailplus.co.uk");
        
    }

    @When("I scroll down to the Recent issues and tap on showall")
    public void i_scroll_down_to_the_recent_issues_and_tap_on() throws InterruptedException  {
    	try {
    	driver.findElement(By.xpath("//*[text()='Newspaper']")).click();
    	Thread.sleep(1000);
    	WebElement fra=driver.findElement(By.xpath("//iframe[contains(@id,'offer_')]"));
    	driver.switchTo().frame(fra);
    	driver.findElement(By.xpath("//*[contains(text(),'Already a subscriber')]//button[text()='Sign in']")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("(//span[@class='modal-close'])[1]")).click();
    	WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
        Thread.sleep(100);
		
        WebElement seeMoreButton1 = driver.findElement(By.xpath("(//img[contains(@class,'slider-arrow-right')])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeMoreButton1);
        Thread.sleep(1000);
      
        List<WebElement> arrowElements = driver.findElements(By.cssSelector("img.dmg-scroller-arrow"));
        if (arrowElements.size() >= 6) {
            WebElement sixthArrowElement = arrowElements.get(5); // Index is 0-based
            sixthArrowElement.click();
        } else {
            System.out.println("Not enough arrow elements found.");
        }
    	//driver.findElement(By.xpath("(//img[contains(@class, 'slider-arrow-right')])[3]")).click();
        WebElement seeMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Show all')])[2]")));
        seeMoreButton.click();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }

    @And("I tap to download the June twentyseven edition")
    public void i_tap_to_download_the_june_edition() throws InterruptedException {
    	WebElement elementToClick = driver.findElement(By.cssSelector("img.lazyloaded[data-src='https://dmg-dmg-production-api.twipecloud.net/Preview/0/0/447158']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToClick);
    	 Thread.sleep(1000);
    	elementToClick.click();
    }

    @And("I sign in with valid credentials {string} and {string}")
    public void i_sign_in_with_valid_credentials_and(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("login.email"));
        WebElement passwordInput = driver.findElement(By.id("login.password"));
        WebElement signInButton = driver.findElement(By.xpath("//*[text()=' Sign in']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    @Then("I wait for the edition to be downloaded")
    public void i_wait_for_the_edition_to_be_downloaded() {

    	 //WebDriverWait downloadWait = new WebDriverWait(driver, 60);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='download-progress']")));
    }

	
    @After public void tearDown() { 
   	 if (driver != null) {
            driver.quit();
        } 
   	 } 
	 


}
