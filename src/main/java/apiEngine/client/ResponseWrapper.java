package apiEngine.client;

import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

public class ResponseWrapper<T> {
    private final Response response;
    private final Class<T> responseClass;

    public ResponseWrapper(Response response, Class<T> responseClass) {
        this.response = response;
        this.responseClass = responseClass;
        this.response.prettyPrint();
    }

    public Response getResponse() {
        return response;
    }

    public T readEntity() {
        return response
                .getBody()
                .as(responseClass);
    }

    public ResponseWrapper<T> expectingStatusCode( int statusCode) {
        MatcherAssert.assertThat("Response code differs", response.getStatusCode(), CoreMatchers.is(statusCode));
        return this;
    }
}
