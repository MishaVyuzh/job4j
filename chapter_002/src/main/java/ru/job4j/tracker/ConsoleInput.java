package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 15.08.2019
 */

public class ConsoleInput implements Input {
    private Scanner scan = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scan.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("");
        }
        return key;
    }
}
