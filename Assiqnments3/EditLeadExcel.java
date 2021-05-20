package week5.day2.Assiqnments3;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLeadExcel extends BaseTest {
	@DataProvider(name = "TestData")
	//create a method
	public Object[][] fetchdata() throws InvalidFormatException, IOException{
		String[][] data = ReadDataExcel.readExcelData("Edit Lead");
		
		return data;
	}

	
	@Test(dataProvider = "TestData",dependsOnMethods = "week5.day2.Assiqnments3.CreateLeadExcel.createlead")
	public void editlead(String editname , CharSequence[] birth) {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(editname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_birthDate")).sendKeys(birth);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

	}

}
