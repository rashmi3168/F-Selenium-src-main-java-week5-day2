package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "Details";
	}

	@Test(dataProvider = "Add")
	public void createLead(String user, String password) {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rashmi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Bhatt");
		driver.findElement(By.xpath("//input[@id='createLeadForm_birthDate']")).sendKeys("6/10/87");

		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("rashmi3168@gmail.com");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("9007721864");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalAddress1']")).sendKeys("CGRA Nanganallur");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalCity']")).sendKeys("Chennai");
		WebElement state1 = driver.findElement(By.xpath("//select[@id='createLeadForm_generalCountryGeoId']"));
		Select select1 = new Select(state1);
		select1.selectByVisibleText("India");

		WebElement state = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select select = new Select(state);
		select.selectByVisibleText("TAMILNADU");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalPostalCode']")).sendKeys("600061");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	}
}
