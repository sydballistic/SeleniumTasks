package org.hdfc;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HdfcBankSite extends BaseClass {
	public static void main(String[] args) {

		getDriver("Chrome");
		launchUrl("https://www.hdfcbank.com/");

		// click dropdown
		findElementByLocators("xpath", "//div[@class='drp1']//div[@class='dropdown']").click();

		// get the all dropdown text

		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));

		for (WebElement ele : allOptions) {
			String text = ele.getText();
			System.out.println(text);
		}

	}

}
