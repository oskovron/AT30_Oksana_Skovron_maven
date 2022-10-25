package apiEngine.requests;

import apiEngine.client.Configuration;
import apiEngine.client.ResponseWrapper;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

public abstract class BaseClient {
    protected RequestSpecification requestSpecification;

    protected Configuration configuration;

    protected abstract Configuration defaultConfiguration();

    public BaseClient() {
        getBookstoreApiClient();
    }

    private void getBookstoreApiClient() {
//        RestAssured.baseURI = BASE_URL_BOOKSTORE;
        configuration = defaultConfiguration();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(configuration.getServicePath())
                .setContentType(configuration.getContentType())
                .build();
        requestSpecification = RestAssured.given().spec(requestSpecification);
        requestSpecification.log().all();
//        requestSpecification.header("Content-Type", "application/json");
    }

    public ResponseWrapper<Response> get(String parameter, String parameterValue, String endpoint) {
        Response response = requestSpecification
                .queryParam(parameter, parameterValue)
                .get(endpoint);
        return new ResponseWrapper<>(response, Response.class);
    }

    public <T, F> ResponseWrapper<F> post(T payload, String endpoint, Class<F> responseClass) {
        Response response = requestSpecification
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
        requestSpecification.header("Authorization", "Basic " + encodeBase64ToStringCredentials(credentials));
        return post(payload, endpoint, responseClass);
    }

    public <T, F> ResponseWrapper<F> postWithBearerAuth(T payload, GetTokenRequest tokenPayload,
                                                        String endpoint, Class<F> responseClass) {
        authorizeUserBearerAuth(tokenPayload);
        return post(payload, endpoint, responseClass);
    }

    public <T, F> ResponseWrapper<F> put(T payload, String endpoint, Class<F> responseClass) {
        Response response = requestSpecification
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
        String token = new TokenClient().getTokenn(tokenPayload);
        requestSpecification.header("Authorization", "Bearer " + token);
    }

}
