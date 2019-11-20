package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class ArrayChar {
    /**
     * Метод startsWith проверяет, что слово начинается с префикса.
     * @param word входящее слово.
     * @param prefix префикс.
     * @return true если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] wrd = word.toCharArray();
        char[] pref = prefix.toCharArray();

        for (int index = 0; index != pref.length; index++) {
            if (wrd[index] != pref[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}