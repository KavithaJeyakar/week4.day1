package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTagsTable {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://html.com/tags/table/");
	driver.manage().window().maximize();
	
	List <WebElement> tableCount= driver.findElements(By.xpath("//table"));
	List <WebElement> rowCount 	= driver.findElements(By.xpath("//table//tr"));
	List <WebElement> colCount1 = driver.findElements(By.xpath("//div[@class= 'render']//table//tr//th"));
	List <WebElement> colCount2 = driver.findElements(By.xpath("//div[@class= 'related-pages']//table//tr//th"));
	
	int tabCount = tableCount.size();
	int rCount= rowCount.size();
	int colCount = colCount1.size() + colCount2.size();
	
	
	System.out.println("Total no of tables: " 	+ tabCount);
	System.out.println("Total no of rows: " 	+ rCount);
	System.out.println("Total no of columns: "  + colCount); 
		
	Thread.sleep(2000);
	driver.close();
	
}
}
