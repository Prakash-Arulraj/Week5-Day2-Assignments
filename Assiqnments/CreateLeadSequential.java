package week5.day2.Assiqnments;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class CreateLeadSequential {
	ChromeDriver driver;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url , String username , String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// step 1: login page
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();

		// step 2: click crmsfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// step 3: create lead
		driver.findElement(By.linkText("Leads")).click();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
