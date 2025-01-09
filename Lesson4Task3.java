/*
    Реализовать класс Calculator, который будет содержать статические методы
    для операций вычитания, сложения, умножения, деления и взятия процента от числа.
    Класс должен работать как с целыми числами, так и с дробями.
 */
import java.util.Scanner;

public class Lesson4Task3 {
    public static void main(String[] args) {
        System.out.print("\nВведите первое число: ");
        var n1 = new InputNumber();
        n1.inputNumber();
        System.out.print("Введите второе число: ");
        var n2 = new InputNumber();
        n2.inputNumber();
        if (n1.getNumberType() == NumberType.LONG && n2.getNumberType() == NumberType.LONG) {
            long l1 = n1.getLongNumber();
            long l2 = n2.getLongNumber();
            double d = Calculator.add(l1, l2);
            print("\n%d + %d = %d", l1, l2, d);
            d = Calculator.subtract(l1, l2);
            print("\n%d - %d = %d", l1, l2, d);
            d = Calculator.multiply(l1, l2);
            print("\n%d * %d = %d", l1, l2, d);
            d = Calculator.divide(l1, l2);
            print("\n%d / %d = %d", l1, l2, d);
            d = Calculator.percent(l1, l2);
            print("\n%d%% от %d = %d", l2, l1, d);
        }
        else {
            var s1 = n1.getString();
            var s2 = n2.getString();
            double d = Calculator.add(n1.getNumberType() == NumberType.LONG ? n1.getLongNumber() : n1.getDoubleNumber(),
                                      n2.getNumberType() == NumberType.LONG ? n2.getLongNumber() : n2.getDoubleNumber());
            print("\n%s + %s = %d", s1, s2, d);
            d = Calculator.subtract(n1.getNumberType() == NumberType.LONG ? n1.getLongNumber() : n1.getDoubleNumber(),
                                    n2.getNumberType() == NumberType.LONG ? n2.getLongNumber() : n2.getDoubleNumber());
            print("\n%s - %s = %d", s1, s2, d);
            d = Calculator.multiply(n1.getNumberType() == NumberType.LONG ? n1.getLongNumber() : n1.getDoubleNumber(),
                                    n2.getNumberType() == NumberType.LONG ? n2.getLongNumber() : n2.getDoubleNumber());
            print("\n%s * %s = %d", s1, s2, d);
            d = Calculator.divide(n1.getNumberType() == NumberType.LONG ? n1.getLongNumber() : n1.getDoubleNumber(),
                                  n2.getNumberType() == NumberType.LONG ? n2.getLongNumber() : n2.getDoubleNumber());
            print("\n%s / %s = %d", s1, s2, d);
            d = Calculator.percent(n1.getNumberType() == NumberType.LONG ? n1.getLongNumber() : n1.getDoubleNumber(),
                                   n2.getNumberType() == NumberType.LONG ? n2.getLongNumber() : n2.getDoubleNumber());
            print("\n%s%% от %s = %d", s2, s1, d);
        }
    }

    public static void print(String formatString, long l1, long l2, double d) {
        if (d == Math.floor(d) && d < Long.MAX_VALUE)
            System.out.printf(formatString + "\n", l1, l2, (long) d);
        else
            System.out.printf(formatString.substring(0, formatString.length() - 2) + d + "\n", l1, l2);

    }

    public static void print(String formatString, String s1, String s2, double d) {
        if (d == Math.floor(d) && d < Long.MAX_VALUE)
            System.out.printf(formatString + "\n", s1, s2, (long) d);
        else
            System.out.printf(formatString.substring(0, formatString.length()-2) + d + "\n", s1, s2);

    }

}

class Calculator {
    public static double add(long a, long b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static double subtract(long a, long b) {
        return a - b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(long a, long b) {
        return a * b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(long a, long b) {
        return (double) a / b;
    }
    public static double divide(double a, double b) {
        return a / b;
    }
    public static double percent(long a, long b) {
        return  (double) a / 100 * b;
    }
    public static double percent(double a, double b) {
        return a / 100 * b;
    }
}

enum NumberType {
    LONG,
    DOUBLE
}

class InputNumber {
    private String inpString;
    private NumberType numberType;
    private long longNumber;
    private double doubleNumber;

    public String getString() {
        return inpString;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public long getLongNumber() {
        return longNumber;
    }

    public double getDoubleNumber() {
        return doubleNumber;
    }

    public void inputNumber() {

        Scanner scanInpString;
        Scanner scanSystemIn = new Scanner(System.in);
        while (!(scanInpString = new Scanner(inpString = scanSystemIn.next())).hasNextDouble())
            System.out.print("Введенное значение не является числом или выходит за пределы допустимого диапазона.\nВведите корректное число: ");
        if (scanInpString.hasNextLong()) {
            longNumber =  scanInpString.nextLong();
            numberType = NumberType.LONG;
        }
        else if (scanInpString.hasNextDouble()) {
            doubleNumber = scanInpString.nextDouble();
            numberType = NumberType.DOUBLE;
        }
        scanInpString.close();
    }
}
