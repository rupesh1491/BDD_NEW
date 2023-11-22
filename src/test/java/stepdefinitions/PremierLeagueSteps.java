package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PremierLeagueSteps {

	 private WebDriver driver;
	    private WebDriverWait wait;

	    @Given("I am on the Daily Mail website")
	    public void i_am_on_the_daily_mail_website() {
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.get("https://www.dailymail.co.uk");
	        driver.manage().window().maximize();
	     // Get all cookies
	        Set<Cookie> cookies = driver.manage().getCookies();

	        // Delete all cookies
	        for (Cookie cookie : cookies) {
	            driver.manage().deleteCookie(cookie);
	        }
	        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    }

	    @When("I click on the Sport menu")
	    public void i_click_on_the_sport_menu() {
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
	        WebElement sportMenu = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(), 'Sport')])[1]")));
	        sportMenu.click();
	       
	    }

	    @And("I scroll down to the Premier League table")
	    public void i_scroll_down_to_the_premier_league_table() {
	        WebElement premierLeagueTable = driver.findElement(By.xpath("//div[text()='Premier League']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", premierLeagueTable);
	    }

	    @And("I click on View all tables")
	    public void i_click_on_view_all_tables() throws InterruptedException {
	    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
	        WebElement sportMenu = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='View fixtures']")));
	        sportMenu.click();
	        WebElement viewAllTablesButton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Results']//following::div[1]")));
	        viewAllTablesButton.click();
	        Thread.sleep(1000);
	    }

	    @When("I retrieve the Pos, PTS for the following teams")
	    public void I_retrieve_the_Pos_PTS_for_the_following_teams(DataTable teamNamesTable) throws InterruptedException {
	        List<Map<String, String>> teamNamesList = teamNamesTable.asMaps(String.class, String.class);

	        for (Map<String, String> teamNameMap : teamNamesList) {
	            String teamName = teamNameMap.get("Team Name");

	            List<WebElement> teamNameElements = driver.findElements(By.xpath("//td[contains(@class,'team-short')]"));
	           
	            for (int i = 0; i < teamNameElements.size(); i++) {
	            	
	                String currentTeamName = teamNameElements.get(i).getText();
	                Thread.sleep(100);
	                

	                if (currentTeamName.equalsIgnoreCase(teamName)) {
	                    String position = driver.findElements(By.xpath("//td[contains(@class,'pos')]")).get(i).getText();
	                    String points = driver.findElements(By.xpath("//td[contains(@class,'score-pts')]")).get(i).getText();

	                    System.out.println("Position for " + teamName + ": " + position);
	                    System.out.println("Points for " + teamName + ": " + points);
	                    break;
	                }
	               
	            }
	        }
	    }
	    @After public void tearDown() { 
	   	 if (driver != null) {
	            driver.quit();
	        } 
	   	 } 
	
}
