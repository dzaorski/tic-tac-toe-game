package org.example;

public enum Result {
    X_WINS("X wins!"),
    O_WINS("X wins!"),
    TIE("Tie!"),
    NONE("None");

    private String result;

    Result(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}


