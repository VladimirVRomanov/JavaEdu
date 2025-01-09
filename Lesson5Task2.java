/*
    Написать абстрактный класс Animal с абстрактным методом getName.
    Сделать несколько классов животных, наследников Animal.
    Метод getName должен выводить название каждого животного.
 */
public class Lesson5Task2 {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Bird(), new Fish() };
        System.out.println();
        for (Animal animal : animals)
            System.out.println(animal.getName());
    }
}

abstract class Animal {
    abstract String getName();
}

class Dog extends Animal {
    public String getName() {
        return "Собака";
    }
}

class Cat extends Animal {
    public String getName() {
        return "Кошка";
    }
}

class Bird extends Animal {
    public String getName() {
        return "Птица";
    }
}

class Fish extends Animal {
    public String getName() {
        return "Рыба";
    }
}