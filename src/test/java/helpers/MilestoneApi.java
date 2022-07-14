package helpers;

import configuration.EndpointsApi;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneApi {

    public MilestoneApi getMilestone(int milestoneID) {
        return given()
                .pathParams("milestone_id", milestoneID)
                .get(EndpointsApi.GET_MILESTONE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(MilestoneApi.class);
    }

    public MilestoneApi getMilestones(int projectID) {
        return given()
                .pathParams("project_id", projectID)
                .get(EndpointsApi.GET_MILESTONES)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(MilestoneApi.class);
    }

    public void addMilestone(int projectID) {

        given()
                .pathParams("project_id", projectID)
                .post(EndpointsApi.ADD_MILESTONE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(MilestoneApi.class);
    }
}




