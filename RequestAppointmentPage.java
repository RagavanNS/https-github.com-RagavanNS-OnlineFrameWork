package PagesSTG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestAppointmentPage {
    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(xpath = "(//span[contains(text(),'My Acc')])[2]")
    WebElement verify_MyAccesstext;
    @FindBy(xpath = "(//a[contains(text(),'Request')])[2]")
    WebElement requestAppointmentButton;
    @FindBy(id = "account")
    WebElement selectAccountDropdown;
    @FindBy(id = "subject")
    WebElement enterSubject;
    @FindBy(id = "requestStaff")
    WebElement requestedStaffDropdown;
    @FindBy(id = "addAppointmentForm.startTime")
    WebElement selectStartTimeDropdown;
    @FindBy(xpath = "//a[contains(@class,'m') and contains(@data-ng-init,'end')]")
    WebElement endDateCalendar;
    @FindBy(xpath = "(//span[text()='04'])[1]")
    WebElement selectDate;
    @FindBy(id = "addAppointmentForm.endTime")
    WebElement selectEndTimeDropdown;
    @FindBy(id = "description")
    WebElement descriptionTextfield;
    @FindBy(name = "location")
    WebElement selectLocationDropdown;
    @FindBy(id = "departmentName")
    WebElement selectDepartmentDropdown;
    @FindBy(id = "saveAppointment")
    WebElement sendRequestButton;
    @FindBy(name = "okBtn")
    WebElement appointmentSuccessfullPopup;

    public RequestAppointmentPage (WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public void verifyMyAccesstextElementIsPresent() {
        driverWait.until(ExpectedConditions.visibilityOf(verify_MyAccesstext));
    }

    public void clickRequestLink() {
        requestAppointmentButton.click();
    }

    public void selectAccount(String visibleText) {
        Select select = new Select(selectAccountDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void enterSubjectField (String subject) {
        driverWait.until(ExpectedConditions.elementToBeClickable(enterSubject));
        enterSubject.sendKeys(subject);
    }

    public void selectRequestedStaff(String visibleText) {
        Select select = new Select(requestedStaffDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void selectStartTime(String value) {
        Select select = new Select(selectStartTimeDropdown);
        select.selectByValue(value);
    }

    public void clickEndDateCalendar() {
        driverWait.until(ExpectedConditions.elementToBeClickable(endDateCalendar));
        endDateCalendar.click();
    }

    public void clickSelectDate() {
        driverWait.until(ExpectedConditions.visibilityOf(selectDate));
        selectDate.click();
    }

    public void SelectEndTime(String value) {
        driverWait.until(ExpectedConditions.visibilityOf(selectEndTimeDropdown));
        Select select = new Select(selectEndTimeDropdown);
        select.selectByValue(value);
    }

    public void enterDescription(String descriptionField) {
        descriptionTextfield.sendKeys(descriptionField);
    }

    public void selectLocation(String visibleText) {
        Select select = new Select(selectLocationDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void selectDepartment(String visibleText) {
        Select select = new Select(selectDepartmentDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void clickSendRequestButton() {
        sendRequestButton.click();
    }

    public void clickSuccessfullPopupOkButton() {
        appointmentSuccessfullPopup.click();
    }
}
