package week5.day2.Assiqnments;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends CreateLeadSequential {

	@Test(invocationCount = 3)
	public void createlead() {
		/*
		 * //1. Try to run CreateLead Testcase 3 times sequentially using appropriate
		 * annotation attribute ( Use invocationCount =3) 2. Implement the common
		 * DataProvider. 3. Dynamic data parametrization for all the 5 testcases -
		 * Create new excel document for the testcases that require the multiple data to
		 * operate on. - Implement the Data parametrization for all the required
		 * testcases through the DataProvider class to read the data from the excel
		 * sheet
		 */
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizent");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmanaban");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Dhinesh");
		driver.findElement(By.name("submitButton")).click();
	}

}
