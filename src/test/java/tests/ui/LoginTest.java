package tests.ui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import core.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() {

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password())
                .getPageIdentifier()
                .shouldBe(Condition.exist);

    }

    @Test
    public void fakeEmailTest() {
        loginStep.improperLogin("Nata", ReadProperties.password())
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Test
    public void fakePassTest() {
        loginStep.improperLogin(ReadProperties.username(), "deathdeathdeath")
                .getErrorTextLocator()
                .shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

    @Test
    public void boundaryTest() {

        loginStep.boundaries251().getErrorTextLocator().shouldHave(text("Field Email/User is too long (250 characters at most)."));
        loginStep.boundaries250().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));
        loginStep.boundaries249().getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));

    }

}


