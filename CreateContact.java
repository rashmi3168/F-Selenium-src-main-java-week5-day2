package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateContact extends BaseClass {
	@BeforeClass
	public void setData() {
		fileName = "Details";
	}

	@Test(dataProvider="Add")
	public void createContact (String user,String password) {
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Rashmi");
        driver.findElement(By.id("lastNameField")).sendKeys("Bhatt");
	    driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewContact_firstName_sp")).getText();
	    System.out.println("First name = "+text+"   "+"Browser Title = "+driver.getTitle());
	}
}
