package HW3workshop1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Methods m = new Methods();
        System.out.println(m.randomStringsListGenerator(5));
        m.dateGeneratorPlus(LocalDateTime.now(), 1, 2,3);
    }
}
