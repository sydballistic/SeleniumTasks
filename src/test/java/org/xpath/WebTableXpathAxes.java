package org.xpath;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableXpathAxes extends BaseClass {

	public static String findLang(String countryName) {

		WebElement lang = driver.findElement(
				By.xpath("//table[@id='countries']//td[text()='" + countryName + "']/following-sibling::td[2]"));

		String text = lang.getText();
		return text;
	}

	public static void main(String[] args) {

		getDriver("Chrome");
		launchUrl("https://cosmocode.io/automation-practice-webtable/");
		String findLang = findLang("Buenos Aires");
		System.out.println(findLang);

	}
}
