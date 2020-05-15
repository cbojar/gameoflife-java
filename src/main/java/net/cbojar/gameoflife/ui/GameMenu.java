package net.cbojar.gameoflife.ui;

import javax.swing.*;

import net.cbojar.gameoflife.world.World;

final class GameMenu extends JMenuBar {
	private static final long serialVersionUID = 287095067067316530L;

	public static GameMenu create(final World world) {
		final JMenu worldMenu = new JMenu("World");
		worldMenu.add(save(world));
		worldMenu.add(load(world));
		worldMenu.add(generate(world));
		worldMenu.add(clear(world));

		final GameMenu menu = new GameMenu();
		menu.add(worldMenu);

		return menu;
	}

	private static JMenuItem save(final World world) {
		final JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(
				(actionEvent) -> JOptionPane.showMessageDialog(null, "Save is not yet supported"));
		return saveItem;
	}

	private static JMenuItem load(final World world) {
		final JMenuItem loadItem = new JMenuItem("Load");
		loadItem.addActionListener(
				(actionEvent) -> JOptionPane.showMessageDialog(null, "Load is not yet supported"));
		return loadItem;
	}

	private static JMenuItem generate(final World world) {
		final JMenuItem generateItem = new JMenuItem("Generate");
		generateItem.addActionListener((actionEvent) -> world.generate());
		return generateItem;
	}

	private static JMenuItem clear(final World world) {
		final JMenuItem clearItem = new JMenuItem("Clear");
		clearItem.addActionListener((actionEvent) -> world.clear());
		return clearItem;
	}
}
