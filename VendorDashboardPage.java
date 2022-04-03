package PagesSTG;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class VendorDashboardPage {
    WebDriver driver;
    WebDriverWait driverWait;
    JavascriptExecutor js;

    @FindBy(xpath = "(//button[p[span[text()='Accounts']]])[2]")
    WebElement AccountsTab;
    @FindBy(id = "mat-expansion-panel-header-1")
    WebElement searchAccountsTab;
    @FindBy(xpath = "//input[@formcontrolname='healthSystem']")
    WebElement healthSystemTextfield;
    @FindBy(xpath = "//span[contains(text(),'Ind')]")
    WebElement checkboxHeaderText;
    @FindBy(id = "mat-checkbox-1")
    WebElement HospitalCheckbox;
    @FindBy(xpath = "//button[span[contains(text(),'Co')]]")
    WebElement ContinueButtonTab;
    @FindBy(xpath = "//button[span[contains(text(),'OK')]]")
    WebElement popupOkButton;
    @FindBy(xpath = "//h5[span[contains(text(),'Be')]]")
    WebElement BeWellHeaderText;
    @FindBy(xpath = "//h5[text()='Questions']")
    WebElement QuestionText;
    @FindBy(xpath = "//label[contains(text(),'Ple')]")
    WebElement RRPText;
    @FindBys({@FindBy(xpath = "//span[text()='Yes']")})
    List<WebElement> RRPQuestions;

    WebElement get_Location_Locator(String location) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + location + "')]"));
    }

    WebElement get_Department_locator(String department) {
        return driver.findElement(By.xpath("//span[text()='" + department + "']"));
    }

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;
    @FindBy(xpath = "//h5[span[contains(text(),'Be')]]")
    WebElement hospitalHeaderText;
    @FindBy(xpath = "//h4[contains(text(),'Conflict')]")
    WebElement TextCOI;
    @FindBy(xpath = "//h5[contains(text(),'R')]")
    WebElement TextRelationship;
    @FindBys({@FindBy(xpath = "//span[contains(text(),'No')]")})
    List<WebElement> clickCOFRadiobutton;
    @FindBy(xpath = "//div[contains(text(),'Te')]")
    WebElement PrivacyPolicyText;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement scrollToCheckbox;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsOfUseandPrivacyPolicyCheckbox;
    @FindBy(xpath = "//button[text()='Next']")
    WebElement COFNextbutton;

    public VendorDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 80);
        this.js = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountsTab() {
        AccountsTab.click();
    }

    public void clickSearchAccountsTab() {
        driverWait.until(ExpectedConditions.visibilityOf(searchAccountsTab));
        searchAccountsTab.click();
    }

    public void enterHealthSystemTextfield(String IDN) {
        healthSystemTextfield.sendKeys(IDN, Keys.ENTER);
    }

    public void verifyCheckboxHeader(String expectedCheckboxHeader) {
        System.out.println("Verifying checkbox header is displayed -> " + expectedCheckboxHeader);
        driverWait.until(ExpectedConditions.visibilityOf(checkboxHeaderText));
        Assert.assertEquals(checkboxHeaderText.getText(), expectedCheckboxHeader);
    }

    public void clickHospitalCheckbox() {
        HospitalCheckbox.click();
    }

    public void clickContinueButtonTab() {
        driverWait.until(ExpectedConditions.visibilityOf(ContinueButtonTab));
        ContinueButtonTab.click();
    }

    public void clickPopupOkButton() {
        popupOkButton.click();
    }

    public void verifyBeWellHeaderText(String expectedBewellheader) {
        System.out.println("Verifying bewell header ->" +expectedBewellheader);
        driverWait.until(ExpectedConditions.visibilityOf(BeWellHeaderText));
        Assert.assertEquals(BeWellHeaderText.getText(),expectedBewellheader);
    }

    public void verifyTextOfQuestion(String expectedQuesText) {
        System.out.println("Verifying question text is displayed -> " + expectedQuesText);
        driverWait.until(ExpectedConditions.visibilityOf(QuestionText));
        Assert.assertEquals(QuestionText.getText(),expectedQuesText);
    }

    public void VerifyRRPText(String expectedRRPText) {
        System.out.println("Verifying RRP Text is displayed -> "+expectedRRPText);
        driverWait.until(ExpectedConditions.visibilityOf(RRPText));
        Assert.assertEquals(RRPText.getText(),expectedRRPText);
    }

    public void clickRRPQuestions() {
        for (WebElement element : RRPQuestions) {
            driverWait.until(ExpectedConditions.visibilityOfAllElements(RRPQuestions));
            element.click();
        }
    }

    public void clickSelectLocationCheckbox(String location) {
        get_Location_Locator(location).click();
    }

    public void clickSelectDepartment(String department) {
        get_Department_locator(department).click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void verifyBewellHeader(String expectedHeader) {
        System.out.println("Verifying bewell header is displayed -> "+expectedHeader);
        driverWait.until(ExpectedConditions.visibilityOf(hospitalHeaderText));
        Assert.assertEquals(hospitalHeaderText.getText(),expectedHeader);
    }

    public void verifyCOIText(String expectedCOIText) {
        System.out.println("Verifying COI text is displayed -> "+expectedCOIText);
        driverWait.until(ExpectedConditions.visibilityOf(TextCOI));
        Assert.assertEquals(TextCOI.getText(),expectedCOIText);
    }

    public void verifyRelationshipText(String expectedRelText) {
        System.out.println("Verifying relationship text is displayed -> "+expectedRelText);
        driverWait.until(ExpectedConditions.visibilityOf(TextRelationship));
        Assert.assertEquals(TextRelationship.getText(),expectedRelText);
    }

    public void clickConflictOfInterestRadioButton() {
        for (WebElement clickRadioButton : clickCOFRadiobutton) {
            clickRadioButton.click();
        }
    }

    public void verifyTextOfTerms(String expectedTextOfTerms) {
        System.out.println("Verifying text of terms text -> "+expectedTextOfTerms);
        driverWait.until(ExpectedConditions.visibilityOf(PrivacyPolicyText));
        Assert.assertEquals(PrivacyPolicyText.getText(),expectedTextOfTerms);
    }

    public void clickPrivacyPolicyCheckbox() {
        Actions actions = new Actions(driver);
        actions.moveToElement(termsOfUseandPrivacyPolicyCheckbox).click().perform();
    }

    public void clickCOFNextButton() {
        COFNextbutton.click();
    }

}
