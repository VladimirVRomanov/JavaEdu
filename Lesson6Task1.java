/*
    Написать класс PersonSuperComparator, который имплементит Comparator,
    но умеет сравнивать по двум параметрам: возраст и имя.
    Класс Person теперь содержит два поля int age и String name.
 */
import java.util.Comparator;
import java.util.TreeSet;

public class Lesson6Task1 {
    public static void main(String[] args) {
        Comparator<Person> personComp = new PersonSuperComparator();
        TreeSet<Person> persons = new TreeSet<Person>(personComp);
        persons.add(new Person("Петя", 22));
        persons.add(new Person("Вася", 33));
        persons.add(new Person("Федя", 44));
        persons.add(new Person("Миша", 22));
        persons.add(new Person("Федя", 55));
        persons.add(new Person("Саша", 33));

        for (Person  p : persons) {
            System.out.println(p.getName() + ", возраст: " + p.getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() { return name; }

    int getAge() { return age; }
}

class PersonSuperComparator implements Comparator<Person> {
    public int compare(Person a, Person b) {
        if (a.getAge() > b.getAge())
            return 1;
        else if (a.getAge() < b.getAge())
            return -1;
        else
            return a.getName().compareTo(b.getName());
    }
}