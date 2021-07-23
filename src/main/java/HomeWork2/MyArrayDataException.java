package HomeWork2;

// Создать исключение MyArrayDataException:

public class MyArrayDataException extends Exception {
// Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа), вбрасывается
// исключение
    public MyArrayDataException(String message) {
        super(message);
    }
}
