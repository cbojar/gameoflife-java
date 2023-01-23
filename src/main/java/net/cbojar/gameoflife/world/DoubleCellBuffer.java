package net.cbojar.gameoflife.world;

public final class DoubleCellBuffer implements CellBuffer {
	private final int rows;
	private final int columns;

	private boolean[][] frontBuffer;
	private boolean[][] backBuffer;

	DoubleCellBuffer(final int rows, final int columns) {
		this.rows = rows;
		this.columns = columns;
		this.frontBuffer = new boolean[rows][columns];
		this.backBuffer = new boolean[rows][columns];
	}

	@Override
	public int rows() {
		return rows;
	}

	@Override
	public int columns() {
		return columns;
	}

	@Override
	public boolean isAlive(final Position position) {
		if (position.row() < 0 || position.column() < 0) {
			return false;
		}

		if (position.row() >= rows() || position.column() >= columns()) {
			return false;
		}

		return frontBuffer[position.row()][position.column()];
	}

	@Override
	public void startAlive(final Position position, final boolean isAlive) {
		frontBuffer[position.row()][position.column()] = isAlive;
	}

	@Override
	public void setAlive(final Position position, final boolean isAlive) {
		backBuffer[position.row()][position.column()] = isAlive;
	}

	@Override
	public void swap() {
		final boolean[][] temp = frontBuffer;
		frontBuffer = backBuffer;
		backBuffer = temp;

		clearBuffer(backBuffer);
	}

	@Override
	public void clear() {
		clearBuffer(frontBuffer);
	}

	private static void clearBuffer(final boolean[][] buffer) {
		for (int row = 0; row < buffer.length; row++) {
			for (int column = 0; column < buffer[row].length; column++) {
				buffer[row][column] = false;
			}
		}
	}
}
