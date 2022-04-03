package PagesSTG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewRequestPage {
    WebDriver driver;
    WebDriverWait driverWait;
    JavascriptExecutor js;
    @FindBy(xpath = "(//p[span[text()='Actions']])[2]")
    WebElement actionsTab;
    @FindBy(xpath = "(//p[span[text()='View Requests']])[2]")
    WebElement viewRequest;

    public ViewRequestPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public void clickActionsTab() {
        actionsTab.click();
    }

    public void clickViewrequest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(viewRequest).click().perform();
    }
}
