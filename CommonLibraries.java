package PagesSTG;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonLibraries {
    WebDriver driver;
    WebDriverWait driverWait;

    public CommonLibraries(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver,70);
        PageFactory.initElements(driver,this);
    }

    public void Sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void spinnerLoading() {
        By spinner_loading = By.id("loadingDiv");
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(spinner_loading));
    }

/*    public static String getData (List<String> excelValues) throws IOException {
        List<String> list = new ArrayList<>();
        String str;
        File location = new File(excelValues.get(0));
        FileInputStream file = new FileInputStream(location);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(excelValues.get(1));
        Row row = sheet.getRow(Integer.parseInt(excelValues.get(2)));
        //short cell = row.getLastCellNum();
        //for (Row row : sheet) {
        for (int cn = 0; cn < row.getLastCellNum(); cn++) {
            Cell rowCell = row.getCell(cn);
            str = String.valueOf(rowCell);
            list.add(str);
            //System.out.println("CELL: " + cn + " --> " + cell.toString());
        }
        file.close();
        System.out.println("List ="+list);
        String String = new String();
        return String;
    }*/

    public static List<Cell> getRowValues (List<String> excelValues) throws IOException {
        List <Cell> cellValues = new ArrayList<>();
        Cell cell;
        File location = new File(excelValues.get(0));
        FileInputStream file = new FileInputStream(location);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(excelValues.get(1));
        Row row = sheet.getRow(Integer.parseInt(excelValues.get(2)));
        for (int cn = 0; cn <= row.getLastCellNum(); cn++) {
            cell = row.getCell(cn);
            cellValues.add(cell);
        }
        file.close();
        return cellValues;
    }

    public void takeScreenShot(String screenShotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        FileUtils.copyFile(source,new File("D:\\MavenStageENV\\src\\test\\resources\\ScreenShot\\"+screenShotName+timeStamp+".jpg"));
        System.out.println("Screenshot taken");
    }
}