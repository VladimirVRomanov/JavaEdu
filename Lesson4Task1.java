/*
    Напишите программу которая получает на вход некую строку, после она вызывает метод,
    заменяющий в строке все вхождения слова «бяка» на «вырезано цензурой» и выводит результат в консоль!
 */
import java.util.Scanner;

public class Lesson4Task1 {
    public static void main(String[] args) {
        System.out.print("\nВведите строку: ");
        var inString = new Scanner(System.in);
        String s = inString.nextLine();
        System.out.println(s.replaceAll("бяка", "вырезано цензурой"));
        inString.close();
    }
}