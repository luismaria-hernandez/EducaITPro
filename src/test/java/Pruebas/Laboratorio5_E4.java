package Pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.paginaLogin;

public class Laboratorio5_E4 {

	WebDriver driver;
	paginaLogin login;
	
	
	String URL="https://www.demo.guru99.com/test/table.html";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
    
	@BeforeSuite
	public void setUp() {
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		    driver.get(URL);
		    driver.manage().window().maximize();
	}
	
	
	@AfterSuite
	public void cierreNavegador() {
		
		driver.quit();
		
	}
	

	@Test
	public void verCelda() {
		
		WebElement verCelda = driver.findElement(By.xpath("//td[contains(text(),'8')]"));
		Assert.assertEquals(verCelda.getText(), "8");
		
	}
	
}
