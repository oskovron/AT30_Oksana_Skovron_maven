package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonFullStore {

    @JsonProperty("store")
    private StoreDTO storeDTO;

    @JsonProperty("expensive")
    private String expensive;

    public JsonFullStore(){}
    public JsonFullStore(StoreDTO storeDTO, String expensive) {
        this.storeDTO = storeDTO;
        this.expensive = expensive;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public String getExpensive() {
        return expensive;
    }

    public void setExpensive(String expensive) {
        this.expensive = expensive;
    }

    @Override
    public String toString() {
        return "JsonFullStore{" +
                "storeDTO=" + storeDTO +
                ", expensive='" + expensive + '\'' +
                '}';
    }
}
