/*
    Реализовать расчет и вывод в консоль последовательности чисел Фибоначчи
    до указанного пользователем N, посредством рекурсии
*/
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson3Task3  {
    public static void main(String[] args) throws IOException {
        final var MIN_NUM = 1;
        final var BY_RECURSION = 1;
        final var BY_LOOP = 2;
        char inpChar = 'y';

        System.out.println("\nВывод последовательности чисел Фибоначчи.\n");
        System.out.print("Введите положительное целое число - номер последнего элемента последовательности Фибоначчи: ");
        InputIntNumber num = new InputIntNumber();
        num.inputNumber();
        while (num.getNumber() < MIN_NUM) {
            System.out.print("Введено недопустимое число. Введите целое число от " + MIN_NUM + " до " + Integer.MAX_VALUE + ": ");
            num.inputNumber();
        }
        var n = num.getNumber();
        var fibonacciSequence = new FibonacciSequence(n);

        System.out.print("\nВыберите метод построения последовательности (" + BY_RECURSION + " - рекурсивный, " + BY_LOOP + " - циклический): ");
        num.inputNumber();
        while (num.getNumber() < BY_RECURSION || num.getNumber() > BY_LOOP) {
            System.out.print("Введено недопустимое число. Введите " + BY_RECURSION + " или " + BY_LOOP + ": ");
            num.inputNumber();
        }
        switch (num.getNumber()) {
            case BY_RECURSION:
                fibonacciSequence.calculateByRecursion();
                break;
            case BY_LOOP:
                fibonacciSequence.calculateByLoop();
                break;
        }

        if ( !fibonacciSequence.checkForCompleteness() ) {
            System.out.printf("\nПоследовательность чисел Фибоначчи до %d-го элемента не может быть построена полностью из-за возможности возникновения ошибки переполнения.\nВывести максимально допустимое количество чисел? (y/n): ", n);
            inpChar = (char) System.in.read();
        }
        if (Character.toLowerCase(inpChar) == 'y')
            fibonacciSequence.printElements(140);
    }
}

class FibonacciSequence {
    private int index;
    private long[] elements;

    FibonacciSequence(int ind) {
        index = ind;
        elements = new long[ind + 1];
    }
    public int getIndex() { return index; }
    public long calculateByRecursion() { return calculate(index); }
    private long calculate(int n) {
        if (n < 0) {
            System.out.println(n + " - недопустимое значение для расчета последовательности чисел Фибоначчи!");
            return -1;
        }
        if (n < 2)
            return elements[n] =  n;
        else {
            if ((double) elements[n - 1] + elements[n - 2] >= Long.MAX_VALUE)
                return elements[n] =  0;
            else
                return elements[n] = calculate(n - 1) + calculate(n - 2);
        }
    }
    public long calculateByLoop() {
        int i;
        elements[1] = 1;
        for (i = 2; i <= index; i++)
            if ((double) elements[i - 1] + elements[i - 2] >= Long.MAX_VALUE) {
                elements[i] = 0;
                break;
            }
            else
                elements[i] = elements[i - 1] + elements[i - 2];
        return elements[index];
    }
    public boolean checkForCompleteness() {
        return elements[index] > 0;
    }
    public void printElements(int lineLengthLimit) {
        StringBuilder s = new StringBuilder();
        String nextElem;
        final var indexOfLastElement = getIndexOfLastPositive();

        System.out.printf("\n" + "Последовательность чисел Фибоначчи от 0 до %d элемента включительно: \n", getIndexOfLastPositive());
        for (int i = 0; i <= indexOfLastElement; i++) {
            nextElem = elements[i] + (i == indexOfLastElement ? "" : ", ");
            if ((s + nextElem).length() > lineLengthLimit) {
                System.out.println(s);
                s = new StringBuilder();
            }
            s.append(nextElem);
        }
        if (!s.isEmpty())
            System.out.println(s);
    }
    public int getIndexOfLastPositive() {
        int result = -1;

        for (int i = index; i > 0; i--)
            if (elements[i] > 0) {
                result = i;
                break;
            }
        return result;
    }
}

class InputIntNumber {
    private int number;

    public int getNumber() {
        return number;
    }
    public void inputNumber() {
        Scanner scanInpString;

        Scanner scanSystemIn = new Scanner(System.in);
        var inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        while ( !scanInpString.hasNextInt() ) {
            System.out.print("Введенное значение не является целым числом или выходит за пределы допустимого диапазона.\nВведите корректное целое число: ");
            inpString = scanSystemIn.next();
            scanInpString = new Scanner(inpString);
        }
        number = scanInpString.nextInt();
        scanInpString.close();
    }
}