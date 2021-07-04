package framework.intro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Day1ReadX {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\DELL\\eclipse-workspace\\OnlineFrameWork\\Input\\TestData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		System.out.println("No of Rows are " + physicalNumberOfRows);
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row r = s.getRow(i);
			int physicalNumberOfCells = r.getPhysicalNumberOfCells();
			System.out.println("Cells are "+ physicalNumberOfCells);
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell c = r.getCell(j);
				System.out.println(c);
			}
		}
	}
}
