package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 13.08.2019
 */
public class Tracker {
    /**
     * Коллекция для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();


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
        this.items.add(item);
        return item;
    }

    /**
     * Метод заменяющий ячейку в массиве items.
     * @param item объект, на который нужно заменить.
     * @return true, при успешной замене, иначе false.
     */
    public boolean replace(Item item) {
        boolean result = false;

        for (Item cur : items) {
            if (item != null && item.getId().equals(cur.getId())) {
                items.set(items.indexOf(cur), item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод, удаляет ячейку в коллекции.
     *
     *  @param item заявка, которую нужно удалить.
     * @return true при успешном удалении, иначе false.
     */
    public boolean delete(Item item) {
        boolean result = false;

        if (item != null) {
            items.remove(item);
            result = true;
        }
        return result;
    }

    /**
     * Метод получение списка всех заявок.
     *
     * @return копию коллекции items без null элементов.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод проверяет элементы коллекции items.
     * Сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий List и возвращает его.
     *
     * @param key - имя элемента, с которым сверяются все элементы коллекции this.items.
     * @return - List, все элементы которого содержат поле name, соответствующее key.
     * */
    public List<Item> findByName(String key) {
        List<Item> nameItems = new ArrayList<>();
        for (Item cur : this.items) {
            if (cur != null && cur.getName().equals(key)) {
                nameItems.add(cur);
            }
        }
        return nameItems;
    }

    /**
     * Метод проверяет элементы коллекции items, сравнивая id с аргументом String id и возвращает найденный Item.
     *
     * @param id - id элемента массива.
     * @return - элемент содержащий схожий с входным id, либо null, если такого элемента нет.
     * */
    public Item findById(String id) {
        Item result = null;
        for (Item cur : items) {
            if (cur != null && cur.getId().equals(id)) {
                result = cur;
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