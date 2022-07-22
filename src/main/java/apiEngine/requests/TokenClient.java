package apiEngine.requests;

import apiEngine.client.ResponseWrapper;
import apiEngine.constants.Routes;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import apiEngine.model.bookstore.responcemodels.TokenResponse;

public class TokenClient extends BaseClient {
    private final String GENERATE_TOKEN = Routes.getGenerateToken();

    public ResponseWrapper<TokenResponse> authenticateUser(GetTokenRequest payload) {
        ResponseWrapper<TokenResponse> response = post(payload, GENERATE_TOKEN, TokenResponse.class);
        String token = response.readEntity().getToken();
        request.header("Authorization", "Bearer " +token);
        return response;
    }

    public String getToken(GetTokenRequest payload) {
        String token = authenticateUser(payload)
                .readEntity()
                .getToken();
        return token;
    }
}
