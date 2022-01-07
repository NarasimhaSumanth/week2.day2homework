package week2.day2homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		// driver.findElement(By.xpath("//form/div[5]/a[text() = 'Create New
		// Account']")).click();

		driver.findElement(By.xpath("//form//a[text() = 'Create New Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Sumanth1P");
		driver.findElement(By.name("lastname")).sendKeys("K");
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		driver.findElement(By.id("password_step_input")).sendKeys("Sumanth@1");

		WebElement day = driver.findElement(By.id("day"));
		Select dd1 = new Select(day);
		dd1.selectByValue("19");

		WebElement month = driver.findElement(By.id("month"));
		Select dd2 = new Select(month);
		dd2.selectByValue("7");

		WebElement year = driver.findElement(By.id("year"));
		Select dd3 = new Select(year);
		dd3.selectByValue("1992");

		driver.findElement(By.className("_58mt")).click();

	}

}
