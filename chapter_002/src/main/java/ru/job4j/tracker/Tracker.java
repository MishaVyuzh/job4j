package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 13.08.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Константа для генерации уникального ключа.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод заменяющий ячейку в массиве items.
     * @param id ячейки, которую нужно заменить.
     * @param item объект, на который нужно заменить.
     * @return true, при успешной замене, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;

        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод, удаляет ячейку в массиве, смещающая все элементы после него на 1 ячейку влево.
     *
     * @param id ячейки, которую нужно удалить.
     * @return true при успешном удалении, иначе false.
     */
    public boolean delete(String id) {
        boolean result = false;

        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод получение списка всех заявок.
     *
     * @return копию массива items без null элементов.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];

        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод проверяет элементы массива items.
     * Сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     *
     * @param key - имя элемента, с которым сверяются все элементы массива this.items.
     * @return - массив, все элементы которого содержат поле name, соответствующее key.
     * */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] nameItems = new Item[position];
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                nameItems[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(nameItems, count);
    }

    /**
     * Метод проверяет элементы массива items, сравнивая id с аргументом String id и возвращает найденный Item.
     *
     * @param id - id элемента массива.
     * @return - элемент содержащий схожий с входным id, либо null, если такого элемента нет.
     * */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}