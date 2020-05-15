package net.cbojar.gameoflife.ui;

import java.awt.Component;
import java.awt.event.*;

import net.cbojar.gameoflife.world.*;

final class WorldDrawing implements MouseListener, MouseMotionListener {
	private final World world;

	WorldDrawing(final World world) {
		this.world = world;
	}

	@Override
	public void mouseClicked(final MouseEvent mouseEvent) {
		setCell(mouseEvent);
	}

	@Override
	public void mouseEntered(final MouseEvent mouseEvent) {
		// Do nothing
	}

	@Override
	public void mouseExited(final MouseEvent mouseEvent) {
		// Do nothing
	}

	@Override
	public void mousePressed(final MouseEvent mouseEvent) {
		// Do nothing
	}

	@Override
	public void mouseReleased(final MouseEvent mouseEvent) {
		// Do nothing
	}

	@Override
	public void mouseDragged(final MouseEvent mouseEvent) {
		setCell(mouseEvent);
	}

	@Override
	public void mouseMoved(final MouseEvent mouseEvent) {
		// Do nothing
	}

	private void setCell(final MouseEvent mouseEvent) {
		final Component component = mouseEvent.getComponent();
		final int width = component.getWidth();
		final int height = component.getHeight();
		final int x = mouseEvent.getX();
		final int y = mouseEvent.getY();

		if (x < 0 || x >= width || y < 0 || y >= height) {
			return;
		}

		final Position cell = Position.at(y * world.rows() / height, x * world.columns() / width);

		world.setAlive(cell, !mouseEvent.isShiftDown());
		component.repaint();
	}
}