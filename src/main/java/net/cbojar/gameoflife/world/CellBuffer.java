package net.cbojar.gameoflife.world;

public interface CellBuffer {
	public int columns();
	public int rows();
	public boolean isAlive(Position position);
	public void startAlive(Position position, boolean isAlive);
	public void setAlive(Position position, boolean isAlive);
	public void swap();
	public void clear();
}
