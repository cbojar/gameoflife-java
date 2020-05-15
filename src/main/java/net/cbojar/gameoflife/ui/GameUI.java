package net.cbojar.gameoflife.ui;

import java.awt.*;

import javax.swing.*;
import net.cbojar.gameoflife.world.*;

public class GameUI {
	private static final long SLEEP_INTERVAL = 20;

	private final World world;
	private final TickTimer timer = TickTimer.create();

	public GameUI(final World world) {
		this.world = world;
	}

	public static GameUI createFor(final World world) {
		return new GameUI(world);
	}

	public void run() {
		final WorldCanvas worldCanvas = WorldCanvas.create(world);
		final JFrame window = createWindow(worldCanvas);
		window.add(worldCanvas, BorderLayout.CENTER);

		window.pack();
		window.setVisible(true);

		for (; true; timer.increment()) {
			try {
				Thread.sleep(SLEEP_INTERVAL);

				if (timer.shouldTick()) {
					world.tick();
				}

				worldCanvas.repaint();
			} catch (final InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private JFrame createWindow(final WorldCanvas worldCanvas) {
		final JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setPreferredSize(new Dimension(600, 600));
		window.setMinimumSize(new Dimension(200, 200));
		window.setMaximumSize(new Dimension(600, 600));

		window.setTitle("Conway's Game of Life");
		window.setLayout(new BorderLayout());

		window.setJMenuBar(GameMenu.create(world));

		window.add(worldCanvas, BorderLayout.CENTER);

		window.add(ControlBar.create(timer), BorderLayout.PAGE_END);

		return window;
	}
}
