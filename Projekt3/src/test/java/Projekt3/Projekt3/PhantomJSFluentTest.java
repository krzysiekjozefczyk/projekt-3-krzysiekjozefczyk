package Projekt3.Projekt3;


import io.github.bonigarcia.SeleniumExtension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@ExtendWith(SeleniumExtension.class)
class PhantomJSFluentTest {
	
	private PhantomJSDriver driver;
	private Wait wait;
	WebElement element;
	
	public PhantomJSFluentTest(PhantomJSDriver driver) {
        this.driver = driver;
        wait = new FluentWait(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class);
    }
	
	  @BeforeEach
	    public void setDefaultPage() {
	        driver.get("https://www.phptravels.net/login");
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
	        driver.findElement(By.name("username")).sendKeys("karamba@wp.pl");
	        driver.findElement(By.name("password")).sendKeys("Qwerty");
	        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
	        driver.get("https://www.phptravels.net/hotels");
	    }

	  @Test
	    public void testMainPage()
	    {
	        wait.until(ExpectedConditions.titleIs("Search Results"));
	        assertEquals("Search Results", driver.getTitle());
	    }
	  
	  @Test
	  public void testSearchEngine() {
		  driver.findElement(By.cssSelector(".dpd1")).sendKeys("04/07/2018");
		  driver.findElement(By.cssSelector(".dpd2")).sendKeys("04/07/2018");
		  driver.findElement(By.cssSelector("button.btn-lg:nth-child(3)")).click();
		  
		  String element1 = driver.findElement(By.xpath("/html/body/div[4]/div[5]/div[1]/div[3]/div/div/h2")).getText();
		  
		  assertEquals("No Results Found", element1);
		  
	  }
	  

}
