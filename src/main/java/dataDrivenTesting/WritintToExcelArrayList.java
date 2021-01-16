package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritintToExcelArrayList {

	public static void main(String[] args) throws IOException {
		
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("Emp Data Using ArrayList");
	
	ArrayList<Object[]> empdata=new ArrayList<Object[]>();
	
	 empdata.add(new Object[]{"EmpID", "Name", "Job"});
	 empdata.add(new Object[]{"101", "ArrayList", "Tester"});
	 empdata.add(new Object[]{"102", "ArrayList", "Amazingly Kind Daughter"});
	 empdata.add(new Object[]{"103", "ArrauList", "Precious Son"});
	
	 
	 int rowCount = 0;
	 for(Object[] emp:empdata)
	 {
		 XSSFRow row=sheet.createRow(rowCount++);
		 int cellnum=0;	 
		 
		 for(Object value:emp)
		 {
			XSSFCell cell=row.createCell(cellnum++);
			
			if(value instanceof String)
				cell.setCellValue((String)value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		 }			 
	 }
 String path=System.getProperty("user.dir") +"/src/test/resources/emloyee.xlsx";
 FileOutputStream outstream=new	FileOutputStream(path) ;
 workbook.write(outstream);
 outstream.close();
 workbook.close();
 System.out.println("Done writing to Excel Using ArrayList"); 
	}
}
