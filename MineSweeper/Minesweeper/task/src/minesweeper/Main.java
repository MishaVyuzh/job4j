package minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = 9;
        int width = 9;
        int numMines = Integer.parseInt(scanner.nextLine());

        MineField minefield = new MineField(height, width, numMines);
        minefield.generateMineSpots();
        minefield.evaluateNeighboringMines();
        minefield.printField();
    }
}