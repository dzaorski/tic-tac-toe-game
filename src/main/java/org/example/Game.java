package org.example;

import java.io.PrintStream;

public class Game {
    private final Board board;

    private char turn;

    private char [][] grid;

    public int getFreeSpots() {
        return freeSpots;
    }

    private int freeSpots;

    Game(PrintStream out) {
        this.board = new Board(this, out);
    }

    public char[][] getGrid() {
        return grid;
    }

    public char getTurn() {
        return turn;
    }

    public void newGame(){
        grid = new char[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                grid[i][j] = ' ';
            }
        }
        freeSpots = 9;
        turn = 'x';
    }

    void print() {
        board.print();
    }

    public boolean playAt(int shot[]) {
        int i = shot[0];
        int j = shot[1];
        if(i>=3||j>=3||i<0||j<0)
            return false;
        if(grid[i][j] != ' '){
            return false;
        }
        grid[i][j] = turn;
        freeSpots--;
        return true;
    }

    public void changeTurn() {
        if(turn == 'x') {
            turn = 'o';
        } else turn = 'x';

    }

    public Result checkWinner(char [][]grid) {
        Result result = Result.NONE;
        // searching for x winning
        for (int i = 0; i < 3; i++) {
            // columns checking for x wins
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] == 'x') {
                result =  Result.X_WINS;
            }
            // rows checking for x wins
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] == 'x') {
                result = Result.X_WINS;
            }
            // diagonal checking for x wins
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 'x'
                    || grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[0][2] == 'x') {
                result = Result.X_WINS;
            }
        }
        // searching for o winning
        for (int i = 0; i < 3; i++) {
            // columns checking for 0 wins
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == 'o') {
                result =  Result.O_WINS;
            }
            // rows checking for 0 wins
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == 'o') {
                result = Result.O_WINS;
            }
            // diagonal checking for 0 win
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 'o'
                    || grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[0][2] == 'o') {
                result = Result.O_WINS;
            }
        }
        // checking for tie (grip is full)
        if (freeSpots == 0 && result == Result.NONE) {
            result = Result.TIE;
        }
        return result;
    }

}
