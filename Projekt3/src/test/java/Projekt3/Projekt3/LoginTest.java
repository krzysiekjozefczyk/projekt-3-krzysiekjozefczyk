package Projekt3.Projekt3;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	private static WebDriver driver;
	WebElement element;
	private final Wait<WebDriver> wait =new WebDriverWait(driver,4);
	
	@BeforeAll
	public static void driverSetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginButton() {
		driver.get("https://www.phptravels.net/login");
		element = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/button"));
		assertNotNull(element);
	}

	@Test
	public void logInCorrect() {
		driver.get("https://www.phptravels.net/login");
		LoginForm login = new LoginForm(driver);
		login.login("karamba@wp.pl", "Qwerty");
		
		element = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a"));
		
		assertNotNull(element);	

		element.click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")).click();
	}
	
	@Test
	public void logInIncorrect() {
		driver.get("https://www.phptravels.net/login");
		LoginForm login = new LoginForm(driver);
		login.login("karamba@wp.pl", "Qwertys");
		
		String element1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/form/div[1]/div[2]/div")).getText();
		
		assertEquals(element1,"Invalid Email or Password");
		
	}

	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
