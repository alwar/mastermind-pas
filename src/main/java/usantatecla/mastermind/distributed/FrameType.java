package usantatecla.mastermind.distributed;

public enum FrameType {
	ADD_PROPOSED_COMBINATION,
	UNDOABLE,
	REDOABLE,
	UNDO,
	REDO,
	GET_WHITES,
	GET_BLACKS,
	GET_COLORS,
	GET_ATTEMPTS,
	GET_LOOSER,
	GET_WINNER,
	GAME_WIDTH,
	STATE,
	START,
	NEW_GAME,
	CLOSE;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
