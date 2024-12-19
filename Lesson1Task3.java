/*
    Написать программу для вывода на экран таблицы умножения.
*/
class Lesson1Task3 {
    public static void main(String[] args) {
        System.out.println("\nТаблица умножения.\n");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++)
                System.out.printf("%4d", i * j);
            System.out.println();
        }
    }
}