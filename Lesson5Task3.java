/*
    Написать интерфейсы Fly, Run и Swim, чтобы в каждом было по одному методу.
    Добавить классам животных из предыдущего задания имплементацию этих интерфейсов.
    Некоторые животные могут реализовать больше одного интерфейса (утка может и плавать, и летать и бегать).
 */
public class Lesson5Task3 {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Bird(), new Fish(), new Duck() };

        System.out.println();
        for (var animal : animals) {
            if (animal instanceof Run)
                ((Run) animal).run();
            if (animal instanceof Fly)
                ((Fly) animal).fly();
            if (animal instanceof Swim)
                ((Swim) animal).swim();
        }
    }
}

interface Fly {
    void fly();
}

interface Run {
    void run();
}

interface Swim {
    void swim();
}

abstract class Animal {
    abstract String getName();
}

class Dog extends Animal implements Run {
    public String getName() {
        return "Собака";
    }
    public void run() {
        System.out.println(getName() + " бегает");
    }
}

class Cat extends Animal implements Run {
    public String getName() {
        return "Кошка";
    }
    public void run() {
        System.out.println(getName() + " бегает");
    }
}

class Bird extends Animal implements Fly {
    public String getName() {
        return "Птица";
    }
    public void fly() {
        System.out.println(getName() + " летает");
    }
}

class Fish extends Animal  implements Swim {
    public String getName() {
        return "Рыба";
    }
    public void swim() {
        System.out.println(getName() + " плавает");
    }
}

class Duck extends Bird implements Fly, Run, Swim {
    public String getName() {
        return "Утка";
    }
    public void fly() {
        System.out.println(getName() + " летает");
    }
    public void run() {
        System.out.println(getName() + " бегает");
    }
    public void swim() {
        System.out.println(getName() + " плавает");
    }
}

