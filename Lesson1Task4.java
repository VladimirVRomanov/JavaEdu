/*
    Написать программу, которая выводит арифметическую или геометрическую прогрессию для N чисел.
*/
import java.io.IOException;
import java.util.Scanner;

public class Lesson1Task4 {
    public static void main(String[] args) throws IOException {
        char progressionType, inpChar = 'y';
        long progressionStart, progressionStep;
        int progressionCount;
        Progression progression;
        final var ARITHMETIC_PROGRESSION = 1;
        final var GEOMETRIC_PROGRESSION = 2;

        System.out.println("\nВывод арифметической или геометрической прогрессии для N чисел.\n");
        System.out.print("Выберите тип прогрессии (" + ARITHMETIC_PROGRESSION + " - арифметическая, " + GEOMETRIC_PROGRESSION + " - геометрическая): ");
        var num = new InputLongNumber();
        num.inputNumber();
        while (num.getNumber() < ARITHMETIC_PROGRESSION || num.getNumber() > GEOMETRIC_PROGRESSION) {
            System.out.print("Введено недопустимое число. Введите " + ARITHMETIC_PROGRESSION + " или " + GEOMETRIC_PROGRESSION + ": ");
            num.inputNumber();
        }
        progressionType = (char) num.getNumber();

        System.out.print("Введите количество членов прогрессии: ");
        num.inputNumber();
        while (num.getNumber() < 1 || num.getNumber() > 1000) {
            System.out.print("Введено недопустимое количество членов прогрессии. Введите целое число от 1 до 1000: ");
            num.inputNumber();
        }
        progressionCount = (int) num.getNumber();

        System.out.print("Введите значение первого члена прогрессии: ");
        num.inputNumber();
        if (progressionType == GEOMETRIC_PROGRESSION)
            while (num.getNumber() == 0) {
                System.out.print("Введено недопустимое значение первого члена геометрической прогрессии. Введите целое число, отличное от 0: ");
                num.inputNumber();
            }
        progressionStart = num.getNumber();

        System.out.print("Введите значение " + (progressionType == ARITHMETIC_PROGRESSION ? "разности" : "знаменателя") + " прогрессии: ");
        num.inputNumber();
        if (progressionType == GEOMETRIC_PROGRESSION)
            while (num.getNumber() == 0) {
                System.out.print("Введено недопустимое значение разности геометрической прогрессии. Введите целое число, отличное от 0: ");
                num.inputNumber();
            }
        progressionStep = num.getNumber();

        if (progressionType == ARITHMETIC_PROGRESSION)
            progression = new ArithmeticProgression(progressionStart, progressionStep, progressionCount);
        else
            progression = new GeometricProgression(progressionStart, progressionStep, progressionCount);

        if ( !progression.checkForCompleteness() ) {
            System.out.print("Прогрессия не может быть построена полностью. Вывести максимально допустимое количество элементов? (y/n): ");
            inpChar = (char) System.in.read();
        }
        if (Character.toLowerCase(inpChar) == 'y') {
            progression.build();
            progression.printElements(140);
        }
    }
}

abstract class Progression {
    protected long step;
    protected int count;
    protected long[] elements;

    Progression(long start, long step, int count) {
        elements = new long[count];
        elements[0] = start;
        this.step = step;
        this.count = count;
    }

    public long[] getElements() {
        return elements;
    }
    abstract boolean checkForCompleteness();
    abstract void build();
    abstract String getType();
    abstract String getStepName();
    public void printElements(int lineLengthLimit) {
        StringBuilder s = new StringBuilder();
        String nextElem;

        System.out.printf("\n" + getType() + " прогрессия (количество членов: %d; первый член: %d, " + getStepName() + ": %d):\n\n",
                          count, elements[0], step);
        for (int i = 0; i < count; i++) {
            nextElem = elements[i] + (i == count - 1 ? "" : ", ");
            if ((s + nextElem).length() > lineLengthLimit) {
                System.out.println(s);
                s = new StringBuilder();
            }
            s.append(nextElem);
        }
        if (!s.isEmpty())
            System.out.println(s);
    }
}

class ArithmeticProgression extends Progression {
    ArithmeticProgression(long start, long step, int count) {
        super(start, step, count);
    }
    public boolean checkForCompleteness() {
        return elements[0] + (double) (count - 1) * step <= Long.MAX_VALUE;
    }
    public void build() {
        for (int i = 1; i < count; i++) {
            if (Long.MAX_VALUE - elements[i - 1] < step) {
                count = i;
                break;
            }
            elements[i] = elements[i - 1] + step;
        }
    }
    protected String getType() {
        return "Арифметическая";
    }
    protected String getStepName() {
        return "разность";
    }
}

class GeometricProgression extends Progression {
    GeometricProgression(long start, long step, int count) {
        super(start, step, count);
    }
    public boolean checkForCompleteness() {
        return elements[0] * Math.pow(step, count - 1) < Long.MAX_VALUE;
    }
    public void build() {
        for (int i = 1; i < count; i++) {
            if ((double) elements[i - 1] * step >= Long.MAX_VALUE) {
                count = i;
                break;
            }
            elements[i] = elements[i - 1] * step;
        }
    }
    protected String getType() {
        return "Геометрическая";
    }
    protected String getStepName() {
        return "знаменатель";
    }
}

class InputLongNumber {
    private long number;

    public long getNumber() {
        return number;
    }
    public void inputNumber() {
        Scanner scanInpString;

        Scanner scanSystemIn = new Scanner(System.in);
        var inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        while ( !scanInpString.hasNextLong() ) {
            System.out.print("Введенное значение не является целым числом или выходит за пределы допустимого диапазона.\nВведите корректное целое число: ");
            inpString = scanSystemIn.next();
            scanInpString = new Scanner(inpString);
        }
        number = scanInpString.nextLong();
        scanInpString.close();
    }
}