package dataDrivenTesting;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromPasswordProtectedFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";
		FileInputStream fis=new FileInputStream(path);
		String password="4545sang";
		
		//Workbook workbook=WorkbookFactory.create(fis,password);
		
		XSSFWorkbook workbook=(XSSFWorkbook)WorkbookFactory.create(fis,password);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int lastRowNumber=sheet.getLastRowNum();
		int lastCollumNumber=sheet.getRow(0).getLastCellNum();
		
		for(int r=0; r<=lastRowNumber; r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<lastCollumNumber; c++)
			{
				XSSFCell cell=row.getCell(c);			
				switch(cell.getCellType())
				{
				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
				case STRING: System.out.print(cell.getStringCellValue()); break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
				case FORMULA: System.out.print(cell.getNumericCellValue());break;
				}
				System.out.print(" | ");			
			}
			System.out.println();		
		}
		workbook.close();
		fis.close();
	}
}
