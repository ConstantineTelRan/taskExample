package pages.demoqa.book_store.api.tests.account;

import io.restassured.response.Response;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.book_store.api.factories.LoginViewModelFactory;
import pages.demoqa.book_store.api.model.LoginViewModelDto;
import pages.demoqa.book_store.api.model.RespGenerateToken;
import pages.demoqa.book_store.api.tests.ApiBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTokenTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewModelDto loginViewModelDto = loginViewModelFactory.getObjectWithAdmin();
    RespGenerateToken respGenerateToken;
    Response response;
    Date curentDate =  DateUtils.addDays(new Date(), 7);;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String expectedDate = formatter.format(curentDate);

    @Test
    public void authorizedTest() {
        response = doPostRequest( GENERATE_TOKEN_END_POINT, 200, loginViewModelDto);
        respGenerateToken = response.as(RespGenerateToken.class);
        Assert.assertNotNull(respGenerateToken.getToken());
        Assert.assertEquals(formatter.format(respGenerateToken.getExpires()), expectedDate);
        Assert.assertEquals(respGenerateToken.getStatus(), "Success");
        Assert.assertEquals(respGenerateToken.getResult(), "User authorized successfully.");
    }
}
