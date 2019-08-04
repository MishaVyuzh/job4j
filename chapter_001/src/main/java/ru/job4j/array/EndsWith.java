package ru.job4j.array;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 4.08.2019
 */

public class EndsWith {
    /**
     * Метод startsWith проверяет, что слово начинается с префикса.
     * @param word входящее слово.
     * @param post префикс.
     * @return true если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] wrd = word.toCharArray();
        char[] pst = post.toCharArray();

        for (int indexWrd = wrd.length - 1, indexPst = pst.length - 1; indexPst >= 0; indexWrd--, indexPst--) {
            if (wrd[indexWrd] != pst[indexPst]) {
                result = false;
                break;
            }
        }
        return result;
    }
}