package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.LocalLogic;
import usantatecla.mastermind.distributed.dispatchers.*;

public class LogicImplementationServer extends LocalLogic {

    public void createDispatchers(DispatcherRegistry registry) {
        registry.add(FrameType.START, new StartDispatcher(this.startController));
        registry.add(FrameType.STATE, new StateDispatcher(this.playController));
        registry.add(FrameType.UNDO, new UndoDispatcher(this.playController));
        registry.add(FrameType.REDO, new RedoDispatcher(this.playController));
        registry.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
        registry.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
        registry.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeController));
        registry.add(FrameType.ADD_PROPOSED_COMBINATION, new AddProposedCombinationDispatcher(this.playController));
        registry.add(FrameType.GET_WHITES, new GetWidthDispatcher(this.playController));
        registry.add(FrameType.GET_BLACKS, new GetBlacksDispatcher(this.playController));
        registry.add(FrameType.GET_COLORS, new GetColorDispatcher(this.playController));
        registry.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(this.playController));
        registry.add(FrameType.GET_LOOSER, new GetLooserDispatcher(this.playController));
        registry.add(FrameType.GET_WINNER, new GetWinnerDispatcher(this.playController));
        registry.add(FrameType.GAME_WIDTH, new GameWidthDispatcher(this.playController));
    }
}
