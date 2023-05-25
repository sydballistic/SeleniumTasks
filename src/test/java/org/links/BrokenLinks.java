package org.links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrokenLinks extends BaseClass {

	public static void main(String[] args) throws IOException {

		getDriver("Chrome");
		launchUrl("https://www.facebook.com");

		List<WebElement> linkCount = driver.findElements(By.tagName("a"));

		// to know number of links present
		int size = linkCount.size();
		System.out.println("Number of link present in the page:" + size);

		// Getting link name one by one,we need to open and confirm its broken link or
		// not
		int brokenCount = 0;
		for (WebElement ele : linkCount) {
			String linkName = ele.getAttribute("href");
			// Convert these string into url
			// URL--> class from java.net package
			URL url = new URL(linkName);

			// open the url-->by using open connection()-->from url class
			URLConnection con = url.openConnection();

			// verify broken link by using status code
			// for getting status code -->we need to convert urlconnection to
			// httpurlconnection
			// httpurl connection -->astract class

			HttpURLConnection connection = (HttpURLConnection) con;
			int response = connection.getResponseCode();

			if (response != 200) {
				brokenCount++;
				System.out.println("Broken Link Names:" + linkName);
			}

		}
		System.out.println("No of Broken Links Count:" + brokenCount);

	}
}
