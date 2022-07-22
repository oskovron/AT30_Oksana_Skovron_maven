package apiEngine.provider;

import apiEngine.model.bookstore.requestmodels.GetTokenRequest;

public class GetTokenRequestProvider {

    public static GetTokenRequest getTokenRequest(String userName, String password) {
        return GetTokenRequest.builder()
                .userName(userName)
                .password(password)
                .build();
    }
}
