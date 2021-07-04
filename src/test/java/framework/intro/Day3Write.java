package framework.intro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day3Write {
	public static void main(String[] args) throws IOException {
		File loc = new File("C:\\Users\\DELL\\eclipse-workspace\\OnlineFrameWork\\Input\\TestData.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Data");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("Siva");
		System.out.println(c);
		Row r1 = s.createRow(1);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("Nisha");
		System.out.println(c1);
		FileOutputStream f = new FileOutputStream(loc);
		w.write(f);
		System.out.println("NS");
	}
}