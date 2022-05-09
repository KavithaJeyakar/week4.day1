package week4.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundToyTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//div[@id='contentblock']//tr"));
		List<WebElement> cCount = driver.findElements(By.xpath("//div[@id='contentblock']//tr//th"));
		
		List<String> listSort = new ArrayList<String>();
		
		int size = rowCount.size();
		int size1 = cCount.size();
		int count=0;
		
		for(int i=2;i<=size;i++)
		{
			String rCount = driver.findElement(By.xpath("//div[@id='contentblock']//tr["+i+"]")).getText();	
			count++;
			
			if (rCount.contains("Learn to interact with Elements"))
					{
				System.out.println(rCount);
					}
			
			String progVal = driver.findElement(By.xpath("//div[@id='contentblock']//tr["+i+"]//td[2]")).getText();
		//	System.out.println("Progress values : " + progVal);
			listSort.add(progVal);
			
			if (progVal.equals("20%"))
			{
				driver.findElement(By.xpath("//div[@id='contentblock']//tr["+i+"]//td[3]")).click();
				String text = driver.findElement(By.xpath("//table//tr[" +i +"]")).getText();
				System.out.println("Vital task for the least completed progress is : " + text);
			}
			
		}
		
		System.out.println("Row count : " + count);
		System.out.println("Column count : " + size1);
	//	System.out.println(listSort);		
		
		driver.close();
		
		
	}
}
