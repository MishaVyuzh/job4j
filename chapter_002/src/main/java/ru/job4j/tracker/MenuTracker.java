package ru.job4j.tracker;

import java.util.*;

/**
 * Внешний класс, добавляющий итем
 */
class AddItem implements UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
    }

    @Override
    public String info() {
        return String.format("%s - %s", this.key(), "Добавить заявку");
    }
}

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения длины массива действий в меню
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new EditItems());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items.length > 0) {
                System.out.println("------------ Список всех заявок --------------");
                for (Item item : items) {
                    System.out.print("ID - " + item.getId() + " | ");
                    System.out.print("Имя - " + item.getName() + " | ");
                    System.out.println("Описание - " + item.getDesc() + " ");
                    System.out.println();
                }
            } else {
                System.out.println("------------ Заявки отсутствуют ------------");
                System.out.println();
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Вывод заявок на экран");
        }

    }

    /**
     * Внутренний класс, изменяющий итем.
     */
    private static class EditItems implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id редактируемой заявки");
            String nameReplace = input.ask("Введите имя новой заявки :");
            String descReplace = input.ask("Введите описание новой заявки :");
            Item item = new Item(nameReplace, descReplace);

            if (tracker.replace(id, item)) {
                System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
                System.out.println();
            } else  {
                System.out.println("Заявки с таким id не существует.");
                System.out.println();
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Редактировать заявку");
        }
    }

    private static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки, которую вы хотите удалить");
            if (tracker.delete(id)) {
                System.out.println("------------ Новая заявка с Id : " + id + " успешно удалена -----------");
                System.out.println();
            } else {
                System.out.println("Заявки с таким id не существует.");
                System.out.println();
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Удалить заявку");
        }
    }

    private static class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки, которую вы хотите найти");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.print("ID - " + item.getId() + " | ");
                System.out.print("Имя - " + item.getName() + " | ");
                System.out.println("Описание - " + item.getDesc() + " ");
                System.out.println();
            } else {
                System.out.println("Заявка не найдена");
                System.out.println();
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск заявки по id");
        }
    }

    private static class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки, которую вы хотите найти");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                if (item != null) {
                    System.out.print("ID - " + item.getId() + " | ");
                    System.out.print("Имя - " + item.getName() + " | ");
                    System.out.println("Описание - " + item.getDesc() + " ");
                    System.out.println();
                } else {
                    System.out.println("Заявка не найдена");
                    System.out.println();
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск заявки по имени");
        }
    }

    private static class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Выход");
        }
    }
}
