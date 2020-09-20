package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonFullStore {

    @JsonProperty("store")
    private StoreDTO storeDTO;

    @JsonProperty("expensive")
    private String expensive;

    //Empty constructor required!
    public JsonFullStore(){}

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO store) {
        this.storeDTO = store;
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
