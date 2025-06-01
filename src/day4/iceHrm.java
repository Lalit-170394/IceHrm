package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iceHrm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		driver.get("https://icehrm-open.gamonoid.com/login.php#");
		driver.manage().window().maximize();
		//logging to the application
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[normalize-space()='Log in']")));
		
		Thread.sleep(1000);
		//cancelling pop up
		//driver.findElement(By.xpath("//div[@id='verifyModel']//li[@class='fa fa-times']")).click();
		
		//navigating to employees page
		driver.findElement(By.xpath("//li[@ref='admin_Employees']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Employees')]")).click();
		
		//clicking on add net employee button
		driver.findElement(By.xpath("//div[@class='ant-space-item']//button[@class='ant-btn ant-btn-default']")).click();
		
		//entering details 
		driver.findElement(By.xpath("//input[@id='employee_id']")).sendKeys("102");
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Prasad");
		driver.findElement(By.xpath("//input[@id='middle_name']")).sendKeys("Vijay");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Sonawane");
	
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[2]")).sendKeys("Indian");
		Thread.sleep(2000);
		List<WebElement> opt = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div//div"));
		System.out.println(opt.size());
		for(WebElement op : opt)
		{
			if(op.getText().equalsIgnoreCase("Indian"))
			{
				op.click();
			}
		}
		
		driver.findElement(By.xpath("//input[@id='birthday']")).click();
		driver.findElement(By.xpath("//div[@class='ant-picker-header-view']//button[1]")).click();
		String year = driver.findElement(By.xpath("//div[@class='ant-picker-header-view']")).getText();
		//button/span[@class='ant-picker-super-prev-icon']
		while(true) {
			year = driver.findElement(By.xpath("//div[@class='ant-picker-header-view']")).getText();
			
			if(year.equals("2002"))
			{
				break;
			}
			driver.findElement(By.xpath("//button/span[@class='ant-picker-super-prev-icon']")).click();
		
		}
		
		List<WebElement>months = driver.findElements(By.xpath("//table[@class='ant-picker-content']//td//div"));
		System.out.println(months.size());
		for(WebElement month : months)
		{
			if(month.getText().equals("Jun"))
			{
				month.click();
				break;
			}
		}
		
		List<WebElement>days = driver.findElements(By.xpath("//table[@class='ant-picker-content']//td[contains(@class,'ant-picker-cell-in-view')]"));
		for(WebElement day : days)
		{
			if(day.getText().equals("16"))
			{
				day.click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[3]")).click();
		List<WebElement> gender = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div//div"));
		for(WebElement g:gender)
		{
			if(g.getText().equals("Male"))
			{
				g.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[4]")).click();
		List<WebElement> ms = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div//div"));
		for(WebElement status:ms)
		{
			if(status.getText().equals("Single"))
			{
				status.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[5]")).click();
		List<WebElement> ethinicity = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div//div"));
		for(WebElement eth:ethinicity)
		{
			if(eth.getText().equalsIgnoreCase("Asian American"))
			{
				eth.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-space-item']//button//span[text()='Next']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='ant-space-item']//button//span[text()='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[7]")).click();
		List<WebElement> empStatus = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
		System.out.println(empStatus.size());
		for(WebElement estatus:empStatus)
		{
			if(estatus.getText().equalsIgnoreCase("Full Time Permanent"))
			{
				estatus.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[8]")).click();
		List<WebElement> department = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
			for(WebElement dept:department)
		{
			if(dept.getText().equalsIgnoreCase("QA Team"))
			{
				dept.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[9]")).click();
		List<WebElement> jobTitle = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
	
		for(WebElement job:jobTitle)
		{
			if(job.getText().equalsIgnoreCase("QA Engineer"))
			{
				job.click();
				break;
			}
		}
			
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[10]")).click();
		List<WebElement> payGrade = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
	
		for(WebElement pg:payGrade)
		{
			if(pg.getText().equalsIgnoreCase("Manager"))
			{
				pg.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='joined_date']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Today')])[2]")).click();
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[11]")).sendKeys("Kolkata");
		List<WebElement> timeZone = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
		System.out.println("time"+timeZone.size());
		for(WebElement time:timeZone)
		{
			if(time.getText().contains("Kolkata"))
			{
				time.click();
				break;
			}
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-space-item']//button//span[text()='Next']")).click();
		
		driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[12]")).sendKeys("India");
		List<WebElement> country = driver.findElements(By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='ant-select-item-option-content']"));
		
		for(WebElement con:country)
		{
			if(con.getText().equals("India"))
			{
				con.click();
				break;
			}
		}
		
		
		
		
		
		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
