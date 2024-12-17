package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio6 {

	WebDriver driver = null;
    String URL ="http://www.automationpractice.pl/index.php";
    String PATH = "..\\EducaITPro\\Drivers\\chromedriver.exe";

    @BeforeMethod
    public void setUp() {

    		
		System.setProperty("webdriver.chrome.driver",PATH);
		
		ChromeOptions options = new ChromeOptions();
		
		//options.addArguments("--headless=old");
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
    	driver.get(URL);
    }
    
    @Test
    public void buscarPalabra() {

        WebElement txtBuscador=driver.findElement(By.id("search_query_top"));

        txtBuscador.clear();

        txtBuscador.sendKeys("Blouse");

        txtBuscador.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void cierreNavegador() {

        driver.close();

    }
	
}
