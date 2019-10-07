package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class DashboardPage extends BasePage {
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement WelcomeAdmin;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutButton;
	
	@FindBy(xpath="//b[text()='PIM']")
	private WebElement PIM;
	
	@FindBy(xpath="//input[@name='tripType' and @value='roundtrip']")
	private WebElement FlightType;
	
	@FindBy(xpath="//select[@name='passCount']")
	private WebElement PassengersCount;
	
	@FindBy(xpath="//select[@name='fromPort']")
	private WebElement DepartingFrom;
	
	@FindBy(xpath="//select[@name='fromMonth']")
	private WebElement DepartingMonth;
	
	@FindBy(xpath="//select[@name='fromDay']")
	private WebElement DepartingDay;
	
	@FindBy(xpath="//select[@name='toPort']")
	private WebElement ArrivingIn;
	
	@FindBy(xpath="//select[@name='toMonth']")
	private WebElement ReturningMonth;
	
	
	
	
	
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashBoardPageTitle() {
		return driver.getTitle();
	}
	
	public void PIMClick() {
		
		PIM.click();
	}
	
	
	
	public void logout() {
		WelcomeAdmin.click();
		LogoutButton.click();
		
	}


}