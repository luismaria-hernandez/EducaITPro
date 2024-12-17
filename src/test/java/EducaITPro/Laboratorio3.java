package EducaITPro;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class Laboratorio3 {

	WebDriver driver;
	String URL= "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
	
	@BeforeSuite()
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", PATH);
		driver = new ChromeDriver();
	}
	
	@BeforeTest()
	public void irURL() {
		driver.get(URL);
	}
	
	@BeforeClass()
	public void maxVentana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test()
	public void registrarUsuario() {
		 
	    WebElement txt_Email=driver.findElement(By.id("email_create"));
		txt_Email.sendKeys("micorreo"+Math.random()+"@correo.com");

		WebElement btn_Create=driver.findElement(By.name("SubmitCreate"));
		btn_Create.click();

		
		WebDriverWait mywait=new WebDriverWait(driver,10);

		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));

		driver.findElement(By.id("id_gender1")).click();
		
		
		WebElement txt_FirstName=driver.findElement(By.name("customer_firstname"));
		txt_FirstName.sendKeys("Juan Cruz");
		
		 
		WebElement txt_Password=driver.findElement(By.name("passwd"));
		txt_Password.sendKeys("123456");
		
		Select drp_Months=new Select(driver.findElement(By.id("months")));
		drp_Months.selectByValue("4");
		
		
	    WebElement btn_Register=driver.findElement(By.xpath("//*[text()='Register']"));
	    
	    btn_Register.click();
	    
	    Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication",driver.getCurrentUrl());
	}
	
	@AfterMethod()
	public void CapturarPantalla() throws IOException{
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File ("..\\EducaITPro\\Evidencias\\pantalla_"+System.currentTimeMillis()+".png"));	
	}
	
   @AfterClass
   public void finPrueba() {
	   
	   System.out.println("Fin de Prueba");
	   
   }

   @AfterTest
   public void cierreNavegador() {
	   
	   driver.close();
   }
   
   
   @AfterSuite
   public void finSuite() {
	  
	   System.out.println("Fin de Suite");
	   
   }	
}
