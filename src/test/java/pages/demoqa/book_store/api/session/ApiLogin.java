package pages.demoqa.book_store.api.session;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import tests.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiLogin extends TestBase{
    static final String baseUrl = "https://demoqa.com";
    final String login = "admin22";
    final String userID = "df43d6f7-6235-48eb-8630-5cf293931ad2";
    final String pass = "Qwerty@12345";

    final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFkbWluMjIiLCJwYXNzd29yZCI6IlF3ZXJ0eUAxMjM0NSIsImlhdCI6MTY4Mzk5NDgwNn0.b73WfHq9YyYgF6DxK2UOTbrGEC_FY5oIlIrT0-P4RJk";


    public Map<String, String> getSession(){
//        RestAssured.baseURI = baseUrl;
        String body = "{\n" +
                "  \"userName\": \"admin22\",\n" +
                "  \"password\": \"Qwerty@12345\"\n" +
                "}";
        Response response = given().contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(body)
                .when().log().all()
                .post("/Account/v1/GenerateToken").then().statusCode(200).log().all().extract().response();

        String token = response.jsonPath().get("token");
        String expires = response.jsonPath().get("expires");
        Map<String, String> cook = new HashMap<>();
        cook.put("token", token);
        cook.put("expires", expires);
        cook.put("userID", userID);
        cook.put("userName", login);


        given().contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(body)
                .when().log().all()
                .post("/Account/v1/Login").then().statusCode(200).log().all().extract().response();

        Response response1 = given().contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + cook.get("token"))
                .cookie("token=" + cook.get("token") + "; expires=" + cook.get("expires") + "; userID=" + cook.get("userID") + "; userName=" + cook.get("userName"))
                .when().log().all()
                .get("/Account/v1/User/df43d6f7-6235-48eb-8630-5cf293931ad2")
                .then().statusCode(200).log().all().extract().response();




        return cook;

    }


//    public void cookieLogin() {
//        Map<String, String> cook = getSession();
//        driver.manage().addCookie(new Cookie("token", cook.get("token")));
//        driver.manage().addCookie(new Cookie("expires", cook.get("expires")));
//        driver.manage().addCookie(new Cookie("userID", cook.get("userID")));
//        driver.manage().addCookie(new Cookie("userName", cook.get("userName")));
//        driver.get("https://demoqa.com/books");
//    }

}
