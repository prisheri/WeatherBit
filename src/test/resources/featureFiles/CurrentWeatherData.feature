Feature: Regression suite get Current Weather Data for multiple places in the world

  Scenario Outline: Get Current Weather Data for multiple places in the world based on Lat and Lon
    Given user wants current weather data for the place with latitude <lat> and longitude <lon>
    When user calls  current weather data API with get http request
    Then response of the API call is success with status code 200
    And "count" in response is 1
    Examples:
      | lat     | lon     |
      | 51.5072 | -0.1276 |
      | 30.608  | -84.242 |
      | 43.04   | -71.478 |

  Scenario Outline: Get Current Weather Data for multiple places in the world based on PostCode
    Given user wants current weather data for the place for postal code "<PostCode>"
    When user calls  current weather data API with get http request
    Then response of the API call is success with status code 200
    And "count" in response is 1
    Examples:
      | PostCode |
      | 28546    |
      | 2550     |
      | 2413     |



