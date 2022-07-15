package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.ProjectsPage;
import pages.SideMenuPage;

public class NavigationSteps extends BaseStep {
    public SideMenuPage sideMenuPage;

    public NavigationSteps(WebDriver driver) {
        super(driver);
        sideMenuPage = new SideMenuPage(driver);

    }
    public ProjectsPage navigateToProjectsPage(){
        projectsPage.openPageByUrl();
        return projectsPage;
    }
    public AddProjectPage navigateToAddNewProjectPage(){
        addProjectPage.openPageByUrl();
        return addProjectPage;
    }
}