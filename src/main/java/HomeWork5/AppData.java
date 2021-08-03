package HomeWork5;

import java.io.*;
import java.util.ArrayList;

// Создаю класс для хранения данных
public class AppData {
    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

// Ввожу пустой конструктор для класса
    public AppData() {
    }

// Создаю метод для считывания данных в файл
    public void saveData(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowArrToString(header));

            for (Integer[] row : data) {
                writer.write(rowArrToString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowArrToString(T[] row) {
        String result = "";
// Создаю цикл, который будет считывать в файл данные из массива, разделяя их знаком ;
        for (int i = 0; i < row.length; i++) {
            result = result + row[i].toString();
            if (i != row.length - 1) {
                result += ";";
            }
        }
// Добавляю символ переноса строки
        result += "\n";
        return result;
    }

// Составляю метод для чтения данных из файла
    public void loadData(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataArrRow(tempString));
            }
            data = dataList.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Создаю метод, который будет разбивать строку на элементы массива
    private Integer[] stringToDataArrRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
