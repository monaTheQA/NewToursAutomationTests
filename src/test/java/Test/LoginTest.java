package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.DashboardPage;
import Pages.LoginPage;


public class LoginTest extends BasePage  {
	
	public LoginPage loginpage;
	private Properties prop;
	public WebDriver driver;
	public DashboardPage dashboardpage;
	
	@BeforeSuite
	public void SetUP() {
		prop = init_properties();
		driver = init_driver(prop.getProperty("browser"));
		//loginpage  = new LoginPage(driver);
	
	}
	
	@Test(priority=0)
	public void goToLoginPage() {
		loginpage=new LoginPage(getDriver());
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	@Test(priority = 2)
	public void loginUser() {
		String adminuser = property.getProperty("adminusername");
		String password = property.getProperty("adminpassword");
		loginpage.Login(adminuser,password );
		String title = dashboardpage.getDashBoardPageTitle();
		Assert.assertEquals(title, "Find a Flight: Mercury Tours: ");
		
	}
	
	/*@AfterSuite
	public void CloseWindows() {
		driver.quit();
	}*/

}
