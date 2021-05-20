package week5.day2.Assiqnments3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeLeadExcel extends BaseTest {
	@DataProvider(name = "TestData")
	//create a method
	public Object[][] fetchdata() throws InvalidFormatException, IOException{
		String[][] data = ReadDataExcel.readExcelData("Merge Lead");
		
		
		return data;
	}

	@Test(dataProvider = "TestData",dependsOnMethods = "week5.day2.Assiqnments3.EditLeadExcel.editlead")
	public void mergelead(String mergename, String secondname) throws InterruptedException {
		// step 11: click merge lead
		driver.findElement(By.linkText("Merge Leads")).click();

		// step 1: click on from lead icon
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();

		// step 2: control to move on second window
		Set<String> allwindowhandles = driver.getWindowHandles();
		List<String> seondwindow = new ArrayList<String>(allwindowhandles);
		driver.switchTo().window(seondwindow.get(1));

		// step 3: enter the value to from lead id
		driver.findElement(By.name("firstName")).sendKeys(mergename);

		// step 4: click to search
		driver.findElement(By.xpath("//button[@type='button']")).click();

		// step 5: wait for sometime
		Thread.sleep(2000);

		// step 6: click to lead id
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		// step 7: control move on first window
		driver.switchTo().window(seondwindow.get(0));

		// step 1: click on to lead icon
		driver.findElement(By.xpath("//span[text()='To Lead']/following::img")).click();

		// step 2: control to move on second window
		allwindowhandles = driver.getWindowHandles();
		seondwindow = new ArrayList<String>(allwindowhandles);
		driver.switchTo().window(seondwindow.get(1));

		// step 3: enter the value to leadid
		driver.findElement(By.name("lastName")).sendKeys(secondname);

		// step 4: click to search
		driver.findElement(By.xpath("//button[@type='button']")).click();

		// step 5: wait for sometime
		Thread.sleep(2000);

		// step 6: click to leadid
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		// step 7: control move on first window
		driver.switchTo().window(seondwindow.get(0));

		// step 8: click to merge button
		driver.findElement(By.linkText("Merge")).click();

		// step 9: switch to alert box
		Alert alert = driver.switchTo().alert();

		// step 10: accept the alert
		alert.accept();

		// step 11: gettitle
		System.out.println(driver.getTitle());

	}

}
