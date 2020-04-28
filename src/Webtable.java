import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtable {

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
	public void displayCompleteTable() {

		int row = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		int col = driver.findElements(By.xpath("/html/body/table/tbody/tr/th")).size();

		for (int i = 2; i <= row; i++) {

			for (int j = 1; j <= col; j++) {
				System.out.print(
						driver.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText()
								+ "  ");
			}
			System.out.println();
		}

	}

	@Test
	public void displayBookNamePrice300() {

		int rowNo = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		int colNo = driver.findElements(By.xpath("/html/body/table/tbody/tr/th")).size();

		for (int i = 2; i <= rowNo; i++) {

			String price = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[4]")).getText();

			if (price.equals("300")) {
				for (int j = 1; j <= colNo; j++) {

					System.out.print(driver
							.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText()+"  ");
					
					j = j + 1;

				}
				
				System.out.println();

			}
		}

	}
	
	@Test(priority=1)
	public void table(){
		
		List<WebElement> table = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		
		for (int i = 0; i <= table.size(); i++) {
			
			
			System.out.println(table.get(i).getText());
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
