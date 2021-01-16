package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcel_ForEachLoop {

	public static void main(String[] args) throws IOException {
	
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet =workbook.createSheet("EmpData Using ForLoop");
	Object empdata[][]= { 	{"EmpID", "Name", "Job"},
							{"101", "SangitaPanday", "Tester"},
							{"102", "MayaPanday", "Amazingly Kind Daughter"},
							{"103", "RyanPanday", "Precious Son"},
						};
	int rowCount=0;	
	for(Object emp[]:empdata)
	{
		XSSFRow row=sheet.createRow(rowCount++);
		int columncount=0;
		
			for(Object value:emp)
			{
				XSSFCell cell=row.createCell(columncount++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);				
			}
	}

	String path=System.getProperty("user.dir") +"/src/test/resources/emloyee.xlsx";
	FileOutputStream outstream=new FileOutputStream(path);
	workbook.write(outstream);
	outstream.close();	
	workbook.close();
	System.out.println("Done writing Data to Excel File!!!");

	}
}
