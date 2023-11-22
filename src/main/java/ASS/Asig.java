package ASS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Asig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

        // Step 1: Log In
        driver.get("http://localhost:5106");
        WebElement usernameField = driver.findElement(By.id("Input_Email"));
        WebElement passwordField = driver.findElement(By.id("Input_Password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");
        loginButton.click();

        // Step 2: Select Brand and Product
        WebElement brandDropdown = driver.findElement(By.id("brand-dropdown"));
        WebElement productDropdown = driver.findElement(By.id("product-dropdown"));
        Select brandSelect = new Select(brandDropdown);
        brandSelect.selectByVisibleText("Desired Brand");
        Select productSelect = new Select(productDropdown);
        productSelect.selectByVisibleText("Desired Product");
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();

        // Step 3: Place the Order
        WebElement addToBasketButton = driver.findElement(By.xpath("//button[contains(text(), 'Add to Basket')]"));
        addToBasketButton.click();
        WebElement checkoutButton = driver.findElement(By.id("checkout-button"));
        checkoutButton.click();
        WebElement payNowButton = driver.findElement(By.id("pay-now-button"));
        payNowButton.click();

        // Verify the "Thanks for your Order!" message
        WebElement orderConfirmationMessage = driver.findElement(By.cssSelector(".order-confirmation-message"));
        String expectedMessage = "Thanks for your Order!";
        String actualMessage = orderConfirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();

	}

}
