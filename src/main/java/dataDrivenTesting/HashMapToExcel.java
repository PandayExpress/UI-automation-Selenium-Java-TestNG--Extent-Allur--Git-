package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("HashMapToExcel");
		
		Map<String, String> data=new HashMap<String, String>();
		data.put("101", "Sangita");
		data.put("102", "Maya");	
		data.put("103", "Ryan");	
		data.put("104", "Mamta");	
		data.put("105", "Radhika");		
		
		int rowno=0;
		for(Map.Entry entry:data.entrySet())
		{
			XSSFRow row=sheet.createRow(rowno++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getKey());
		}
		
		String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";
		FileOutputStream fos= new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
		workbook.close();
		System.out.println("Writing from HashMap to Excel!!!");
	}

}
