package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected DashboardPage dashboardPage;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected AddProjectPage addProjectPage;
    protected NewProjectAddedPage newProjectAddedPage;

    public BaseStep(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);;
        addProjectPage = new AddProjectPage(driver);
        newProjectAddedPage = new NewProjectAddedPage(driver);

    }

}
