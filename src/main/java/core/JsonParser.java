package core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import model.JsonFullStore;
import model.StoreDTO;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonParser {

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/books.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<JsonFullStore> storeDTOList = objectMapper.readValue(file, typeFactory.constructCollectionType(ArrayList.class, JsonFullStore.class));

        storeDTOList.forEach(store -> System.out.println(store));

//        System.out.println(storeDTOList.get(0).getBicycle());
        System.out.println(storeDTOList.get(0).getStoreDTO().getBook());
        System.out.println(storeDTOList.get(0).getStoreDTO().getBicycle());


    }
}
