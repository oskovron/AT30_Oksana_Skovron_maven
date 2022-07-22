package apitests;

import apiEngine.repositories.BookRepository;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateBookByIsbnTest {

    private String userId, initialIsbn, replaceIsbn;

    @BeforeClass
    public void init() {
        userId = "f10eeb4a-fe60-4630-aa40-24ac205c9dbb";
        initialIsbn = "9781449331818";
        replaceIsbn = "9781449365035";

    }

    @Test
    public void testUpdateBookByIsbn() {
        Response response = new BookRepository()
                .updateBookByIsbn(userId, initialIsbn, replaceIsbn, "osUser", "osUserPass@1")
                .getResponse();
        response.getStatusCode();

    }
}
