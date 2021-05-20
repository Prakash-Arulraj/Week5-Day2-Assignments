package week5.day2.Assiqnments2;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseTest {
	@DataProvider(name = "TestData")
	// create a method
	public Object[][] fetchdata() {
		String[][] data = new String[2][3];
		data[0][0] = "Cognizant";
		data[0][1] = "Prakash";
		data[0][2] = "Kumar";
		
		data[1][0] = "Cognizant";
		data[1][1] = "Preethi";
		data[1][2] = "Prakash";
		

		return data;

	}

	@Test(dataProvider = "TestData")
	public void createlead(String companyname , String firstname , String lastname) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.name("submitButton")).click();

	}

}
