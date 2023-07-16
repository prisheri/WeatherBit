@CurrentWeatherData
Feature: Regression suite get Current Weather Data for multiple places in the world

  #This scenario is for getting current weather data using latitude and longitude as inputs
  @CurrentWeather_Lat_Lon
  Scenario Outline: Get Current Weather Data for multiple places in the world based on Lat and Lon
    Given user wants current weather data for the place with latitude <Lat> and longitude <Lon>
    When user calls  current weather data API with get http request
    Then response of the API call is success with status code 200
    And count in response is 1
    And verify city name "<City>", country code "<CountryCode>"
    Examples:
      | Lat     | Lon     | City           | CountryCode |
      | 51.5072 | -0.1276 | London         | GB          |
      | 30.608  | -84.242 | Calvary        | US          |
      | 43.04   | -71.478 | South Hooksett | US          |

    #This scenario is for getting current weather data using postal code as input
  @CurrentWeather_PostalCode
  Scenario Outline: Get Current Weather Data for multiple places in the world based on PostCode
    Given user wants current weather data for the place for postal code "<PostCode>"
    When user calls  current weather data API with get http request
    Then response of the API call is success with status code 200
    And count in response is 1
    Examples:
      | PostCode |
      | 28546    |
      | 2550     |
      | 61835    |


