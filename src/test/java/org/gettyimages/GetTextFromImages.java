package org.gettyimages;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GetTextFromImages extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		getDriver("Chrome");
		launchUrl("https://www.gettyimages.in");

		List<WebElement> allTexts = driver.findElements(By.xpath("//a[@class='MMEj5UzOeeYUMexlberg']"));

		// perform mosehover action
		Actions ac = new Actions(driver);

		int count = 1;
		for (int i = 0; i < allTexts.size(); i++) {
			WebElement allImages = allTexts.get(i);
			ac.moveToElement(allImages).perform();
			// to get the all txt inthe images
			// System.out.println("//div[@class='naI1c7zAnreqRUgGxqfS'][" + (count + i) +
			// "]");
			String imageText = driver
					.findElement(By.xpath("((//div[@class='naI1c7zAnreqRUgGxqfS'])[" + (count + i) + "])")).getText();

			System.out.println(imageText);

			// List<WebElement> findElements =
			// driver.findElements(By.xpath("//div[@class='naI1c7zAnreqRUgGxqfS']"));
			// for (WebElement webElement : findElements) {
			//
			// String text = webElement.getText();
			// System.out.println(text);
			// }

		}

	}

}
