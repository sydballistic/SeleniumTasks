package org.xpath;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class XpathAxes extends BaseClass {

	public static void main(String[] args) {
		BaseClass b = new BaseClass();
		getDriver("Chrome");

		// launchUrl("https://www.facebook.com/login");
		// WebElement txtUserName = findElementByLocators("xpath",
		// "//button[@id='loginbutton']/parent::div/preceding-sibling::div/child::input");
		// typeTextEnter(txtUserName, "Username");

		launchUrl("https://www.amazon.in/");
		WebElement txtSearchBox = findElementByLocators("id", "twotabsearchtextbox");
		typeTextEnter(txtSearchBox, "iphones");

		WebElement getPrice = findElementByLocators("xpath",
				"(//span[@class='a-size-medium a-color-base a-text-normal']/parent::a/parent::h2/parent::div/following-sibling::div/following-sibling::div/child::div/child::div/child::div/child::div/child::a/child::span/child::span[@class='a-offscreen'])[1]");
		String price = b.gettingText(getPrice);
		System.out.println(price);
	}

}
