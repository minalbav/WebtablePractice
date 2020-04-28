import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Table {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Exe\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("file:/C:/Users/admin/Desktop/webtable.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void init() {

		WebElement tbl = driver.findElement(By.name("BookTable"));

		List<WebElement> rows = tbl.findElements(By.tagName("tr"));

		for (int i = 1; i < rows.size(); i++) {
			// check column each in row, identification with 'td' tag
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			// column iteration
			for (int j = 1; j <= 2; j++) {
				System.out.print(cols.get(j).getText()+"   ");
			}
			System.out.println();
			
		}

	} 
	
	
	@Test
	public void twocol() {
		
		int rowcount = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		int colcount = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		
		for(int totalRow = 2; totalRow<=rowcount;totalRow++) {
	
			
			String value = driver.findElement(By.xpath("/html/body/table/tbody/tr["+totalRow+"]/td[2]")).getText();
			System.out.println(value);
		
		}
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
