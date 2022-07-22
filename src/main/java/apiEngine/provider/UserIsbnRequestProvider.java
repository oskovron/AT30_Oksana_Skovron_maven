package apiEngine.provider;

import apiEngine.model.bookstore.requestmodels.UserIdIsbnRequest;

public class UserIsbnRequestProvider {
    public static UserIdIsbnRequest getUserIdAndIsbn(String userId, String isbn) {
        return UserIdIsbnRequest.builder()
                .userId(userId)
                .isbn(isbn)
                .build();
    }

}
