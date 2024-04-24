package Testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.HomePageHeader;

public class HeaderLinksTest extends BaseClass {

	HomePageHeader homePageHeader;

	@Test
	public void headerLinksTest() throws IOException {

		homePageHeader = new HomePageHeader(driver);
		List<WebElement> numberOfLinks = homePageHeader.getHeaderLinks();
		System.out.println(numberOfLinks.size());
		Iterator<WebElement> it = numberOfLinks.iterator();
		while (it.hasNext()) {
			String url = it.next().getAttribute("href");
			if ((url == null) || (url.isEmpty())) {
				System.out.println("url is empty");
			}
			HttpURLConnection huc;
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.connect();
				if (huc.getResponseCode() >= 400) {
					System.out.println(url + " is broken");
				} else {
					System.out.println(url + " is valid");
				}
			} catch (MalformedURLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) { // TODO Auto-generated catch
				e.printStackTrace();
			}

		}
		
		getScreenshot();
	}
}
