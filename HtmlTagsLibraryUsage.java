package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlTagsLibraryUsage 
{
	public static void main(String[] args) 
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://html.com/tags/table/");
	driver.manage().window().maximize();
	
	List <WebElement>  text = driver.findElements(By.xpath("//div[@class='render']//tbody//tr"));
	
	int size = text.size();
	System.out.println(size);
	
	for(int i=1;i<=size;i++)
	{
		String text1 = driver.findElement(By.xpath("//div[@class='render']//tbody//tr[" +i+ "]")).getText();	
		
		if (text1.contains("Market Share"))
		{
			System.out.println(text1);
		}
		else if (text1.contains("Absolute Usage"))
		{
			System.out.println(text1);
		}
	}
	driver.close();
	
	}
}
