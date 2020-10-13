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


public class Keywords {
	private static Logger log = Logger.getLogger(Keywords.class);

	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Constant.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Constant.driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constant.driver = new InternetExplorerDriver();
			break;

		default:
			log.info(" Invalid browser name");
		}
	}

	public static void launchUrl(String url) {
		Constant.driver.get(url);
		log.info(" Url is launch successfully");
	}

	public static void clearCookies() {
		Constant.driver.manage().deleteAllCookies();
	}

	public static void maximizeBrowser() {
		Constant.driver.manage().window().maximize();
	}

	public static void navigateBack() {
		Constant.driver.navigate().back();
	}

	public static void navigateForward() {
		Constant.driver.navigate().forward();
	}

	public static WebElement getWebElement(String locatorType, WebElement locatorValue) {
		WebElement element = null;
		switch (locatorType) {

		case "XPATH":
			element = locatorValue;
			break;

		case "CSS":
			element = locatorValue;
			break;

		case "ID":
			element = locatorValue;
			break;

		case "LINKTEXT":
			element = locatorValue;
			break;

		case "PARTIALLINKTEXT":
			element = locatorValue;
			break;
		default:
			log.info(" Invalid selector type");
		}
		return element;
	}

	public static void enterText(String locatorType, WebElement locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickOnElement(String locatorType, WebElement locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void selectValueFromDropdown(String locatorType, WebElement locatorValue, String textToSelect) {
		WebElement element = getWebElement(locatorType, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
	}

	public static boolean isElementDisplayed(String locatorType, WebElement locatorValue) {
		return getWebElement(locatorType, locatorValue).isDisplayed();
	}

	public static void mouseHover(String locatorType, WebElement locatorValue) {
		WebElement element = getWebElement(locatorType, locatorValue);

		Actions act = new Actions(Constant.driver);
		act.moveToElement(element).build().perform();
	}

	public static String getTextOfElement(String locatorType, WebElement locatorValue) {
		WebElement element1 = getWebElement(locatorType, locatorValue);
		String text = element1.getText();
		return text;
	}

	public static List<WebElement> getListOfWebelements(String locatorType, WebElement locatorValue) {
		List<WebElement> element = null;
		switch (locatorType) {
		case "XPATH":
			element = (List<WebElement>) locatorValue;
			break;
		case "CSS":
			element = (List<WebElement>) locatorValue;
			break;
		case "ID":
			element = (List<WebElement>) locatorValue;
			break;
		case "LINK_TEXT":
			element = (List<WebElement>) locatorValue;
			break;
		case "PARTIAL_LINK_TEXT":
			element = (List<WebElement>) locatorValue;
			break;
		case "CLASS":
			element = (List<WebElement>) locatorValue;
			break;
		default:
			break;
		}
		return element;
	}

	public static void getScreenShot() {
		String path = System.getProperty("user.dir");
		File f = new File(path + "/Screenshot/" + getDate());

		if (f.mkdirs() == true) {
			System.out.println("Folder Created");
		} else {
			System.out.println("Folder not Created");
		}
		File file = new File(f, "/screenshot_" + getDateAndTime() + ".png");

		try {
			Robot robo = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage image = robo.createScreenCapture(rect);
			ImageIO.write(image, "png", file);
		} catch (AWTException e) {
			System.err.println("unable to take Screenshot");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to take Screenshot");
			e.printStackTrace();
		}
	}

			private static String getDateAndTime() {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss");
				String formatteddate = now.format(date);
				return formatteddate;
	}

			private static String getDate() {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy_MM_dd");
				String formattedDate1 = now.format(date);
				return formattedDate1;
	}

	public void fullPageScreenShot() {
		String path = System.getProperty("user.dir");
		File f = new File(path + "/Screenshot/" + getDate());

		if (f.mkdirs() == true) {
			System.out.println("Folder Created");
		} else {
			System.out.println("Folder not Created");
		}
		File file = new File(f, "/screenshot_" + getDateAndTime() + ".png");
		AShot ashot = new AShot();
		Screenshot sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(Constant.driver);
		try {
			ImageIO.write(sc.getImage(), "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int displayListCount(String locatorType, WebElement locatorValue) {
		List<WebElement> element = getListOfWebelements(locatorType, locatorValue);
		for (WebElement ele : element) {
			ele.getSize();
			Constant.count++;
		}
		return Constant.count;
	}

	public static void closeBrowser() {
		Constant.driver.close();
	}

	public static void quitBrowser() {
		Constant.driver.quit();
	}
}
