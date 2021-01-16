package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.*;

public class ExcelToHashMap {

	public static void main(String[] args) throws IOException {

	String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";	
	FileInputStream fis=new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("HashMapToExcel");
	
	int lastRowNumber =sheet.getLastRowNum();
	
	HashMap<String, String> dataHash=new HashMap<String, String>();
	for(int r =0; r<=lastRowNumber; r++)
	{
		String key=sheet.getRow(r).getCell(0).getStringCellValue();
		String value=sheet.getRow(r).getCell(1).getStringCellValue();
		dataHash.put(key, value);		
	}
	
	
	for(Map.Entry entry:dataHash.entrySet())
	{
		System.out.println(entry.getKey() + "  " + entry.getValue());
		
	}

	
	}
}
