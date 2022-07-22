package apiEngine.model.bookstore.responcemodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {
    private String token;

    public String getToken() {
        return token;
    }
}
