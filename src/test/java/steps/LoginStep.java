package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }
    public DashboardPage successLogin(String email, String psw){
        login(email, psw);
        return dashboardPage;
    }

    public LoginPage incorrectLogin(String email, String psw){
        login(email, psw);
        return loginPage;
    }

    public void login(String email, String psw){
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage boundaries251() {
        String random251 = RandomStringUtils.randomAlphabetic(251);
        login(random251, ReadProperties.password());

        return loginPage;



    }


    public LoginPage boundaries250() {
        String random250 = RandomStringUtils.randomAlphabetic(250);
        login(ReadProperties.username(), random250);
        return loginPage;
    }

    public LoginPage boundaries249() {
        String random249= RandomStringUtils.randomAlphabetic(249);
        login(random249, ReadProperties.password());
        return loginPage;
    }

    public LoginPage logout(){
        return loginPage;
    }
}