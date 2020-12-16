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

    final int[] takeANumber() {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int[] shot = new int[2];
        for (int i = 0; i < shot.length; i++) {
            try {
                shot[i] = Integer.parseInt(String.valueOf(input[i]));
            } catch (NumberFormatException nfe) {
                System.err.println("Could not parse as an int at index: " + i);
            } catch (IndexOutOfBoundsException ioobe) {
                System.err.println("Nothing to parse in at index: " + i);
            }
        }
        return shot;
    }

    final void invalidMove() {
        System.out.println("Invalid move!\n");
    }

    final void showTheResult(Result result) {
        System.out.println(result.toString());
    }
}
