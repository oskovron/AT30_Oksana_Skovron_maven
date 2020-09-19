package HWworkshop1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LottoFullDTO {
    @JsonProperty("lotto")
    private LottoDTO lotto;

    // TODO: What to do with this - line number?
    private int lineNumber;

    public LottoFullDTO(){}

    public LottoDTO getLotto() {
        return lotto;
    }

    public void setLotto(LottoDTO lotto) {
        this.lotto = lotto;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "LottoFullDTO{" +
                "lotto=" + lotto +
                '}';
    }
}
