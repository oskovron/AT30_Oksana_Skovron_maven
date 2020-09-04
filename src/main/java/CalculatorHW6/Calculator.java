package CalculatorHW6;

public class Calculator {

    public int add(int a, int b) {
        if (a + b <= 2147483647 && a + b >= -2147483648) {
            return a + b;
        } else {
            System.out.println("Sorry, number is too large.");
            return 0;
        }

    }

    public int subtract(int a, int b) {
        if (a - b >=-2147483648) {
            return a - b;
        }else{
            return 0;
        }
    }

    public int divide(int a, int b) {
        if (b==0){
            System.out.println("Can't divide by zero.");
           return 0;
        }else {
            return a / b;
        }
    }

    public int multiply(int a, int b) {
        if (a*b<=2147483647 && a*b>=-2147483648) {
            return a * b;
        }else{
            System.out.println("Sorry, number is too large.");
            return 0;
        }
    }


}
