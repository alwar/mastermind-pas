package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayControllerLocal extends PlayController {

    private final UndoController undoController;
    private final RedoController redoController;
    private final ProposalController proposalController;

    public PlayControllerLocal(Session session) {
        super(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
        this.proposalController = new ProposalController(session);
    }

    public Error addProposedCombination(List<Color> colors) {
        return this.proposalController.parseProposedCombination(colors);
    }

    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    public boolean isLooser() {
        return this.proposalController.isLooser();
    }

    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.proposalController.getColors(position);
    }

    public int getBlacks(int position) {
        return this.proposalController.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.proposalController.getWhites(position);
    }

    public void undo() {
        this.undoController.undo();
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }
}
