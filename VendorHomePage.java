package PagesSTG;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorHomePage {
    WebDriver driver;
    WebDriverWait driverWait;
    @FindBy(xpath = "//span[contains(text(),'Ven')]")
    WebElement VendormateCredentialingLink;
    @FindBy(id = "hideMessageBtn")
    WebElement ContinueButton;

    public VendorHomePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    public void clickVendormateCredentialingLink() {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(VendormateCredentialingLink)).click();
        } catch (StaleElementReferenceException e) {
            e.getLocalizedMessage();
        }
    }

    public void clickContinuebutton() {
        driverWait.until(ExpectedConditions.visibilityOf(ContinueButton)).click();
    }
}
