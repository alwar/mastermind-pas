package usantatecla.mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.WithConsoleView;
import usantatecla.mastermind.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {
	
	private PlayController playController;
	
	public ProposedCombinationView(PlayController playController) {
		this.playController = playController;
	}
	
	void write(int position) {
		for (Color color : this.playController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
