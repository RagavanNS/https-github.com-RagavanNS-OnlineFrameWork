package framework.intro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day1Read {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\OnlineFrameWork\\Input\\TestData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		
		int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		System.out.println("No of Rows are " + physicalNumberOfRows);
		
		Row r = s.getRow(0);
		int physicalNumberOfCells = r.getPhysicalNumberOfCells();
		System.out.println("Cells are " + physicalNumberOfCells);
		
		Cell c = r.getCell(1);
		System.out.println(c);
	}
}
