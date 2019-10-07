package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LoginPage extends BasePage {
	private Properties prop;
	public WebDriver driver;
	
	
	@FindBy(xpath="//input[@name='userName']")
	private WebElement UserNameTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordTextBox;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement LoginBtn;
	
	
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getApplicationLogo() {
		return driver.getCurrentUrl();
	}
	
	public void Login(String Username,String Password) {
		UserNameTextBox.sendKeys(Username);
		PasswordTextBox.sendKeys(Password);
		LoginBtn.click();
		
		//return new DashBoardPage();
	}
	
	

}
