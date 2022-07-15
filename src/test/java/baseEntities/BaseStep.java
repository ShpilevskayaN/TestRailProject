package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected AddProjectPage addProjectPage;
    protected DashboardPage dashboardPage;
    protected LoginPage loginPage;
    protected NewProjectAddedPage newProjectAddedPage;
    protected ProjectsPage projectsPage;


    public BaseStep(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        addProjectPage = new AddProjectPage(driver);
        newProjectAddedPage = new NewProjectAddedPage(driver);

    }

}
