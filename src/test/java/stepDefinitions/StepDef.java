package stepDefinitions;

import common.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responsePOJO.WeatherData;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDef {

    private String baseURL;
    private String apiKey;
    private RequestSpecification reqSpec;
    private RequestSpecification reqGiven;
    private Response response;
    private WeatherData wd;


    @Given("user wants current weather data for the place with latitude {double} and longitude {double}")
    public void user_wants_current_weather_data_for_the_place_with_latitude_and_longitude(Double lat, Double lon) throws IOException {
        // fetch base URL and API key from api.properties file under resources folder
        baseURL = Util.readPropertyFile("api.properties", "baseURL");
        apiKey = Util.readPropertyFile("api.properties", "APIKey");


        //used requestSpecification builder class to reuse specifications like baseURL, query params, headers,cookies etc.
        reqSpec = new RequestSpecBuilder().setBaseUri(baseURL)
                .addQueryParam("lat", lat)
                .addQueryParam("lon", lon)
                .addQueryParam("key", apiKey)
                .build();

        reqGiven = given().log().all().spec(reqSpec);


    }

    @Given("user wants current weather data for the place for postal code {string}")
    public void user_wants_current_weather_data_for_the_place_for_postal_code(String postalCode) throws IOException {
        // fetch base URL and API key from api.properties file under resources folder
        baseURL = Util.readPropertyFile("api.properties", "baseURL");
        apiKey = Util.readPropertyFile("api.properties", "APIKey");

        //used requestSpecification builder class to reuse specifications like baseURL, query params, headers,cookies etc.
        reqSpec = new RequestSpecBuilder().setBaseUri(baseURL)
                .addQueryParam("postal_code", postalCode)
                .addQueryParam("key", apiKey)
                .build();

        reqGiven = given().log().all().spec(reqSpec);

    }

    @When("user calls  current weather data API with get http request")
    public void user_calls_current_weather_data_api_with_get_http_request() {

        //making GET http request using RequestSpecification object and capturing response in Response class object
        response = reqGiven.expect().defaultParser(Parser.JSON)
                .when()
                .get("/current")
                .then().log().all()
                .extract().response();
        //using POJO class to store the data from response
        wd = response.as(WeatherData.class);

    }

    @Then("response of the API call is success with status code {int}")
    public void response_of_the_api_call_is_success_with_status_code(int responseCode) {

        //making assertion for a successful get response for given status code
        assertEquals("Status code verification", response.getStatusCode(), responseCode);

    }

    @Then("count in response is {int}")
    public void count_in_response_is(int value) {

        //making assertion that "count" attribute in response should be equal to the expected value
        assertEquals("Count verification", wd.getCount(), value);

    }

    @Then("verify city name {string}, country code {string}")
    public void verify_city_name_country_code(String city, String cc) {

        //making assertion that "city name" and country code attribute in response should be equal to the expected values
        assertEquals("City name verification", city, wd.getData().get(0).getCity_name());
        assertEquals("Country Code verification", cc, wd.getData().get(0).getCountry_code());


    }


}
