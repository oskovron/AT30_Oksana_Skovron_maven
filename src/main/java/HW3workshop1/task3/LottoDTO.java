package HW3workshop1.task3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LottoDTO {
    @JsonProperty("lottoId")
    private int lottoId;

    @JsonProperty("winning-numbers")
    private int[] winning_numbers;

    @JsonProperty("winners")
    private List<WinnersDTO> winners;

    public LottoDTO(){}
    public LottoDTO(int lottoId, int[] winning_numbers, List<WinnersDTO> winners) {
        this.lottoId = lottoId;
        this.winning_numbers = winning_numbers;
        this.winners = winners;
    }

    public int getLottoId() {
        return lottoId;
    }

    public void setLottoId(int lottoId) {
        this.lottoId = lottoId;
    }

    public int[] getWinning_numbers() {
        return winning_numbers;
    }

    public void setWinning_numbers(int[] winning_numbers) {
        this.winning_numbers = winning_numbers;
    }

    public List<WinnersDTO> getWinners() {
        return winners;
    }

    public void setWinners(List<WinnersDTO> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoId=" + lottoId +
                ", winning_numbers=" + Arrays.toString(winning_numbers) +
                ", winners=" + winners +
                '}';
    }
}
