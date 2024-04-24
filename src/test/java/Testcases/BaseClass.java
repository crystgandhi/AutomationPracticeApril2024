package Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.File;



import Utilites.ReadConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfigProperties readconfigProperties;
	WebDriver driver;

	@BeforeTest
	public void Setup() throws IOException {
		WebDriverManager.chromedriver().setup();
		readconfigProperties = new ReadConfigProperties();
		String url = readconfigProperties.getUrl();
		System.out.println(url);
		String browsername = readconfigProperties.getBrowserName();
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

	}

	public void getScreenshot() throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		java.io.File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(".\\screenshot.png");
		FileHandler.copy(sourceFile, destinationFile);
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
