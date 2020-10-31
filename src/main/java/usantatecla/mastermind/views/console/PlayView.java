package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;

public class PlayView {
    void interact(PlayController playController) {
        new PlayMenu(playController).execute();
        new GameView(playController).showGameStatus();
    }
}
