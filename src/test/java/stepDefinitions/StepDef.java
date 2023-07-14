package stepDefinitions;

import common.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDef {

    private String baseURL;
    private String apiKey;
    private RequestSpecification reqSpec;
    RequestSpecification reqGiven;
    Response response;


    @Given("user wants current weather data for the place with latitude {double} and longitude {double}")
    public void user_wants_current_weather_data_for_the_place_with_latitude_and_longitude(Double lat, Double lon) throws IOException {
        baseURL= Util.readPropertyFile("api.properties","baseURL");
        apiKey= Util.readPropertyFile("api.properties","APIKey");

         reqSpec=new RequestSpecBuilder().setBaseUri(baseURL)
                 .addQueryParam("lat",lat)
                 .addQueryParam("lon",lon)
                 .addQueryParam("key",apiKey)
                 .build();

         reqGiven=given().log().all().spec(reqSpec);


    }

    @Given("user wants current weather data for the place for postal code {string}")
    public void user_wants_current_weather_data_for_the_place_for_postal_code(String postalCode) throws IOException {

        baseURL= Util.readPropertyFile("api.properties","baseURL");
        apiKey= Util.readPropertyFile("api.properties","APIKey");

        reqSpec=new RequestSpecBuilder().setBaseUri(baseURL)
                .addQueryParam("postal_code",postalCode)
                .addQueryParam("key",apiKey)
                .build();

        reqGiven=given().log().all().spec(reqSpec);

    }
    @When("user calls  current weather data API with get http request")
    public void user_calls_current_weather_data_api_with_get_http_request() {
        response =reqGiven.when().get("/current").then().log().all().extract().response();


    }
    @Then("response of the API call is success with status code {int}")
    public void response_of_the_api_call_is_success_with_status_code(Integer responseCode) {
        assertEquals(response.getStatusCode(),200);
    }
    @Then("{string} in response is {int}")
    public void in_response_is(String attribute, int value) {
        System.out.println(" count is "+Util.getJsonPath(response,attribute));
        int val=Integer.parseInt(Util.getJsonPath(response,attribute));
        assertEquals(val,value);

    }

}
