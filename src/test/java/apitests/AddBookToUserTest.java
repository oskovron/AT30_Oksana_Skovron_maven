package apitests;

import apiEngine.client.ResponseWrapper;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import apiEngine.model.bookstore.responcemodels.BookErrorResponse;
import apiEngine.provider.AddBookToUserRequestProvider;
import apiEngine.provider.GetTokenRequestProvider;
import apiEngine.repositories.BookRepository;
import io.restassured.response.Response;
import apiEngine.model.bookstore.requestmodels.AddBookToUserRequest;
import apiEngine.model.bookstore.requestmodels.ISBN;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import apiEngine.requests.BooksClient;

public class AddBookToUserTest {
    private String credentials, userId, isbn;
    AddBookToUserRequest addBookToUserRequest;
    GetTokenRequest getTokenRequest;

    @BeforeMethod
    public void init() {
        credentials = "osUser:osUserPass@1";
        userId = "f10eeb4a-fe60-4630-aa40-24ac205c9dbb";
        isbn = "9781449331818";

//        addBookToUserRequest = AddBookToUserRequestProvider.getAddBookToUserRequest(userId, isbn);
//        getTokenRequest = GetTokenRequestProvider.getTokenRequest("osUser", "osUserPass@1");
    }

    @Test
    public void testAddBookToUser() {
//        String credentialsEncodedToBase64 = Base64.getEncoder().encodeToString(credentials.getBytes());

////        Response response = new BaseClient().postWithBasicAuth(payloadModel, credentials, Routes.books());
//        Response response = new BooksClient().addBookToUser(payloadModel, credentials);
//        System.out.println(response.getStatusCode());
//        response.prettyPrint();
        System.out.println("*************");
//        BooksClient booksClient = new BooksClient();
//        Response response1 = booksClient.addBookToUserBearerAuth(addBookToUserRequest, getTokenRequest);

        ResponseWrapper<Response> response1 = new BookRepository()
                .addBookToUserBearerAuth(userId, isbn, "osUser", "osUserPass@1");
        Response responseBook = response1.getResponse();
        responseBook.prettyPrint();
        Object o = responseBook.getBody().jsonPath().get("");
        System.out.println(o);
        BookErrorResponse bookErrorResponse = responseBook.as(BookErrorResponse.class);
        String errorResponseMessage = bookErrorResponse.getMessage();
    }

}
