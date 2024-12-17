package EducaITPro;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Laboratorio2 {

	public void lab2_E1Test() {
		
		System.setProperty("webdriver.chrome.driver","..\\EducaITPro\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		
		WebElement txt_email = driver.findElement(By.id("email_create"));
		txt_email.sendKeys("micorreo"+ Math.random() +"@correo.com");
		
		WebElement btn_create = driver.findElement(By.id("SubmitCreate"));
		
		btn_create.click();
	}
	
}
