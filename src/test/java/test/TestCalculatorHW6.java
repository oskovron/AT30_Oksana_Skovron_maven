package test;

import CalculatorHW6.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorHW6 extends BaseTest {
    Calculator calculator = new Calculator();

    @Test
    public void testCalculatorAdd1() {
        int add = calculator.add(600, 1);
        System.out.println(add);
        softAssert.assertEquals(sign(add), sign(1), "We added two positive values, sum can't be negative");
        Assert.assertEquals(add, 601, "Different sum.");
    }

    @Test
    public void testCalculatorAdd2() {
        int add = calculator.add(600, -1);
        System.out.println(add);
        softAssert.assertEquals(sign(add), sign(1), "Bigger value is positive, sum can't be negative");
        Assert.assertEquals(add, 599, "Different sum.");
    }

    @Test
    public void testCalculatorAdd3() {
        int add = calculator.add(-600, 1);
        System.out.println(add);
        softAssert.assertEquals(sign(add), sign(-1), "Bigger value is negative, sum can't be positive");
        softAssert.assertEquals(add, -599, "Different sum.");
    }

    //TODO: figure out what to do with this sum 2147483647+1 = -2147483648
    @Test
    public void testCalculatorAdd4() {
        int add = calculator.add(2147483647, 1);
        System.out.println(add);

        //We expect that if we add two positive values, sign will remain positive.
        softAssert.assertEquals(sign(add), sign(1), "We added two positive values, sum can't be negative");
        softAssert.assertEquals(add, 0);

    }

    @Test
    public void testCalculatorAdd5() {
        int add = calculator.add(-2147483647, -1);
        System.out.println(add);

        //We expect that if we add two negative values, sign will remain negative.
        softAssert.assertEquals(sign(add), sign(-1), "We added two negative values, sum can't be positive");
        softAssert.assertEquals(add, -2147483648);
    }

    //TODO: figure out what to do with this sum -2147483647 + (-2) = 2147483647
    @Test
    public void testCalculatorAdd6() {
        int add = calculator.add(-2147483647, -2);
        System.out.println(add);

        //We expect that if we add two negative values, sign will remain negative.
        softAssert.assertEquals(sign(add), sign(-1), "We added two negative values, sum can't be positive");
        softAssert.assertEquals(add, 0); //actual 2147483647
    }


    @Test
    public void testCalculatorSubtract1() {
        int subtract = calculator.subtract(100, 6);
        System.out.println(subtract);
        softAssert.assertEquals(sign(subtract), sign(1),
                "Value a is bigger than value b, subtraction can't be negative. ");
        softAssert.assertEquals(subtract, 94, "Different value.");
    }

    @Test
    public void testCalculatorSubtract2() {
        int subtract = calculator.subtract(5, 6);
        System.out.println(subtract);
        softAssert.assertEquals(sign(subtract), sign(-1),
                "Value a is smaller than value b, subtraction can't be positive. ");
        softAssert.assertEquals(subtract, -1, "Different value.");
    }

    @Test
    public void testCalculatorSubtract3() {
        int subtract = calculator.subtract(-1, -2);
        System.out.println(subtract);
        softAssert.assertEquals(sign(subtract), sign(1), "Minus and minus should return plus.");
        softAssert.assertEquals(subtract, 1, "Different value.");
    }

    @Test
    public void testCalculatorSubtract4() {
        int subtract = calculator.subtract(-2147483648, 1);
        System.out.println(subtract);
        softAssert.assertEquals(sign(subtract), sign(-1),
                "Value a is bigger than value b, subtraction can't be positive");
        softAssert.assertEquals(subtract, 0);
    }

    @Test(dataProvider = "dataForDivisionByZero")
    public void testCalculatorDivide1(int a, int b) {
        int divide = calculator.divide(a, b);
        System.out.println(divide);
        softAssert.assertEquals(divide, 0);
    }

    @Test
    public void testCalculatorDivide2() {
        int divide = calculator.divide(22, 3);
        System.out.println(divide);
        softAssert.assertEquals(divide, 7, "Different value.");
    }

    @Test(dataProvider = "dataForDivisionOfMinusNumbers")
    public void testCalculatorDivide3(int a, int b){
        int divide = calculator.divide(a,b);
        System.out.println(divide);
        softAssert.assertEquals(sign(divide), sign(-1));
        softAssert.assertEquals(divide, -16, "Different value.");
    }

    @Test
    public void testCalculatorDivide4(){
        int divide = calculator.divide(-4,-2);
        System.out.println(divide);
        softAssert.assertEquals(sign(divide), sign(1), "Minus and minus should return plus.");
        softAssert.assertEquals(divide, 2);
    }

    @Test
    public void testCalculatorMultiply1(){
        int multiply = calculator.multiply(20 ,60);
        System.out.println(multiply);
        softAssert.assertEquals(sign(multiply), sign(1),
                "We multiply two positive values, result should be positive value.");
        softAssert.assertEquals(multiply, 1200);
    }



    @Test
    public void testCalculatorMultiply2(){
        int multiply = calculator.multiply(-2 ,5);
        System.out.println(multiply);
        softAssert.assertEquals(sign(multiply), sign(-1),
                "One of values is negative, result should be negative value.");
        softAssert.assertEquals(multiply, -10);
    }

    //TODO: figure out what to do with this result 2147483647 * 2 = -2
    @Test
    public void testCalculatorMultiply3(){
        int multiply = calculator.multiply(2147483647 ,2);
        System.out.println(multiply);
        softAssert.assertEquals(sign(multiply), sign(1),
                "We multyply two positive numbers, result should be positive number");
        softAssert.assertEquals(multiply, 0); //actual -2
    }

    @Test(dataProvider = "dataForMultiplyByZero")
    public void testCalculatorMultiply4(int a, int b){
        int multiply = calculator.multiply(a ,b);
        System.out.println(multiply);
        softAssert.assertEquals(sign(multiply), sign(0),
                "We multyply by zero, result should be equal to 0.");
        softAssert.assertEquals(multiply, 0);
    }







    private static int sign(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }

    @DataProvider
    public Object[][] dataForDivisionByZero() {
        return new Integer[][]{
                {2, 0},
                {-2, 0}
        };
    }

    @DataProvider
    public Object[][] dataForDivisionOfMinusNumbers(){
        return new Integer[][]{
                {33, -2},
                {-33, 2}
        };
    }

    @DataProvider
    public Object[][] dataForMultiplyByZero(){
        return new Integer[][]{
                {2, 0},
                {-2147483648, 0},
                {2147483647, 0},
                {0, 0},
        };
    }
}