package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHeader {
	
	public WebDriver driver;
	public HomePageHeader(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a")
	List<WebElement> hederlinks;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement homeLink;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement signUpLoginLink;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement productsLink;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cartLink;
	
	@FindBy(css="a[href='/logout']")
	WebElement logoutLink;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")
	WebElement deleteAccountLink;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[6]")
	WebElement testcasesLink;
	@FindBy(xpath="//a[normalize-space()='API Testing']")
	WebElement apitestingLink;
	
	public List<WebElement> getHeaderLinks() {
		return hederlinks;
		}
	public void getSignUpLoginLink() {
		signUpLoginLink.click();
	}

}
