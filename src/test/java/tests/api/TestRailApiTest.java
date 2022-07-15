package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import configuration.Endpoints;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TestRailApiTest extends BaseApiTest {


    @Test
    public void getAllProjectsTest(){
        // Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
        // Setup Response Object
        Response response = httpRequest.request(Method.GET, Endpoints.GET_PROJECTS);
        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }
    @Test
    public void getAllProjectsShortTest(){
        given()
                // .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                // .auth().preemptive().basic(ReadProperties.username(),ReadProperties.password())
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void addNewProjectApiTest(){
        Project newProject = Project.builder()
                .name("GOmetamazingProjectAAAAAuuu")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProject.getName()))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void addProjectApiTest() {
        Project project = Project.builder()
                .name("ProJoJo")
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void addProjectApiTest1() {
        Project project = Project.builder()
                .name("PRoJecTune")
                .typeOfProject(ProjectType.MULTIPLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        Project newProject = given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);
        System.out.println(newProject.toString());
    }
    @Test
    public void validateNameOfProjectsTest(){
        given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("projects.get(0).id", is(1))
                .body("projects.get(0).name", equalTo("WP Test"));
        //.extract()
        // .jsonPath("$.projects[0].id")
    }
    @Test
    public void validateNameOfProjectsWithJsonPathTest(){
        JsonPath jsonPath = given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath();
        String name = jsonPath.getString("projects[0].name");
        System.out.println(name);
        int id = jsonPath.getInt("projects[0].id");
        System.out.println(id);
        Assert.assertEquals(name, "WP Test");
        Assert.assertEquals(id, 1);
    }
    @Test
    public void getExactProject(){
        given()
                .pathParam("project_id", 1)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id",is(1))
                .body("name", equalTo("WP Test"));
    }
    @Test
    public void getExactProjectAsObjectTest(){
        Response response = given()
                .pathParam("project_id", 1)
                .get(Endpoints.GET_PROJECT);

        Project actualProject = new Gson().fromJson(response.getBody().asString(), Project.class);
        Assert.assertEquals(actualProject.getName(), "WP Test");


    }



}