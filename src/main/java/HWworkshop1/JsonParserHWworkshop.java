package HWworkshop1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import model.JsonFullStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParserHWworkshop {
    //TODO: Add try catch
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/lotto.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        TypeFactory typeFactory = TypeFactory.defaultInstance();

//        List<JsonFullStore> storeDTOList = objectMapper.readValue(file,
//                typeFactory.constructCollectionType(HashMap.class,LottoFullDTO.class ));

//        storeDTOList.forEach(store -> System.out.println(store));
//
////        System.out.println(storeDTOList.get(0).getBicycle());
//        System.out.println(storeDTOList.get(0).getStoreDTO().getBook());
//        System.out.println(storeDTOList.get(0).getStoreDTO().getBicycle());


    }
}
