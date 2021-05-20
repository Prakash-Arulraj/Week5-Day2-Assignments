package week5.day2.Assiqnments3;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel {

	public static String[][] readExcelData(String sheetname) throws InvalidFormatException, IOException {
		// workbook
		File filename = new File("./data/Leads.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(filename);

		// sheet
		XSSFSheet sheet = wbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][columncount];

		for (int i = 1; i <= rowcount; i++) {
			// row
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columncount; j++) {
				// column (cell)
				XSSFCell cell = row.getCell(j);
				// print all the column values
				System.out.println(cell.getStringCellValue());
				data[i-1][j] = cell.getStringCellValue();

			}
		}
		//close workbook
		wbook.close();
		
		return data;

	}

}
