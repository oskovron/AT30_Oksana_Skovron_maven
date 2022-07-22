package apiEngine.model.bookstore.requestmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserIdIsbnRequest {
    private String userId;
    private String isbn;
}
