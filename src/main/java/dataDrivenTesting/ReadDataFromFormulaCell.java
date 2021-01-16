package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulaCell {

	public static void main(String[] args) throws IOException {

		FileInputStream fis= new FileInputStream(".\\DataFiles\\readformula.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("FormulaCeLL");
		
		int lastRowNumber=sheet.getLastRowNum();
		int lastCollumNumber=sheet.getRow(0).getLastCellNum();
		
		for(int r=0; r<=lastRowNumber; r++)
		{
			XSSFRow row=sheet.getRow(r);
			
			for(int c=0; c<lastCollumNumber; c++)
			{
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING:
					cell.getStringCellValue(); break;
				case NUMERIC:
					 cell.getNumericCellValue(); break;
				case BOOLEAN:
					 cell.getBooleanCellValue(); break;
				case FORMULA:
					 cell.getNumericCellValue(); break;					
				}
			}
		fis.close();
		workbook.close();
		}
	
	}

}
