package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterEmp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://icehrm-open.gamonoid.com/login.php#");
		driver.manage().window().maximize();
		//logging to the application
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//div[@id='verifyModel']//li[@class='fa fa-times']")).click();
		
		//navigating to employees page
		driver.findElement(By.xpath("//li[@ref='admin_Employees']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Employees')]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Filter Employees']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div//div"));
		for(WebElement op : options)
		{
			if(op.getText().equals("QA Engineer"))
			{
				op.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//div[@class='ant-space-item']//button//span[text()='Save'])[1]")).click();
		Thread.sleep(1000);		
		List<WebElement> emp = driver.findElements(By.xpath("//div[@class='ant-spin-container']//li[@class='ant-list-item']"));
		System.out.println("size :  "+emp.size());
		Thread.sleep(3000);
		WebElement nxtbtn = driver.findElement(By.xpath("//li[@title='Next Page']//button[@class='ant-pagination-item-link']"));
		boolean status = nxtbtn.isEnabled();
		System.out.println(status);
		while(true)
		{			
			Thread.sleep(1000);
			if(status)
			{
				nxtbtn.click();
				//emp.addAll(driver.findElements(By.xpath("//div[@class='ant-spin-container']//li[@class='ant-list-item']")));
				
			}
			else
			{
				break;
			}			
			status = nxtbtn.isEnabled();
		}
		Thread.sleep(2000);		
		int i=1;
		for(WebElement em :emp )
		{
			System.out.println(i+"  "+em.getText());
			i++;
		}
		

	}

}
