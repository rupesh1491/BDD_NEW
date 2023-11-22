package stepdefinitions.google;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class google {
	private WebDriver driver;
	@Given("open google page")
	public void open_google_page() {
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
	  
	}

	@When("Enter selenium on search box and click on search")
	public void enter_selenium_on_search_box_and_click_on_search() {
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		driver.findElement(By.name("btnK")).submit();
	   
	}

	@When("Selenium should be found sucessfully")
	public void selenium_should_be_found_sucessfully() {
	  WebElement text= driver.findElement(By.xpath("(//span[text()='Selenium'])[1]"));
	  String selenium=text.getText();
	  AssertJUnit.assertEquals(selenium, "Selenium");
	}

	@Then("close the browser")
	public void close_the_browser() {
	    driver.quit();
	}


}
