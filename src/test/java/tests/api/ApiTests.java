package tests.api;


import baseEntities.BaseApiTest;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTests extends BaseApiTest {
    public int projectId;
    public String projectName="Test project";


    //NFE tests
    @Test(priority = 1)
    public void addProjectNFE() {

        Project project = Project.builder()
                .name(projectName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", project.getName());

        projectId = projectHelper.addProject(jsonMap,HttpStatus.SC_OK);

    }

    @Test(priority = 2)
    public void getProjectNFE() {
        projectHelper.getProject(projectId,HttpStatus.SC_OK);
    }

    @Test(priority = 3)
    public void getProjectsNFE() {
        projectHelper.getProjects();
    }

    @Test(priority = 4)
    public void getProjectNameNFE() {
        String actualProject = projectHelper.getProjectName(projectId);
        Assert.assertEquals(actualProject,projectName);

    }

    @Test(priority = 7)
    public void deleteProject(){
        projectHelper.deleteProject(projectId,HttpStatus.SC_OK);
    }


    //AEF tests

    @Test(priority = 5)
    public void getProjectAFE() {
        projectHelper.getProject(50,HttpStatus.SC_BAD_REQUEST);
    }
    @Test(priority = 7)
    public void deleteProjectAEF(){
        projectHelper.deleteProject(50,HttpStatus.SC_BAD_REQUEST);
    }


    @Test(priority = 6)
    public void getExactProjectAEF(){

    }


}
