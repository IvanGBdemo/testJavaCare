package HomeWork4;

import java.util.ArrayList;
import java.util.HashMap;

// Создал класс объекта Телефонный справочник
public class PhoneBook {

// Составил коллекцию HashMap с двумя параметрами (Фамилия и номер телефона)
// При этом Номера телефонов составляют коллекцию внутри коллекции
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

// Ввожу метод, добавляющий записи в телефонный справочник
    public void add(String lastName, String phoneNumber) {
        ArrayList<String> outputOfThePhoneByLastName = phoneBook.getOrDefault(lastName, new ArrayList<>());
        outputOfThePhoneByLastName.add(phoneNumber);
        phoneBook.put(lastName, outputOfThePhoneByLastName);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }

    public static void main(String[] args) {
// Создаю экземпляр класса справочника с конструктором
        PhoneBook phoneBook = new PhoneBook();
// Добавляю записи в созданный телефонный справочник
        phoneBook.add("Fedorov", "89156951753");
        phoneBook.add("Isaev", "89063123456");
        phoneBook.add("Zheleznov", "89002454545");
        phoneBook.add("Bykov", "89067852963");
        phoneBook.add("Kozlov", "89536742651");
        phoneBook.add("Petrov", "89604131214");
        phoneBook.add("Ivanov", "89053469587");
        phoneBook.add("Sidorov", "89118369258");
        phoneBook.add("Zaharov", "89014369258");
        phoneBook.add("Fedorov", "89156951753");

// Добавляю возможность вывода в консоль номера телефона из справочника по фамилии владельца
        System.out.println(phoneBook.get("Fedorov"));
    }
}
