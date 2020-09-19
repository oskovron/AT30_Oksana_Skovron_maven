package HWworkshop1;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    private LocalDateTime currentDate;

    //1.Написати метод, який генерує випадкову колекцію стрічок, кожна з яких є стрічкою, що містить від 6 до 15 символів.
    //Кількість стрічок в колекції передається, як параметр методу.
    public List<String> randomStringsListGenerator(int stringsNumber){
        List<String> strList = new ArrayList<>();
        for (int i = 0; i<=stringsNumber; i++) {
            String s = RandomStringUtils.randomAlphabetic(6, 15);
            strList.add(s);
        }
        return strList;
    }

    //2. Написати метод, який приймає параметром поточну дату та додає дні,
    // місяці та рік до цієї дати. Усі ці значення передаються параметрами в метод теж.
    public void dateGeneratorPlus(LocalDateTime currentDate, long years, int month, int days){
        System.out.println(LocalDateTime.now().plusYears(years).plusMonths(month).plusDays(days));
    }

    //3. Написати метод, який зчитує дані з файлу у HashMap, ключем якої є номер рядку файлу, а value - це текст у рядку файлу.
    //Записати у інший файл тільки ті значення HashMap, ключі яких є степенем 2.
    //Використати перехоплення виключення ситуацій - (файлу не існує, ітд)

}
