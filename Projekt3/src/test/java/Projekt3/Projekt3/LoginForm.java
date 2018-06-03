package Projekt3.Projekt3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {
	private final Wait<WebDriver> wait;
	
	@FindBy(name = "username")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"loginfrm\"]/div[1]/div[5]/button")
	private WebElement button;

	public LoginForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,5);
	}

	public void login(String email, String password) {
		wait.until(ExpectedConditions.titleContains("Login"));
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		button.click();
		
	}

}
