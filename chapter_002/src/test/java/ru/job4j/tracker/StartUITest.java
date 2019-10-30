package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит стандартный вывод в консоль.
    private PrintStream stdout = System.out;
    // буфер, содержащий результат
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

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
            + "\r\n" + "0 - Добавить заявку"
            + "\r\n" + "1 - Вывод заявок на экран"
            + "\r\n" + "2 - Редактировать заявку"
            + "\r\n" + "3 - Удалить заявку"
            + "\r\n" + "4 - Поиск заявки по id"
            + "\r\n" + "5 - Поиск заявки по имени"
            + "\r\n" + "6 - Выход";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        new StartUI(input0, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input2, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findByName("test replace").get(0).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedValueNull() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input3, tracker).init();
        tracker.add(first);
        // проверяем, что Id удален.
        assertThat(tracker.delete(first), is(true));
    }

    @Test
    public void whenFindByIdThenTrackerHasItem() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input4, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(tracker.findById(def.getId()).getId(), is(def.getId()));
    }

    @Test
    public void   whenFindByNameThenTrackerReturnItems() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input5, tracker).init();

        assertThat(tracker.findByName(first.getName()), is(List.of(first, second)));
    }

    /*@Test
    public void whenShowFindAllItems() {
        new StartUI(input1, tracker).init();
        StringBuilder output = new StringBuilder();
        output
                .append(menu)
                .append("\r\n" + "------------ Список всех заявок --------------" + "\r\n");

        for (Item item : tracker.findAll()) {
            output
                    .append(String.format("ID - %s | Имя - %s | Описание - %s \r\n\r\n", item.getId(), item.getName(), item.getDesc()));
        }
        assertThat(new String(out.toByteArray()), is(output
                        //.append(System.lineSeparator())
                        .toString()
                )
        );
    }*/

    /*@Test
    public void whenShowFindByIdThenTrackerHasItem() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input4, tracker).init();
        StringBuilder output = new StringBuilder();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(new String(out.toByteArray()), is(output
                .append(menu)
                .append("\r\n" + "------------ Поиск заявки по id --------------" + "\r\n")
                .append(String.format("ID - %s | Имя - %s | Описание - %s \r\n\r\n",
                        tracker.findAll().get(0).getId(),
                        tracker.findAll().get(0).getName(),
                        tracker.findAll().get(0).getDesc()))
                .toString()
        ));
    }*/

   /* @Test
    public void whenShowFindByNameThenTrackerReturnItems() {
        // создаём StartUI и вызываем метод init()
        new StartUI(input6, tracker).init();
        StringBuilder output = new StringBuilder();
        String result = out.toString();
        // проверяем, что нулевой элемент массива в трекере содержит id, введённое при эмуляции.
        assertThat(result, is(output
                .append(menu)
                .append("\r\n" + "------------ Поиск заявки по имени --------------" + "\r\n")
                .append(String.format("ID - %s | Имя - %s | Описание - %s \r\n\r\n",
                        tracker.findAll().get(3).getId(),
                        tracker.findAll().get(3).getName(),
                        tracker.findAll().get(3).getDesc()))
                .toString()
        ));
    }*/
}
