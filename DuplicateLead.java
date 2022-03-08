package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "Details";
	}

	@Test(dataProvider="Add")
	public void duplicateLead(String user,String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("rashmi3168@gmail.com");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String text2 = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		System.out.println(text2);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains(text2)) 
				{
			System.out.println("verified title name is Duplicate Lead");
			
		} else {
			System.out.println("verified title name is NOT Duplicate Lead");

		}
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			Thread.sleep(3000);
		String text3 = driver.findElement(By.xpath("//span[@id=\"viewLead_firstName_sp\"]")).getText();
		System.out.println(text3);
		if (text3.equals(text)) {
			System.out.println("the duplicated lead name is same as captured name");
			
		} else {
			System.out.println("the duplicated lead name is NOT same as captured name");
		}
	
	}
}
