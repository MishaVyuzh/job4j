package ru.job4j.array;


import java.util.Arrays;

/**
 * @author Mikhail Vyuzhanin (vyuzzzh@yandex.ru)
 * @version $#16439$
 * @since 15.08.2019
 */

public class ArrayCombo {

    int[] merge(int[] left, int[] right) {
        int[] combo = new int[left.length + right.length];
        int l = 0, r = 0;

        for (int i = 0; i < combo.length; i++) {
            if (l == left.length) {
                combo[i] = right[r];
                r++;
                continue;
            }
            if (r == right.length) {
                combo[i] = left[l];
                l++;
            }
            else if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    combo[i] = left[l];
                    l++;
                } else {
                    combo[i] = right[r];
                    r++;
                }
            }
        }
        return combo;
    }

    public static void main(String[] args) {
        ArrayCombo comb = new ArrayCombo();
        int[] a = new int[] {1, 3};
        int[] b = new int[] {2, 4};

        System.out.println(Arrays.toString(comb.merge(a, b)));
    }
}
