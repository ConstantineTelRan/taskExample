package pages.demoqa.book_store.api.session;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class Session {
    @Getter
    Cookie restAssuredCookie;
    @Getter
    org.openqa.selenium.Cookie seleniumCoockie;

//    public RequestSpecification getRequestSpec() {
//        RequestSpecification req = given()
//                .contentType(ContentType.JSON)
//                .accept("application/json, text/plain, */*")
//                .header("Cookie", "JSESSIONID=" + restAssuredCookie.toString());
//        return req;
//    }


}
