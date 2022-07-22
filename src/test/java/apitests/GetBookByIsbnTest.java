package apitests;

import apiEngine.model.bookstore.responcemodels.BookResponse;
import apiEngine.requests.BooksClient;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBookByIsbnTest {

    private String isbn;

    @BeforeClass
    public void init() {
            isbn = "9781449331818";
    }

    @Test
    public void testGetBookByIsbn() {
        Response response = new BooksClient().getBookByIsbn(isbn)
                .getResponse();
//        response.prettyPrint();
        BookResponse bookResponse = response.getBody()
                .as(BookResponse.class);
        System.out.println(response.getStatusCode());
        System.out.println(bookResponse.getAuthor());


    }
}
