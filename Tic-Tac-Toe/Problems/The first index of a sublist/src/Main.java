import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> one = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        List<String> two = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        int first = Collections.indexOfSubList(one, two);
        int last = Collections.lastIndexOfSubList(one, two);

        System.out.println(first + " " + last);
    }
}