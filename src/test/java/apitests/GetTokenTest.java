//package apitests;
//
//import apiEngine.provider.GetTokenRequestProvider;
//import io.restassured.response.Response;
//import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
//import apiEngine.model.bookstore.responcemodels.TokenResponse;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import apiEngine.requests.TokenClient;
//
//public class GetTokenTest {
//
//    @Test
//    public void testGetToken() {
////        String payload = "{\n" +
////                "  \"userName\": \"osUser\",\n" +
////                "  \"password\": \"osUserPass@1\"\n" +
////                "}";
//        GetTokenRequest getToketRequestBody = GetTokenRequestProvider.getTokenRequest("osUser", "osUserPass@1");
//
//        Response response = new TokenClient().authenticateUser(getToketRequestBody);
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 200);
//        response.prettyPrint();
//
//        //deserialization
//        TokenResponse tokenResponse = response.as(TokenResponse.class);
//        String token = tokenResponse.getToken();
//        System.out.println("Token is: " + token);
//
//        String token1 = new TokenClient().getToken(getToketRequestBody);
//    }
//}
