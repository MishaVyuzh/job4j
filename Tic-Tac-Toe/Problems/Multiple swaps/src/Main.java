import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Collections.swap(nums, scanner.nextInt(), scanner.nextInt());
        }
        for(String str : nums) {
            System.out.print(str + " ");
        }
    }
}