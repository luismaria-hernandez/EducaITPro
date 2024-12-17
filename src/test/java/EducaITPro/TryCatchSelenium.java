package EducaITPro;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//ESTE ES UN EJERCICIO QUE NO ESTÁ EN ALUMNI

public class TryCatchSelenium {
	@Test
	public void testSeleniumExample() {
		WebDriver driver = null;
		String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
        
		By searchqueryLocator=By.cssSelector("input[placeholder='Search']");
		
        try {

			System.setProperty("webdriver.chrome.driver", PATH);
			driver= new ChromeDriver();		
			driver.get(URL);
			driver.manage().window().maximize();

			WebElement txtBuscador=driver.findElement(searchqueryLocator);

			txtBuscador.clear();

			txtBuscador.sendKeys("Blouse");

			txtBuscador.sendKeys(Keys.ENTER);


		} catch (Exception e) {

			//e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {

			if (driver != null) {
				driver.quit();
			}
		}
	}
}
