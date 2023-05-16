package tests.book_store.api;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiBase {
    protected Faker faker = new Faker();
    private final String BASE_URL = "https://demoqa.com";
    private final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFkbWluMjIiLCJwYXNzd29yZCI6IlF3ZXJ0eUAxMjM0NSIsImlhdCI6MTY4NDE0NTA3MH0.KVrfbbc_4ESM84pTNYTa5Fl7adKPWe1mRU55GX_-zJI";
    protected final String  AUTHORIZED_END_POINT = "/Account/v1/Authorized";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

    public Response doPostRequest(Object body, String endPoint, Integer statusCode) {
        Response resp = given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().statusCode(statusCode);
        return resp;
    }

}
