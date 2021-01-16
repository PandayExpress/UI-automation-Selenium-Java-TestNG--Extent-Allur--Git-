package dataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.*;


public class DataBaseToExcel {

	public static void main(String[] args) throws SQLException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	

	
	Connection conn=null;
	
	String connectionString="jdbc:sqlserver://LAPTOP-M7ASUJEB\\HOMEDQLSERVER:49170; Database=LarsonElectronics; IntegratedSecurity=true";
	try {
		System.out.println("Connection String   " + connectionString);
		conn=DriverManager.getConnection(connectionString);
		System.out.println("successful connection!");
	}
	catch(SQLException e){
		System.out.println("Error connecting to Database");
		
	}
	Statement statement=conn.createStatement();
	ResultSet rs=statement.executeQuery("SELECT TOP (100) *   FROM LarsonElectronics.dbo.Audit");
		
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("FromDataBaseToExcel");
	XSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("Id");
	row.createCell(1).setCellValue("OrderNumber");
	row.createCell(3).setCellValue("Step");
	row.createCell(4).setCellValue("UserId");
	row.createCell(5).setCellValue("Added");
	
	int r=1;
	while(rs.next())
	{
		Integer lId=rs.getInt("id");
		Integer lordernumber=rs.getInt("ordernumber");
		String lstep=rs.getString("step");
		Integer luserid=rs.getInt("userid");
		Date ladded=rs.getDate("added");
		
		row=sheet.createRow(r++);
		
		row.createCell(0).setCellValue(lId);
		row.createCell(1).setCellValue(lordernumber);
		row.createCell(2).setCellValue(lstep);
		row.createCell(3).setCellValue(luserid);
		row.createCell(4).setCellValue(ladded);				
	}
	String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";	
	FileOutputStream fos=new FileOutputStream(path);
	workbook.write(fos);
	fos.close();
	workbook.close();
	conn.close();	
	System.out.println("Got data from the database and wrote to xcel!!");
}	
}
