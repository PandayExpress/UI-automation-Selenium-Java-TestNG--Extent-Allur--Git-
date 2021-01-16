package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteFormulaCell {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("CreatingFormulaCell");
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		
		row.createCell(3).setCellValue("A1*B1*C1");
		
		String path=System.getProperty("user.dir") +"/src/test/resources/emloyee.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();		
		System.out.println("Done writing FormulaCell  " +path);
		workbook.close();
	
	}

}
