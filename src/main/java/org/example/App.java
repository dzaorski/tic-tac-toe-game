package org.example;

/**
 * TicTacToe game!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game(System.out);
        GameLoop gameLoop = new GameLoop(game);
        gameLoop.play();
    }
}
