package Pruebas;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class CrossBrowserTest {
	
	WebDriver driver = null;
    String URL ="http://www.automationpractice.pl/index.php";
    String PATH = "..\\EducaITPro\\Drivers\\chromedriver.exe";
    String PATHF = "..\\EducaITPro\\Drivers\\geckodriver.exe";

    @BeforeMethod
    @Parameters("navegador")
    public void setUp(String navegador) {

    	if(navegador.equalsIgnoreCase("chrome")) {
    		
    		System.setProperty("webdriver.chrome.driver",PATH);
    		driver = new ChromeDriver();
    		
    	}
    	else {
    		
    		System.setProperty("webdriver.gecko.driver",PATHF);
    		driver = new FirefoxDriver();
    		
    	}
    	
    	driver.manage().window().maximize();
    	driver.get(URL);
    }
    
    @Test
    public void buscarPalabra() {

        WebElement txtBuscador=driver.findElement(By.cssSelector("input[placeholder='Search']"));

        txtBuscador.clear();

        txtBuscador.sendKeys("Blouse");

        txtBuscador.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void cierreNavegador() {

        driver.close();

    }

}
