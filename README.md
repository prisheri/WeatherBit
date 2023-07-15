# WeatherBit
I have created this repo for Qantas Loyalty QA challenge

Used tools and framework:
1. RestAssured - Java library to test RESTful APIs
2. Cucumber - testing tool that supports Behavior Driven Development
3. Maven - a project management tool that is based on POM (project object model). It is used for project build, dependency, and documentation.
4. JUnit - a unit testing framework for Java programming language

Main features:
1. BDD framework to test REST APIs. BDD is a software development methodology that emphasizes collaboration and communication among developers, testers, and business stakeholders. BDD testing is a testing framework that uses natural language to describe the behavior of an application, focusing on its functional requirements and business goals.
2. Feature files store high-level description of scenarios and steps in gherkin(given,when,then) language. Feature file is as entry point to Cucumber tests.
3. Used Scenario Outline to run same scenario multiple times with different value. This supports Data Driven testing. To test with more data just add values in Examples section of each scenario in the feature file.
4. REST-Assured is a Java API is to test REST webservices. 
5. All classes and methods are implemented in Java with Maven repository to include all dependencies needed.
6. Used https://github.com/damianszczepanik/maven-cucumber-reporting lpugin to generate HTML reports. The HTML reports are very descriptive with good statistics.
7. Each scenario is tagged to run sepecific scenario or even complete feature file

Demo:
1. Software Requirement to run this project:
    
   a. JRE
   
   b. Maven
2. Download this project and in command line execute:
   
   a. "mvn test verify -Dcucumber.filter.tags="@CurrentWeatherData"  - to run entire feature file containing all the scenarios to get current weather data
   
   b. "mvn test verify -Dcucumber.filter.tags="@CurrentWeather_Lat_Lon" - to run scenario to get weather data with latitude and longitude as inputs
   
   c. "mvn test verify -Dcucumber.filter.tags="@CurrentWeather_PostalCode" - to run scenario to get weather data with post code as input
   
