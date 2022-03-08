package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{
	@BeforeClass
	public void setData() {
		fileName = "details";
	}

	@Test(dataProvider = "Add")
	public void deleteLead(String user, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9007721864");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		Thread.sleep(3000);
		WebElement get = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String captured = get.getText();
		System.out.println(captured);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("(//a[@href='javascript:document.deleteLeadForm.submit()'])")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(captured);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();

		String text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String orginal = "No records to display";
		System.out.println(text);
		if (text.equals(orginal)) {
			System.out.println("Confirmation - Records Deleted");
		} else {
			System.out.println("Confirmation - Records NOT Deleted");
		}
	}
}
