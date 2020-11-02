package usantatecla.mastermind;

import usantatecla.mastermind.controllers.LocalLogic;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	protected View createView() {
		return new GraphicsView();
	}

	@Override
	protected Logic createLogic() {
		return new LocalLogic();
	}

	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
