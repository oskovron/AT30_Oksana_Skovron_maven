package HW3workshop1.task3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParserHWworkshop {
    //3. Написати метод, який зчитує дані з файлу у HashMap, ключем якої є номер рядку файлу, а value - це текст у рядку файлу.
    //Записати у інший файл тільки ті значення HashMap, ключі яких є степенем 2.
    //Використати перехоплення виключення ситуацій - (файлу не існує, ітд)

    //TODO: Add try catch
    public static void main(String[] args) throws Exception {
        Map<Integer, String> mapLotto = new HashMap<>();
        FileInputStream file = new FileInputStream("src/main/resources/lotto.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        TypeFactory typeFactory = TypeFactory.defaultInstance();

        List<LottoFullDTO> lottoList = objectMapper.readValue(file, typeFactory.constructCollectionType
                (ArrayList.class, LottoFullDTO.class));

        for (LottoFullDTO lottoFullDTO: lottoList) {
            mapLotto.put(lottoList.indexOf(lottoFullDTO), lottoFullDTO.toString());
        }

        //I'm stuck on taking row numbers and taking data from each row
        System.out.println("Map");
        System.out.println(mapLotto);

//        System.out.println(lottoList.get(0).getLotto());
//        System.out.println(lottoList.get(1).getCar().getAge());


    }
}
