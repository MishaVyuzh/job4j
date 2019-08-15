package ru.job4j.tracker;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 15.08.2019
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода заявки.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String ID_FIND = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String NAME_FIND = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals((answer))) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItems();
            } else if (DELETE.equals(answer)) {
                this.deleteItems();
            } else if (ID_FIND.equals(answer)) {
                this.findByIdItems();
            } else if (NAME_FIND.equals(answer)) {
                this.findByNameItems();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
    }

    /**
     * Метод выводит все заявки на экран.
     */
    private void showItems() {
        Item[] items = this.tracker.findAll();

        if (items.length > 0) {
            System.out.println("------------ Список всех заявок --------------");
            for(Item item : items) {
                this.showOneItem(item);
            }
        } else {
            System.out.println("------------ Заявки отсутствуют ------------");
            System.out.println();
        }
    }

    /**
     * Метод реализует редактирование заявки по входящему id в хранилище.
     */
    private void editItems() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id редактируемой заявки");
        String nameReplace = this.input.ask("Введите имя новой заявки :");
        String descReplace = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(nameReplace, descReplace);
        this.tracker.replace(id, item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " -----------");
        System.out.println();
    }

    /**
     * Метод реализует удаление заявки по входящему id в хранилище.
     */
    private void deleteItems() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки, которую вы хотите удалить");
        this.tracker.delete(id);
        System.out.println("------------ Новая заявка с Id : " + id + " успешно удалена -----------");
        System.out.println();
    }

    /**
     * Метод реализует поиск заявки по входящему id в хранилище.
     * Выводит найденную заявку.
     */
    private void findByIdItems() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки, которую вы хотите найти");
        Item item = this.tracker.findById(id);
        this.showOneItem(item);
    }

    /**
     * Метод реализует поиск заявок по входящему имени в хранилище.
     * Выврдит все заявки с одинаковыми именами.
     */
    private void findByNameItems() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки, которую вы хотите найти");
        Item items[] = this.tracker.findByName(name);
        for(Item item : items) {
            this.showOneItem(item);
        }
    }

    /**
     * Метод выводит одну заявку.
     */
    private void showOneItem(Item item) {
        System.out.print("ID - " + item.getId() + " | ");
        System.out.print("Имя - " + item.getName() + " | ");
        System.out.println("Описание - " + item.getDesc() + " ");
        System.out.println();
    }

    /**
     * Метод выводит меню.
     */
    private void showMenu() {
        System.out.println("------------ Меню ------------");
        System.out.println("0 - Добавиить заявку");
        System.out.println("1 - Вывод заявок на экран");
        System.out.println("2 - Редактировать заявку");
        System.out.println("3 - Удалить заявку");
        System.out.println("4 - Поиск заявки по id");
        System.out.println("5 - Поиск заявки по имени");
        System.out.println("6 - Выход");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}