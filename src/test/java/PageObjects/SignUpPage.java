package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
	WebElement signUpHeader;
	@FindBy(name = "name")
	WebElement name;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement emailAddrress;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signupButton;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement mrRadioButton;
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement mrsRadioButton;
	@FindBy(id="password")
	WebElement password;

	public String getName() {
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}

	public String getEmail() {
		String email = RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
		return email;
	}

	public void getSignUpDetails() throws InterruptedException {
		name.sendKeys(getName());
		emailAddrress.sendKeys(getEmail());
		Thread.sleep(3000);
		signupButton.click();
	}
	public void clickMrsRadioButton() {
		mrsRadioButton.click();
	}
	
	public void clickMrRadioButton() {
		mrRadioButton.click();
	}
	public String generatePassword() {
		String pword=RandomStringUtils.randomAlphanumeric(8);
		return pword;
	}
	public void enterPassword() {
		password.sendKeys(generatePassword());
	}

}
