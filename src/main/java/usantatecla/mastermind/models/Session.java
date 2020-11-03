package usantatecla.mastermind.models;

public interface Session {
    StateValue getValueState();

    int getWidth();

    void next();

    boolean undoable();

    void undo();

    void redo();

    boolean redoable();

    void reset();
}
