package be.businesstraining.domain;

public enum GameStatus {
    PAR_DEUX(111, 2),
    PAR_QUATRE(777, 4),
    PAR_DIX(421, 10);

    // Tirage gagnant
    public final int VALUE;

    // Multiplication
    public final int RATIO;

    GameStatus(int VALUE, int RATIO) {
        this.VALUE = VALUE;
        this.RATIO = RATIO;
    }

    public int getVALUE() {
        return VALUE;
    }

    public int getRATIO() {
        return RATIO;
    }
}
