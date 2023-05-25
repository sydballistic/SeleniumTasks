package org.pagination;

import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Pagination extends BaseClass {

	public static void main(String[] args) {

		getDriver("Chrome");
		launchUrl("https://www.amazon.in/");

		WebElement textSearchBox = findElementByLocators("id", "twotabsearchtextbox");
		typeTextEnter(textSearchBox, "iphones");

		List<WebElement> paginationBox = driver
				.findElements(By.xpath("//div[@class='a-section a-text-center s-pagination-container']"));
		int paginationBoxSize = paginationBox.size();
		System.out.println(paginationBoxSize);

		List<String> productName = new ArrayList<String>();

		if (paginationBoxSize > 0) {

			do {

				List<WebElement> allPhoneNames = driver
						.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

				for (WebElement phoneNames : allPhoneNames) {

					String textPhoneNames = phoneNames.getText();
					// System.out.println(textPhoneNames);

					productName.add(textPhoneNames);
				}

				WebElement btnNext1 = driver.findElement(By.xpath("//a[text()='Next']"));
				boolean enabledBtnNext1 = btnNext1.isEnabled();

				WebElement btnNext2 = driver.findElement(By.xpath(
						"//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
				boolean enabledBtnNext2 = btnNext2.isEnabled();
				System.out.println(enabledBtnNext2);

//				WebElement btn20 = driver
//						.findElement(By.xpath("//span[contains(@class,'s-pagination-item s-pagination-disabled')]"));
//				boolean enabled = btn20.isEnabled();
//				System.out.println(enabled);

				if (enabledBtnNext2) {
					btnClick(btnNext1);
				} else {
					break;
				}

			} while (true);

		} else {
			System.out.println("The Page doesn't have any pagination");
		}
	}

}
