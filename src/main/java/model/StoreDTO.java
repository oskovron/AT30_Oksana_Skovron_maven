package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class StoreDTO {

private List<BookDTO> book;
private BicycleDTO bicycle;


    public StoreDTO(@JsonProperty("book") List<BookDTO> book,
                    @JsonProperty("bicycle") BicycleDTO bicycle) {
        this.book = book;
        this.bicycle = bicycle;
    }


    public List<BookDTO> getBook() {
        return book;
    }

    public void setBook(List<BookDTO> book ) {
        this.book = book;
    }

    public BicycleDTO getBicycle() {
        return bicycle;
    }

    public void setBicycle(BicycleDTO bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String toString() {
        return "Store{" +
                "book=" + book +
                ", bicycle=" + bicycle +
                '}';
    }
}
