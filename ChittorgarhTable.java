package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
//import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		
		driver.findElement(By.id("navbtn_stockmarket")).click();
		
		driver.findElement(By.xpath("//a[@class ='ch-bar-item ch-button' and text() ='NSE Bulk Deals' ]")).click();
			
		List <WebElement> secName = driver.findElements(By.xpath("//table[@class ='table table-bordered table-condensed table-striped']//tbody//tr//td[3]"));
		
		int size = secName.size();
		
		System.out.println("size : " +size);
		
		List <String> text2 = new ArrayList<String>();
		Set <String> duplSet = new LinkedHashSet<String>();
		
		
		System.out.println("Security Name list : " );
		for (int i=1;i<=size; i++)
		{
			String text1 = driver.findElement(By.xpath("//table[@class ='table table-bordered table-condensed table-striped']//tbody//tr["+i+"]//td[3]")).getText();
			System.out.println(text1);		
			text2.add(text1);
		}
		
		for (int j=0;j<size; j++)
		{
			for(int k=j+1;k<size;k++)
			{
		//	String text3 = text2.get(j);
			
				if(text2.get(j).equals(text2.get(k)))
				{
				 duplSet.add(text2.get(k));
				}
			}
		}
		System.out.println("Duplicate Security Names are : " + duplSet);
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
