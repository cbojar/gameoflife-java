package net.cbojar.gameoflife.world;

import java.util.*;

import net.cbojar.gameoflife.rules.*;

public class World {
	public static final int MIN_ROWS = 1;
	public static final int MIN_COLUMNS = 1;
	public static final int MAX_ROWS = 1000;
	public static final int MAX_COLUMNS = 1000;

	private static final List<Rule> RULES = Collections.unmodifiableList(Arrays.asList(
			new OverPopulationRule(),
			new UnderPopulationRule(),
			new BalancedPopulationRule(),
			new GrowingPopulationRule()));

	private final CellBuffer cells;

	private World(final CellBuffer cells) {
		this.cells = cells;
	}

	public static World create(final int rows, final int columns) {
		if (rows < MIN_ROWS) {
			throw new IllegalArgumentException("Rows (" + rows + ") less than min " + MIN_ROWS);
		}

		if (rows > MAX_ROWS) { 
			throw new IllegalArgumentException("Rows (" + rows + ") exceeds max " + MAX_ROWS);
		}

		if (rows < MIN_COLUMNS) {
			throw new IllegalArgumentException("Columns (" + columns + ") less than min " + MIN_COLUMNS);
		}

		if (columns > MAX_COLUMNS) { 
			throw new IllegalArgumentException("Columns (" + columns + ") exceeds max " + MAX_COLUMNS);
		}

		return new World(new DoubleCellBuffer(rows, columns));
	}

	public int rows() {
		return cells.rows();
	}

	public int columns() {
		return cells.columns();
	}

	public synchronized boolean isAlive(final Position position) {
		return cells.isAlive(position);
	}

	public synchronized void setAlive(final Position position) {
		cells.startAlive(position, true);
	}

	public synchronized void setAlive(final Position position, final boolean isAlive) {
		cells.startAlive(position, isAlive);
	}

	public synchronized void forEachCell(final CellConsumer cellConsumer) {
		for (int row = 0; row < rows(); row++) {
			for (int column = 0; column < columns(); column++) {
				final Position position = Position.at(row, column);
				cellConsumer.accept(position, isAlive(position));
			}
		}
	}

	public synchronized void generate() {
		final Random random = new Random();
		forEachCell((position, isAlive) -> {
			setAlive(position, random.nextInt(4) == 0);
		});
	}

	public synchronized void tick() {
		forEachCell((position, isAlive) -> {
			final Neighborhood neighborhood = new BoundedNeighborhood(this, position);
			for (final Rule rule : RULES) {
				if (rule.applies(neighborhood)) {
					cells.setAlive(position, rule.apply(neighborhood));
				}
			}
		});

		cells.swap();
	}

	public synchronized void clear() {
		cells.clear();
	}

	@FunctionalInterface
	public static interface CellConsumer {
		void accept(Position position, boolean isAlive);
	}
}
