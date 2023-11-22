package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import Pages.CustomTestListener;
import Pages.Home;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class saucedemo1 {
	private WebDriver driver;
    private Login login;
    private Home home;
   private Hooks hook;


    @Given("User opens the browser")
    public void user_opens_the_browser() {
    	 driver = new ChromeDriver();
    	 login = new Login(driver);
    	 home=new Home(driver);
    	 hook=new Hooks(driver);
    	 
    	 //CustomTestListener customListener = new CustomTestListener(driver);
    }

    @Given("User navigates to the URL")
    public void user_navigates_to_the_URL() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
       // WebElement usernameInput = driver.findElement(By.id("user-name"));
       // usernameInput.sendKeys(username);
    	login.enterUserName(username);
    	login.enterpassword(password);

       // WebElement passwordInput = driver.findElement(By.id("password"));
      //  passwordInput.sendKeys(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User should be on the home page")
    public void user_should_be_on_the_home_page() {
        
		/*
		 * WebElement productsElement =
		 * driver.findElement(By.xpath("//span[text()='Products']")); String
		 * productsText = productsElement.getText().trim();
		 * System.out.println(productsText); String expectedText = "Products"; //
		 * Assert.assertEquals("Expected to be on the home page", expectedText,
		 * productsText); Assert.assertEquals(expectedText, productsText);
		 */
    	home.verifyHomePage();
    	//screenshot.captureScreenshot(driver, "verification");
    }

    @Then("User adds three items to the shopping cart")
    public void user_adds_three_items_to_the_shopping_cart() throws InterruptedException {
       driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
       driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
       driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
       Thread.sleep(1000);
    }
    @After(order = 0)
    @Then("User closes the browser")
    public void user_closes_the_browser() {
    	  
    	        driver.quit();
    	    }

}
