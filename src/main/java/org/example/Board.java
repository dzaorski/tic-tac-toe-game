package org.example;

import java.io.PrintStream;

public class Board {
    static final String HORIZONTAL_LINE = "+" + ("-".repeat(8) + "+").repeat(4);
    static final String ROW_FORMAT = " %-7s | %-6s | %-6s | %-6s |%n";

    final Game game;
    final PrintStream out;

    public Board(Game game, PrintStream out) {
        this.game = game;
        this.out = out;
    }

    void print() {
        out.println();
        out.format(ROW_FORMAT, "BOARD", "COL 1", "COL 2", "COL 3");
        for (int row = 0; row < 3; row++) {
            out.println(HORIZONTAL_LINE);
            out.format(ROW_FORMAT, "ROW " + (row + 1), game.getGrid()[row][0], game.getGrid()[row][1], game.getGrid()[row][2]);
        }
        out.println(HORIZONTAL_LINE + "\n");
    }
}

