package ru.job4j.department;

import java.util.*;

public class SortDepartment {
    List<String> directOrder(List<String> departments) {
        List<String> fillList = fillGaps(departments);
        Collections.sort(fillList);
        return fillList;
    }

    List<String> reverseOrder(List<String> departments) {
        List<String> fillList = fillGaps(departments);
        Set<String> set = new TreeSet<>((o1, o2) -> {
            int minimal = Math.min(o1.length(), o2.length());
            int result = 0;
            for (int index = 0; index < minimal; index++) {
                Character leftChar = o1.charAt(index);
                Character rightChar = o2.charAt(index);
                result = rightChar.compareTo(leftChar);
                if (result != 0) {
                    break;
                }
            }
            return result == 0 ? o1.length() - o2.length() : result;
        });
        set.addAll(fillList);

        return new ArrayList<>(set);
    }

    List<String> fillGaps(final List<String> departments) {
        Set<String> departmentsSet = new TreeSet<>(departments);

        for (String department : departments) {
            for (int j = 0; j < department.length(); j++) {
                if (department.charAt(j) == '\\') {
                    departmentsSet.add(department.substring(0, j));
                }
            }
        }
        return new ArrayList<>(departmentsSet);
    }
}
