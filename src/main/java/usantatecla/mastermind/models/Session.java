package usantatecla.mastermind.models;

public interface Session {
    StateValue getValueState();

    int getWidth();

    boolean undoable();

    void undo();

    void redo();

    boolean redoable();

    void reset();
}
