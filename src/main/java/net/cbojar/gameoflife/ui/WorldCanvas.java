package net.cbojar.gameoflife.ui;

import java.awt.*;

import javax.swing.JPanel;

import net.cbojar.gameoflife.world.World;

final class WorldCanvas extends JPanel {
	private static final long serialVersionUID = -2379174388742219481L;

	private final World world;

	private WorldCanvas(final World world) {
		this.world = world;
	}

	public static WorldCanvas create(final World world) {
		final WorldCanvas canvas = new WorldCanvas(world);
		canvas.setBackground(Color.WHITE);

		final WorldDrawing worldDrawing = new WorldDrawing(world);
		canvas.addMouseListener(worldDrawing);
		canvas.addMouseMotionListener(worldDrawing);

		return canvas;
	}

	@Override
	public void paint(final Graphics graphics) {
		graphics.clearRect(0, 0, getWidth(), getHeight());

		final double cellWidth = (double)getWidth() / world.columns();
		final double cellHeight = (double)getHeight() / world.rows();

		graphics.setColor(Color.DARK_GRAY);
		world.forEachCell((position, isAlive) -> {
			if (isAlive) {
				graphics.fillRect(
						(int)(cellWidth * position.column()), (int)(cellHeight * position.row()),
						(int)cellWidth + 1, (int)cellHeight + 1);
			}
		});

		graphics.setColor(Color.WHITE);
		world.forEachCell((position, isAlive) -> {
			if (!isAlive) {
				graphics.fillRect(
						(int)(cellWidth * position.column()), (int)(cellHeight * position.row()),
						(int)cellWidth + 1, (int)cellHeight + 1);
			}
		});
	}
}