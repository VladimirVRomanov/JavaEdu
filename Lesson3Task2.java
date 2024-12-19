/*
    Запросить у пользователя целое число N, создать двумерный массив размером N на N.
    Заполнить его случайными числами и вывести на экран сумму диагоналей массива.
*/
import java.util.Random;
import java.util.Scanner;

public class Lesson3Task2 {
    public static void main(String[] args) {
        final var MIN_ARRAY_LEN = 2;
        final var MAX_ARRAY_LEN = 10;
        final var RANDOM_UPPER_BOUND = 100;

        System.out.println("\nВывод суммы диагоналей матрицы целых чисел.\n");
        String prompt = "Введите целое число от " + MIN_ARRAY_LEN + " до " + MAX_ARRAY_LEN + ": ";
        System.out.print(prompt);
        InputIntNumber num = new InputIntNumber();
        num.inputNumber();
        while (num.getNumber() < MIN_ARRAY_LEN || num.getNumber() > MAX_ARRAY_LEN) {
            System.out.print("Введено недопустимое число. " + prompt);
            num.inputNumber();
        }
        var n = num.getNumber();
        int[][] arr = new int[n][n];
        Random random = new Random();
        System.out.printf("\nМатрица размером %d на %d случайных чисел в диапазоне от 0 до %d:\n\n",
                          n, n, RANDOM_UPPER_BOUND - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = random.nextInt(RANDOM_UPPER_BOUND);
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.print("\n");
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i][i] + arr[i][n-i-1];

        System.out.printf("\nСумма диагоналей матрицы равна %d\n", sum);
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