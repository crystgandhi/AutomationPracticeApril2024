package Testcases;


import org.testng.annotations.Test;



public class LoginTest extends BaseClass{
	

	@Test
	public void loginTestTC001() {
		
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		
		
	}

}
