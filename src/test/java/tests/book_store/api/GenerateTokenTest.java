package tests.book_store.api;

import io.restassured.response.Response;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.book_store.api.factory.LoginViewModelFactory;
import pages.demoqa.book_store.api.model.ExampleTokenDto;
import pages.demoqa.book_store.api.model.LoginViewDto;
import pages.demoqa.book_store.api.model.TokenViewDto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTokenTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    TokenViewDto tokenViewDto;
    Response response;

    Date date = DateUtils.addDays(new Date(), 7);
    Date dateTime = DateUtils.addHours(date, -6);

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    String expectedDate = formatter.format(dateTime);

    Date dateExample = DateUtils.addDays(new Date(), 7);
    String expectedExampleDate = formatter.format(dateExample);



    @Test
    public void generateTokenTest() {
        response = doPostRequest(loginViewDto, GENERATE_TOKEN_END_POINT, 200);
        tokenViewDto = response.as(TokenViewDto.class);
        Assert.assertNotNull(tokenViewDto.getToken());
        Assert.assertTrue(tokenViewDto.getExpires().contains(expectedDate));
        Assert.assertEquals(tokenViewDto.getStatus(), "Success");
        Assert.assertEquals(tokenViewDto.getResult(), "User authorized successfully.");
    }

    @Test
    public void dateTest() {
        response = doPostRequest(loginViewDto, GENERATE_TOKEN_END_POINT, 200);
        ExampleTokenDto exampleTokenDto = response.as(ExampleTokenDto.class);
//        Assert.assertEquals(exampleTokenDto.getExpires(), date);
        Assert.assertEquals(formatter.format(exampleTokenDto.getExpires()), expectedExampleDate);
    }

}
