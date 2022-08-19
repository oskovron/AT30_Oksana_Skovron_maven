package apiEngine.petstoreapi.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClientPetStore {
    protected RequestSpecification request;

    public BaseClientPetStore() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        request = RestAssured.given();
        request.log().all();
    }

    protected <T> Response post(T payload, String endpoint) {
        return request
                .body(payload)
                .post(endpoint);
    }

}
