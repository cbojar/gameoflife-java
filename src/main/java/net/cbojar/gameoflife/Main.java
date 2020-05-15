package net.cbojar.gameoflife;

import net.cbojar.gameoflife.ui.GameUI;
import net.cbojar.gameoflife.world.*;

public final class Main {
	public static void main(final String... args) throws InterruptedException {
		final World world = World.create(100, 100);
		world.generate();

		final GameUI ui = GameUI.createFor(world);
		ui.run();
	}
}
