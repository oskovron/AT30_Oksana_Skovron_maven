package apitests;

import apiEngine.petstoreapi.client.UploadImageClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadImageToPetTest {

    @Test
    public void testUploadImage() {
        String userId = "9223372036854063000";
        UploadImageClient uploadImageClient = new UploadImageClient();
        Response response = uploadImageClient.uploadImage(userId);
        response.prettyPrint();
        Assert.assertEquals(
                response.getStatusCode(),
                200);
    }
}
