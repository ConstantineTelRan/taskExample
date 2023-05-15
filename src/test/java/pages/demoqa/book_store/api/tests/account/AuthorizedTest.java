package pages.demoqa.book_store.api.tests.account;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.book_store.api.factories.LoginViewModelFactory;
import pages.demoqa.book_store.api.model.LoginViewModelDto;
import pages.demoqa.book_store.api.tests.ApiBase;

public class AuthorizedTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewModelDto loginViewModelDto = loginViewModelFactory.getObjectWithAdmin();
    Response response;

    @Test
    public void authorizedTest() {
        response = doPostRequest(AUTHORIZED_END_POINT, 200, loginViewModelDto);
        Assert.assertTrue(response.asString().contains("true"));
    }
}
