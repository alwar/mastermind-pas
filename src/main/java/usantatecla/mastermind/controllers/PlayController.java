package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends Controller {
    private final UndoController undoController;
    private final RedoController redoController;
    private final ProposalController proposalController;

    public PlayController(Game game, State state) {
        super(game, state);
        this.undoController = new UndoController(game, state);
        this.redoController = new RedoController(game, state);
        this.proposalController = new ProposalController(game, state);
    }

    public Error addProposedCombination(List<Color> colors) {
        return this.proposalController.addProposedCombination(colors);
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

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
