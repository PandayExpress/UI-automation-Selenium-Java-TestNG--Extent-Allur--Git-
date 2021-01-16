package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;


public class ReadWriteFormulaCells {

	public static void main(String[] args) throws IOException {

	String path=System.getProperty("user.dir") +"/src/test/resources/emloyee.xlsx";
	System.out.println(path);
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("ReadingWritingFormulaCell");
	
	
	sheet.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
	fis.close();
	
	FileOutputStream fos=new FileOutputStream(path);
	workbook.write(fos);
	workbook.close();
		
	System.out.println("Done!!!");	
	}
}