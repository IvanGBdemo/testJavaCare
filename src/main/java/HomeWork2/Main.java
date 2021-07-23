package HomeWork2;

public class Main {

    //  Написать метод, на вход которому подается двумерный строковый массив и, который пробрасывает два исключения
    public static int arraySum(String[][] twoDimArray) throws MyArraySizeException, MyArrayDataException {
//     исключение подачи массива другого размера
        if (twoDimArray.length != 4) {
            throw new MyArraySizeException("Длина массива не соответствует условию");
        }

        for (String[] array : twoDimArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("Высота массива не соответствует условию");
            }
        }
// метод должен пройтись по всем элементам массива,
        int sum = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                try {
// преобразовать в int и просуммировать
                    sum += Integer.parseInt(twoDimArray[i][j]);
//  если в ячейке лежит символ или текст вместо числа, бросить исключение MyArrayDataException с детализацией,
//  в какой ячейке неверные данные.
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не число в ячейке с адресом: " + i + "," + j);
                }
            }
        }
//   вернуть сумму ячеек массива
        return sum;
    }

    public static void main(String[] args) {

// 1. Создать двумерный строковый массив размером 4х4.

            String[][] twoDimArray =
                    {{"1", "2", "3", "4"},
                            {"5", "6", "7k", "8"},
                            {"9", "10", "11", "12"},
                            {"13", "14", "15", "16"}};

            try {
//  В методе main() вызвать полученный метод и вывести результат расчета
                System.out.println(arraySum(twoDimArray));
//  обработать возможные исключения с выводом детализации
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            } catch (MyArrayDataException e) {
                e.printStackTrace();
            }
        }
    }