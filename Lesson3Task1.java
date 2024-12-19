/*
    Реализовать алгоритм сортировки массива пузырьком и попытаться его оптимизировать.
    Оптимизацию будем "считать" количеством итераций цикла.
*/
import java.util.Arrays;
import java.util.Random;

public class Lesson3Task1 {
    public static void main(String[] args) {
        final var RANDOM_UPPER_BOUND = 100;
        int[][] array = new int[2][100];

        Random random = new Random();
        for (int i = 0; i < array[0].length; i++)
            array[0][i] = random.nextInt(RANDOM_UPPER_BOUND);
        array[1] = array[0].clone();

        System.out.println("\nСортировка массива целых чисел по возрастанию.");
        System.out.println("\nМассив до сортировки:");
        System.out.println(Arrays.toString(array[0]));

        var bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(array[0]);
        System.out.println("\nМассив после сортировки:");
        System.out.println(Arrays.toString(array[0]));
        System.out.printf("\nКоличество итераций: %d\n", bubbleSorter.getIterationCount());

        bubbleSorter.sortOptimized(array[1]);
        System.out.println("\nМассив после оптимизированной сортировки:");
        System.out.println(Arrays.toString(array[1]));
        System.out.printf("\nКоличество итераций: %d\n", bubbleSorter.getIterationCount());
    }
}

class BubbleSorter {
    private int iterationCount;

    public int getIterationCount() { return iterationCount; }

    public void sort(int[] arr) {
        iterationCount = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    var a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                }
                iterationCount++;
            }
    }
    public void sortOptimized(int[] arr) {
        iterationCount = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = arr.length - 1; j > i ; j--) {
                if (arr[j - 1] > arr[j]) {
                    var a = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = a;
                }
                iterationCount++;
            }
    }
}