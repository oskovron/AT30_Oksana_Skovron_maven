package HW3workshop1.tryIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LottoFullDTO {

    @JsonProperty("lotto")
    private LottoDTO lotto;

    public LottoFullDTO(){}

    public LottoDTO getLotto() {
        return lotto;
    }

    public void setLotto(LottoDTO lotto) {
        this.lotto = lotto;
    }

    @Override
    public String toString() {
        return "LottoFullDTO{" +
                "lotto=" + lotto +
                '}';
    }
}
