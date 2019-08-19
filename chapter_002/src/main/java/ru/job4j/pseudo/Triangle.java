package ru.job4j.pseudo;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 19.08.2019
 */

public class Triangle implements Shape{
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("     *     ");
        pic.append("    * *    ");
        pic.append("   *   *   ");
        pic.append("  *     *  ");
        pic.append(" *       * ");
        pic.append("***********");
        return pic.toString();
    }

    public static void main(String[] args) {

    }
}
