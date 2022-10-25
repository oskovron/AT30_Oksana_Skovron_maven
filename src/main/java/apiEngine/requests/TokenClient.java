package apiEngine.requests;

import apiEngine.client.Configuration;
import apiEngine.client.ResponseWrapper;
import apiEngine.constants.EndpointsBookstore;
import apiEngine.constants.Routes;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import apiEngine.model.bookstore.responcemodels.TokenResponse;

public class TokenClient extends BaseClient {
    private final String GENERATE_TOKEN = Routes.getGenerateToken();

    @Override
    protected Configuration defaultConfiguration() {
        return new Configuration(EndpointsBookstore.BASE_URL_BOOKSTORE, "application/json");
    }

    private ResponseWrapper<TokenResponse> authenticateUser(GetTokenRequest payload) {
        ResponseWrapper<TokenResponse> response = post(payload, GENERATE_TOKEN, TokenResponse.class);
        String token = response.readEntity().getToken();
        requestSpecification.header("Authorization", "Bearer " +token);
        return response;
    }

    public String getTokenn(GetTokenRequest payload) {
        String token = authenticateUser(payload)
                .readEntity()
                .getToken();
        return token;
    }
}
