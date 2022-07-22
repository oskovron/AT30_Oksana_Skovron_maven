package apiEngine.requests;

import apiEngine.client.ResponseWrapper;
import apiEngine.constants.Routes;
import apiEngine.model.bookstore.requestmodels.AddBookToUserRequest;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import apiEngine.model.bookstore.requestmodels.UserIdIsbnRequest;
import io.restassured.response.Response;

public class BooksClient extends BaseClient {
    public final String BOOKS = Routes.books();
    public final String BOOK = Routes.book();

    public ResponseWrapper<Response> getBookByIsbn(String isbn) {
        return get("ISBN" , isbn, BOOK);
    }

    public ResponseWrapper<Response> addBookToUser(AddBookToUserRequest payload, String credentials) {
        return postWithBasicAuth(payload, credentials, BOOKS, Response.class);
    }

    public ResponseWrapper<Response> addBookToUserBearerAuth(AddBookToUserRequest bookPayload, GetTokenRequest tokenPayload) {
        return postWithBearerAuth(bookPayload, tokenPayload, BOOKS, Response.class);
    }

    public ResponseWrapper<Response> updateBookByIsbn(UserIdIsbnRequest payload, String initialIsbn,
                                                      GetTokenRequest tokenPayload) {
        authorizeUserBearerAuth(tokenPayload);
        return put(payload, BOOKS +"/"+ initialIsbn, Response.class);
    }
}
