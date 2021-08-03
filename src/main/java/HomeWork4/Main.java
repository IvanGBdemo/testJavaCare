package HomeWork4;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

// Создал одномерный массив из 15 слов с повторением
        String[] arr = {"Watermelon", "Barberry", "Cowberry", "Elderberry", "Cherry", "Melon", "Honeysuckle",
                "Wild strawberry", "Shadberry", "Viburnum", "Cranberry", "Cherry", "Rosehip", "Black currant", "Rowan"};

// HashMap<String, Integer> uniqueWords = new HashMap<>();
// Создал коллекцию типа HashMap, в которой после удаления останутся только уникальные элементы
        HashMap<String, Integer> listOfUniqueWords = new HashMap<>();

// Составил цикл for-else, который добавляет уникальные элементы в коллекцию из массива,
// и количество повторений слова в коллекции
        for (int i = 0; i < arr.length; i++) {
            if (listOfUniqueWords.containsKey(arr[i])) {
                listOfUniqueWords.put(arr[i], listOfUniqueWords.get(arr[i]) + 1);
            } else {
                listOfUniqueWords.put(arr[i], 1);
            }
        }
// Вывожу полученную коллекцию в консоль
        System.out.println(listOfUniqueWords);
    }
}
