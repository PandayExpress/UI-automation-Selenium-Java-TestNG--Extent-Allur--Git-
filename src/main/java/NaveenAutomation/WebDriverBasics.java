package NaveenAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);

		if(title.equals("google"))
		{
			System.out.println("Correct title");
		}
		else
		{
			System.out.println("In-Correct title");			
		}
		driver.quit();
	}

}
