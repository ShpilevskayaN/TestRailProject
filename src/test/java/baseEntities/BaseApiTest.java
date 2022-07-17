package baseEntities;


import configuration.ReadProperties;
import helper.ProjectHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    public ProjectHelper projectHelper;



    @BeforeClass
    public void setupEnv() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectHelper= new ProjectHelper();



    }

}
