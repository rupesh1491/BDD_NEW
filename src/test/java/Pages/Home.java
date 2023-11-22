package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Home extends BasePage {

	public Home(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement productsElement;
	
	public void verifyHomePage() {
		 String productsText = productsElement.getText().trim();
    	 System.out.println(productsText);
         String expectedText = "Product";
        // Assert.assertEquals("Expected to be on the home page", expectedText, productsText);
         Assert.assertEquals(expectedText, productsText);
	}

}
