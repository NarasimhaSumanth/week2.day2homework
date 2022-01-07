package week2.day2homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_CreateContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Sumanth4");
		driver.findElement(By.id("lastNameField")).sendKeys("k");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sum");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("k");
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Testing");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Description");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("Sumanth1234@gmail.com");
		WebElement dd1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropdown = new Select(dd1);
		dropdown.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test purpose");
		driver.findElement(By.name("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		String title2 = driver.getTitle();

		System.out.println(title2);

	}

}
