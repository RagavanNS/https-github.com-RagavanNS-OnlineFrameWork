package framework.intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4Base {
	static WebDriver driver;
	
	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\OnlineFrameWork\\Drive\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void insertType(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public static void click(WebElement ele) {
		ele.click();
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
}
