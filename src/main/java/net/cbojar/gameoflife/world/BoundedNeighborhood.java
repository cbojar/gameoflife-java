package net.cbojar.gameoflife.world;

import net.cbojar.gameoflife.rules.Neighborhood;

public class BoundedNeighborhood implements Neighborhood {
	private final World world;
	private final Position position;

	public BoundedNeighborhood(final World world, final Position position) {
		this.world = world;
		this.position = position;
	}

	@Override
	public boolean cell() {
		return world.isAlive(position);
	}

	@Override
	public boolean northwest() {
		return world.isAlive(position.northwest());
	}

	@Override
	public boolean north() {
		return world.isAlive(position.north());
	}

	@Override
	public boolean northeast() {
		return world.isAlive(position.northeast());
	}

	@Override
	public boolean east() {
		return world.isAlive(position.east());
	}

	@Override
	public boolean southeast() {
		return world.isAlive(position.southeast());
	}

	@Override
	public boolean south() {
		return world.isAlive(position.south());
	}

	@Override
	public boolean southwest() {
		return world.isAlive(position.southwest());
	}

	@Override
	public boolean west() {
		return world.isAlive(position.west());
	}
}
