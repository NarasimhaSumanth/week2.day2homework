package week2.day2homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Sumanth2");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		WebElement first = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		String firstelement = first.getText();
		System.out.println(firstelement);
		
		first.click();
		
		WebElement title2 = driver.findElement(By.xpath("//div[@id=\"sectionHeaderTitle_leads\"]"));
		String title3 = title2.getText();
		System.out.println(title3);
		
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(" change");
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(3000);
		
		WebElement companyname = driver.findElement(By.id("viewLead_companyName_sp"));
		String ChangedName = companyname.getText();
		
		System.out.println("updated name" +"" + "is"+ "" +ChangedName);
		driver.close();
		
		
		
		

	}

}
