package tests.api;


import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.Project;
import models.Suite;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



@Epic("Diploma API tests")

public class ApiTest extends BaseApiTest {
    public int projectId;
    public int suiteID;
    public String suiteName = "Test Name";

    //NFE test
    @Test(description = "NFE Add project test" ,groups = "main tests")
    public void addProjectNFETest() {
        System.out.println();
        Project project = Project.builder()
                .name("Test project")
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", project.getName());
        projectId = projectHelper.addProject(jsonMap, HttpStatus.SC_OK);

    }

    @Test(dependsOnMethods ="addProjectNFETest", description = "NFE Add Suite test",groups = "main tests")
    public void addSuite() {
        Suite suite = Suite.builder()
                .name(suiteName)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", suite.getName());

        suiteID = suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_OK);

    }

    @Test(dependsOnMethods ="addSuite", description = "NFE Get Suite test",groups = "main tests")
    public void getSuiteNFETest() {
        suiteHelper.getSuite(suiteID, HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods ="addSuite", description = "NFE Get Suites test",groups = "main tests")
    public void getSuitesNFETest() {
        suiteHelper.getSuites(projectId, HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods ="addSuite", description = "NFE Comparison actual suite name and adjusted suite name ",groups = "main tests")
    public void getSuiteName() {
        String actualSuiteName =   suiteHelper.getSuiteName(suiteID);
        Assert.assertEquals(actualSuiteName,suiteName);
    }

    //AEF tests
    @Test(dependsOnMethods ="addSuite", description = "AEF get project test",groups = "main tests")
    public void getSuiteAEFTest() {
        suiteHelper.getSuite(50, HttpStatus.SC_BAD_REQUEST);
    }

    @Test(dependsOnMethods ="addSuite", description = "AEF add project test ",groups = "main tests",expectedExceptions=NullPointerException.class)
    public void addSuiteAEFTest() {

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("incorrect field", "incorrect value");

        suiteHelper.addSuite(projectId, jsonMap, HttpStatus.SC_BAD_REQUEST);
    }

    @Test( description = "NFE Delete Suite test",dependsOnGroups ="main tests" )
    public void deleteSuite() {
        suiteHelper.deleteSuite(suiteID);
    }


    @Test( description = "NFE Delete Project test",dependsOnMethods ="deleteSuite")
    public void deleteProject() {
        projectHelper.deleteProject(projectId);
    }


}
