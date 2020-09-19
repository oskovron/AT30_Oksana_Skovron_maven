package HWworkshop1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class LottoDTO {
    @JsonProperty("lottoId")
    private int lottoId;

    @JsonProperty("winning-numbers")
    private int[] winning_numbers;

    @JsonProperty("winners")
    private WinnersDTO winners;

    public LottoDTO(int lottoId, int[] winning_numbers, WinnersDTO winners) {
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

    public WinnersDTO getWinners() {
        return winners;
    }

    public void setWinners(WinnersDTO winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return "LottoDTO{" +
                "lottoId=" + lottoId +
                ", winning_numbers=" + Arrays.toString(winning_numbers) +
                ", winners=" + winners +
                '}';
    }
}
