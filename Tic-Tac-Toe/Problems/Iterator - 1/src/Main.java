import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        Set<Long> set = new TreeSet<>();
        for (String lo : s) {
            set.add(Long.parseLong(lo));
        }

        Iterator<Long> iter = set.iterator();
        while (iter.hasNext()) {
            Long current = iter.next();
            if (current % 2 == 0) {
                iter.remove();
            }
        }
        for(Long l : set) {
            System.out.println(l);
        }
    }
}