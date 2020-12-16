package org.example;

public class GameLoop {
    private final Game game;
    private final Menu menu = new Menu(System.out);

    private Result result = Result.NONE;

    public GameLoop(Game game) {
        this.game = game;
    }

    void play() {
        menu.greetings();
        game.newGame();
        game.print();
        do {
            menu.playerTakesTurn(game.getTurn());
            if (game.playAt(menu.takeANumber())) {
                game.print();
                game.changeTurn();
            } else {
                menu.invalidMove();
            }
            result = game.checkWinner(game.getGrid());
        } while (result == Result.NONE && game.getFreeSpots() != 0);
        menu.showTheResult(result);
    }
}

