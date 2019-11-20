import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> res = new ArrayList<>();
        for (String s : array) {
            if (s.charAt(0) == 'J') {
                s = s.substring(1);
                res.add(s);
            }
        }
        Collections.reverse(res);
        for (String s : res) {
            System.out.println(s);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}