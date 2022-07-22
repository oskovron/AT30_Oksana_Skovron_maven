package apiEngine.repositories;

import apiEngine.client.ResponseWrapper;
import apiEngine.model.bookstore.requestmodels.AddBookToUserRequest;
import apiEngine.model.bookstore.requestmodels.GetTokenRequest;
import apiEngine.model.bookstore.requestmodels.UserIdIsbnRequest;
import apiEngine.provider.AddBookToUserRequestProvider;
import apiEngine.provider.GetTokenRequestProvider;
import apiEngine.provider.UserIsbnRequestProvider;
import apiEngine.requests.BooksClient;
import io.restassured.response.Response;

public class BookRepository {
    private BooksClient booksClient;

    public BookRepository() {
        booksClient = new BooksClient();
    }

    public ResponseWrapper<Response> addBookToUserBearerAuth(String userId, String isbn, String userName, String password) {
        AddBookToUserRequest addBookToUserRequest = AddBookToUserRequestProvider.getAddBookToUserRequest(userId, isbn);
        GetTokenRequest tokenRequest = GetTokenRequestProvider.getTokenRequest(userName, password);
        return booksClient.addBookToUserBearerAuth(addBookToUserRequest, tokenRequest);
    }

    public ResponseWrapper<Response> updateBookByIsbn(String userId, String initialIsbn, String replaceIsbn,
                                                      String userName, String password) {
        UserIdIsbnRequest userIdAndIsbnRequest = UserIsbnRequestProvider.getUserIdAndIsbn(userId, replaceIsbn);
        GetTokenRequest tokenRequest = GetTokenRequestProvider.getTokenRequest(userName, password);
        return booksClient.updateBookByIsbn(userIdAndIsbnRequest, initialIsbn, tokenRequest);
    }

}
