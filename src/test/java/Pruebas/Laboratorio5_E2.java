package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.paginaLogin;

public class Laboratorio5_E2 {

	WebDriver driver;
	paginaLogin login;
	
	
	String URL="http://demo.guru99.com/test/upload";
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
		
		//driver.close();
		
	}
	
	@Test
	public void cargarArchivos () {
		
		WebElement rutaArchivo = driver.findElement(By.id("uploadfile_0"));
		rutaArchivo.sendKeys("C:\\Users\\Usuario\\Documents\\Curso de Selenium\\Archivos de prueba\\Prueba1.txt");
		
	}
	
	
}
