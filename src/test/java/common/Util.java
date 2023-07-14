package common;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util {

    public static String readPropertyFile(String propFileName, String key) throws IOException {
        Properties p=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesFile\\"+propFileName);
        p.load(fis);
        return p.getProperty(key);


    }

    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }


}
