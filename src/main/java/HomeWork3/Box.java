package HomeWork3;

import java.util.ArrayList;

// Дан Класс Box (в виде обобщения), в который можно складывать фрукты
public class Box<T extends Fruit> {

    //  Вводим коллекцию, отражающую содержимое коробки
    private ArrayList<T> fruitList = new ArrayList<>();

    //  Создаём переменную Box (пустую коробку, в которую будем складывать фрукты)
    public Box() {
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    //   Создаём метод, добавляющий фрукты в коробку
    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public float getWeight() {
        return fruitList.size() * fruitList.get(0).getWeight();
    }

// Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с другой
    public boolean compare(Box<?> boxToCompare) {
        return Math.abs(getWeight() - boxToCompare.getWeight()) < 0.0001;
    }

    //  Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую, соблюдая сортировку.
    //  В текущей коробке фруктов не остаётся
    public void pouringFruitIntoAnotherBox(Box<T> box) {
        box.getFruitList().addAll(fruitList);
        fruitList.clear();
    }

    @Override
    public String toString() {
        return "Box{" + "fruitList=" + fruitList + '}';
    }
}
