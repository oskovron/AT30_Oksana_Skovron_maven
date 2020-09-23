package HW3workshop1;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Methods {

    //1.Написати метод, який генерує випадкову колекцію стрічок, кожна з яких є стрічкою, що містить від 6 до 15 символів.
    //Кількість стрічок в колекції передається, як параметр методу.
    public List<String> randomStringsListGenerator(int stringsNumber){
        List<String> strList = new ArrayList<>();
        for (int i = 1; i<=stringsNumber; i++) {
            String s = RandomStringUtils.randomAlphabetic(6, 15);
            strList.add(s);
        }
        return strList;
    }

    //2. Написати метод, який приймає параметром поточну дату та додає дні, місяці та рік до цієї дати.
    //  Усі ці значення передаються параметрами в метод теж.
    public void dateGeneratorPlus(LocalDateTime currentDate, long years, int month, int days){
        System.out.println(LocalDateTime.now().plusYears(years).plusMonths(month).plusDays(days));
    }

    //3. Написати метод, який зчитує дані з файлу у HashMap, ключем якої є номер рядку файлу, а value - це текст у рядку файлу.
    //Записати у інший файл тільки ті значення HashMap, ключі яких є степенем 2.
    //Використати перехоплення виключення ситуацій - (файлу не існує, ітд)
    public static Map readFileToMapByRows(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Create variables:
        Map<Integer, String> map = new HashMap();
        Integer lineNumber = 1;
        String lineText;

        while((lineText=bufferedReader.readLine()) != null){
            map.put(lineNumber, lineText);
            lineNumber++;
        }
        bufferedReader.close();
        return map;
    }

    public void writeMapToFile(Map map){
        File outputFile = new File("src\\main\\resources\\outputFile.txt");
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))){
            Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
            int count = 0;
            while (it.hasNext() && count < map.size()) {
                Map.Entry<Integer, String> pairs = it.next();
                fileWriter.write(pairs.getValue() + "\n");
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
