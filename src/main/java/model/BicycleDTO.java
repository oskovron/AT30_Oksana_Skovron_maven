package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BicycleDTO {

    private String color;
    private int price;

    public BicycleDTO(@JsonProperty("color") String color,
                      @JsonProperty("price") int price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BicycleDTO{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
