package Projekt3.Projekt3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;


class SignUpTest {
	
	private static WebDriver driver;
	WebElement element;

	@BeforeAll
	public static void driverSetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void SignUpButton() {
		driver.get("https://www.phptravels.net/register");
		element = driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button"));
		assertNotNull(element);
	}
	
	
	@Test
	public void SignUpCorrect() {
		driver.get("https://www.phptravels.net/register");
		SignUpForm signup = new SignUpForm(driver);
		signup.SignUp("Marcin","Mycha","siemaeloo@wp.pl", "Qwerty","Qwerty");
		
		element = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a"));
		
		assertNotNull(element);	

		element.click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")).click();
	}
	
	@Test
	public void SignUpIncorrect() {
		driver.get("https://www.phptravels.net/register");
		SignUpForm signup = new SignUpForm(driver);
		signup.SignUp("Marcin","Mycha","siemaeloos@wp.pl", "Qwerty","Qwertyy");
		
		String element1 = driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[2]/div/p")).getText();
		
		assertEquals(element1,"Password not matching with confirm password.");	

	}
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
