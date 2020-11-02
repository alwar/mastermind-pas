package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.List;

public interface Session {
    StateValue getValueState();

    int getWidth();

    void next();

    boolean undoable();

    void undo();

    void redo();

    boolean redoable();

    void addProposedCombination(List<Color> colors);

    boolean isWinner();

    boolean isLooser();

    int getAttempts();

    List<Color> getColors(int position);

    int getBlacks(int position);

    int getWhites(int position);

    void reset();
}
