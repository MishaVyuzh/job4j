package minesweeper;

public class Mine {
    private boolean isMine;
    private int numberNearbyMines;

    void setAsMine() {
        isMine = true;
    }

    boolean isMine() {
        return isMine;
    }

    void setNumberNearbyMines(int numberNearbyMines) {
        this.numberNearbyMines = numberNearbyMines;
    }

    @Override
    public String toString() {
        if (isMine) {
            return "X";
        } else if (numberNearbyMines > 0 && numberNearbyMines < 9) {
            return "" + numberNearbyMines;
        } else {
            return ".";
        }
    }
}