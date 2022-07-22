package apiEngine.provider;

import apiEngine.model.bookstore.requestmodels.AddBookToUserRequest;
import apiEngine.model.bookstore.requestmodels.ISBN;

import java.util.ArrayList;
import java.util.List;

public class AddBookToUserRequestProvider {

    public static AddBookToUserRequest getAddBookToUserRequest(String userId, String isbn) {
        ISBN isbn1 = ISBN.builder()
                .isbn(isbn)
                .build();

        List<ISBN> isbnList = new ArrayList<>();
        isbnList.add(isbn1);

        return AddBookToUserRequest.builder()
                .userId(userId)
                .collectionOfIsbns(isbnList)
                .build();
    }

}
