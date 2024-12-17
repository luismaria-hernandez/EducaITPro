package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.paginaLogin;

public class Laboratorio5 {

	WebDriver driver;
	paginaLogin login;
	
	
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
    
	@BeforeMethod
	public void setUp() {
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		    driver.get(URL);
		    driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void cierreNavegador() {
		
		driver.close();
		
	}
	
	@Test(dataProvider="Datos Login") /*Parámetro minuscula-mayuscula, y el nombre tal cual lo definimos abajo*/
	public void irPaginaLogin (String email, String password) {
		
		login = new paginaLogin(driver);
		login.ingresarDatos(email, password);
		Assert.assertEquals(login.getTextTitleForm(),"AUTHENTICATION");
		
	}
	
	@DataProvider(name="Datos Login") /*Anotación data provider*/
	public Object[][] getData() {
		
		Object[][]data = new Object[3][2]; /*Definimos la matríz*/
		
		/*Definimos los datos que van a estar en las posiciones de la matríz*/
		
		data[0][0] = "test1@mail.com";data[0][1] = "1234";
		data[1][0] = "test2@mail.com";data[1][1] = "5678";
		data[2][0] = "test3@mail.com";data[2][1] = "9123";
		
		return data;
	}
	
}
