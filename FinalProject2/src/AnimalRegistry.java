import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalRegistry {
    private static List<Animal> animalList = new ArrayList<>();
    private static Map<String, Integer> animalTypeCount = new HashMap<>();

    public static void main(String[] args) {
        animalList.add(new Cat("Микаса", "20.11.2020", "Спать"));
        animalList.add(new Horse("Агата", "12.02.2021", "Стоять"));
        animalList.add(new Dog("Рекс", "22.04.2019", "Служить"));
        Scanner scanner = new Scanner(System.in);


        boolean a = true;
        while(a) {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Посмотреть список животных по дате рождения");
            System.out.println("3. Список команд животного");
            System.out.println("4. Обучение новым командам");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addAnimal(scanner);
                    break;
                case "2":
                    displayAnimalsByDateOfBirth();
                    break;
                case "3":
                    displayAnimalCommands(scanner);
                    break;
                case "4":
                    teachAnimalCommand(scanner);
                    break;
                case "5":
                    displayTotalAnimalCount();
                    break;
                case "0":
                    System.out.println("Программа завершена");
                    a = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню");
                    break;
            }
        }

        scanner.close();
    }


    private static void addAnimal(Scanner scanner) {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел");

        int animalType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения животного: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Введите команду животного: ");
        String command = scanner.nextLine();

        switch (animalType) {
            case 1:
                Dog dog = new Dog(name, dateOfBirth, command);
                animalList.add(dog);
                incrementAnimalTypeCount("Собака");
                break;
            case 2:
                Cat cat = new Cat(name, dateOfBirth, command);
                animalList.add(cat);
                incrementAnimalTypeCount("Кошка");
                break;
            case 3:
                Hamster hamster = new Hamster(name, dateOfBirth, command);
                animalList.add(hamster);
                incrementAnimalTypeCount("Хомяк");
                break;
            case 4:
                Horse horse = new Horse(name, dateOfBirth, command);
                animalList.add(horse);
                incrementAnimalTypeCount("Лошадь");
                break;
            case 5:
                Camel camel = new Camel(name, dateOfBirth, command);
                animalList.add(camel);
                incrementAnimalTypeCount("Верблюд");
                break;
            case 6:
                Donkey donkey = new Donkey(name, dateOfBirth, command);
                animalList.add(donkey);
                incrementAnimalTypeCount("Осел");
                break;
            default:
                System.out.println("Неверный тип животного");
                break;
        }
    }


    private static void incrementAnimalTypeCount(String animalType) {
        animalTypeCount.put(animalType, animalTypeCount.getOrDefault(animalType, 0) + 1);
    }


    private static void displayAnimalsByDateOfBirth() {
        animalList.sort((a1, a2) -> a1.getDateOfBirth().compareTo(a2.getDateOfBirth()));

        System.out.println("Список животных по дате рождения:");

        for (Animal animal : animalList) {
            System.out.println("Тип: " + animal.getType());
            System.out.println("Имя: " + animal.getName());
            System.out.println("Дата рождения: " + animal.getDateOfBirth());
            System.out.println("Команда: " + animal.getCommand());
            System.out.println();
        }
    }


    private static void displayAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.println("Список команд животного " + name + ": " + animal.getCommand());
                return;
            }
        }

        System.out.println("Животное не найдено");
    }


    private static void teachAnimalCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.print("Введите новую команду: ");
                String newCommand = scanner.nextLine();

                animal.setCommand(animal.getCommand() + ", " + newCommand);
                System.out.println("Команда успешно добавлена");
                return;
            }
        }

        System.out.println("Животное не найдено");
    }


    private static void displayTotalAnimalCount() {
        System.out.println("Общее количество животных:" + animalList.size());

    }
}