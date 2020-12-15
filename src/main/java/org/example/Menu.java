package org.example;

import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
    final PrintStream out;

    public Menu(PrintStream out) {
        this.out = out;
    }

    final void greetings() {
        System.out.println( "\nHello in TicTacToe game!" );
    }

    final void playerTakesTurn(char turn) {
        System.out.println("Now is player " + turn + " turn.");
        System.out.println("Write you move - row number and column number (in example 13):");
    }

    final int[] takeAShot() {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int[] shot = new int[2];
        shot[0] = Integer.parseInt(String.valueOf(input[0])) - 1;
        shot[1] = Integer.parseInt(String.valueOf(input[1])) - 1;
        return shot;
    }

    final void invalidMove() {
        System.out.println("Invalid move!\n");
    }

    final void showTheResult(Result result) {
        System.out.println(result.toString());
    }
}
