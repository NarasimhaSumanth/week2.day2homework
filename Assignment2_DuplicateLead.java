package week2.day2homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("sumanth123@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		WebElement result = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));

		String lead1 = result.getText();
		System.out.println(lead1);
		result.click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();

		WebElement header = driver.findElement(By.id("sectionHeaderTitle_leads"));
		String title1 = header.getText();
		System.out.println(title1);

		//driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		driver.findElement(By.name("submitButton")).click();
		
		WebElement duplicate = driver.findElement(By.id("viewLead_firstName_sp"));
		String name = duplicate.getText();
		System.out.println(name);

		if (lead1.equals(name)) {

			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		
		driver.close();

	}

}
