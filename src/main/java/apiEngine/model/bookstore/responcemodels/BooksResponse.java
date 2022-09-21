package apiEngine.model.bookstore.responcemodels;

import lombok.Data;

import java.util.List;

@Data
public class BooksResponse {
    private List<BookResponse> booksList;
}
