package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class saucedemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		//logging to the application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(2000);
		
		//add 3 products into cart
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		String count =driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
	
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		int size = driver.findElements(By.xpath("//div[@class='inventory_item_name']")).size();
		
		if(Integer.parseInt(count)==size)
		{
			System.out.println("shopping cart showing right number");
		}
		else
		{
			System.out.println("shopping cart showing wrong number");
		}
	
		driver.findElement(By.xpath("//div[@class='cart_footer']//button[@name='checkout']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Lalit");
		driver.findElement(By.name("lastName")).sendKeys("Sonawane");
		driver.findElement(By.name("postalCode")).sendKeys("425013");
		driver.findElement(By.name("continue")).click();
		
		driver.findElement(By.name("finish")).click();
		
		String confirm = driver.findElement(By.tagName("h2")).getText();
		String expText="Thank you for your order!";
		if(confirm.equals(expText))
		{
			System.out.println("Order Placed Successfully");
		}
		else
		{
			System.out.println("checkout failed");
		}
	
	}

}
