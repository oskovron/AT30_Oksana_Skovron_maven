package apiEngine.requests;

import apiEngine.client.ResponseWrapper;
import apiEngine.constants.Endpoints;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

public class BaseClient {
    protected RequestSpecification request;

    public BaseClient() {
        RestAssured.baseURI = Endpoints.BASE_URL_BOOKSTORE;
        request = RestAssured.given();
        request.log().all();
        request.header("Content-Type", "application/json");
    }

    public ResponseWrapper<Response> get(String parameter, String parameterValue, String endpoint) {
        Response response = request
                .queryParam(parameter, parameterValue)
                .get(endpoint);
        return new ResponseWrapper<>(response, Response.class);
    }

    public <T, F> ResponseWrapper<F> post(T payload, String endpoint, Class<F> responseClass) {
        Response response = request
                .body(payload)
                .post(endpoint);
        return new ResponseWrapper<>(response, responseClass);
    }

    /**
     * Credentials in format username:password
     */
    //todo: ad credentials separately
    public <T, F> ResponseWrapper<F> postWithBasicAuth(T payload, String credentials,
                                                       String endpoint, Class<F> responseClass) {
        request.header("Authorization", "Basic " + encodeBase64ToStringCredentials(credentials));
        return post(payload, endpoint, responseClass);
    }

    public <T, F> ResponseWrapper<F> postWithBearerAuth(T payload, GetTokenRequest tokenPayload,
                                                        String endpoint, Class<F> responseClass) {
        authorizeUserBearerAuth(tokenPayload);
        return post(payload, endpoint, responseClass);
    }

    public <T, F> ResponseWrapper<F> put(T payload, String endpoint, Class<F> responseClass) {
        Response response = request
                .body(payload)
                .put(endpoint);
        return new ResponseWrapper<>(response, responseClass);
    }

    /**
     * Credentials in format username:password
     */
    private String encodeBase64ToStringCredentials(String credentials) {
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    public void authorizeUserBearerAuth(GetTokenRequest tokenPayload) {
        String token = new TokenClient().getToken(tokenPayload);
        request.header("Authorization", "Bearer " + token);
    }

}
