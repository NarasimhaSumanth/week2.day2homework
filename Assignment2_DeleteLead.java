package week2.day2homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DeleteLead {

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
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("1");
		//driver.findElement(By.name("phoneAreaCode")).sendKeys("022");
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(3000);
		
		WebElement firstlead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
			
		String lead = firstlead.getText();
		
		System.out.println(lead);
		
		firstlead.click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(lead);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		WebElement message = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		Thread.sleep(3000);
		String msg = message.getText();
		Thread.sleep(3000);
		
		System.out.println(msg);
		
		if (msg.contains("No records to display")) {
			System.out.println("Record"+""+lead+""+ "successfully deleted ");
			
		} else {
			System.out.println("Fail");

		}
		
		driver.close();
		
		
		
		
	}

}
