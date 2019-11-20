import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            matrix.add(scanner.nextLine());
        }
        int rotate = scanner.nextInt();
        Collections.rotate(matrix, rotate);
        for (String s : matrix) {
            System.out.println(s);
        }
    }
}