/*
    Написать метод, который возвращает множество, в котором удалены все элементы чётной длины исходного множества
*/
import java.util.Set;
import java.util.LinkedHashSet;

public class Lesson6Task4 {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        set.add("Один");
        set.add("Два");
        set.add("Три");
        set.add("Четыре");
        set.add("Пять");
        set.add("Шесть");
        set.add("Семь");
        set.add("Восемь");
        set.add("Девять");
        set.add("Десять");
        System.out.println("\nИсходное множество:\n" + set.toString());
        removeEvenLength(set);
        System.out.println("\nМножество, в котором удалены все элементы чётной длины:\n" + set.toString());
    }

    public static Set<String> removeEvenLength(Set<String> set) {
        var iterator = set.iterator();
        while (iterator.hasNext())
            if (iterator.next().length() % 2 == 0)
                iterator.remove();
        return set;
        }
}