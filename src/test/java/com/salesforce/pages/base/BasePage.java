package com.salesforce.pages.base;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	public static void driverSetUp(String browser) {
		System.out.println("Driver setup");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	}
	
	public static WebDriver getDriverInstance(){
		return driver;
	}
	
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public BasePage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void clearElement(WebElement element) {
		element.clear();
	}
	
	public static void waitUntilVisible(WebElement element) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilTitle(String expectedTitle) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.titleIs(expectedTitle));	
	}
	
	public static void waitUntillocatedById(String id) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public static void waitUntilClickable(WebElement element) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitUntilLocatedBy(By locator) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void clickButton(WebElement element) {
		element.click();
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void switchToWindow(String[] arr, int index) {
		driver.switchTo().window(arr[index]);
	}
	
	public static String[] handleWindows() {
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		return getWindow;
	}
	
	public static void closeDriver() {
		driver.close();
	}
	
}
