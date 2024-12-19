/*
    Написать программу для определения является ли введенный пользователем год високосным.
    Каждый 150-й год –високосный, а также любой год, который делится на 4.
*/
import java.util.Scanner;

public class Lesson1TaskDop {
    public static void main(String[] args) {
        System.out.println("\nОпределяет, является ли год високосным.\n");
        System.out.print("Введите год - положительное целое число: ");
        InputIntNumber num = new InputIntNumber();
        num.inputNumber();
        while (num.getNumber() < 1) {
            System.out.print("Введено недопустимое значение. Введите положительное целое число : ");
            num.inputNumber();
        }
        var year = num.getNumber();
        System.out.println(year + " - " + (year % 4 == 0 || year % 150 == 0 ? "" : "не") + "високосный год");
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