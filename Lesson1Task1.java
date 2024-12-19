/*
    Написать программу для поиска минимального из двух чисел.
*/
import java.util.Scanner;

class Lesson1Task1 {
    public static void main(String[] args) {
        System.out.println("\nОпределение минимального из двух введённых чисел.\n");
        System.out.print("Введите первое число: ");
        var n1 = new InputNumber();
        n1.inputNumber();
        System.out.print("Введите второе число: ");
        var n2 = new InputNumber();
        n2.inputNumber();
        var minNum = new MinOfTwoNumbers();
        System.out.println(minNum.compare(n1, n2));
    }
}

class MinOfTwoNumbers {
    public String compare(InputNumber n1, InputNumber n2) {
        var minNum = min(n1, n2);
        if (minNum != null)
            return minNum.getInpString() + " - минимальное из чисел " + n1.getInpString() + " и " + n2.getInpString();
        else
            return "Введённые числа равны.";
    }

    private InputNumber min(InputNumber n1, InputNumber n2) {
        if (n1.getNumber() < n2.getNumber())
            return n1;
        else if (n1.getNumber() > n2.getNumber())
            return n2;
        else
            return null;
    }
}

class InputNumber {
    private String inpString;
    private double number;

    public String getInpString() {
        return inpString;
    }

    public double getNumber() {
        return number;
    }

    public void inputNumber() {
        Scanner scanInpString;
        Scanner scanSystemIn = new Scanner(System.in);
        while (!(scanInpString = new Scanner(inpString = scanSystemIn.next())).hasNextDouble())
            System.out.print("Введенное значение не является числом или выходит за пределы допустимого диапазона.\nВведите корректное число: ");
        number = scanInpString.nextDouble();
        scanInpString.close();
    }
}
