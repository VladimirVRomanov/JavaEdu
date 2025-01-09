/*
    Поэкспериментировать с ключевым словом final.
 */
public class Lesson4Task2 {
    public static void main(String[] args) {

        // Для final переменных примитивных типов невозможно изменение содержимого переменной
        final int finalVar = 1;
        // finalVar = 2; // Ошибка компиляции: cannot assign a value to final variable finalVar

        // Для ссылочных переменных невозможно присвоить новую ссылку на другой объект
        final Class1 obj1 = new Class1();
        // obj1 = new Class1(); // Ошибка компиляции: cannot assign a value to final variable obj1

        // Изменение состояния объекта, на который ссылается переменная, возможно
        obj1.i = 1;
        System.out.println("i = " + obj1.i);
        obj1.i = 2;
        System.out.println("i = " + obj1.i);
    }
}

class Class1 {
    int i;

    final void finalMethod() {}
}

class Class2 extends Class1 {
    // Невозможно переопределение метода в классах-наследниках
    // final void finalMethod() {} // Ошибка компиляции: finalMethod() in Class2 cannot override finalMethod() in Class1
                                   //                    overridden method is final
}

final class Class3 {

}

// Невозможно наследование от final класса
// class Class4 extends Class3 {} // Ошибка компиляции: cannot inherit from final Class3
