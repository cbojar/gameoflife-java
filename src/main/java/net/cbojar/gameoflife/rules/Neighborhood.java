package net.cbojar.gameoflife.rules;

public interface Neighborhood {
	boolean cell();
	boolean northwest();
	boolean north();
	boolean northeast();
	boolean east();
	boolean southeast();
	boolean south();
	boolean southwest();
	boolean west();

	default int countLivingNeighbors() {
		int count = 0;

		count += northwest() ? 1 : 0;
		count += north() ? 1 : 0;
		count += northeast() ? 1 : 0;
		count += east() ? 1 : 0;
		count += southeast() ? 1 : 0;
		count += south() ? 1 : 0;
		count += southwest() ? 1 : 0;
		count += west() ? 1 : 0;

		return count;
	}
}
