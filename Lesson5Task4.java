/*
    Написать абстрактный класс Человек реализующий интерфейсы «бежать» и «плавать» (в каждом сделать 1-2 метода).
    Сделать несколько наследников этого класса с конкретной реализацией методов, которые объявлены в интерфейсах.
 */

public class Lesson5Task4 {
    public static void main(String[] args) {
        Person[] persons = { new ProfessionalAthlete("Петя"),
                             new StudentAthlete("Вася"),
                             new NotAthlete("Федя") };
        System.out.println();
        for (var person : persons) {
            person.runShortDistance();
            person.runLongDistance();
            person.swimCrawl();
            person.swimBreaststroke();
            person.swimBackstroke();
            person.swimButterfly();
        }

    }
}

interface Run {
    void runShortDistance();
    void runLongDistance();
}

interface Swim {
    void swimCrawl();
    void swimBreaststroke();
    void swimBackstroke();
    void swimButterfly();
}

abstract class Person implements Run, Swim {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } ;
}

abstract class Athlete extends Person  implements Run, Swim {
    Athlete(String name) {
        super(name);
    }
    protected String getType() {
        return "Спортсмен";
    }
}

class ProfessionalAthlete extends Athlete {
    ProfessionalAthlete(String name) {
        super(name);
    }
    protected String getType() {
        return "Профессиональный " + super.getType().toLowerCase();
    }
    public void runShortDistance() {
        System.out.println(getType() + " " + super.getName() + " очень быстро бегает на короткие дистанции.");
    }
    public void runLongDistance() {
        System.out.println(getType() + " " + super.getName() + " достаточно быстро бегает на длинные дистанции.");
    }
    public void swimCrawl() {
        System.out.println(getType() + " " + super.getName() + " отлично плавает кролем.");
}
    public void swimBreaststroke() {
        System.out.println(getType() + " " + super.getName() + " прекрасно плавает брассом.");
        }
    public void swimBackstroke() {
        System.out.println(getType() + " " + super.getName() + " уверенно плавает на спине.");
        }
    public void swimButterfly() {
        System.out.println(getType() + " " + super.getName() + " умеет плавать баттерфляем.");
        }
}

class StudentAthlete extends Athlete {
    StudentAthlete(String name) {
        super(name);
    }
    protected String getType() {
        return "Студент-" + super.getType().toLowerCase();
    }
    public void runShortDistance() {
        System.out.println(getType() + " " + super.getName() + " быстро бегает на короткие дистанции.");
    }
    public void runLongDistance() {
        System.out.println(getType() + " " + super.getName() + " недостаточно быстро бегает на длинные дистанции.");
    }
    public void swimCrawl() {
        System.out.println(getType() + " " + super.getName() + " хорошо плавает кролем.");
    }
    public void swimBreaststroke() {
        System.out.println(getType() + " " + super.getName() + " хорошо плавает брассом.");
    }
    public void swimBackstroke() {
        System.out.println(getType() + " " + super.getName() + " умеет плавать на спине.");
    }
    public void swimButterfly() {
        System.out.println(getType() + " " + super.getName() + " не умеет плавать баттерфляем.");
    }
}

class NotAthlete extends Person {
    NotAthlete(String name) {
        super(name);
    }
    protected String getType() {
        return "Обычный человек, не спортсмен";
    }
    public void runShortDistance() {
        System.out.println(getType() + " " + super.getName() + " не очень быстро бегает на короткие дистанции.");
    }
    public void runLongDistance() {
        System.out.println(getType() + " " + super.getName() + " медленно бегает на длинные дистанции.");
    }
    public void swimCrawl() {
        System.out.println(getType() + " " + super.getName() + " умеет плавать кролем.");
    }
    public void swimBreaststroke() {
        System.out.println(getType() + " " + super.getName() + " умеет плавать брассом.");
    }
    public void swimBackstroke() {
        System.out.println(getType() + " " + super.getName() + " не умеет плавать на спине.");
    }
    public void swimButterfly() {
        System.out.println(getType() + " " + super.getName() + " не умеет плавать баттерфляем.");
    }
}
