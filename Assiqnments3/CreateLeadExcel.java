package week5.day2.Assiqnments3;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadExcel extends BaseTest {
	
	@DataProvider(name = "TestData")
	//create a method
	public Object[][] fetchdata() throws InvalidFormatException, IOException{
		String[][] data = ReadDataExcel.readExcelData("Create Lead");
		return data;
		
	}
	
	@Test(dataProvider = "TestData")
	public void createlead(String companyname, String firstname, String lastname) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.name("submitButton")).click();

	}

}
