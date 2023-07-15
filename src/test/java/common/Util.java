package common;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {

    //reusable method to read any properties file.
    public static String readPropertyFile(String propFileName, String key) throws IOException {
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\propertiesFile\\" + propFileName);
        p.load(fis);
        return p.getProperty(key); //return the value of key from .properties file
    }

    //reusable method to read Json response and extract value for an attribute
    public static String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }


}
