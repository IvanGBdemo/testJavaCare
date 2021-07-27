package HomeWork3;

public class Main {

    public static void main(String[] args) {
    }

// Написать метод, который меняет два элемента массива местами
    public static void replacingAnArrayElement(Object[] array, int a, int o) {
        Object tmp = array[a];
        array[a] = array[o];
        array[o] = tmp;
    }
}
