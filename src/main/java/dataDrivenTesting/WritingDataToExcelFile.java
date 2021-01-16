package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class WritingDataToExcelFile {

	public static void main(String[] args) throws IOException {
		
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet =workbook.createSheet("EmpData using 2 DimentionalObjectArray");
	Object empdata[][]= { 	{"EmpID", "Name", "Job"},
							{"101", "Sangita", "Tester"},
							{"102", "Maya", "Daughter"},
							{"103", "Ryan", "Son"},
						};
	int rows=empdata.length;
	int cols=empdata[0].length;
	System.out.println(rows+ cols);
	for(int r=0; r<rows; r++)
	{	
		XSSFRow row = sheet.createRow(r);
		
		for(int c=0; c<cols; c++)
		{
			XSSFCell cell=row.createCell(c);
			Object value=empdata[r][c];
			
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
	System.out.println("Done writing Data to Excel File!!!");
	workbook.close();
}
}