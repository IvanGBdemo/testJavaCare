package HomeWork5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Создаю экземпляр класса AppData
        AppData appData = new AppData();
        // Передаю в созданный ранее метод считывания loadData ссылку на файл
        appData.loadData("dataHW5.csv");
//Вывожу в консоль получившиеся заголовки массива
        System.out.println(Arrays.toString(appData.getHeader()));
        //Вывожу в консоль остальные данные массива. Так как массив - двумерный командой deepToString
        System.out.println(Arrays.deepToString(appData.getData()));
// Передаю в созданный ранее метод записи saveData название создаваемого файла
        appData.saveData("dataHW5-2.csv");
    }
}
