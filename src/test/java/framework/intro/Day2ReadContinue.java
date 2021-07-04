package framework.intro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day2ReadContinue {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\OnlineFrameWork\\Input\\TestData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(2);
		int cellType = c.getCellType();
		System.out.println("Celltype is "+ cellType);
		System.out.println("Cell value is "+ c);
		if (cellType == 1) {
			String stringCellValue = c.getStringCellValue();
			System.out.println(stringCellValue);
		} else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellvalue = c.getDateCellValue();
				System.out.println(dateCellvalue);
				SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
				String format = sim.format(dateCellvalue);
				System.out.println(format);
			} else {
				double numericCellValue = c.getNumericCellValue();
				System.out.println(numericCellValue);
				long l = (long) numericCellValue;
				String valueOf = String.valueOf(1);
				System.out.println(valueOf);
			}
		}
	}
}
