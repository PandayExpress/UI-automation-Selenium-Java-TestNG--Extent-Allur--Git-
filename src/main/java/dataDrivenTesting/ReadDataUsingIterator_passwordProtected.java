package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

public class ReadDataUsingIterator_passwordProtected {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
				
		String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";
		FileInputStream fis=new FileInputStream(path);
		String password="4545sang";
		XSSFWorkbook workbook= (XSSFWorkbook)WorkbookFactory.create(fis,password);
		XSSFSheet sheet=workbook.createSheet("ForgroundBackgroundColor1");
		XSSFRow row=sheet.createRow(1);
		
		//Setting BackGround Color
		CellStyle style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		
		XSSFCell cell=row.createCell(1);
		cell.setCellValue("Welcome");
		cell.setCellStyle(style);
		
		cell=row.createCell(2);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		cell=row.createCell(3);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		//Set ForeGroundColor
		style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
		cell=row.createCell(4);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		cell=row.createCell(5);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		cell=row.createCell(6);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fos.close();	
		
		System.out.println("Done Applying BackGround and ForeGround Color!!");
	}
}
