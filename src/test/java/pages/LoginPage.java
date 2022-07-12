package pages;


import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By logInButtonLocator = By.id("button_primary");
    private By errorTextLocator = By.className("error-text");

    public LoginPage(WebDriver driver) {super(driver);}

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    public WebElement getEmailInput(){return driver.findElement(emailInputLocator);}
    public WebElement getPswInput(){
        return driver.findElement(pswInputLocator);
    }
    public WebElement getLogInButton(){
        return driver.findElement(logInButtonLocator);
    }
    public WebElement getErrorTextElement(){return driver.findElement(errorTextLocator);}
}