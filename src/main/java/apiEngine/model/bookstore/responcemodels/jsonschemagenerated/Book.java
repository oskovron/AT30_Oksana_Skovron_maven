
package apiEngine.model.bookstore.responcemodels.jsonschemagenerated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Book {

    private String isbn;
    private String title;
    @JsonProperty("subTitle")
    private String subTitle;
    private String author;
    private String publishDate;
    private String publisher;
    private Integer pages;
    private String description;
    private String website;
}
