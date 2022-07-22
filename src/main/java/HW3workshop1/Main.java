package HW3workshop1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {

        Methods m = new Methods();
//        //Task 1:
        System.out.println("Task 1: ");
        System.out.println(m.randomStringsListGenerator(5));

//        //Task 2:
        System.out.println("Task 2: ");
        m.dateGeneratorPlus(LocalDateTime.now(), 1, 2,3);

        //Task3:
        //Read file into hashMap
        System.out.println("Task 3: ");
        Map<Integer, String> mapOriginal = null;
        try {
            mapOriginal = m.readFileToMapByRows("src\\main\\resources\\text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("MapOriginal: " + mapOriginal);

        //Filter only rows with keys sqrt of 2 and add to new map
        Map<Integer, String> filteredMap = mapOriginal.entrySet().stream()
                .filter(x -> x.getKey() != 0 && ((x.getKey() & (x.getKey() - 1)) == 0))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        System.out.println("Filtered map: " + filteredMap);

        //write new map to file
        m.writeMapToFile(filteredMap);
    }
}
