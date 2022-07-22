package apiEngine.model.bookstore.requestmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBookToUserRequest {
    public String userId;
    public List<ISBN> collectionOfIsbns;

//        public AddBookToUserRequest(String userId, ISBN isbn) {
//        this.userId = userId;
//        this.collectionOfIsbns = new ArrayList<>();
//        collectionOfIsbns.add(isbn);
//    }
}
