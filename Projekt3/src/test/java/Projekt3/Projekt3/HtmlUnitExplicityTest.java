package Projekt3.Projekt3;

import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;

@ExtendWith(SeleniumExtension.class)
class HtmlUnitExplicityTest {

	private WebDriver driver;
    private WebDriverWait wait;
    WebElement element;

    public HtmlUnitExplicityTest() {
        this.driver = new HtmlUnitDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @BeforeEach
    public void setDefaultPage() {
    	driver.get("https://www.phptravels.net/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        driver.findElement(By.name("username")).sendKeys("karamba@wp.pl");
        driver.findElement(By.name("password")).sendKeys("Qwerty");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        driver.get("https://www.phptravels.net/flights");
    }
    @Test
    public void testMainPage()
    {
        wait.until(ExpectedConditions.titleIs("Flights List"));
        assertEquals("Flights List", driver.getTitle());
    }
    

}
