package usantatecla.mastermind;

import usantatecla.mastermind.controllers.LocalLogic;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	protected View createView() {
		return new ConsoleView();
	}

	@Override
	protected Logic createLogic() {
		return new LocalLogic();
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
