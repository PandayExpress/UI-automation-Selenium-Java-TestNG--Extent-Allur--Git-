package dataDrivenTesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class WebTableToExcel {
	public static void main(String[]args) throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

		String path=System.getProperty("user.dir") +"/src/test/resources/loginData.xlsx";
		XLUtility xlutil= new XLUtility(path);
		
		xlutil.setCellData("Sheet2", 0, 0, "County");
		xlutil.setCellData("Sheet2", 0, 1, "Population");
		xlutil.setCellData("Sheet2", 0, 2, "% of World");
		xlutil.setCellData("Sheet2", 0, 3, "Date");
		xlutil.setCellData("Sheet2", 0, 4, "Source");
		
		/* xlutil.fillRedColor("Sheet2", 0, 0);
		xlutil.fillRedColor("Sheet2", 0, 1);
		xlutil.fillRedColor("Sheet2", 0, 2);
		xlutil.fillRedColor("Sheet2", 0, 3);
		xlutil.fillRedColor("Sheet2", 0, 4);
		*/
		
		WebElement table=driver.findElement(By.xpath("//table[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]/tbody"));
		int rows=table.findElements(By.xpath("tr")).size();

		//driver.findElements(By.xpath("//table[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]/tbody/tr")).size();
		
		for (int r=1; r<=rows; r++)
		{
			String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();			
			String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();			
			String percentOfWorld=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();			
			String date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();			
			String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();			
			
			xlutil.setCellData("Sheet2", r, 0, country);
			xlutil.setCellData("Sheet2", r, 1, population);
			xlutil.setCellData("Sheet2", r, 2, percentOfWorld);
			xlutil.setCellData("Sheet2", r, 3, date);
			xlutil.setCellData("Sheet2", r, 0, source);	
		}		
		System.out.println("WebScraping - WebHarvesting - Done!!"+ path);	
		driver.quit();		
	}

}
