package Projekt3.Projekt3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class SignUpForm {

	private final Wait<WebDriver> wait;
	
	@FindBy(name = "firstname")
	private WebElement Firstname;

	@FindBy(name = "lastname")
	private WebElement Lastname;

	@FindBy(name  = "email")
	private WebElement Email;
	
	@FindBy(name  = "password")
	private WebElement Password;
	
	@FindBy(name  = "confirmpassword")
	private WebElement Confirmpassword;
	
	@FindBy(xpath  = "/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")
	private WebElement Button;

	public SignUpForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,4);
	}

	public void SignUp(String firstname, String lastname, String email, String password, String confirmpassword) {
		//wait.until(ExpectedConditions.titleContains("Register"));
		Firstname.sendKeys(firstname);
		Lastname.sendKeys(lastname);
		Email.sendKeys(email);
		Password.sendKeys(password);
		Confirmpassword.sendKeys(confirmpassword);
		Button.click();
		
	}

}
