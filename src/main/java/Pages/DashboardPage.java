package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class DashboardPage extends BasePage {
		
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
	
	@FindBy(xpath="//select[@name='toDay']")
	private WebElement ReturningDay;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashBoardPageTitle() {
		return driver.getTitle();
	}
}
