package net.cbojar.gameoflife.world;

public final class Position {
	private final int row;
	private final int column;

	private Position(final int row, final int column) {
		this.row = row;
		this.column = column;
	}

	public static Position at(final int row, final int column) {
		return new Position(row, column);
	}

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}

	public Position northwest() {
		return Position.at(row - 1, column - 1);
	}

	public Position north() {
		return Position.at(row - 1, column);
	}

	public Position northeast() {
		return Position.at(row - 1, column + 1);
	}

	public Position west() {
		return Position.at(row, column - 1);
	}

	public Position east() {
		return Position.at(row, column + 1);
	}

	public Position southwest() {
		return Position.at(row + 1, column - 1);
	}

	public Position south() {
		return Position.at(row + 1, column);
	}

	public Position southeast() {
		return Position.at(row + 1, column + 1);
	}

	@Override
	public String toString() {
		return String.format("Position{row: %d, column: %d}", row, column);
	}
}
