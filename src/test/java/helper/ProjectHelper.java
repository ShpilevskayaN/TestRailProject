package helper;


import configuration.Endpoints;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectHelper {


    public int addProject(Map jsonMap,int httpStatus) {

        JsonPath jsonPath = given()
                .body(jsonMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body()
                .extract()
                .jsonPath();

        return jsonPath.getInt("id");

    }

    public void getProject(int projectID,int httpStatus) {
        given()
                .pathParam("project_id", projectID)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(httpStatus)
                .log().body();

    }

    public void getProjects() {
        given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }


    public String getProjectName(int projectId) {

        JsonPath jsonPath = given()
                .pathParams("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().status()
                .log().body()
                .extract()
                .jsonPath();

        return jsonPath.getString("name");
    }



    public void deleteProject(int projectId,int httpStatus) {

        given()
                .when()
                .pathParams("project_id", projectId)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(httpStatus)
                .log().body();
    }
}