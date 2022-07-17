package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewProjectAddPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";
    public NewProjectAddPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return successMessageLocator;
    }
    private By successMessageLocator = By.xpath("//*[@class='message message-success']");

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getSuccessMessage(){return waitsService.waitForPresenceOfElement(successMessageLocator);}
}
