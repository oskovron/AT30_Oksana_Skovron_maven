package CalculatorHW6;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int add = calculator.add(2147483647, 2147483647);
        System.out.println(add);
    }
}
