package stepdefinitions.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class amzone {
	private WebDriver driver;
	
	@Given("open amzone page")
	public void open_amzone_page() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	    
	}

	@When("Enter mobile phone on search box and click on search")
	public void enter_mobile_phone_on_search_box_and_click_on_search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
		driver.findElement(By.id("nav-search-submit-button")).submit();
		
	   
	}

	@Then("select Samsung phone and andriode")
	public void select_samsung_phone_and_andriode() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='SAMSUNG']//parent::a//div//label//i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Android']//parent::a//div//label//i")).click();
		
		
	  
	}

	@And("quite the browser")
	public void close_the_browser() {
	    driver.quit();
	}


	

}
