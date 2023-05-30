package tests.book_store.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.book_store.api.factory.LoginViewModelFactory;
import pages.demoqa.book_store.api.model.LoginViewDto;

public class AuthorizedTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    Response response;

    @Test
    public void authorizedTest() {
        response = doPostRequest(loginViewDto, AUTHORIZED_END_POINT, 200);
        Assert.assertTrue(response.asString().contains("true"));
    }


}
