package HWworkshop1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class WinnersDTO {
    @JsonProperty("winnerId")
    private int winnerId;
    @JsonProperty("numbers")
    private int[] numbers;

    public WinnersDTO(int winnerId, int[] numbers) {
        this.winnerId = winnerId;
        this.numbers = numbers;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }


    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "WinnersDTO{" +
                "winnerId=" + winnerId +
                ", numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
