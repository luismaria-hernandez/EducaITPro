package Pruebas;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Paginas.paginaLogin;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class Laboratorio4 {

	WebDriver driver;
	paginaLogin login;
	
	
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
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
		
		driver.close();
		
	}
	
	@Test
	public void irRegistroLogin() {
		
		login = new paginaLogin(driver); /*El constructor de la clase de login recibe el driver de parámentro*/
		login.ingresarDatos("test@test.com", "Clave1234");
		Assert.assertEquals(login.getTextTitleForm(),"AUTHENTICATION");
		
	}
}
