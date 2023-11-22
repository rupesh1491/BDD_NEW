package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage{
	
	@FindBy(id="user-name")
	private WebElement uername;
	
	@FindBy(id="password")
	private WebElement pasword;
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String username) {
		uername.sendKeys(username);
	}
	public void enterpassword(String password) {
		pasword.sendKeys(password);
	}
	
	

}
