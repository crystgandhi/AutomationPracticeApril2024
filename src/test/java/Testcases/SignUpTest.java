package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.HomePageHeader;
import PageObjects.SignUpPage;

public class SignUpTest extends BaseClass{
	
	HomePageHeader homePageHeader;
	SignUpPage signUpPage;
	@Test
	public void signUptest() throws IOException, InterruptedException {
		homePageHeader = new HomePageHeader(driver);
		homePageHeader.getSignUpLoginLink();
		signUpPage =new SignUpPage(driver);
		signUpPage.getSignUpDetails();
		signUpPage.clickMrsRadioButton();
		getScreenshot();
	}
	
	

}
