package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected AddMilestonePage addMilestonePage;
    protected DashboardPage dashboardPage;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected SideMenuPage sideMenuPage;
    protected TopMenuPage topMenuPage;


    public BaseStep(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        topMenuPage = new TopMenuPage(driver);



    }

}