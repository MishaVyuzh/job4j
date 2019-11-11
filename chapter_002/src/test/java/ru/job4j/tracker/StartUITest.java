package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит стандартный вывод в консоль.
   // private PrintStream stdout = System.out;
    // буфер, содержащий результат
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    private Tracker tracker = new Tracker();
    private Item def = tracker.add(new Item("test name", "desc"));
    private Item first = tracker.add(new Item("first", "first desc"));
    private Item second = tracker.add(new Item("first", "second desc"));
    private Item third = tracker.add(new Item("third", "third desc"));

    private Input input0 = new StubInput(new String[]{"0", "test name", "desc", "y"});
    private Input input1 = new StubInput(new String[]{"1", "y"});
    private Input input2 = new StubInput(new String[]{"2", first.getId(), "test replace", "заменили заявку", "y"});
    private Input input3 = new StubInput(new String[]{"3", def.getId(), "y"});
    private Input input4 = new StubInput(new String[]{"4", def.getId(), "y"});
    private Input input5 = new StubInput(new String[]{"5", first.getName(), "y"});
    private Input input6 = new StubInput(new String[]{"5", third.getName(), "y"});
    private String menu = "------------ Меню ------------"
            + System.lineSeparator() + "0 - Добавить заявку"
            + System.lineSeparator() + "1 - Вывод заявок на экран"
            + System.lineSeparator() + "2 - Редактировать заявку"
            + System.lineSeparator() + "3 - Удалить заявку"
            + System.lineSeparator() + "4 - Поиск заявки по id"
            + System.lineSeparator() + "5 - Поиск заявки по имени"
            + System.lineSeparator() + "6 - Выход";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(System.out);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        new StartUI(input0, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input2, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findByName("test replace").get(0).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedValueNull() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input3, tracker, output).init();
        tracker.add(first);
        // проверяем, что Id удален.
        assertThat(tracker.delete(first), is(true));
    }

    @Test
    public void whenFindByIdThenTrackerHasItem() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input4, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(tracker.findById(def.getId()).getId(), is(def.getId()));
    }

    @Test
    public void   whenFindByNameThenTrackerReturnItems() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input5, tracker, output).init();

        assertThat(tracker.findByName(first.getName()), is(List.of(first, second)));
    }

    @Test
    public void whenShowFindAllItems() {
        new StartUI(input1, tracker, output).init();
        StringBuilder output = new StringBuilder();
        output
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Список всех заявок --------------")
                .append(System.lineSeparator());

        for (Item item : tracker.findAll()) {
            output
                    .append(String.format("ID - %s | Имя - %s | Описание - %s ", item.getId(), item.getName(), item.getDesc()))
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());
        }
        assertThat(new String(out.toByteArray()), is(output
                        .toString()
                )
        );
    }

    @Test
    public void whenShowFindByIdThenTrackerHasItem() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input4, tracker, output).init();
        StringBuilder output = new StringBuilder();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(new String(out.toByteArray()), is(output
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Поиск заявки по id --------------")
                .append(System.lineSeparator())
                .append(String.format("ID - %s | Имя - %s | Описание - %s ",
                        tracker.findAll().get(0).getId(),
                        tracker.findAll().get(0).getName(),
                        tracker.findAll().get(0).getDesc()))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenShowFindByNameThenTrackerReturnItems() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input6, tracker, output).init();
        StringBuilder output = new StringBuilder();
        String result = out.toString();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(result, is(output
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Поиск заявки по имени --------------")
                .append(System.lineSeparator())
                .append(String.format("ID - %s | Имя - %s | Описание - %s ",
                        tracker.findAll().get(3).getId(),
                        tracker.findAll().get(3).getName(),
                        tracker.findAll().get(3).getDesc()))
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString()
        ));
    }
}
