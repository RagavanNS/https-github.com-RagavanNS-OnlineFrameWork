package PagesSTG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class VendorLoginPage {
    WebDriver driver;
    WebDriverWait driverWait;

    @FindBys({@FindBy(tagName = "footer")})
    List<WebElement> tagText;
    @FindBy(xpath = "//b[text()='GHX Login']")
    WebElement GHXLoginHeader;
    @FindBy(xpath = "//h5[contains(text(),'En')]")
    WebElement LoginText;
    @FindBy(xpath = "//input[@type='text']")
    WebElement usernameTextfield;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;
    @FindBy(id = "btnLogin")
    WebElement loginButton;

    public VendorLoginPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    public void getTexts() {
        for (WebElement presentText : tagText) {
            String text = presentText.getText();
            System.out.println(text);
        }
    }

    public void VerifyGHXLoginHeader(String expectedHeader) {
        System.out.println("Verifying GHXLogin Header Expected ->" +expectedHeader);
        driverWait.until(ExpectedConditions.visibilityOf(GHXLoginHeader));
        System.out.println("Verifying GHXLogin Header Actual ->" +GHXLoginHeader.getText());
        Assert.assertEquals(GHXLoginHeader.getText(),expectedHeader);
    }

    public void VerifyLoginText(String expectedLoginText) {
        System.out.println("Verifying Login Text ->" +expectedLoginText);
        driverWait.until(ExpectedConditions.visibilityOf(LoginText));
        Assert.assertEquals(LoginText.getText(),expectedLoginText);
    }

    public String setUsernameTextfield(String userName) {
        usernameTextfield.sendKeys(userName);
        return userName;
    }

    public void setPasswordField(String passWord) {
        passwordField.sendKeys(passWord);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


    /*public static String getData(int row, int cell, String filePath, String fileName) throws IOException {
        String value = null;
        File loc = new File(filePath);
        FileInputStream file = new FileInputStream(loc);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(fileName);
        Row row1 = sheet.getRow(row);
        Cell cell1 = row1.getCell(cell);
//       int cellType = cell1.getCellType();

//       if (cellType == 1) {
//           value = cell1.getStringCellValue();
//       }
//       else if (cellType == 0) {
//           if (DateUtil.isCellDateFormatted(cell1));
//           Date dateCellValue = cell1.getDateCellValue();
//           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//           value = dateFormat.format(dateCellValue);
//       }else {
//           double numericCellValue = cell1.getNumericCellValue();
//           long l = (long) numericCellValue;
//           value = String.valueOf(l);
//       }
        value = cell1.getStringCellValue();

        return value;
    }*/
}
