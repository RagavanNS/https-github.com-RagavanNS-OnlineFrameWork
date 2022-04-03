package TestSTG;

import PagesSTG.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class VendorDashboardTest {
    static WebDriver driver;
    static VendorLoginPage login;
    static CommonLibraries libraries;
    static VendorHomePage homePage;
    static VendorDashboardPage dashboard;
    static RequestAppointmentPage appointment;
    static ViewRequestPage requestPage;
    static String bewell_text = "Bewell Hospital";
    static String pathName = "D:\\MavenStageENV\\src\\test\\resources\\Automationdata.xlsx";
    static String sheetName = "TestDatas";

    static List<String> rowValue_1 = Arrays.asList(pathName, sheetName, String.valueOf(1));
    static String login_header;
    static String login_text;
    static String user_name;
    static String pass_word;


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite-->");
    }

    @Parameters({"chromeBrowser", "BrowserPath", "URL"})
    @BeforeTest
    public void beforeTest(String chromeBrowser, String BrowserPath, String URL) {
        System.setProperty(chromeBrowser, BrowserPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.get(URL);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method-->");
    }

    /*@DataProvider(name = "login")
    public Object[][] loginData() {
        return new Object[][] {
                {"GHX Login"},
                {"Enter your GHX credentials to log in."},
                {"sivaragavan.s+registration001@mookambikainfo.com","Testuser@18"},
                {"Testuser@18"}
        };
    }*/
    @Test(priority = 0, groups = {"loginPage"})
    public void login() throws IOException {
        login = new VendorLoginPage(driver);
        libraries = new CommonLibraries(driver);
        homePage = new VendorHomePage(driver);
        dashboard = new VendorDashboardPage(driver);
        appointment = new RequestAppointmentPage(driver);
        requestPage = new ViewRequestPage(driver);
        login.getTexts();
        login_header = String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(0));
        login_text = String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(1));
        user_name = String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(2));
        pass_word = String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(3));
        login.VerifyGHXLoginHeader(login_header);
        login.VerifyLoginText(login_text);
        login.setUsernameTextfield(user_name);
        login.setPasswordField(pass_word);
        login.clickLoginButton();
    }

    @Test(priority = 1, groups = {"homePage"})
    public void home() {
        libraries.spinnerLoading();
        homePage.clickVendormateCredentialingLink();
        libraries.spinnerLoading();
        homePage.clickContinuebutton();
    }

    @Test(priority = 2, groups = {"dashBoard"})
    public void vendorDashboard() throws InterruptedException, IOException {
        dashboard.clickAccountsTab();
        dashboard.clickSearchAccountsTab();
        dashboard.enterHealthSystemTextfield(bewell_text);
        dashboard.verifyCheckboxHeader(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(4)));
        dashboard.clickHospitalCheckbox();
        dashboard.clickContinueButtonTab();
        dashboard.clickPopupOkButton();
        libraries.spinnerLoading();
        dashboard.verifyBeWellHeaderText(bewell_text);
        dashboard.verifyTextOfQuestion((String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(5))));
        dashboard.VerifyRRPText(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(6)));
        libraries.spinnerLoading();
        libraries.Sleep(4000);
        dashboard.clickRRPQuestions();
        dashboard.clickSelectLocationCheckbox(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(7)));
        dashboard.clickSelectLocationCheckbox(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(8)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(9)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(10)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(11)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(12)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(13)));
        dashboard.clickSelectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(14)));
        dashboard.clickNextButton();
        dashboard.verifyBewellHeader(bewell_text);
        dashboard.verifyCOIText(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(15)));
        dashboard.verifyRelationshipText(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(16)));
        dashboard.clickConflictOfInterestRadioButton();
        dashboard.verifyTextOfTerms(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(17)));
        dashboard.clickPrivacyPolicyCheckbox();
        dashboard.clickCOFNextButton();
    }

    @Test(priority = 3, dependsOnGroups = {"loginPage", "homePage", "dashBoard"})
    public void requestAppointment() throws IOException {
        appointment.verifyMyAccesstextElementIsPresent();
        appointment.clickRequestLink();
        appointment.selectAccount(bewell_text);
        libraries.spinnerLoading();
        appointment.enterSubjectField(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(18)));
        appointment.selectRequestedStaff(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(19)));
        appointment.selectStartTime(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(20)));
        appointment.clickEndDateCalendar();
        appointment.clickSelectDate();
        appointment.SelectEndTime(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(21)));
        appointment.enterDescription(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(22)));
        appointment.selectLocation(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(23)));
        appointment.selectDepartment(String.valueOf(CommonLibraries.getRowValues(rowValue_1).get(24)));
        appointment.clickSendRequestButton();
        appointment.clickSuccessfullPopupOkButton();
    }

    @Test(priority = 4, dependsOnMethods = {"requestAppointment"})
    public void viewRequest() {
        requestPage.clickActionsTab();
        requestPage.clickViewrequest();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            libraries.takeScreenShot(result.getName());
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite--->");
    }
}


