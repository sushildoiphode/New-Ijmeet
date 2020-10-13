package com.ijmeet.keywords;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ijmeet.util.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class FEKeywords {
	private static Logger log = Logger.getLogger(FEKeywords.class);

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {

		case "XPATH":
			element = Constant.driver.findElement(By.xpath(locatorValue));
			break;

		case "CSS":
			element = Constant.driver.findElement(By.cssSelector(locatorValue));
			break;

		case "ID":
			element = Constant.driver.findElement(By.id(locatorValue));
			break;

		case "LINKTEXT":
			element = Constant.driver.findElement(By.linkText(locatorValue));
			break;

		case "PARTIALLINKTEXT":
			element = Constant.driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			log.info(" Invalid selector type");
		}
		return element;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void selectValueFromDropdown(String locatorType, String locatorValue, String textToSelect) {
		WebElement element = getWebElement(locatorType, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

	public static boolean isElementDisplayed(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).isDisplayed();
	}

	public static void mouseHover(String locatorType, String locatorValue) {
		WebElement element = getWebElement(locatorType, locatorValue);

		Actions act = new Actions(Constant.driver);
		act.moveToElement(element).build().perform();
	}

	public static String getTextOfElement(String locatorType, String locatorValue) {
		WebElement element1 = getWebElement(locatorType, locatorValue);
		String text = element1.getText();
		return text;
	}

	public static List<WebElement> getListOfWebelements(String locatorType, String locatorValue) {
		List<WebElement> element = null;
		switch (locatorType) {
		case "XPATH":
			element = Constant.driver.findElements(By.xpath(locatorValue));
			break;
		case "CSS":
			element = Constant.driver.findElements(By.cssSelector(locatorValue));
			break;
		case "ID":
			element = Constant.driver.findElements(By.id(locatorValue));
			break;
		case "LINK_TEXT":
			element = Constant.driver.findElements(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element = Constant.driver.findElements(By.partialLinkText(locatorValue));
			break;
		case "CLASS":
			element = Constant.driver.findElements(By.className(locatorValue));
			break;
		default:
			break;
		}
		return element;
	}

	public static int displayListCount(String locatorType, String locatorValue) {
		List<WebElement> element = getListOfWebelements(locatorType, locatorValue);
		for (WebElement ele : element) {
			ele.getSize();
			Constant.count++;
		}
		return Constant.count;
	}

	
}


