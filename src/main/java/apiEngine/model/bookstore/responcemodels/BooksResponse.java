package apiEngine.model.bookstore.responcemodels;

import lombok.Data;

import java.awt.print.Book;
import java.util.List;

@Data
public class BooksResponse {
    private List<Book> booksList;
}
