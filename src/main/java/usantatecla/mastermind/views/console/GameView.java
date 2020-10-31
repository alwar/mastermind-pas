package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

public class GameView {
    private PlayController playController;
    private Console console;

    public GameView(PlayController playController) {
        this.playController = playController;
        this.console = new Console();
    }

    public void showGameStatus() {
        for (int i = 0; i < playController.getAttempts(); i++) {
            new ProposedCombinationView(playController).write(i);
            new ResultView(playController).writeln(i);
        }
        if (playController.isWinner()) {
            this.console.writeln(MessageView.WINNER.getMessage());
        } else if (playController.isLooser()) {
            this.console.writeln(MessageView.LOOSER.getMessage());
        }

    }
}
