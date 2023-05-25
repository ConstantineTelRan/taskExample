package pages.demoqa.book_store.api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import pages.demoqa.book_store.api.factories.LoginViewModelFactory;
import pages.demoqa.book_store.api.model.LoginViewModelDto;
import pages.demoqa.book_store.api.model.RespGenerateToken;

public class ApiBase {
    protected Faker faker = new Faker();

    protected final String AUTHORIZED_END_POINT = "/Account/v1/Authorized";
    protected final String GENERATE_TOKEN_END_POINT = "/Account/v1/GenerateToken";

    final String BASE_URI = "https://demoqa.com/";
    final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFkbWluMjIiLCJwYXNzd29yZCI6IlF3ZXJ0eUAxMjM0NSIsImlhdCI6MTY4NDE0NTA3MH0.KVrfbbc_4ESM84pTNYTa5Fl7adKPWe1mRU55GX_-zJI";

    String apiKey;


    @BeforeMethod
    public void getToken() {
        LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
        LoginViewModelDto loginViewModelDto = loginViewModelFactory.getObjectWithAdmin();
        apiKey = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(loginViewModelDto)
                .when()
                .log().all()
                .post(GENERATE_TOKEN_END_POINT)
                .then().log().all()
                .extract().response().as(RespGenerateToken.class).getToken();
    }



    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
//            .addHeader("Access-Token", apiKey)
            .build();

    public Response doPostRequest(String endPoint, Integer responseCode, Object body) {
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", apiKey)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }


}
