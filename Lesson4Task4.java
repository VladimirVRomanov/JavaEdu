/*
    Реализовать класс в конструкторе которого будет счетчик количества создаваемых объектов.
    Написать метод для получения информации о количестве.
 */
public class Lesson4Task4 {
    public static void main(String[] args) {
        System.out.println("\nCчетчик количества создаваемых объектов");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nСоздаем объект " + i);
            new CounterOfObjects().showCountInfo();
        }
    }
}

class CounterOfObjects {
    private static int objectCounter;

    CounterOfObjects() {
        objectCounter++;
    }

    public int getObjectCount() { return objectCounter; }

    public void showCountInfo () {
        System.out.printf("Количество созданных объектов: %d\n", getObjectCount());
    }
}