package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "Details";
	}

	@Test(dataProvider="Add")
	public void editLead (String user,String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		String titleName="View Lead | opentaps CRM";
		System.out.println("Title of this page = "+driver.getTitle());
		if(titleName.equals(driver.getTitle()))
		{
			System.out.println(titleName+ " = is correct Title");
		}
		else {
			System.out.println("not correct title");
		}
			
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("LEAF TEST");
		driver.findElement(By.xpath("//input[@name='submitButton'][1]")).click();
		WebElement get = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String text1 = "LEAF TEST";
		System.out.println("changed company name = "+text1);
		if (get.getText().contains(text1)) {
			System.out.println("changes in company name is confirmed = "+text1);
			
		} else {System.out.println("changes not happened");

		}
	}
	
}
