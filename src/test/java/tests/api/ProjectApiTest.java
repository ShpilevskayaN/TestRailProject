package tests.api;

import baseEntities.BaseApiTest;
import configuration.EndpointsApi;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectApiTest extends BaseApiTest {

    @Test
    public void getProjectsApiTest() {
        given()
                .when()
                .get(EndpointsApi.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getProjectApiTest() {
        given()
                .when()

                .get(EndpointsApi.GET_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectApiTest() {
        given()
                .when()
                .get(EndpointsApi.ADD_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void updateProjectApiTest() {
        given()
                .when()
                .get(EndpointsApi.UPDATE_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deleteProjectApiTest() {
        given()
                .when()
                .get(EndpointsApi.DELETE_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
