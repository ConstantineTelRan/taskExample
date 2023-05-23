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
    private final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFkbWluMjIiLCJwYXNzd29yZCI6IlF3ZXJ0eUAxMjM0NSIsImlhdCI6MTY4NDg0MTYwNn0.L6jq9ZujMkTGW4vymke6rCo0BTkwpSZCZjKh3Na1l_A";
    protected final String  AUTHORIZED_END_POINT = "/Account/v1/Authorized";
    protected final String GENERATE_TOKEN_END_POINT = "/Account/v1/GenerateToken";

//    private String apiKey = getToken();

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

//    public String getToken(){
//        LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
//        LoginViewDto loginViewDto = loginViewModelFactory.getObject();
//        TokenViewModel tokenViewModel = given()
//                .body(loginViewDto)
//                .post(GENERATE_TOKEN_END_POINT)
//                .then().extract().response().as(TokenViewModel.class);
//
//        return tokenViewModel.getToken();
//    }



}
