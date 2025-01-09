/*
    Переписать проект с урока (вендинговый автомат) используя конструктор, перечисления и взаимодействие с пользователем.
 */
import java.util.Scanner;

public class Lesson5Task1 {
    public static void main(String[] args) {
        Drink[] drinks = { Drink.WATER,
                           Drink.TEA,
                           Drink.KVAS,
                           Drink.COLA,
                           Drink.COFFEE
        };
        Menu[] menu = { Menu.SHOW_DRINKS,
                        Menu.ADD_MONEY,
                        Menu.GET_DRINK,
                        Menu.QUIT
        };
        var vendingMachine = new VendingMachine(drinks, menu);
        vendingMachine.run();
    }
}

enum Drink {
    WATER("Вода", 10),
    TEA("Чай", 25),
    KVAS("Квас", 50),
    COLA("Кола", 90),
    COFFEE("Кофе", 100);

    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}

enum Menu {
    SHOW_DRINKS("Посмотреть меню напитков", 1),
    ADD_MONEY("Внести деньги на счет", 2),
    GET_DRINK("Получить напиток", 3),
    QUIT("Уйти", 4);

    private final String itemName;
    private final int itemNum;

    Menu(String itemName, int itemNum) {
        this.itemName = itemName;
        this.itemNum = itemNum;
    }

    public String getItemName() { return itemName; }
    public int getItemNum() { return itemNum; }
}

class VendingMachine {
    private final Drink[] drinks;
    private final Menu[] menu;
    private int balance;

    VendingMachine(Drink[] drinks, Menu[] menu) {
        this.drinks = drinks;
        this.menu = menu;
    }

    public void run() {
        InputIntNumber num = new InputIntNumber(1, 4);
        while (true) {
            showMenu();
            while (!num.inputNumber()) {
                incorrectUserChoice();
                showMenu();
            }
            var userChoice = num.getValue();
            switch (userChoice) {
                case 1:
                    showDrinksMenu();
                    break;
                case 2:
                    addMoney();
                    break;
                case 3:
                    getDrink();
                    break;
                case 4:
                    goodBy();
                    return;
                default:
                    incorrectUserChoice();
            }
        }
    }

    private void showMenu() {
        System.out.println("\nВыберите действие:");
        for (var menuItem : menu)
            System.out.println(menuItem.getItemNum() + " -> " + menuItem.getItemName());
        System.out.print("Ваш выбор: ");
    }
    private void showDrinksMenu() {
        System.out.print("\nМеню напитков:");
        showListOfDrinks();
    }
    private void showListOfDrinks() {
        for (int i = 0; i < drinks.length; i++)
            System.out.printf("\n%d -> %4s %3d руб.", i + 1, drinks[i].getName(), drinks[i].getPrice());
        System.out.println();
    }

    private void addMoney() {
        showMoneyPrompt();
        var money = new InputIntNumber(1, Integer.MAX_VALUE);
        while (!money.inputNumber()) {
            System.out.println("Введена некорректная сумма.");
            showMoneyPrompt();
        }
        balance += money.getValue();
        System.out.printf("\nДеньги внесены на счет. Баланс %d руб.\n", balance);
    }

    private void showMoneyPrompt() {
        System.out.print("\nВведите сумму в рублях: ");
    }

    private void getDrink() {
        if (balance == 0) {
            System.out.println("\nВы не внесли деньги на счет. Внесите сумму, достаточную для оплаты напитка.");
            return;
        }
        showDrinkChoicePrompt();
        var num = new InputIntNumber(1, drinks.length);
        while (!num.inputNumber()) {
            incorrectUserChoice();
            showDrinkChoicePrompt();
        }
        var numberOfDrink = num.getValue() - 1;
        if (balance < drinks[numberOfDrink].getPrice()) {
            System.out.printf("\nДля оплаты выбранного напитка \"%s\" ценой %d руб. недостаточно средств на счете: %d руб.\nВнесите еще %d руб. или выберите более дешевый напиток.\n",
                    drinks[numberOfDrink].getName(), drinks[numberOfDrink].getPrice(), balance, drinks[numberOfDrink].getPrice() - balance);
            return;
        }
        balance -= drinks[numberOfDrink].getPrice();
        System.out.printf("\nВы выбрали напиток \"%s\". Возьмите Ваш напиток.", drinks[numberOfDrink].getName());
        showBalance();
    }
    private void getRestOfMoney() {
        if (balance > 0)
            System.out.printf("\nЗаберите оставшиеся деньги: %d руб.\n", balance);
        balance = 0;
    }
    private void showDrinkChoicePrompt() {
        System.out.print("\nВыберите напиток:");
        showListOfDrinks();
        System.out.print("Ваш выбор: ");
    }
    private void showBalance() {
        System.out.printf("\nБаланс: %d руб.\n", balance);
    }
    private void goodBy() {
        getRestOfMoney();
        System.out.println("\nВсего доброго! До новых встреч!\n");
    }
    private void incorrectUserChoice() {
        System.out.println("Выбран несуществующий вариант");
    }
}

class InputIntNumber {
    private int value;
    private final int lower;
    private final int upper;

    InputIntNumber(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
    public int getValue() {
        return value;
    }

    public boolean inputNumber() {
        boolean result = true;
        Scanner scanInpString;

        Scanner scanSystemIn = new Scanner(System.in);
        var inpString = scanSystemIn.next();
        scanInpString = new Scanner(inpString);
        if ( !scanInpString.hasNextInt() )
            result = false;
        else {
            value = scanInpString.nextInt();
            if (value < lower || value > upper)
                result = false;
        }
        scanInpString.close();
        return result;
    }
}